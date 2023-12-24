package pro.sky.skyspringbook.service;

import org.springframework.stereotype.Service;
import pro.sky.skyspringbook.entity.Employee;
import pro.sky.skyspringbook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyspringbook.exceptions.EmployeeNotFoundException;
import pro.sky.skyspringbook.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    private List<Employee> employeesList;

    EmployeeBookServiceImpl() {
        employeesList = new ArrayList<>() {
            {
                add(new Employee("Vasya", "Vasin"));
                add(new Employee("Kolya", "Kolin"));
                add(new Employee("Vera", "Verina"));
                add(new Employee("Olesya", "Olesina"));
                add(new Employee("Petya", "Petin"));
                add(new Employee("Stas", "St"));
                add(new Employee("Diana", "Di"));
                add(new Employee("Olya", "Ol"));
                add(new Employee("Valera", "Delaay"));
                add(new Employee("Grisha", "Gr"));
            }
        };
    }

    @Override
    public String welcomeToEmployeeManager() {
        return "<b>Это главная страница</b>";
    }

    @Override
    public Employee addNewEmployee(String firstName, String lastName) {
        Employee addedEmployee = null;
        int limitEmployee = 10;
        for (Employee employee : employeesList) {
            if (employee != null) {
                if (employeesList.size() >= limitEmployee) {
                    throw new EmployeeStorageIsFullException("Количество сотрудников не может превышать 10");
                }
                if (employee.getFirstName() == firstName && employee.getLastName() == lastName) {
                    throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
                }
                if (employee.getFirstName() != firstName && employee.getLastName() != lastName) {
                    addedEmployee = new Employee(firstName, lastName);
                    System.out.println("Сотрудник добавлен");
                    break;
                }
            }
        }
        return addedEmployee;
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        for (Employee employee : employeesList) {
            if (employee != null && employee.getFirstName() == firstName && employee.getLastName() == lastName) {
                employee = null;
                break;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
    }

    @Override
    public void findEmployee(String firstName, String lastName) {
        for (Employee employee : employeesList) {
            if (employee != null && employee.getFirstName() == firstName && employee.getLastName() == lastName) {
                System.out.println(employee);
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
    }
}
