package HibernateEmployeeManagementSystem.HibernateEMS.ui;

import javax.swing.*;
import java.awt.*;

import HibernateEmployeeManagementSystem.HibernateEMS.entity.Employee;
import HibernateEmployeeManagementSystem.HibernateEMS.service.EmployeeService;

public class UpdateEmployee extends JFrame {

    private JTextField txtId, txtName, txtSalary, txtEmail;
    private EmployeeService service = new EmployeeService();

    public UpdateEmployee() {

        setTitle("UPDATE EMPLOYEE");
        setSize(420, 320);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("Employee ID:");
        lblId.setBounds(50, 40, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(160, 40, 120, 25);
        add(txtId);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(290, 40, 90, 25);
        add(btnSearch);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 90, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(160, 90, 160, 25);
        add(txtName);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(50, 130, 100, 25);
        add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(160, 130, 160, 25);
        add(txtSalary);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 170, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(160, 170, 160, 25);
        add(txtEmail);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(150, 220, 100, 30);
        add(btnUpdate);

        btnSearch.addActionListener(e -> loadEmployee());
        btnUpdate.addActionListener(e -> updateEmployee());

        setVisible(true);
    }

    private void loadEmployee() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Employee emp = service.findEmployee(id);

            if (emp != null) {
                txtName.setText(emp.getName());
                txtSalary.setText(String.valueOf(emp.getSalary()));
                txtEmail.setText(emp.getEmail());
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid ID");
        }
    }

    private void updateEmployee() {
        try {
            boolean success = service.updateEmployee(
                Integer.parseInt(txtId.getText()),
                txtName.getText(),
                Integer.parseInt(txtSalary.getText()),
                txtEmail.getText()
            );

            JOptionPane.showMessageDialog(this,
                success ? "Employee Updated" : "Update Failed");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }
}
