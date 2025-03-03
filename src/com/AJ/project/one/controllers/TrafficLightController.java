package com.AJ.project.one.controllers;

import com.AJ.project.one.gui.TrafficLightGUI;

import javax.swing.*;

public class TrafficLightController {
    private TrafficLightGUI gui;
    private Timer lightTimer, carTimer;
    private int state = 0;

    public TrafficLightController(TrafficLightGUI gui) {
        this.gui = gui;
        lightTimer = new Timer(5000, e -> changeLight());
        carTimer = new Timer(100, e -> gui.moveCars(state == 1));
        carTimer.start();
    }

    public void startAuto() {
        lightTimer.start();
    }

    public void stopAuto() {
        lightTimer.stop();
    }

    public void setManualLight(int newState) {
        state = newState;
        gui.setLight(state);
    }

    private void changeLight() {
        state = (state + 1) % 3;
        gui.setLight(state);
    }
}
