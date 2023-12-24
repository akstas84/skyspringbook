package pro.sky.skyspringbook.service;

import pro.sky.skyspringbook.entity.Employee;


public interface EmployeeBookService {

    String welcomeToEmployeeManager();

    Employee addNewEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);
}
