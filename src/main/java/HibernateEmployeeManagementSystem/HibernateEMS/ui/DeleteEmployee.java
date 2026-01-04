package HibernateEmployeeManagementSystem.HibernateEMS.ui;

import javax.swing.*;

import HibernateEmployeeManagementSystem.HibernateEMS.service.EmployeeService;

public class DeleteEmployee extends JFrame {

    private JTextField txtId;
    private EmployeeService service = new EmployeeService();

    public DeleteEmployee() {

        setTitle("DELETE EMPLOYEE");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("Employee ID:");
        lblId.setBounds(40, 40, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(140, 40, 100, 25);
        add(txtId);

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(90, 90, 100, 30);
        add(btnDelete);

        btnDelete.addActionListener(e -> deleteEmployee());

        setVisible(true);
    }

    private void deleteEmployee() {
        try {
            int id = Integer.parseInt(txtId.getText());

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = service.deleteEmployee(id);
                JOptionPane.showMessageDialog(this,
                    success ? "Employee Deleted" : "Delete Failed");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid ID");
        }
    }
}
