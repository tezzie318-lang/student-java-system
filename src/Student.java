public class Student {
    // 1. 定义私有属性（与数据库字段对应）
    private int id;                 // 对应数据库 id
    private String name;            // 对应数据库 name
    private String gender;          // 对应数据库 gender
    private String className;       // 对应数据库 class_name
    private double mathScore;       // 对应数据库 math_score
    private double javaScore;       // 对应数据库 java_score

    // 2. 无参构造方法（必须有）
    public Student() {
    }

    // 3. 全参构造方法（方便后续通过一行代码创建对象）
    public Student(int id, String name, String gender, String className, double mathScore, double javaScore) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.className = className;
        this.mathScore = mathScore;
        this.javaScore = javaScore;
    }

    // 4. Getter 和 Setter 方法（用于读取和设置属性）
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public double getMathScore() { return mathScore; }
    public void setMathScore(double mathScore) { this.mathScore = mathScore; }

    public double getJavaScore() { return javaScore; }
    public void setJavaScore(double javaScore) { this.javaScore = javaScore; }

    // 5. toString 方法（方便打印输出查看结果）
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", className='" + className + '\'' +
                ", mathScore=" + mathScore +
                ", javaScore=" + javaScore +
                '}';
    }
}
