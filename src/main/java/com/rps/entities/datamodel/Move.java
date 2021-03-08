package com.rps.entities.datamodel;
import com.rps.entities.LegalMove;

import javax.persistence.*;

@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private LegalMove move;

    public void setName( String name ) {
        this.name = name;
    }

    public void setMove( LegalMove move ) {
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public LegalMove getMove() {
        return move;
    }

    public Move() {
    }

    public Move( String name, LegalMove move ) {
        this.name = name;
        this.move = move;
    }
}