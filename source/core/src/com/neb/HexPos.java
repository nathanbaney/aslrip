package com.neb;

import java.util.ArrayList;
import java.util.List;

public class HexPos {
    public int x;
    public int y;

    public HexPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    public HexPos getN(){
        return new HexPos(this.x, this.y - 2);
    }
    public HexPos getNE(){
        return new HexPos(this.x, this.y - 1);
    }
    public HexPos getNW(){
        return new HexPos(this.x - 1, this.y - 1);
    }
    public HexPos getS(){
        return new HexPos(this.x, this.y + 2);
    }
    public HexPos getSE(){
        return new HexPos(this.x, this.y + 1);
    }
    public HexPos getSW(){
        return new HexPos(this.x - 1, this.y + 1);
    }
    public List<HexPos> getAdjacents(){
        List<HexPos> neighbors = new ArrayList<HexPos>();
        neighbors.add(this.getN());
        neighbors.add(this.getNE());
        neighbors.add(this.getNW());
        neighbors.add(this.getS());
        neighbors.add(this.getSE());
        neighbors.add(this.getSW());
        return neighbors;
    }
    @Override
    public int hashCode(){
        return this.x + this.y * 10000; //as close to upper/lower registers as i know in java lol
    }
    @Override
    public boolean equals(Object o){
        return (this.hashCode() == o.hashCode());
    }
}
