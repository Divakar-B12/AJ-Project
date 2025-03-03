package com.AJ.project.one.models;

import java.awt.*;

public class Car {
    public int x, y;
    public Color color;
    public boolean hasCrossedLight = false;
    public int speed;

    public Car(int x, int y, Color color, int speed) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.speed = speed;
    }

    public void move() {
        x += speed;
    }
}