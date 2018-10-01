package com.zolbayar.cracking_the_oyster.object_oriented_design;

/*
    Purpose: Design a parking lot with object oriented principles

    Insight:
 */

import java.util.List;
import java.util.Queue;

public class ParkingLotDesign {

    class ParkingLot {
        Queue<ParkingSpot> availableSpots;
        List<ParkingSpot> filledSpots;

        int perHourFee;

        public ParkingLot(Queue<ParkingSpot> availableSpots, List<ParkingSpot> filledSpots, int perHourFee) {
            this.availableSpots = availableSpots;
            this.filledSpots = filledSpots;
            this.perHourFee = perHourFee;
        }

        public boolean enterCar(Car car){
            if(availableSpots.size() > 0){
                ParkingSpot spot = availableSpots.remove();
                car.park(spot);
                filledSpots.add(spot);
            }

            return false;
        }

        public boolean exitCar(Car car){
            if(car.occupiedSpot != null){
                for(ParkingSpot spot : filledSpots){
                    if(spot.equals(car.occupiedSpot)){
                        filledSpots.remove(spot);
                        break;
                    }
                }

                availableSpots.add(car.occupiedSpot);
                return true;
            }

            return false;
        }

    }

    class Car {

        String model;
        String regNum;
        ParkingSpot occupiedSpot;

        void park(ParkingSpot spot){
            spot.isAvailable = false;
            spot.currentCar = this;
            occupiedSpot = spot;
        }
    }

    class Entrance {
        boolean isOpened;

        public void chargeFee(Car car){

        }
    }

    class ParkingSpot {
        int number;
        boolean isAvailable;
        Car currentCar;
    }
}
