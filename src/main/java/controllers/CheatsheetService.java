package controllers;

import repositories.CheatsheetRepo;

public class CheatsheetService {

    public final CheatsheetRepo repo;

    public CheatsheetService(CheatsheetRepo repo) {
        this.repo = repo;
    }
}
