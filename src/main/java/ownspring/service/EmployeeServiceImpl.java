package ownspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ownspring.entity.Employee;
import ownspring.hashing.Hashing;
import ownspring.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private Hashing hashing;


    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository,Hashing hashing) {
        this.employeeRepository = employeeRepository;
       this.hashing=hashing;
    }

    @Override
    public Employee save(Employee employee) throws Exception{
       //employee.setPassword();
//        System.out.println(employee.getPassword());
//        System.out.println(employee.getEmployee_ID());
//        System.out.println(employee.getAge());

       // int id= Integer.parseInt(employee.getAddress().getZipcode());

             //   Integer.parseInt(String.valueOf(employee.getEmployee_ID()));
       employee.setPassword(hashing.encrypt(employee.getPassword()));


         return  employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) throws Exception {
        Optional<Employee> employee= employeeRepository.findById(id);
        return employee.orElseThrow(()->new IllegalArgumentException("Salam"));

    }

    @Override
    public List<Employee> getEmployees() {


        return  employeeRepository.findAll();
    }

    @Override
    public Employee delete(Long id) throws Exception {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isPresent()){
            employeeRepository.delete(employee.get());
            return employee.get();
        }
        else return null;
    }

    @Override
    public Employee update(Employee employee, Long id) throws Exception {
        Optional<Employee> savedEmployee=employeeRepository.findById(id);
        if(savedEmployee.isPresent()){
            savedEmployee.get().setEmployeeName(employee.getEmployeeName());
            savedEmployee.get().setEmployeeSurname(employee.getEmployeeSurname());
            savedEmployee.get().setAge(employee.getAge());

            return employeeRepository.save(savedEmployee.get());

        }
        else return null;
    }
}
