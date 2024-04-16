public class Student implements Comparable<Student>{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // this.xxx - o.xxx  增序
    // o.xxx - this.xxx  降序
    @Override
    public int compareTo(Student o) {
        System.out.println(this.getAge() + "+" + this.name + "---" + o.age + "+" + o.name);
        // 根据年龄做主要排序条件
        int ageResult = o.age - this.age;
        // 根据姓名做次要排序条件
        int nameResult = ageResult == 0 ? o.name.compareTo(this.name) : ageResult;
        return nameResult;
    }

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
