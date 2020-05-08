package com.alm.research.gov.paperwork.applicantsservice.okta.users;

import com.alm.research.gov.paperwork.applicantsservice.models.ApplicantDTO;
import com.alm.research.gov.paperwork.applicantsservice.models.Meta;
import com.alm.research.gov.paperwork.applicantsservice.okta.users.exceptions.RegistrationException;
import com.alm.research.gov.paperwork.applicantsservice.okta.users.models.createUserRequest.CreateUserRequest;
import com.alm.research.gov.paperwork.applicantsservice.okta.users.models.createUserRequest.Credentials;
import com.alm.research.gov.paperwork.applicantsservice.okta.users.models.createUserRequest.Password;
import com.alm.research.gov.paperwork.applicantsservice.okta.users.models.createUserRequest.Profile;
import com.alm.research.gov.paperwork.applicantsservice.okta.users.models.oktaCreatedUserResponse.OktaUserCreatedResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OktaUsersServiceImpl implements OktaUsersService {
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    @Value("${gov.paperwork.okta-url}")
    private String oktaBaseUrl;

    @Value("${gov.paperwork.okta-api-token}")
    private String oktaApiToken;

    public OktaUsersServiceImpl(OkHttpClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    @Override
    public ApplicantDTO createUser(ApplicantDTO applicantDTO) throws IOException {

        CreateUserRequest createUserRequest = new CreateUserRequest() {{
            setProfile(new Profile() {{
                setEmail(applicantDTO.getIdentity().getEmail());
                setFirstName(applicantDTO.getIdentity().getFirstName());
                setLastName(applicantDTO.getIdentity().getLastName());
                setLogin(applicantDTO.getIdentity().getEmail());
            }});

            setCredentials(new Credentials() {{
                setPassword(new Password() {{
                    setValue(applicantDTO.getIdentity().getPassword());
                }});
            }});
        }};

        String createUserRequestJSON = objectMapper.writeValueAsString(createUserRequest);

        RequestBody body = RequestBody.create(createUserRequestJSON, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(oktaBaseUrl + "/api/v1/users?activate=true")
                .addHeader("Authorization", "SSWS " + oktaApiToken)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RegistrationException(response.code(), response.body().string());
            }

            OktaUserCreatedResponse oktaUserCreatedResponse =
                    objectMapper.readValue(response.body().bytes(), OktaUserCreatedResponse.class);

            Meta meta = new Meta();
            meta.setOktaUser(oktaUserCreatedResponse);
            applicantDTO.setMeta(meta);

            return applicantDTO;
        }
    }
}
