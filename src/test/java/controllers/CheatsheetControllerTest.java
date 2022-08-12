package controllers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.dmwlabs.CheatsheetAPI.CheatsheetApiApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Cheatsheet;
import entities.CheatsheetDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes= {CheatsheetApiApplication.class, CheatsheetController.class})
@AutoConfigureMockMvc

public class CheatsheetControllerTest {

    @Autowired
    MockMvc mock;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ObjectMapper jsonifier;

    private CheatsheetDTO mapToDTO(Cheatsheet cheatsheet) {
        return mapper.map(cheatsheet, CheatsheetDTO.class);
    }

    private final Long TEST_CREATEID = 6L;
    private final Cheatsheet TEST_CREATECheat = new Cheatsheet(null, "", "Tim Burton", "console.log");

    @BeforeEach
    public void dbWipe() {

    }

    @Test
    public void testCreate() {
        Cheatsheet expected = TEST_CREATECheat;
        expected.setId(TEST_CREATEID);
        try {

            mock.perform(post("/cheats").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                            .content(this.jsonifier.writeValueAsString(TEST_CREATECheat)))

                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}