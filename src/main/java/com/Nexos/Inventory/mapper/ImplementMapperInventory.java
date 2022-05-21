package com.Nexos.Inventory.mapper;


import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.request.RequestInventory;
import org.springframework.stereotype.Component;

@Component
public class ImplementMapperInventory implements MapperInventory {

    @Override
    public Inventory createInventory(RequestInventory requestInventory, Person currentPerson) {
        Inventory inventory = new Inventory();
        inventory.setName(requestInventory.getName());
        inventory.setQuantity(requestInventory.getQuantity());
        inventory.setAdmissionDate(requestInventory.getAdmissionDate());
        inventory.setPerson(currentPerson);

        return inventory;
    }

    @Override
    public Inventory updateInventory(Inventory currentInventory, RequestInventory requestInventory) {
        currentInventory.setName(requestInventory.getName());
        currentInventory.setQuantity(requestInventory.getQuantity());
        currentInventory.setAdmissionDate(requestInventory.getAdmissionDate());

        return currentInventory;
    }
}
