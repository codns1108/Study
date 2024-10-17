package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("학생 수를 입력하세요:");
        int num = sc.nextInt();

        // 학생 정보를 저장할 ArrayList
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();

        System.out.println("학생 수만큼 이름, 국어 성적, 영어 성적, 수학 성적을 입력해주세요:");
        for (int i = 0; i < num; i++) {
            // 한 명의 학생 정보를 저장할 HashMap
            HashMap<String, Object> student = new HashMap<>();

            // 학생 정보 입력받기
            System.out.print("이름: ");
            String name = sc.next();
            System.out.print("국어 성적: ");
            int korean = sc.nextInt();
            System.out.print("영어 성적: ");
            int english = sc.nextInt();
            System.out.print("수학 성적: ");
            int math = sc.nextInt();

            // HashMap에 학생 정보 추가
            student.put("name", name);
            student.put("korean", korean);
            student.put("english", english);
            student.put("math", math);

            // 총점과 평균 계산
            int total = korean + english + math;
            double average = total / 3.0;

            // HashMap에 총점과 평균 추가
            student.put("total", total);
            student.put("average", average);

            // 학생 정보를 ArrayList에 추가
            students.add(student);
        }

        // MariaDB 연결 설정
        String url = "jdbc:mariadb://127.0.0.1:3306/grade";
        String user = "root";
        String password = "codns1108";

        // MariaDB에 학생 정보 저장
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO students (name, korean, english, math, total, average) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                for (HashMap<String, Object> student : students) {
                    pstmt.setString(1, (String) student.get("name"));
                    pstmt.setInt(2, (int) student.get("korean"));
                    pstmt.setInt(3, (int) student.get("english"));
                    pstmt.setInt(4, (int) student.get("math"));
                    pstmt.setInt(5, (int) student.get("total"));
                    pstmt.setDouble(6, (double) student.get("average"));

                    // SQL 실행
                    pstmt.executeUpdate();
                }
            }
            System.out.println("학생 정보를 데이터베이스에 저장했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 학생별 정보 출력
        System.out.println("\n입력된 학생 정보:");
        for (HashMap<String, Object> student : students) {
            String name = (String) student.get("name");
            int korean = (int) student.get("korean");
            int english = (int) student.get("english");
            int math = (int) student.get("math");
            int total = (int) student.get("total");
            double average = (double) student.get("average");

            System.out.println("이름: " + name +
                    ", 국어: " + korean +
                    ", 영어: " + english +
                    ", 수학: " + math +
                    ", 총점: " + total +
                    ", 평균: " + String.format("%.2f", average));
        }
    }
}
