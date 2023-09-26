package com.ecommerce.account.dto.request;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserQueryRequest {

    private Integer age;

    private String sex;

    private Integer status;

    private String username;

    private Timestamp createdAt;



}
