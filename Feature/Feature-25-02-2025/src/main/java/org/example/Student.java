package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class Student {
    @CsvBindByPosition(position = 0) private int id;
    @CsvBindByPosition(position = 1) private String name;
    @CsvBindByPosition(position = 2) private String department;
    @CsvBindByPosition(position = 3) private int salary;
    @CsvBindByPosition(position = 4) private int marks;
    @CsvBindByPosition(position = 5) private String email;
    @CsvBindByPosition(position = 6) private String phone;

    public Student() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Department='" + department + '\'' +
                ", Salary=" + salary +
                ", Marks=" + marks +
                ", Email='" + email + '\'' +
                ", Phone='" + phone + '\'' +
                '}';
    }
}
