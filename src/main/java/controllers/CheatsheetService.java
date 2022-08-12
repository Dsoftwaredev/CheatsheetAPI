package controllers;

import entities.Cheatsheet;
import org.springframework.stereotype.Service;
import repositories.CheatsheetRepo;

import java.util.List;

@Service
public class CheatsheetService {

    public final CheatsheetRepo repo;

    public CheatsheetService(CheatsheetRepo repo) {
        this.repo = repo;
    }

    public List<Cheatsheet> getAllCheats() {
        return this.repo.findAll();
    }

    public Cheatsheet createCheat(Cheatsheet cheat) {
        Cheatsheet newCheatsheet = this.repo.save(cheat);
        return newCheatsheet;
    }
}
