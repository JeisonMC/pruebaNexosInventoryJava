package com.Nexos.Inventory;

import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.repository.RepositoryInventory;
import com.Nexos.Inventory.repository.RepositoryPerson;
import com.Nexos.Inventory.request.RequestInventory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class InventorySystemApplicationTestsInventory {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepositoryPerson repositoryPerson;

    @Autowired
    private RepositoryInventory repositoryInventory;

    @Test
    public void listAllInventory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/inventory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateInventory() throws Exception {
        RequestInventory requestInventory = new RequestInventory();
        requestInventory.setName("transmission toyota");
        requestInventory.setQuantity(12);
        requestInventory.setPersonId("e580e860-8fce-4626-b355-ec53786e19ff");
        requestInventory.setAdmissionDate(LocalDateTime.now(ZoneOffset.UTC).toString());

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/inventory")
                        .content(asJsonString(requestInventory))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateInventory() throws Exception {
        Person person = new Person();
        person.setPersonId(UUID.fromString("e580e860-8fce-4626-b355-ec53786e19ff"));
        person.setName("admin");
        person.setAge(25);
        person.setEmail("test@test.com");
        person.setPassword("123");
        repositoryPerson.save(person);


        Inventory inventoryTest = new Inventory();
        inventoryTest.setId(UUID.fromString("bce420ae-fc56-45db-8a3a-ce88465f3e62"));
        inventoryTest.setName("Bumper Nissan");
        inventoryTest.setQuantity(2);
        inventoryTest.setAdmissionDate(LocalDateTime.now(ZoneOffset.UTC).toString());
        inventoryTest.setPerson(person);
        repositoryInventory.save(inventoryTest);

        RequestInventory requestInventory = new RequestInventory();
        requestInventory.setName("Bumper Hyundai");
        requestInventory.setQuantity(10);
        requestInventory.setPersonId("e580e860-8fce-4626-b355-ec53786e19ff");
        requestInventory.setAdmissionDate(LocalDateTime.now(ZoneOffset.UTC).toString());

        mockMvc.perform(MockMvcRequestBuilders
                        .patch("/inventory/bce420ae-fc56-45db-8a3a-ce88465f3e62")
                        .content(asJsonString(requestInventory))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
