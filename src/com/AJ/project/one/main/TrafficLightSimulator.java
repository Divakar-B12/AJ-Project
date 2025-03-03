package com.AJ.project.one.main;

import com.AJ.project.one.controllers.TrafficLightController;
import com.AJ.project.one.gui.TrafficLightGUI;

import javax.swing.*;
import java.awt.*;

public class TrafficLightSimulator extends JFrame {
    private TrafficLightGUI gui;
    private TrafficLightController controller;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulation with Enhanced Design");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gui = new TrafficLightGUI();
        add(gui, BorderLayout.CENTER);
        controller = new TrafficLightController(gui);

        JPanel controlPanel = new JPanel();
        JButton startBtn = new JButton("Start Auto");
        JButton stopBtn = new JButton("Stop Auto");
        JButton redBtn = new JButton("Red");
        JButton greenBtn = new JButton("Green");
        JButton yellowBtn = new JButton("Yellow");

        controlPanel.add(startBtn);
        controlPanel.add(stopBtn);
        controlPanel.add(redBtn);
        controlPanel.add(greenBtn);
        controlPanel.add(yellowBtn);
        add(controlPanel, BorderLayout.SOUTH);

        startBtn.addActionListener(e -> controller.startAuto());
        stopBtn.addActionListener(e -> controller.stopAuto());
        redBtn.addActionListener(e -> controller.setManualLight(0));
        greenBtn.addActionListener(e -> controller.setManualLight(1));
        yellowBtn.addActionListener(e -> controller.setManualLight(2));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrafficLightSimulator().setVisible(true));
    }
}
