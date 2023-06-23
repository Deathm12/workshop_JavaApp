package com.WorkshopJava.app;

import java.util.Map;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class App extends GameApplication {
    // EntityBuilder player;
    Entity player;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    public void initGame() {
        EntityBuilder build = FXGL.entityBuilder();
        build.at(50, 50);
        build.view(new Rectangle(25, 25, Color.BLUE));
        player = build.buildAndAttach();
        FXGL.getGameWorld().addEntityFactory(new Factory());
        FXGL.spawn("enemy", 10, 10);
    }

    @Override
    public void initInput() {
        FXGL.onKeyDown(KeyCode.RIGHT, () -> {
            player.setPosition((player.getX() + 5), player.getY());
        });
        FXGL.onKeyDown(KeyCode.LEFT, () -> {
            player.setPosition((player.getX() - 5), player.getY());
        });
        FXGL.onKeyDown(KeyCode.UP, () -> {
            player.setPosition((player.getX()), player.getY() - 5);
        });
        FXGL.onKeyDown(KeyCode.DOWN, () -> {
            player.setPosition((player.getX()), player.getY() + 5);
        });
    }

    @Override
    public void initUI() {
        Text textPixels = new Text("Ceci est un text");
        textPixels.setTranslateX(50);
        textPixels.setTranslateY(100);
        FXGL.getGameScene().addUINode(textPixels);
        // textPixels.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());
    }

    // @Override
    // protected void initGameVars(Map<String, Object> vars) {
    //     vars.put("pixelsMoved", 0);
    //     FXGL.inc("pixelMoved", +1);
    // }
}
