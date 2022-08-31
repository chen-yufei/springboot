package com.chenyuhui.springboot.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;
    private String userId;
    private Integer money;

}
