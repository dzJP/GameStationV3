package se.iths.springdatalabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.springdatalabb.game.GameService;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/new")
    public String login(@RequestParam String name, Model model) {
        // Login in method;
        model.addAttribute("player", gameService.add(name));
        return "redirect:/";
    }

    @GetMapping("/guess")
    public String guessViewPage(Model model) {
        return "guessgame";
    }

    @PostMapping("/all")
    String getAll(Model model) {
        model.addAttribute("guessList", gameService.getAll());
        return "resultpage";
    }

    @PostMapping("/guess")
    public String guessGame(@RequestParam int guess, Model model) {
        String guessText = gameService.makeGuess(guess);
        model.addAttribute("guess", guessText);
        return "guessgame";
    }

    @GetMapping("/dicegame")
    public String diceViewPage(Model m) {
        return "dicegame";
    }

    @PostMapping("/dicegame")
    public String diceGame(@RequestParam int dice, Model m) {
        String diceText = gameService.rollDice(dice);
        m.addAttribute("dicegame", diceText);
        return "dicegame";
    }

    @GetMapping("/result")
    String getResult(Model model) {
        model.addAttribute("results", gameService.getResult());
        return "resultpage";
    }

}
