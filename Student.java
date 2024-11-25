public class Student {
    int id,age;
    String name;
    double gpa;
    
    public Student(int id, String name, int age, double gpa){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    // Getters
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return gpa;
    }

    // Setters
    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + age + ", " + gpa;
    }
}
