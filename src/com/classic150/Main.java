package com.classic150;

public class Main {

    public static void main(String[] args) {
        String str = "()";
        Stack mystack = new Stack();
        boolean valid = mystack.isValid(str);
        System.out.println(valid);
    }

}
