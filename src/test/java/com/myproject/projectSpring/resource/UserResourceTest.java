package com.myproject.projectSpring.resource;

import com.myproject.projectSpring.repositories.UserRepository;
import com.myproject.projectSpring.resources.UserResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserResource.class)
public class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void shoulReturnAllUser() throws Exception {
        mockMvc.perform(get("/user/all")).andExpect(status().isOk());

    }

    @Test
    public void shouldCreateOneUser() throws Exception {
        mockMvc.perform(post("/user/post")
                .contentType("application/json")
                .content("{\"id\":1,\"name\":\"test\",\"profession\":{\"id\":1,\"name\":\"Programmer\",\"description\":\"Create Programs\"}}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldDeleteOneUser() throws Exception {
        mockMvc.perform(post("/user/delete/1")).andExpect(status().isOk());
    }

    @Test
    public void shouldGetOneUser() throws Exception {
        mockMvc.perform(get("/user/1")).andExpect(status().isOk());
    }
}
