package repos;


import com.dmwlabs.CheatsheetAPI.CheatsheetApiApplication;
import entities.Cheatsheet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import repositories.CheatsheetRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {CheatsheetApiApplication.class, CheatsheetRepo.class})
@ActiveProfiles("test")
public class CheatsheetRepoTest {

    @Autowired
    CheatsheetRepo repo;

    @BeforeEach
    public void dbWipe() {

    }

    @Test
    public void testSave() {
        Cheatsheet cheatsheet = new Cheatsheet(1L, "test", "test", "test");
        assertEquals(cheatsheet, repo.save(cheatsheet));
    }

    @Test
    public void testFindAll() {
        Cheatsheet cheat1 = new Cheatsheet(1L,"Java", "print", "console.log()" );
        Cheatsheet cheat2 = new Cheatsheet(2L,"Javascript", "print", "console.print()");
        Cheatsheet cheat3= new Cheatsheet(3L,"Java", "print", "console.log()" );
        List<Cheatsheet> expected = List.of(cheat1, cheat2, cheat3);
        assertEquals(expected, repo.findAll());
    }

}
