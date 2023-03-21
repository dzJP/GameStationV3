package se.iths.springdatalabb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    List<Player> findByNumber(int number);

    List <Player> findByName(String name);
}
