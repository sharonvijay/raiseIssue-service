package org.reg.raiseIssueservice.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private Long phoneNo;
    private String email;
}
