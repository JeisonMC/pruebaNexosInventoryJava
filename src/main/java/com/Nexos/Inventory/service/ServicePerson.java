package com.Nexos.Inventory.service;

import com.Nexos.Inventory.mapper.MapperPerson;
import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.repository.RepositoryPerson;
import com.Nexos.Inventory.repository.RepositoryRole;
import com.Nexos.Inventory.request.RequestPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePerson {

    @Autowired
    private RepositoryPerson repositoryPerson;

    @Autowired
    private RepositoryRole repositoryRole;

    @Autowired
    private MapperPerson mapperPerson;

    public List<Person> listAllPerson() {
        return repositoryPerson.findAll();
    }

    public Person createPerson(RequestPerson requestCreatePerson) throws Exception {
        var person = repositoryPerson.findByEmailPerson(requestCreatePerson.getEmail());
        var currentRole = repositoryRole.findRoleByName(requestCreatePerson.getRole());
        try{
            if (person != null) {
                throw new Exception("This email already exists");
            }
        }catch (Exception e){
            System.out.println("Error:" + e);
        }
        return repositoryPerson.save(mapperPerson.createPerson(requestCreatePerson, currentRole));
    }
}
