package repositories;

import entities.Cheatsheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheatsheetRepo extends JpaRepository<Cheatsheet, Integer> {

}
