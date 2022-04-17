package com.task.application.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonBean {
    private Long id;
    private String name;
    private String sector;
    private Boolean isAgreedToTerms;

}
