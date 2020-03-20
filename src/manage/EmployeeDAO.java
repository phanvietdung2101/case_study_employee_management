package manage;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    List<Employee> findByDepartment(String department);
    void save(Employee employee);
    Employee findById(int id);
    void update(int id, Employee employee);
    void remove(int id);
}
