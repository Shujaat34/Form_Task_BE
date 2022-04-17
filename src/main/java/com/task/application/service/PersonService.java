package com.task.application.service;

import com.task.application.bean.PersonBean;

import java.util.List;
import java.util.Set;

public interface PersonService {
    PersonBean addPerson(PersonBean category);

    PersonBean updatePerson(PersonBean category);

    List<PersonBean> getAllPersons();

    PersonBean getPersonById(Long id);
}
