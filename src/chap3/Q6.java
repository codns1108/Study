package chap3;

import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        int sum = 0;
        int ssum = 0;
        int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};

        Scanner sc = new Scanner(System.in);
        System.out.println("금액을 입력하세요 >>");
        int num = sc.nextInt();

        for(int i = 0; i < unit.length; i++) {
            sum = num % unit[i];
            ssum = num / unit[i];
            num = sum;

            if(ssum != 0) {
                System.out.println(unit[i] + "짜리 : " + ssum + '개');
            }
        }

    }
}





