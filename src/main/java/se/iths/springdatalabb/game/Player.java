package se.iths.springdatalabb.game;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Result> results;

    public Player() {
    }
    public Player(String name) {
        this.name = name;
        this.results = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Result> getResults() {
        return results;
    }

    public void setResult(List<Result> results) {
        this.results = results;
    }

    public void addResult(Result result) {
        results.add(result);
    }

}
