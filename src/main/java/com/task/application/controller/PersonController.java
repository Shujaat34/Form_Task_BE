package com.task.application.controller;

import com.task.application.bean.PersonBean;
import com.task.application.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;


    @PostMapping("/add")
    public ResponseEntity<PersonBean> addPerson(@RequestBody PersonBean personBean) {
        return ResponseEntity.ok(personService.addPerson(personBean));
    }

    @PutMapping("/update")
    public ResponseEntity<PersonBean> updatePerson(@RequestBody PersonBean personBean) {
        return ResponseEntity.ok(personService.updatePerson(personBean));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<PersonBean>> getAll() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<PersonBean> getPerson(@PathVariable("personId") Long personId) {
        return ResponseEntity.ok(personService.getPersonById(personId));
    }

}