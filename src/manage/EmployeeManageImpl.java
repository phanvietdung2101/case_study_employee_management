package manage;


import dataController.EmployeeData;
import dataController.Data;
import model.Employee;

import java.util.*;

public class EmployeeManageImpl implements EmployeeManage {
    private static Map<Integer, Employee> employeeHashmap;
    private static Data employeeData = new EmployeeData("D:\\case_study\\data\\employee_data.txt");
    static {
        employeeHashmap = employeeData.read();
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeHashmap.values());
    }

    @Override
    public void save(Employee employee) {
        employeeHashmap.put(employee.getId(), employee);
        employeeData.write(employeeHashmap);
    }

    @Override
    public Employee findById(int id) {
        return employeeHashmap.get(id);
    }

    @Override
    public void update(int id, Employee customer) {
        employeeHashmap.put(id, customer);
        employeeData.write(employeeHashmap);
    }

    @Override
    public void remove(int id) {
        employeeHashmap.remove(id);
        employeeData.write(employeeHashmap);
    }
}
