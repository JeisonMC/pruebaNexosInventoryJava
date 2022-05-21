package com.Nexos.Inventory.mapper;

import com.Nexos.Inventory.model.Role;
import com.Nexos.Inventory.request.RequestRole;
import org.springframework.stereotype.Component;

@Component
public class ImplementMapperRole implements MapperRole {

    @Override
    public Role createRole(RequestRole requestRole) {
        Role role = new Role();
        role.setName(requestRole.getName());

        return role;
    }

    @Override
    public Role updateRole(Role currentRole, RequestRole requestRole) {
        currentRole.setName(requestRole.getName());

        return currentRole;
    }
}
