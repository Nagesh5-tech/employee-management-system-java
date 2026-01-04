package HibernateEmployeeManagementSystem.HibernateEMS.service;

import java.util.List;

import HibernateEmployeeManagementSystem.HibernateEMS.dao.EmployeeDAO;
import HibernateEmployeeManagementSystem.HibernateEMS.entity.Employee;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();

    public boolean addEmployee(String name, int salary, String email) {
        if (salary <= 0 || name.isBlank()) return false;
        return dao.save(new Employee(name, salary, email));
    }

    public Employee findEmployee(int id) {
        return dao.getById(id);
    }

    public List<Employee> getAllEmployees() {
        return dao.getAll();
    }

    public boolean updateEmployee(int id, String name, int salary, String email) {
        Employee emp = dao.getById(id);
        if (emp == null) return false;
        emp.setName(name);
        emp.setSalary(salary);
        emp.setEmail(email);
        return dao.update(emp);
    }

    public boolean deleteEmployee(int id) {
        return dao.delete(id);
    }
}
