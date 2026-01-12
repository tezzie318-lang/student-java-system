import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {

    // 1. 添加学生信息到数据库
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (name, gender, class_name, math_score, java_score) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGender());
            pstmt.setString(3, student.getClassName());
            pstmt.setDouble(4, student.getMathScore());
            pstmt.setDouble(5, student.getJavaScore());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. 根据ID查询学生信息
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("class_name"),
                        rs.getDouble("math_score"),
                        rs.getDouble("java_score")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 3. 显示所有学生信息
    public void showAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("====== 所有学生列表 ======");
            while (rs.next()) {
                System.out.printf("ID: %d | 姓名: %s | 班级: %s | 高数: %.1f | Java: %.1f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("class_name"),
                        rs.getDouble("math_score"),
                        rs.getDouble("java_score"));
            }
            System.out.println("==========================");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. 计算并显示平均分
    public void calculateAvgScores() {
        String sql = "SELECT AVG(math_score) as avg_math, AVG(java_score) as avg_java FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                double avgMath = rs.getDouble("avg_math");
                double avgJava = rs.getDouble("avg_java");
                System.out.println("====== 成绩统计 ======");
                System.out.printf("高数平均分: %.2f%n", avgMath);
                System.out.printf("Java平均分: %.2f%n", avgJava);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}