import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建管理器对象
        StudentManager manager = new StudentManager();
        // 创建扫描器，用于读取用户在命令行的输入
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== 学生成绩管理系统 ======");
            System.out.println("1. 添加学生");
            System.out.println("2. 根据ID查询学生");
            System.out.println("3. 显示所有学生");
            System.out.println("4. 统计平均成绩");
            System.out.println("5. 退出系统");
            System.out.print("请输入选项(1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("请输入姓名:");
                    String name = scanner.next();
                    System.out.println("请输入性别:");
                    String gender = scanner.next();
                    System.out.println("请输入班级:");
                    String className = scanner.next();
                    System.out.println("请输入高数成绩:");
                    double mathScore = scanner.nextDouble();
                    System.out.println("请输入Java成绩:");
                    double javaScore = scanner.nextDouble();

                    // ID 填 0 即可，因为数据库会自动生成自增 ID
                    Student newStudent = new Student(0, name, gender, className, mathScore, javaScore);
                    if (manager.addStudent(newStudent)) {
                        System.out.println("✅ 添加成功！");
                    } else {
                        System.out.println("❌ 添加失败，请检查数据库连接。");
                    }
                    break;

                case 2:
                    System.out.print("请输入要查询的学生ID: ");
                    int id = scanner.nextInt();
                    Student s = manager.getStudentById(id);
                    if (s != null) {
                        System.out.println("查询结果: " + s);
                    } else {
                        System.out.println("❌ 未找到ID为 " + id + " 的学生。");
                    }
                    break;

                case 3:
                    manager.showAllStudents();
                    break;

                case 4:
                    manager.calculateAvgScores();
                    break;

                case 5:
                    System.out.println("系统已退出，再见！");
                    return; // 结束程序

                default:
                    System.out.println("❌ 无效选项，请重新输入。");
            }
        }
    }
}