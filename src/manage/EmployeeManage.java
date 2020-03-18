package manage;

import model.Employee;

import java.util.List;

public interface EmployeeManage {
    List<Employee> findAll();
    void save(Employee employee);
    Employee findById(int id);
    void update(int id, Employee employee);
    void remove(int id);
}
