package controllers;

import com.dmwlabs.CheatsheetAPI.CheatsheetApiApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Users;
import entities.UsersDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes= {CheatsheetApiApplication.class, UsersController.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UsersControllerTest {

    @Autowired
    MockMvc mock;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ObjectMapper jsonifier;

    private UsersDTO mapToDTO(Users users) {
        return mapper.map(users, UsersDTO.class);
    }

    @BeforeEach
    public void dbWipe() {

    }

    private final Long TEST_CREATEID = 1L;

    private final Long TEST_ID1 = 1L;

    private final Users TEST_USER1 = new Users(1L, "Daniel", "danielw1@icloud.com");
    private final Long TEST_1D2 = 2L;
    private final Users TEST_USER2 = new Users(2L, "Daniel M", "danielw2@icloud.com");
    private final Long TEST_ID3 = 3L;
    private final Users TEST_USER3 = new Users(3L, "Daniel W", "danielw3@icloud.com");

    private final Users TEST_CREATEUSER = new Users(null, "Daniel", "danielw1@icloud.com");


    @Test
    public void testGetAll() {
        List<UsersDTO> expected = List.of(mapToDTO(TEST_USER1),mapToDTO(TEST_USER2));
        try {

            mock.perform(get("/users").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(expected)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() {
        Users expectedUser = TEST_CREATEUSER;
        expectedUser.setId(1L);
        try {

            mock.perform(post("/users").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                            .content(this.jsonifier.writeValueAsString(TEST_CREATEUSER)))

                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expectedUser))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Test
    public void testUpdate() {
        Users updated = TEST_USER1;
        Long ID = TEST_ID1;
        try {

            mock.perform(put("/users/"+ID).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                            .content(this.jsonifier.writeValueAsString(updated)))
                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(updated)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        Long id = TEST_ID3;
        boolean expected = true;
        try {

            mock.perform(delete("/users/"+id).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(expected)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}