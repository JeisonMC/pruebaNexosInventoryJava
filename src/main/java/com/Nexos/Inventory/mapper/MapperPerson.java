package com.Nexos.Inventory.mapper;


import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.model.Role;
import com.Nexos.Inventory.request.RequestPerson;

public interface MapperPerson {
    Person createPerson(RequestPerson requestPerson, Role role);

    Person updatePerson(Person person , RequestPerson requestPerson, Role role);
}
