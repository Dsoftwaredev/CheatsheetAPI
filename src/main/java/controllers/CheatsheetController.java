package controllers;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class CheatsheetController {

    private final CheatsheetService service;

    public CheatsheetController(CheatsheetService service) {
        this.service = service;
    }


}
