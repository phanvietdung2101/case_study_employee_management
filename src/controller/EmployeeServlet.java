package controller;

import manage.EmployeeManage;
import manage.EmployeeManageImpl;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employeeList")
public class EmployeeServlet extends HttpServlet {
    EmployeeManage employeeManage = new EmployeeManageImpl();
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
                break;
            default:
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");

        Employee employee = this.employeeManage.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            employee.setName(name);
            employee.setEmail(email);
            employee.setAddress(address);
            employee.setSalary(salary);
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

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = this.employeeManage.findAll();
        request.setAttribute("employeeList",employeeList);

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
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
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
        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = new Employee(id,name,email,address,salary);
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
