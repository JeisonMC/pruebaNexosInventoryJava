package com.Nexos.Inventory.service;

import com.Nexos.Inventory.mapper.MapperRole;
import com.Nexos.Inventory.model.Role;
import com.Nexos.Inventory.repository.RepositoryRole;
import com.Nexos.Inventory.request.RequestRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceRole {

    @Autowired
    private RepositoryRole repositoryRole;

    @Autowired
    private MapperRole mapperRole;

    public List<Role> listAllRole() {
        return repositoryRole.findAll();
    }

    public Role createRole(RequestRole requestCreateRole) throws Exception {
        var role = repositoryRole.findRoleByName(requestCreateRole.getName());
        try{
            if (role != null) {
                throw new Exception("This role already exists");
            }
        }catch (Exception e){
            System.out.println("Error:" + e);
        }
        return repositoryRole.save(mapperRole.createRole(requestCreateRole));
    }

    public Role updateRole(RequestRole requestRole, UUID id) throws Exception {
        var currentRole = repositoryRole.findByIdRol(id);
        try{
            if (currentRole == null) {
                throw new Exception("This role not exists");
            }
        }catch (Exception e){
            System.out.println("Error:" + e);
        }
        return repositoryRole.save(mapperRole.updateRole(currentRole, requestRole));
    }
}
