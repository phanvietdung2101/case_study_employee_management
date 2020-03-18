package manage;


import model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManageImpl implements EmployeeManage {
    private static Map<Integer, Employee> employeeHashmap;

    static {
        employeeHashmap = new HashMap<>();
        employeeHashmap.put(1, new Employee(1, "John", "john@codegym.vn", "Hanoi",1000));
        employeeHashmap.put(2, new Employee(2, "Bill", "bill@codegym.vn", "Danang",2000));
        employeeHashmap.put(3, new Employee(3, "Alex", "alex@codegym.vn", "Saigon",3000));
        employeeHashmap.put(4, new Employee(4, "Adam", "adam@codegym.vn", "Beijin",4000));
        employeeHashmap.put(5, new Employee(5, "Sophia", "sophia@codegym.vn", "Miami",1000));
        employeeHashmap.put(6, new Employee(6, "Rose", "rose@codegym.vn", "Newyork",10000));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeHashmap.values());
    }

    @Override
    public void save(Employee employee) {
        employeeHashmap.put(employee.getId(), employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeHashmap.get(id);
    }

    @Override
    public void update(int id, Employee customer) {
        employeeHashmap.put(id, customer);
    }

    @Override
    public void remove(int id) {
        employeeHashmap.remove(id);
    }
}
