package com.kata.series.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kata.series.constants.EazySchoolConstants;
import com.kata.series.model.Person;
import com.kata.series.model.Roles;
import com.kata.series.repository.PersonRepository;
import com.kata.series.repository.RolesRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder encoder;
    
    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setPwd(encoder.encode(person.getPwd()));
        person.setConfirmPwd(encoder.encode(person.getPwd()));
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
