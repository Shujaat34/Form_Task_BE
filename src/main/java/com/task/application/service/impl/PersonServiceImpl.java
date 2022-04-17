package com.task.application.service.impl;

import com.task.application.bean.PersonBean;
import com.task.application.model.Person;
import com.task.application.repository.PersonRepository;
import com.task.application.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonBean addPerson(PersonBean person) {
        Person entity = personRepository.save(new Person(person.getName(), person.getSector(), person.getIsAgreedToTerms()));
        return new PersonBean(entity.getId(),entity.getName(),entity.getSector(),entity.getIsAgreedToTerms());
    }

    @Override
    public PersonBean updatePerson(PersonBean person) {
        Person entity = null;
        if(person.getId() != null){
            entity = personRepository.getById(person.getId());
            if(entity != null){
                entity.setName(person.getName());
                entity.setSector(person.getSector());
                entity.setIsAgreedToTerms(person.getIsAgreedToTerms());
                entity = personRepository.save(entity);
            }

        }
        return new PersonBean(entity.getId(),entity.getName(),entity.getSector(),entity.getIsAgreedToTerms());
    }

    @Override
    public List<PersonBean> getAllPersons() {
        List<Person> all = personRepository.findAll();
        List<PersonBean> allPersons = new ArrayList<>();
        for (Person p: all) {
            allPersons.add(new PersonBean(p.getId(),p.getName(),p.getSector(),p.getIsAgreedToTerms()));
        }
        return allPersons;
    }

    @Override
    public PersonBean getPersonById(Long id) {
        PersonBean personBean = null;
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            Person p = person.get();
            personBean = new PersonBean(p.getId(),p.getName(),p.getSector(),p.getIsAgreedToTerms());
        }
        return personBean;
    }
}
