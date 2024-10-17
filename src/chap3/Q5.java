package chap3;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        int n[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("양의 정수를 10개 입력하세요");
        for (int j = 0; j < n.length; j++) {
            n[j] = sc.nextInt();
        }
        System.out.print("3의 배수는 : ");
        for (int i = 0; i < n.length; i++){
            if(n[i] % 3 == 0){
                System.out.print(n[i] + " ");
            }
        }
//        for (int i = 0; i < n.length; i++){
//            for(int j; j < n.length; j++){
//            n[i][j] = sc.nextInt()
//        }
//
    }

}
