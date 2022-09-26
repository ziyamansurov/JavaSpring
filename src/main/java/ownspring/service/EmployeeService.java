package ownspring.service;

import ownspring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee) throws Exception;
    Employee getEmployeeById(Long  id) throws Exception;
    List<Employee> getEmployees();
    Employee delete(Long  id) throws Exception;
    Employee update(Employee employee,Long  id) throws Exception;



}
