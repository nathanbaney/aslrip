package com.neb;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelCache;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;

/**
 * big ol thing of hexes, look into using ModelCache
 */
public class HexMap {
    public final int width;
    public final int height;

    public Map<HexPos, Hex> hexMap;

    public ModelCache cache;

    public HexMap(int width, int height){
        this.width = width;
        this.height = height;
        hexMap = new HashMap<HexPos, Hex>();
        cache = new ModelCache();
    }
    public HexMap(){
        this(10, 10);
    }
    public void testInitialize(){
        Material triMat = new Material();
        Model testModel = getTestModel();
        cache.begin();
        for (int x = 0; x < 1; x++){
            for (int y = 0; y < 1; y++){
                HexPos tempPos = new HexPos(x, y);
                Hex tempHex = new Hex(tempPos, testModel);
                hexMap.put(tempPos, tempHex);
                ModelInstance tempInstance = new ModelInstance(testModel);
                tempInstance.transform.setTranslation(x, y, 0);
                cache.add(tempInstance);
            }
        }
        cache.end();
    }
    private Model getTestModel(){
        Model testModel;
        ModelBuilder builder = new ModelBuilder();
        builder.begin();
        MeshPartBuilder partBuilder;
        partBuilder = builder.part("tri1", GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                new Material());
        partBuilder.triangle(new Vector3(20, 0, 0), new Vector3(60, 0, 0), new Vector3(40, 40, 0));
        builder.node();
        partBuilder = builder.part("tri2", GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                new Material());
        partBuilder.triangle(new Vector3(20, 0, 0), new Vector3(40, 40, 0), new Vector3(0, 40, 0));
        builder.node();
        partBuilder = builder.part("tri3", GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                new Material());
        partBuilder.triangle(new Vector3(40, 40, 0), new Vector3(60, 0, 0), new Vector3(80, 40, 0));
        builder.node();
        partBuilder = builder.part("tri4", GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                new Material());
        partBuilder.triangle(new Vector3(0, 40, 0), new Vector3(40, 40, 0), new Vector3(20, 80, 0));
        builder.node();
        partBuilder = builder.part("tri5", GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                new Material());
        partBuilder.triangle(new Vector3(40, 40, 0), new Vector3(60, 80, 0), new Vector3(20, 80, 0));
        builder.node();
        partBuilder = builder.part("tri6", GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                new Material());
        partBuilder.triangle(new Vector3(40, 40, 0), new Vector3(80, 40, 0), new Vector3(60, 80, 0));
        builder.node();
        testModel = builder.end();
        return testModel;
    }
}
