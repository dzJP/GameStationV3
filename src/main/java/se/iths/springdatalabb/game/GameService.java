package se.iths.springdatalabb.game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.springdatalabb.storage.PlayerRepository;


import java.util.*;

@Service
@SessionScope
public class GameService {
    @Autowired
    PlayerRepository playerRepository;
    Random random = new Random();
    Result result;
    Player player;
    private int secretNumber;

    public GameService() {
    }

    public Player add(String name) {
        Optional <Player> player = playerRepository.findByName(name);
        if (player.isEmpty()) {
            this.player = playerRepository.save(new Player(name));
        } else {
            this.player = player.get();
        }
        secretNumber = random.nextInt(1, 50);
        result = new Result();
        return this.player;
    }

    public String makeGuess(int guess) {
        if (guess > secretNumber) {
            return "The number: " + guess + " is too high. Number of tries: " + result.increaseScore();
        } else if (guess < secretNumber) {
            return "The number: " + guess + " is too low. Number of tries: " + result.increaseScore();
        }
        result.increaseScore();
        result.setResult(10);
        player.addResult(result);
        playerRepository.save(player);
        return guess + " is correct! 10 points awarded";
    }

    public String rollDice(int dice) {
        secretNumber = random.nextInt(1, 6);
        if (dice > secretNumber) {
            result.increaseScore();
            return "You rolled: " + dice + " Bot rolled: " + secretNumber;
        } else if (dice < secretNumber) {
            result.decreaseScore();
            return "You rolled: " + dice + " Bot rolled: " + secretNumber;
        }
        player.addResult(result);
        playerRepository.save(player);
        return "You rolled the same as the AI, Game Over.";
    }

    public List<PlayerDTO> getResult() {
        return playerRepository.findAll().stream().map(player -> new PlayerDTO(
                        player.getName(), player.getResults()
                        .stream()
                        .map(Result::getResult)
                        .reduce(0,Integer::sum)*1.0))
                        .sorted()
                        .toList();
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

}
