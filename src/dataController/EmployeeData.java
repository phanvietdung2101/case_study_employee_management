package dataController;

import model.Employee;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmployeeData implements Data {
    File employeeData ;

    public EmployeeData() {
    }

    public EmployeeData(String filePath) {
        this.employeeData =  new File(filePath);;
    }

    @Override
    public Map<Integer, Employee> read() {
        Map<Integer,Employee> employeeMap = new HashMap<>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    new FileInputStream(employeeData), "UTF-8"));
            String line = "";
            Employee employee;
            while((line = in.readLine()) != null){
                String[] elementArr = line.split("~~");
                employee = new Employee(
                        Integer.parseInt(elementArr[0]),
                        elementArr[1],
                        elementArr[2],
                        elementArr[3],
                        elementArr[4],
                        elementArr[5]);
                employeeMap.put(employee.getId(),employee);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeMap;
    }

    @Override
    public void write(Map<Integer, Employee> employeeMap) {
        try {
            Employee employee;
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(employeeData),"UTF-8"));
            for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
                employee = entry.getValue();
                out.write(employee.toString());
                out.newLine();
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
