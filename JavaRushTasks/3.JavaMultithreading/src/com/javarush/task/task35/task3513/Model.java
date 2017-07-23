package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score = 0;
    protected int maxTile = 2;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value) return true;
            }
        }

        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i-1][j].value) return true;
            }
        }
        return false;
    }

    protected void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            Tile randomTile = emptyTiles.get((int) (Math.random() * emptyTiles.size()));
            randomTile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTales = new ArrayList<>();

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].isEmpty()) emptyTales.add(gameTiles[i][j]);
            }
        }
        return emptyTales;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length-1; i++) {
            for (int j = 0; j < tiles.length-1; j++) {
                if (tiles[j].isEmpty() && !tiles[j+1].isEmpty()) {
                    tiles[j] = tiles[j+1];
                    tiles[j+1] = new Tile();
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        compressTiles(tiles);
        boolean isChanged = false;
        for (int i = 0; i < tiles.length-1; i++) {
            if (tiles[i].value == tiles[i+1].value && !tiles[i].isEmpty()) {
                isChanged = true;
                tiles[i].value = tiles[i].value * 2;
                tiles[i+1] = new Tile();
                score += tiles[i].value;
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                compressTiles(tiles);
            }
        }
        return isChanged;
    }

    private void rotateToRight() {
        for (int i = 0; i < FIELD_WIDTH / 2; i++)
        {
            for (int j = i; j < FIELD_WIDTH - i - 1; j++) {
                Tile temp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH - 1 - j][i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = temp;
            }
        }
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTiles[i][j] = new Tile();
            }
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTiles[i][j].value = tiles[i][j].value;
            }
        }

        previousStates.push(newTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty()) gameTiles = previousStates.pop();
        if (!previousScores.isEmpty()) score = previousScores.pop();
    }

    void left() {
        if (isSaveNeeded) saveState(gameTiles);
        int j = 0;
        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]))
                j++;
        }
        if (j != 0) {
            addTile();
        }
        isSaveNeeded = true;
    }

    void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }

    void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }

    void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }

    void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0: left();
            case 1: right();
            case 2: up();
            case 3: down();
        }
    }

    public boolean hasBoardChanged() {
        int sum1 = 0;
        int sum2 = 0;
        if (!previousStates.isEmpty()) {
            for (int i = 0; i < gameTiles.length; i++) {
                for (int j = 0; j < gameTiles.length; j++) {
                    sum1 += gameTiles[i][j].value;
                    sum2 += previousStates.peek()[i][j].value;
                }
            }
        }
        return sum1 != sum2;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        final PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());

        queue.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                left();
            }
        }));

        queue.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                right();
            }
        }));

        queue.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                up();
            }
        }));

        queue.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                down();
            }
        }));

        MoveEfficiency mov = queue.peek();
        mov.getMove().move();
    }
}
