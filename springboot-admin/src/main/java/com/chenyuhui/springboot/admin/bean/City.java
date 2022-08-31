package com.chenyuhui.springboot.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;

}
