package com.springboot.study.controller;

import com.springboot.study.dao.EmployeeDao;
import com.springboot.study.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String addEmp(){
        return "emp/add";
    }
}
