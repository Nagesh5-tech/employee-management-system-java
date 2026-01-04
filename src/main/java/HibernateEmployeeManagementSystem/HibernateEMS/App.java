package HibernateEmployeeManagementSystem.HibernateEMS;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import HibernateEmployeeManagementSystem.HibernateEMS.entity.Employee;

public class App {

    static SessionFactory factory;
    static Scanner sc = new Scanner(System.in);

    // ✅ Hibernate initialization
    static {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        factory = con.buildSessionFactory();
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("  EMPLOYEE MANAGEMENT APPLICATION");
        System.out.println("====================================");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 -> Add Employee");
            System.out.println("2 -> Get Employee by ID");
            System.out.println("3 -> Update Employee");
            System.out.println("4 -> Remove Employee");
            System.out.println("Other -> Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addEmployee();
                case 2 -> getEmployee();
                case 3 -> updateEmployee();
                case 4 -> removeEmployee();
                default -> {
                    System.out.println("Thank you for using Employee Management Application");
                    factory.close();
                    sc.close();
                    return;
                }
            }
        }
    }

    // ---------------- ADD EMPLOYEE ----------------
    public static void addEmployee() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();

            System.out.print("Enter Email: ");
            String email = sc.next();

            Employee emp = new Employee(name, salary, email);
            session.persist(emp);

            tx.commit();
            System.out.println("✅ Employee added successfully");

        } catch (Exception e) {
            tx.rollback();
            System.out.println("❌ Failed to add employee");
        } finally {
            session.close();
        }
    }

    // ---------------- GET EMPLOYEE ----------------
    public static void getEmployee() {
        Session session = factory.openSession();

        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            Employee emp = session.get(Employee.class, id);

            if (emp != null) {
                System.out.println("Employee Details:");
                System.out.println(emp);
            } else {
                System.out.println("❌ Employee not found");
            }
        } finally {
            session.close();
        }
    }

    // ---------------- UPDATE EMPLOYEE ----------------
    public static void updateEmployee() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();

            Employee emp = session.get(Employee.class, id);

            if (emp != null) {
                System.out.print("Enter New Name: ");
                String name = sc.next();

                System.out.print("Enter New Salary: ");
                int salary = sc.nextInt();

                System.out.print("Enter New Email: ");
                String email = sc.next();

                emp.setName(name);
                emp.setSalary(salary);
                emp.setEmail(email);

                tx.commit();
                System.out.println("✅ Employee updated successfully");
            } else {
                System.out.println("❌ Employee not found");
                tx.rollback();
            }

        } catch (Exception e) {
            tx.rollback();
            System.out.println("❌ Update failed");
        } finally {
            session.close();
        }
    }

    // ---------------- DELETE EMPLOYEE ----------------
    public static void removeEmployee() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();

            Employee emp = session.get(Employee.class, id);

            if (emp != null) {
                session.remove(emp);
                tx.commit();
                System.out.println("✅ Employee deleted successfully");
            } else {
                System.out.println("❌ Employee not found");
                tx.rollback();
            }

        } catch (Exception e) {
            tx.rollback();
            System.out.println("❌ Delete failed");
        } finally {
            session.close();
        }
    }
}
