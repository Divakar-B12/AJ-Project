package com.AJ.project.one.business;

import com.AJ.project.one.models.Car;
import java.util.List;

public class TrafficBusinessLogic {
    public void processCarMovement(List<Car> cars, boolean move, int stopLine) {
        for (Car car : cars) {
            if (car.hasCrossedLight || move) {
                car.move();
                if (car.x >= stopLine) {
                    car.hasCrossedLight = true;
                }
            }
            if (car.x > 1000) {
                car.x = -200;
                car.hasCrossedLight = false;
            }
        }
    }
}