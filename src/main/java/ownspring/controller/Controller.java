package ownspring.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ownspring.entity.Employee;
import ownspring.pagination.Pagination;
import ownspring.repository.EmployeeRepository;
import ownspring.service.EmployeeService;
import ownspring.service.EmployeeServiceImpl;

import java.util.List;



@RestController
@RequestMapping("/employee")
public class Controller {


    private EmployeeService employeeService;
   private Pagination pagination;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService,Pagination pagination ){
        this.pagination=pagination;
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<Employee> getEmployee() {
        try {
            return employeeService.getEmployees();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){

        try {
            return employeeService.save(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Long id){

        try {
            return employeeService.getEmployeeById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping ("{id}")
    public Employee delete(@PathVariable("id") Long id){

        try {
            return employeeService.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping ("{id}")
    public Employee update(@RequestBody Employee employee ,@PathVariable("id") Long id){

        try {
            return employeeService.update(employee,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/page")
    public Page<Employee> pagination(@RequestParam Integer pageSize,
                                     @RequestParam Integer page){

        return pagination.pagination(pageSize,page);


    }






}
