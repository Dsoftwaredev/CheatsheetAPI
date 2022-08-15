package controllers;

import entities.Cheatsheet;
import entities.CheatsheetDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import repositories.CheatsheetRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CheatsheetService {

    private ModelMapper mapper;
    public final CheatsheetRepo repo;

    public CheatsheetService(CheatsheetRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public CheatsheetDTO mapToDTO(Cheatsheet cheatsheet) {
        return mapper.map(cheatsheet, CheatsheetDTO.class);
    }
    public List<Cheatsheet> getAllCheats() {
        return this.repo.findAll();
    }

    public Cheatsheet createCheat(Cheatsheet cheat) {
        Cheatsheet newCheatsheet = this.repo.save(cheat);
        return newCheatsheet;
    }

    public Cheatsheet updateCheat(Long id, Cheatsheet cheat) {
        Optional<Cheatsheet> CheatToUpdateOptional = this.repo.findById(id);
        if (!CheatToUpdateOptional.isPresent()) {
            return null;
        }

        // Since isPresent() was true, we can .get() the Person object out of the Optional
        Cheatsheet CheatToUpdate = CheatToUpdateOptional.get();

        if (cheat.getCodeLanguage() != null) {
            CheatToUpdate.setCodeLanguage(cheat.getCodeLanguage());
        }
        if (cheat.getCheatMethod() != null) {
            CheatToUpdate.setCheatMethod(cheat.getCheatMethod());
        }
        if (cheat.getCheatBody() != null) {
            CheatToUpdate.setCheatBody(cheat.getCheatBody());
        }
        Cheatsheet updatedCheat = this.repo.save(CheatToUpdate);
        return updatedCheat;
    }

    public Cheatsheet deleteCheat(Long id) {
        Optional<Cheatsheet> cheatToDeleteOptional = this.repo.findById(id);
        if (!cheatToDeleteOptional.isPresent()) {
            return null;
        }
        Cheatsheet cheatToDelete = cheatToDeleteOptional.get();
        this.repo.delete(cheatToDelete);
        return cheatToDelete;
    }
}
