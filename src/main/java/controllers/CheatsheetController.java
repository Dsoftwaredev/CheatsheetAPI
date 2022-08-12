package controllers;

import entities.Cheatsheet;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class CheatsheetController {

    private final CheatsheetService service;

    public CheatsheetController(CheatsheetService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<Cheatsheet> getAllCheats() {
        return this.service.getAllCheats();
    }


}
