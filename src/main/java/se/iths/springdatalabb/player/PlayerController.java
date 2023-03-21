package se.iths.springdatalabb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    PlayerService service;

    @GetMapping("/all")
    String getAll(Model m) {
        m.addAttribute("playerList", service.getAll());
        return "show";
    }

    @PostMapping("/number")
    String getBySecretNumber(Model m, @RequestParam int playerNumber) {
        m.addAttribute("playerList", service.getByNumber(playerNumber));
        return "show";
    }


    @GetMapping("/new")
    String addNewForm(Model m) {
        m.addAttribute("player", new Player());
        return "newplayer";
    }


    @PostMapping("/new")
    String addNewPlayer(@ModelAttribute Player player, Model m) {
        // NEver trust a client
        service.add(player);
        m.addAttribute("player", new Player());
        return "newplayer";
    }


}
