package HibernateEmployeeManagementSystem.HibernateEMS.ui;

import javax.swing.*;

public class ManagementApp extends JFrame {

    public ManagementApp() {

        setTitle("EMPLOYEE MANAGEMENT APP");
        setSize(500, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton add = new JButton("ADD EMPLOYEE");
        JButton get = new JButton("GET EMPLOYEE BY ID");
        JButton update = new JButton("UPDATE EMPLOYEE");
        JButton delete = new JButton("DELETE EMPLOYEE");
        JButton all = new JButton("GetAllEmployees");

        add.setBounds(60, 60, 160, 30);
        get.setBounds(260, 60, 160, 30);
        update.setBounds(60, 120, 160, 30);
        delete.setBounds(260, 120, 160, 30);
        all.setBounds(170, 180, 160, 30);

        add(add); add(get); add(update); add(delete); add(all);

        add.addActionListener(e -> new AddEmployee());
        get.addActionListener(e -> new GetEmployeeById());
        update.addActionListener(e -> new UpdateEmployee());
        delete.addActionListener(e -> new DeleteEmployee());
        all.addActionListener(e -> new GetAllEmployees());

        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagementApp();
    }
}
