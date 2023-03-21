package se.iths.springdatalabb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    public List<Player> getAll() {
        return repo.findAll();
    }

    public List <Player> getByNumber(int number) {
        return repo.findByNumber(number);
    }

    public void add(Player player) {
        repo.save(player);
    }
}
