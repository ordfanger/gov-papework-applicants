package com.alm.research.gov.paperwork.applicantsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoAuditing
@LoadBalancerClients({
        @LoadBalancerClient(name = "applicants-service", configuration = ClientConfiguration.class)
})
public class ApplicantsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicantsServiceApplication.class, args);
    }

}
