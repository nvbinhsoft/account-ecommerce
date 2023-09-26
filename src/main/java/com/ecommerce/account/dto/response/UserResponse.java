package com.ecommerce.account.dto.response;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private String username;

    private String email;

    private String mobile;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Timestamp createdBy;

    private Timestamp updateBy;

    public UserResponse(String username, String email, String mobile, Timestamp createdAt,
            Timestamp updatedAt, Timestamp createdBy, Timestamp updateBy) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updateBy = updateBy;
    }
}
