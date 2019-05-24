package com.springboot.study.controller;

import com.springboot.study.dao.DepartmentDao;
import com.springboot.study.dao.EmployeeDao;
import com.springboot.study.entities.Department;
import com.springboot.study.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String add(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String update(@PathVariable int id, ModelMap modelMap){
        Collection<Department> departments = departmentDao.getDepartments();
        Employee employee=employeeDao.get(id);
        modelMap.addAttribute("depts",departments);
        modelMap.addAttribute("emp",employee);
        return "emp/add";
    }
}
