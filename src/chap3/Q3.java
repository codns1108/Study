package chap3;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요");
        int j = sc.nextInt();
        for(int i=0;  i < j; i++){
            for(int k = j; k > i; k--){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
