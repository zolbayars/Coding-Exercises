package com.zolbayar.cracking_the_oyster.object_oriented_design;

/*
    Purpose: Design an object oriented data structure for a simple call center.
            When there are no available responder or they couldn't handle the customer,
            the call is escalated to a manager and so on to the director.

    Insight: Don't make it so simple

 */

import java.util.ArrayList;

public class CallCenter {

    private ArrayList<Responder> responders;
    private ArrayList<Manager> managers;
    private ArrayList<Director> directors;

    public void dispatchCall(){
        boolean isCustomerServed = false;

        isCustomerServed = serveCustomer(responders);


    }

    private boolean serveCustomer(ArrayList<Employee> employees){
        boolean isServed = false;

        for(Employee employee : employees){
            if(employee.isAvailable()){
                employee.serveCustomer();
                employee.makeUnavailable();
                isServed = true;
            }
        }

        return isServed;
    }

    abstract class Employee {
        public abstract void escalateCall();
        public abstract boolean isAvailable();
        public abstract void makeAvailable();
        public abstract void makeUnavailable();
        public abstract void serveCustomer();
    }

    class Responder extends Employee {

        @Override
        public void escalateCall() {

        }

        @Override
        public boolean isAvailable() {
            return false;
        }

        @Override
        public void makeAvailable() {

        }

        @Override
        public void makeUnavailable() {

        }

        @Override
        public void serveCustomer() {

        }
    }

    class Manager extends Employee{

        @Override
        public void escalateCall() {

        }

        @Override
        public boolean isAvailable() {
            return false;
        }

        @Override
        public void makeAvailable() {

        }

        @Override
        public void makeUnavailable() {

        }

        @Override
        public void serveCustomer() {

        }
    }

    class Director extends Employee{

        @Override
        public void escalateCall() {

        }

        @Override
        public boolean isAvailable() {
            return false;
        }

        @Override
        public void makeAvailable() {

        }

        @Override
        public void makeUnavailable() {

        }

        @Override
        public void serveCustomer() {

        }
    }
}
