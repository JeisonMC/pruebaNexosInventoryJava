package com.Nexos.Inventory;

import com.Nexos.Inventory.request.RequestPerson;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class InventorySystemApplicationTestsPerson {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listAllPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testcreatePerson() throws Exception {
        RequestPerson requestPerson = new RequestPerson();
        requestPerson.setName("admin");
        requestPerson.setAge(25);
        requestPerson.setEmail("test@test.com");
        requestPerson.setPassword("123");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/person")
                        .content(asJsonString(requestPerson))
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
