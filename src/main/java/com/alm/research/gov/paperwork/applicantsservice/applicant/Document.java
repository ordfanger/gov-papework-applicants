package com.alm.research.gov.paperwork.applicantsservice.applicant;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Document {
    private DocumentType type;
    private List<String> attachments; //links to s3 bucket
}

@Data
class DocumentType {
    @Id
    private String id;
    private String title;
    private String description;
}