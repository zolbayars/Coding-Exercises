package com.zolbayar.cracking_the_oyster.object_oriented_design;

/*
    Purpose: Design a parking lot with object oriented principles

    Insight: Don't just make simple assumptions.
        - Core classes could've been these: Vehicle, Bus, Motorcycle, Car, ParkingLot, Level, ParkingSpot
        - Vehicle is an abstract parent for vehicle types, ParkingLot is a wrapper class around bunch of levels
        - Levels are filled with parking spots
 */

import java.util.List;

public class ParkingLotDesign {

    class ParkingLot {
        Level[] levels;
        private final int NUM_LEVELS = 5;

        public void parkVehicle(Vehicle vehicle){

        }
    }

    class Level {
        int level;
        ParkingSpot[] parkingSpots;
        int availableSpots;
    }

    class ParkingSpot {
        int rowNum;
    }

    public enum VehicleType {
        LARGE, COMPACT, SMALL
    }

    public abstract class Vehicle {
        protected List<ParkingSpot> spotsOccupied;
        protected String licencePlate;
        protected VehicleType type;
        protected int rowSize;

        public void park(ParkingSpot spot){
            spotsOccupied.add(spot);
        }

        public void leave(){
            spotsOccupied.clear();
        }

        public List<ParkingSpot> getSpotsOccupied() {
            return spotsOccupied;
        }

        public String getLicencePlate() {
            return licencePlate;
        }

        public VehicleType getType() {
            return type;
        }

        public int getRowSize() {
            return rowSize;
        }
    }

    class Car extends Vehicle {
        public Car() {
            type = VehicleType.COMPACT;
            rowSize = 1;
        }
    }

    class MotorCycle extends Vehicle {
        public MotorCycle() {
            type = VehicleType.SMALL;
            rowSize = 1;
        }
    }

    class Bus extends Vehicle {
        public Bus() {
            type = VehicleType.LARGE;
            rowSize = 5;
        }
    }

}
