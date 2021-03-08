package com.rps.entities.datamodel;
import javax.persistence.*;
import java.util.List;

@Entity
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany
            (
            targetEntity = Move.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="gameId_fk",
    referencedColumnName = "id")
    private List<Move> moves;
    private String result;


    public GameResult( List<Move> moves, String result ) {
        this.moves = moves;
        this.result = result;
    }

    public GameResult() {
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> playerDetails) {
        this.moves = playerDetails;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
