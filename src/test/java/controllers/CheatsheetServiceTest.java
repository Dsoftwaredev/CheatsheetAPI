package controllers;

import config.config;
import entities.Cheatsheet;
import entities.CheatsheetDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import repositories.CheatsheetRepo;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(classes = {CheatsheetService.class, CheatsheetRepo.class, config.class})
@ActiveProfiles("test")
public class CheatsheetServiceTest {

    @Autowired
    CheatsheetService service;

    @MockBean
    CheatsheetRepo repo;

    @Test
    public void testCreate() {
        Cheatsheet cheatsheet = new Cheatsheet(1L, "Java", "Print", "System.out.println");

        Mockito.when(repo.save(cheatsheet)).thenReturn(cheatsheet);
        assertEquals(service.createCheat(cheatsheet), cheatsheet);

        Mockito.verify(this.repo, Mockito.times(1)).save(cheatsheet);

    }

    @Test
    public void testGetAllCheats() {
        Cheatsheet cheatsheet = new Cheatsheet(1L,"Java", "Print", "System.out.println");
        List<Cheatsheet> list = new ArrayList<Cheatsheet>();
        list.add(cheatsheet);
        Mockito.when(repo.findAll()).thenReturn(list);
        assertEquals(list, service.getAllCheats());
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

}
