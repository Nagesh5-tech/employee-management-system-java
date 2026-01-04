package HibernateEmployeeManagementSystem.HibernateEMS.ui;

import javax.swing.*;
import java.awt.*;

import HibernateEmployeeManagementSystem.HibernateEMS.service.EmployeeService;

public class AddEmployee extends JFrame {

    private JTextField txtName;
    private JTextField txtSalary;
    private JTextField txtEmail;

    // ✅ Service layer (MVC)
    private EmployeeService service = new EmployeeService();

    public AddEmployee() {

        setTitle("ADD EMPLOYEE");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        // ---------- TITLE ----------
        JLabel lblTitle = new JLabel("ADD EMPLOYEE");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setBounds(130, 15, 200, 25);
        add(lblTitle);

        // ---------- NAME ----------
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 60, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(160, 60, 160, 25);
        add(txtName);

        // ---------- SALARY ----------
        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(50, 100, 100, 25);
        add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(160, 100, 160, 25);
        add(txtSalary);

        // ---------- EMAIL ----------
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 140, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(160, 140, 160, 25);
        add(txtEmail);

        // ---------- SAVE BUTTON ----------
        JButton btnSave = new JButton("SAVE");
        btnSave.setBounds(140, 190, 100, 30);
        add(btnSave);

        btnSave.addActionListener(e -> saveEmployee());

        setVisible(true);
    }

    // ---------- SAVE LOGIC ----------
    private void saveEmployee() {
        try {
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            int salary = Integer.parseInt(txtSalary.getText().trim());

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required");
                return;
            }

            boolean success = service.addEmployee(name, salary, email);

            if (success) {
                JOptionPane.showMessageDialog(this, "Employee added successfully");
                new ManagementApp().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add employee");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salary must be a number");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
