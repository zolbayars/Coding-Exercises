package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.ArrayList;

public class Paren {

    class Parenthesis {
        private String current;
        private int count;

        public Parenthesis() {
            this.current = "()";
            this.count = 1;
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
            System.out.println("newC = " + newC);
            this.current = newC;
            return this.current;
        }

        public String addOutside(int count){
            StringBuilder builder = new StringBuilder(this.current);
            for(int i = 0; i < count; i++){
                builder.append("()");
            }

            this.current = builder.toString();
            return this.current;
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

        public void add(int index, int count, boolean isOutside){
            System.out.println("currentList before = " + currentList);
            if(currentList.size() == 0){
                Parenthesis parenthesis = new Parenthesis();
                parenthesis.addInside(count - 1);
                currentList.add(parenthesis);
            }else{

                Parenthesis prevParen;
                boolean isNotSet = false;
                try {
                    prevParen = currentList.get(index);
                }catch (IndexOutOfBoundsException ex){
                    prevParen = new Parenthesis();
                    isNotSet = true;
                }


                if(isOutside){
                    prevParen.addOutside(count);
                }else{
                    if(prevParen.getCount() == 1){
                        prevParen.addInside(count - 1);
                    }else{
                        prevParen.addInside(count);
                    }

                }

                if(isNotSet){
                    currentList.add(index, prevParen);
                }else{
                    currentList.set(index, prevParen);
                }

//                currentList.add(index, prevParen);
            }
            System.out.println("currentList after = " + currentList);
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
        System.out.println(getPerms(3, parenthesisList));
    }

    ParenthesisList getPerms(int count, ParenthesisList list){
        System.out.println("count = " + count);
        if(count == 1){
//            list.add(0, 1, false);
            return list;
        }

        if(count == 2){
            list.add(0, 1, false);
            list.add(0, 1, true);
            list.add(1, 2, false);
            return list;
        }

        list = getPerms(count - 1, list);
        System.out.println("list = " + list);

        return list;
    }
}
