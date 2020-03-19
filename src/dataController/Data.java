package dataController;

import model.Employee;

import java.util.Map;

public interface Data {
    public Map<Integer, Employee> read();
    public void write(Map<Integer,Employee> employeeMap);
}
