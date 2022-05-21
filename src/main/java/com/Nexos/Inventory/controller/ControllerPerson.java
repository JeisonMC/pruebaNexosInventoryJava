package com.Nexos.Inventory.controller;

import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.request.RequestPerson;
import com.Nexos.Inventory.service.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class ControllerPerson {

    @Autowired
    private ServicePerson servicePerson;

    public ControllerPerson(ServicePerson servicePerson) {
        this.servicePerson = servicePerson;
    }

    @GetMapping()
    public List<Person> findAllPerson() {
        return servicePerson.listAllPerson();
    }

    @PostMapping()
    public Person createInventory(@RequestBody RequestPerson requestPerson) throws Exception {
        return servicePerson.createPerson(requestPerson);
    }
}
