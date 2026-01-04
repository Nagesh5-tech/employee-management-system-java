package HibernateEmployeeManagementSystem.HibernateEMS.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import HibernateEmployeeManagementSystem.HibernateEMS.service.EmployeeService;

public class GetAllEmployees extends JFrame {

    public GetAllEmployees() {

        EmployeeService service = new EmployeeService();

        setTitle("ALL EMPLOYEES");
        setSize(600, 300);
        setLocationRelativeTo(null);

        String[] cols = {"ID", "NAME", "SALARY", "EMAIL"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        service.getAllEmployees().forEach(e ->
            model.addRow(new Object[]{
                e.getId(),
                e.getName(),
                e.getSalary(),
                e.getEmail()
            })
        );

        JTable table = new JTable(model);
        add(new JScrollPane(table));

        setVisible(true);
    }
}
