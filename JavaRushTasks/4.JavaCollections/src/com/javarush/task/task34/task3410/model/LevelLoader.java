package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        int currentLevel = level % 60 == 0 ? 60 : level % 60;
        List<String> levelInfo = new ArrayList<>();
        String stringLevel = "Maze: " + currentLevel;

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            String line = "";
            while (!line.equals(stringLevel)) { line = reader.readLine(); }
            for (int i = 0; i < 7; i++) {
                line = reader.readLine();
            }
            while (!"".equals(line)) {
                levelInfo.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Wall> wallSet = new HashSet<>();
        Set<Box> boxSet = new HashSet<>();
        Set<Home> homeSet = new HashSet<>();
        Player player = null;

        for (int i = 0; i < levelInfo.size(); i++) {
            String str = levelInfo.get(i);
            for (int j = 0; j < str.length(); j++) {
                int x = (j == 0) ? Model.FIELD_CELL_SIZE / 2 : (Model.FIELD_CELL_SIZE / 2) + j * Model.FIELD_CELL_SIZE;
                int y = (i == 0) ? Model.FIELD_CELL_SIZE / 2 : (Model.FIELD_CELL_SIZE / 2) + i * Model.FIELD_CELL_SIZE;
                char symbol = str.charAt(j);
                switch (symbol) {
                    case 'X': {
                        wallSet.add(new Wall(x,y));
                        break;
                    }
                    case '*': {
                        boxSet.add(new Box(x,y));
                        break;
                    }
                    case '.': {
                        homeSet.add(new Home(x,y));
                        break;
                    }
                    case '&': {
                        homeSet.add(new Home(x,y));
                        boxSet.add(new Box(x,y));
                        break;
                    }
                    case '@': {
                        player = new Player(x,y);
                        break;
                    }
                }
            }
        }

        return new GameObjects(wallSet, boxSet, homeSet, player);
    }
}
