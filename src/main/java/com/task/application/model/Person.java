package com.task.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sector;
    @Column(columnDefinition = "tinyint(1) default 0")
    private Boolean isAgreedToTerms;

    public Person(String name, String sector, Boolean isAgreedToTerms) {
        this.name = name;
        this.sector = sector;
        this.isAgreedToTerms = isAgreedToTerms;
    }
}
