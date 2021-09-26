package com.myproject.projectSpring.resource;

import com.myproject.projectSpring.repositories.ProfessionRepository;
import com.myproject.projectSpring.resources.ProfessionResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ProfessionResource.class)
public class ProfessionResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfessionRepository professionRepository;

    @Test
    public void shouldReturnAllProfessions() throws Exception {
        mockMvc.perform(get("/profission/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldPostAProfession() throws Exception {
        mockMvc.perform(post("/profission/post")
                        .contentType("application/json").content("{\"id\":\"null\", \"name\": \"Programmer\",\"description\":\" Create Programs\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void shoudReturnOnlyProfessionSpecific() throws Exception {
        mockMvc.perform(get("/profission/1")).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteProfession() throws Exception {
        mockMvc.perform(delete("/profission/delete/1")).andExpect(status().isOk());
    }
}
