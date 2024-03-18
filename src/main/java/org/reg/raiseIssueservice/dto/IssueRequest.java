package org.reg.raiseIssueservice.dto;

import lombok.Data;

@Data
public class IssueRequest {
    private String issueName;
    private Long userId;
}
