package controllers;

import entities.Cheatsheet;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class CheatsheetController {

    private final CheatsheetService service;

    public CheatsheetController(CheatsheetService service) {
        this.service = service;
    }

    @GetMapping("/cheats")
    public List<Cheatsheet> getAllCheats() {
        return this.service.getAllCheats();
    }

    @PostMapping("/cheats")
    public Cheatsheet createCheat(@RequestBody Cheatsheet cheat) {
        return this.service.createCheat(cheat);
    }

    @PutMapping("/cheats/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cheatsheet updateCheat(@PathVariable("id") Long id, @RequestBody Cheatsheet cheat) {
        return this.service.updateCheat(id, cheat);
    }
    @DeleteMapping("/cheats/{id}")
    public Cheatsheet deleteCheat(@PathVariable("id") Long id) {
        return this.service.deleteCheat(id);
    }

}
