package com.Nexos.Inventory.mapper;

import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.model.Role;
import com.Nexos.Inventory.request.RequestPerson;
import org.springframework.stereotype.Component;

@Component
public class ImplementMapperPerson implements MapperPerson {

    @Override
    public Person createPerson(RequestPerson requestPerson, Role role) {
        Person person = new Person();
        person.setName(requestPerson.getName());
        person.setAge(requestPerson.getAge());
        person.setRole(role);
        person.setEmail(requestPerson.getEmail());
        person.setPassword(requestPerson.getPassword());

        return person;
    }

    @Override
    public Person updatePerson (Person currentPerson, RequestPerson requestPerson, Role role) {
        currentPerson.setName(requestPerson.getName());
        currentPerson.setRole(role);
        currentPerson.setAge(requestPerson.getAge());
        currentPerson.setPassword(requestPerson.getPassword());

        return currentPerson;
    }
}
