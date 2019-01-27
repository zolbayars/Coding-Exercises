package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.ArrayList;

public class Paren {

    class Parenthesis {
        private String current;
        private int count;

        public Parenthesis() {
            this.current = "()";
        }

        public Parenthesis(String current) {
            this.current = current;
        }

        public String addInside(int count){
            int index = this.current.indexOf(")");
//            System.out.println("index = " + index);

            String startingParensToAdd = "";
            String endingParensToAdd = "";
            for(int i = 0; i < count; i++){
                startingParensToAdd += "(";
                endingParensToAdd += ")";
            }

            String newC = new StringBuilder(this.current).insert(index, startingParensToAdd).toString();
            newC = new StringBuilder(newC).insert(index + count, endingParensToAdd).toString();
//            System.out.println("newC = " + newC);
            return null;
        }

        public String getCurrent() {
            return current;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return current;
        }
    }

    class ParenthesisList {
        private ArrayList<Parenthesis> currentList;

        public ParenthesisList() {
            this.currentList = new ArrayList<>();
        }

        public ParenthesisList(ArrayList<Parenthesis> currentList) {
            this.currentList = currentList;
        }

        public void add(int index, int count){

            if(index > currentList.size() || index == 0){
                Parenthesis parenthesis = new Parenthesis();
                parenthesis.addInside(count);
                currentList.add(parenthesis);
            }else{
                Parenthesis prevParen = currentList.get(index);
                prevParen.addInside(count);
                currentList.add(index, prevParen);
            }
        }

        public ArrayList<Parenthesis> getCurrentList() {
            return currentList;
        }

        @Override
        public String toString() {
            return currentList.toString();
        }
    }

    // 1 -> ()
    // 2 -> ()() (())
    // 3 -> ()()() ((())) (()()) (())() ()(())
    // 4 -> ()()()() (((()))) (())(()) ()()(()) ()(())() (())()() ((()))() ()((()))
    public void printAllPerms(int num){
//        Parenthesis parenthesis = new Parenthesis();
//        parenthesis.addInside(0);

        ParenthesisList parenthesisList = new ParenthesisList();
        System.out.println(getPerms(2, parenthesisList));
    }

    ParenthesisList getPerms(int count, ParenthesisList list){
        System.out.println("count = " + count);
        if(count == 1){
            list.add(0, 1);
            return list;
        }

        if(count == 2){
            list.add(0, 1);
            list.add(0, 1);
            list.add(1, 2);
            return list;
        }

        list = getPerms(count - 1, list);
        System.out.println("list = " + list);

        return list;
    }
}
