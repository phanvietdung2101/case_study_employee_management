package controller;

import manage.EmployeeDAO;
import manage.EmployeeManager;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employeeList")
public class EmployeeServlet extends HttpServlet {
    EmployeeDAO employeeManage = new EmployeeManager();
    private List<Employee> employeeList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                showViewDetailForm(request,response);
                break;
            default:
                listEmployee(request,response);
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");

        Employee employee = this.employeeManage.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            employee.setName(name);
            employee.setEmail(email);
            employee.setAddress(address);
            employee.setSalary(salary);
            employee.setDepartment(department);
            this.employeeManage.update(id,employee);
            request.setAttribute("employee",employee);
            request.setAttribute("message","Employee information was updated");
            dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeManage.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.employeeManage.remove(id);
            try {
                response.sendRedirect("/employeeList");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        String categoryList = request.getParameter("listCategory");
        if(categoryList == null || categoryList == "") {
            employeeList = this.employeeManage.findAll();
        } else {
            employeeList = this.employeeManage.findByDepartment(categoryList);
        }
        String sortType = request.getParameter("sort");
        Comparator<Employee> compareByName = (Employee o1, Employee o2) -> o1.getName().compareToIgnoreCase(o2.getName());
        Comparator<Employee> compareBySalary = (Employee o1, Employee o2) -> o1.getSalary().compareToIgnoreCase(o2.getSalary());
        if(sortType != null) {
            switch (sortType) {
                case "nameAscending":
                    Collections.sort(employeeList, compareByName);
                    break;
                case "nameDescending":
                    Collections.sort(employeeList, compareByName.reversed());
                    break;
                case "salaryAscending":
                    Collections.sort(employeeList, compareBySalary);
                    break;
                case "salaryDescending":
                    Collections.sort(employeeList, compareBySalary.reversed());
                    break;
                default:
                    break;
            }
        }

        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewDetailForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeManage.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee",employee);
            dispatcher = request.getRequestDispatcher("employee/view.jsp");
        } try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeManage.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee",employee);
            dispatcher = request.getRequestDispatcher("employee/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeManage.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee",employee);
            dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/add.jsp");
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addEmployee(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");
        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = new Employee(id,name,email,address,salary,department);
        this.employeeManage.save(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/add.jsp");
        request.setAttribute("message","New employee was added");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
