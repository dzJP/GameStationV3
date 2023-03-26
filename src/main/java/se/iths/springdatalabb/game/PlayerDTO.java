package se.iths.springdatalabb.game;

public class PlayerDTO implements Comparable {

    private String name;
    private Double score;

    public PlayerDTO(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object object) {
        PlayerDTO playerDTO = (PlayerDTO) object;
        return Double.compare(this.score, playerDTO.score);
    }

    public PlayerDTO() {
    }

    public Double getScore() {
        return score;
    }

    public String getName() {
        return name;
    }



}
