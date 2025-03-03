package com.AJ.project.one.gui;

import com.AJ.project.one.models.Car;
import com.AJ.project.one.business.TrafficBusinessLogic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrafficLightGUI extends JPanel {
    private Color red = Color.RED, yellow = Color.GRAY, green = Color.GRAY;
    private List<Car> cars = new ArrayList<>();
    private final int STOP_LINE = 350;
    private TrafficBusinessLogic businessLogic;

    public TrafficLightGUI() {
        setPreferredSize(new Dimension(1000, 600));
        Random random = new Random();
        businessLogic = new TrafficBusinessLogic();

        for (int i = 0; i < 10; i++) {
            int startX = -i * 200;
            int speed = 4 + random.nextInt(5);
            cars.add(new Car(startX, 500, new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), speed));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(160, 160, 160));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.fillRect(450, 100, 100, 300);

        g.setColor(red);
        g.fillOval(470, 110, 60, 60);
        g.setColor(yellow);
        g.fillOval(470, 180, 60, 60);
        g.setColor(green);
        g.fillOval(470, 250, 60, 60);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 480, 1000, 120);

        g.setColor(Color.WHITE);
        for (int i = 0; i < getWidth(); i += 100) {
            g.fillRect(i, 540, 50, 5);
        }

        for (Car car : cars) {
            g.setColor(car.color);
            g.fillRoundRect(car.x, car.y, 90, 50, 25, 25);
            g.setColor(Color.BLACK);
            g.fillOval(car.x + 10, car.y + 35, 20, 20);
            g.fillOval(car.x + 60, car.y + 35, 20, 20);
        }
    }

    public void setLight(int state) {
        red = (state == 0) ? Color.RED : Color.GRAY;
        green = (state == 1) ? Color.GREEN : Color.GRAY;
        yellow = (state == 2) ? Color.YELLOW : Color.GRAY;
        repaint();
    }

    public void moveCars(boolean move) {
        businessLogic.processCarMovement(cars, move, STOP_LINE);
        repaint();
    }
}