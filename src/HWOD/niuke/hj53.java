package HWOD.niuke;

import java.util.Scanner;

public class hj53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] res = new int[]{2,3,2,4};

        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n <= 2) {
                System.out.println(-1);
                return;
            }
            System.out.println(res[(n+1)%4]);
        }
    }
}
