package ems.demo.springproject.controller;

import ems.demo.springproject.entityvalues.Employee;
import ems.demo.springproject.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    public  EmployeeController(EmployeeService service){
        this.service=service;
    }

    @GetMapping
    public  String showAllEmployees(Model model){
        model.addAttribute("employees",service.getAllEmployees());
        return "List";
    }
    @GetMapping("/add")
    public String addEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "add";
    }
    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute Employee employee){
        service.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/edit/{id}")
    public  String editEmployeeForm(@PathVariable int id,Model model){
        model.addAttribute("employee",service.getEmployeeById(id));
                return "edit";
    }
    @PostMapping("edit/{id}")
    public String updateEmployee(@PathVariable int id,@ModelAttribute Employee employee){
        employee.setId(id);
        service.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
        return "redirect:/employees";
    }

}
