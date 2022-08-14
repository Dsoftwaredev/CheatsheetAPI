package controllers;

import config.config;
import entities.Cheatsheet;
import entities.Users;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import repositories.CheatsheetRepo;
import repositories.UsersRepo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {UsersService.class, UsersRepo.class, config.class})
@ActiveProfiles("test")
public class UsersServiceTest {

    @Autowired
    UsersService service;

    @MockBean
    UsersRepo repo;

    @Test
    public void testCreate() {
        Users user = new Users(1L, "Daniel m", "Danielw288@icloud.com");

        Mockito.when(repo.save(user)).thenReturn(user);
        assertEquals(service.createUser(user), user);

        Mockito.verify(this.repo, Mockito.times(1)).save(user);

    }

    @Test
    public void testGetAllUsers() {
        Users user = new Users(1L, "Daniel", "Danielw288@icloud.com" );
        List<Users> list = new ArrayList<Users>();
        list.add(user);
        Mockito.when(repo.findAll()).thenReturn(list);
        assertEquals(list, service.getAllUsers());
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

}
