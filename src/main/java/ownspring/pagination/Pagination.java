package ownspring.pagination;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import ownspring.entity.Employee;

public interface Pagination {

    public Page<Employee> pagination(Integer pageSize,Integer page);
}
