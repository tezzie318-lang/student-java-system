import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // 数据库配置
    private static final String URL = "jdbc:mysql://localhost:3306/student_management?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "20050630Ymj";

    // 获取数据库连接的方法
    public static Connection getConnection() {
        try {
            // 加载驱动（新版驱动可省略，但写上更保险）
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // 释放资源的方法（可选，简化代码暂不写）
}
