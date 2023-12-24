package pro.sky.skyspringbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyspringbook.entity.Employee;
import pro.sky.skyspringbook.service.EmployeeBookServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {

    private EmployeeBookServiceImpl employeeBookServiceImpl;

    public EmployeeBookController(EmployeeBookServiceImpl employeeBookServiceImpl) {
        this.employeeBookServiceImpl = employeeBookServiceImpl;
    }

    @GetMapping(path = "/add")
    public Employee addNewEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
            return employeeBookServiceImpl.addNewEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public void removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeBookServiceImpl.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public void findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeBookServiceImpl.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/home")
    public String welcomeToEmployeeManager() {
        return employeeBookServiceImpl.welcomeToEmployeeManager();
    }
}
