package org.reg.raiseIssueservice.dto;

import lombok.Data;

@Data
public class IssueRequest {
    private String name;
    private Long userId;
}
