package com.rps.entities.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String move;

    public void setName( String name ) {
        this.name = name;
    }

    public void setMove( String move ) {
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public String getMove() {
        return move;
    }

    public Move() {
    }

    public Move( String name, String move ) {
        this.name = name;
        this.move = move;
    }
}