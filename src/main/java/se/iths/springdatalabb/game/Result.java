package se.iths.springdatalabb.game;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer result;

    public Result() {
        this.result = 0;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }

    public int decreaseScore() {
        return --result;
    }

    public int increaseScore() {
        return ++result;
    }
}
