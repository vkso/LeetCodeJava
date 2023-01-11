import com.leetcode.tools.MyLinkedList;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        MyLinkedList myLinkedList = new MyLinkedList(x);

        System.out.println(myLinkedList.getLength());
        myLinkedList.show();

    }
}

