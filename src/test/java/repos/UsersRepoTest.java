package repos;


import com.dmwlabs.CheatsheetAPI.CheatsheetApiApplication;
import entities.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import repositories.UsersRepo;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {CheatsheetApiApplication.class, UsersRepo.class})
@ActiveProfiles("test")
public class UsersRepoTest {

    @Autowired
    UsersRepo repo;

    @BeforeEach
    public void dbWipe() {

    }

    @Test
    public void testSave() {
        Users users = new Users(1L, "Daniel", "dan@icloud.com");
        assertEquals(users, repo.save(users));
    }

    @Test
    public void testFindAll() {
        Users user1 = new Users(1L,"Daniel", "danielw1@icloud.com" );
        Users user2 = new Users(2L,"Daniel M", "danielw2@icloud.com");

        List<Users> expected = List.of(user1, user2);
        assertEquals(expected, repo.findAll());
    }
}
