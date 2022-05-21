package com.Nexos.Inventory;

import com.Nexos.Inventory.request.RequestRole;
import com.Nexos.Inventory.service.ServiceRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class InventorySystemApplicationTestsRole {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ServiceRole serviceRole;

    @Test
    public void testListAllRole() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/role")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testcreateRole() throws Exception {
        RequestRole requestRole = new RequestRole();
        requestRole.setName("admin");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/role")
                        .content(asJsonString(requestRole))
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
