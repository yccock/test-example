package com.test.behavior.mode.visitor.structure;

import com.test.behavior.mode.visitor.element.Employee;
import com.test.behavior.mode.visitor.visitor.Department;

import java.util.ArrayList;

/**
 * 员工列表类：对象结构
 */
public class EmployeeList {

    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void handle(Department department) {
        for (Employee employee : employeeList) {
            employee.accept(department);
        }
    }
}
