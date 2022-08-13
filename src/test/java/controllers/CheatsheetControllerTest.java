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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes= {CheatsheetApiApplication.class, CheatsheetController.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
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

    @BeforeEach
    public void dbWipe() {

    }

    private final Long TEST_CREATEID = 1L;

    private final Long TEST_ID1 = 1L;
    private final Cheatsheet TEST_CHEAT1 = new Cheatsheet(1L, "Java", "print", "console.log()");
    private final Long TEST_1D2 = 2L;
    private final Cheatsheet TEST_CHEAT2 = new Cheatsheet(2L, "Javascript", "print", "console.print()");
    private final Long TEST_ID3 = 3L;
    private final Cheatsheet TEST_CHEAT3 = new Cheatsheet(3L, "Java", "print", "console.log()");

    private final Cheatsheet TEST_CREATECheat = new Cheatsheet(null, "Java", "print", "console.log()");



    @Test
    public void testCreate() {
        Cheatsheet expected = TEST_CREATECheat;
        expected.setId(1L);
        try {

            mock.perform(post("/cheats").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                            .content(this.jsonifier.writeValueAsString(TEST_CREATECheat)))

                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAll() {
        List<CheatsheetDTO> expected = List.of(mapToDTO(TEST_CHEAT1),mapToDTO(TEST_CHEAT2));
        try {

            mock.perform(get("/cheats").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(expected)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testUpdate() {
        Cheatsheet updated = TEST_CHEAT1;
        Long ID = TEST_ID1;
        try {

            mock.perform(put("/cheats/"+ID).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
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

            mock.perform(delete("/cheats/"+id).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(expected)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}