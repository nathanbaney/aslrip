package com.neb;

import com.badlogic.gdx.graphics.g3d.Model;

public class Hex {
    Model model;
    HexPos pos;

    public Hex(HexPos pos, Model model){
        this.pos = pos;
        this.model = model;
    }
    public Hex(HexPos pos){
        this(pos, null);
    }
    public Hex(){
        this(null, null);
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
