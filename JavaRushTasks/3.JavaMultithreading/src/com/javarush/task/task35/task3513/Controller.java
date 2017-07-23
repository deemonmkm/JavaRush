package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;

    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return this.model.score;
    }

    public void resetGame() {
        model.resetGameTiles();
        model.maxTile = 2;
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
    }

    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ESCAPE) resetGame();
        if (!this.model.canMove()) view.isGameLost = true;
        if (!view.isGameLost && !view.isGameWon) {
            if (key.getKeyCode() == KeyEvent.VK_LEFT) model.left();
            if (key.getKeyCode() == KeyEvent.VK_RIGHT) model.right();
            if (key.getKeyCode() == KeyEvent.VK_UP) model.up();
            if (key.getKeyCode() == KeyEvent.VK_DOWN) model.down();
            if (key.getKeyCode() == KeyEvent.VK_Z) model.rollback();
            if (key.getKeyCode() == KeyEvent.VK_R) model.randomMove();
            if (key.getKeyCode() == KeyEvent.VK_A) model.autoMove();
        }
        if (this.model.maxTile == WINNING_TILE) view.isGameWon = true;
        view.repaint();
    }
}
