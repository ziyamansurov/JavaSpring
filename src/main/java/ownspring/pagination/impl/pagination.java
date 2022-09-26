package ownspring.pagination.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ownspring.entity.Employee;
import ownspring.pagination.Pagination;
import ownspring.repository.EmployeeRepository;

@Getter
@Setter
@NoArgsConstructor

@Repository
public class pagination implements Pagination {
    private EmployeeRepository employeeRepository;

    @Autowired
    public pagination(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<Employee> pagination(Integer pageSize, Integer page) {
        Pageable pageable= PageRequest.of(page,pageSize);
        return employeeRepository.findAll(pageable);
    }
}
