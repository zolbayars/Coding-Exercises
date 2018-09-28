package com.zolbayar.cracking_the_oyster.object_oriented_design;

/*
    Purpose: Design an object oriented data structure for a simple call center.
            When there are no available responder or they couldn't handle the customer,
            the call is escalated to a manager and so on to the director.

    Insight: Don't make it so simple
            - CallHandler and Call classes were necessary. And the Rank enum too.
            - Call should be placed on the call handler. Then it should've queue the current employees by the rank
            - assign values for levels of employees and number of respondents
            - the call queue should be created from a new call (which comes from dispatchCall method)
 */

import java.util.List;

public class CallCenter {

    class CallHandler {

        private final int LEVELS = 3;

        private final int RESPONDENTS = 10;
        private final int MANAGERS = 3;
        private final int DIRECTORS = 2;

        // Employee queue with rank.
        // 0 - responder, 1 - manager, 2 - director
        List<List<Employee>> employeeQueue;
        List<List<Call>> callQueue;

        public CallHandler(List<List<Employee>> employeeQueue, List<List<Call>> callQueue) {
            this.employeeQueue = employeeQueue;
            this.callQueue = callQueue;
        }

        private Employee getAvailableEmployee(){
            for(List<Employee> employeeList : employeeQueue){
                for(Employee employee : employeeList){
                    if(employee.isAvailable()){
                        return employee;
                    }
                }
            }
            return null;
        }

        public void receiveCalls(Caller caller){
            Call call = new Call(caller);
            dispatchCall(call);
        }

        private void dispatchCall(Call call){
            Employee employee = getAvailableEmployee();
            if(employee != null){
                call.setHandler(employee);
                employee.makeUnavailable();
            }else{
                call.makeReply("Please wait for a minute.");
                callQueue.get(call.getRank().getValue()).add(call);
            }
        }

    }

    enum Rank {
        RESPONDER(0), MANAGER(1), DIRECTOR(2);

        private int id;
        Rank(int id) {
            this.id = id;
        }

        public int getValue(){
            return this.id;
        }
    }

    class Call {
        private Rank rank;
        private Employee handler;
        private Caller caller;

        public Call(Caller caller) {
            this.caller = caller;
            rank = Rank.RESPONDER;
        }

        void setHandler(Employee employee){
            this.handler = employee;
            employee.serveCustomer();
        }

        Employee getHandler() {
            return handler;
        }

        public Rank getRank() {
            return rank;
        }

        private String reply;

        void makeReply(String reply){
            this.reply = reply;
        }
    }

    // A person who is calling
    class Caller{

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
