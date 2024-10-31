package study;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseManager {
    private String url = "jdbc:mariadb://127.0.0.1:3306/grade";
    private String user = "root";
    private String password = "codns1108";

    public void saveStudents(ArrayList<HashMap<String, Object>> students) {
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

                    pstmt.executeUpdate();
                }
            }
            System.out.println("학생 정보를 데이터베이스에 저장했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HashMap<String, Object>> getStudents() {
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HashMap<String, Object> student = new HashMap<>();
                student.put("id", rs.getInt("id"));
                student.put("name", rs.getString("name"));
                student.put("korean", rs.getInt("korean"));
                student.put("english", rs.getInt("english"));
                student.put("math", rs.getInt("math"));
                student.put("total", rs.getInt("total"));
                student.put("average", rs.getDouble("average"));
                students.add(student);
            }
            System.out.println("학생 정보를 데이터베이스에서 가져왔습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }}