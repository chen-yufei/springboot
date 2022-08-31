package com.chenyuhui.springboot.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer userId;
    private String userName;
    private String password;

    public User(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }

}
