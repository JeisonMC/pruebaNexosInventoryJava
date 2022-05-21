package com.Nexos.Inventory.mapper;


import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.request.RequestInventory;

public interface MapperInventory {
    Inventory createInventory(RequestInventory requestInventory, Person person);

    Inventory updateInventory(Inventory inventory , RequestInventory requestInventory);
}
