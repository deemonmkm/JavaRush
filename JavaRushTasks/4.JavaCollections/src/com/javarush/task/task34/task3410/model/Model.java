package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model implements EventListener {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    GameObjects gameObjects;
    int currentLevel = 1;
    LevelLoader levelLoader = new LevelLoader(Paths.get("..\\res\\levels.txt"));

    @Override
    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollisionAndMoveIfAvaliable(direction)) return;
        switch (direction) {
            case RIGHT:
                player.move(FIELD_CELL_SIZE, 0);
                break;
            case LEFT:
                player.move(-FIELD_CELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_CELL_SIZE);
                break;
        }
        checkCompletion();
    }

    @Override
    public void restart() {
        restartLevel(currentLevel);
    }

    @Override
    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    @Override
    public void levelCompleted(int level) {

    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Player player = gameObjects.getPlayer();

        GameObject stop = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Home) &&
                    !(gameObject instanceof Player) &&
                    player.isCollision(gameObject, direction)) {
                stop = gameObject;
            }
        }
        if (stop == null) return false;
        if (stop instanceof Box) {
            Box stopBox = (Box) stop;
            if (checkWallCollision(stopBox, direction)) return true;
            for (Box box : gameObjects.getBoxes()) {
                if (stopBox.isCollision(box, direction)) return true;
            }
            switch (direction) {
                case DOWN:
                    stopBox.move(0, FIELD_CELL_SIZE);
                    break;
                case UP:
                    stopBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case RIGHT:
                    stopBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case LEFT:
                    stopBox.move(-FIELD_CELL_SIZE, 0);
                    break;
            }
        }
        return false;
    }

    public void checkCompletion()
    {

        boolean yes = true;

        for (Home home : gameObjects.getHomes())
        {
            boolean currentyes = false;

            for (Box box : gameObjects.getBoxes())
            {
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    currentyes = true;
            }

            if (!currentyes) yes = false;
        }

        if (yes)
            eventListener.levelCompleted(currentLevel);
    }
}
