package com.zolbayar.cracking_the_oyster.object_oriented_design;

/*
    Purpose: Design an object oriented data structure for a simple call center.
            When there are no available responder or they couldn't handle the customer,
            the call is escalated to a manager and so on to the director.

    Insight: Don't make it so simple
            CallHandler and Call classes were necessary. And the Rank enum too.
            Call should be placed on the call handler. Then it should've queue the current employees by the rank
 */

import java.util.ArrayList;
import java.util.List;

public class CallCenter {

    class CallHandler {

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

        private void handleCall(Call call){
           Employee employee = getAvailableEmployee();
           if(employee != null){
               call.setHandler(employee);
           }else{
               call.makeReply("Sorry, no one is available to answer you.");
           }
        }

        public void receiveCalls(){
            for(List<Call> callList : callQueue){
                for(Call call : callList){
                    if(call.getHandler() == null){
                        handleCall(call);
                    }
                }
            }
        }
        
    }

    enum Rank {
        RESPONDER, MANAGER, DIRECTOR
    }

    class Call {
        private Rank rank;
        private Employee handler;

        void setHandler(Employee employee){
            this.handler = employee;
            employee.makeUnavailable();
        }

        Employee getHandler() {
            return handler;
        }

        private String reply;

        void makeReply(String reply){
            this.reply = reply;
        }
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
