package HibernateEmployeeManagementSystem.HibernateEMS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int salary;

    @Column(nullable = false, unique = true)
    private String email;

    public Employee() {}

    public Employee(String name, int salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getSalary() { return salary; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setSalary(int salary) { this.salary = salary; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary + " | " + email;
    }
}
