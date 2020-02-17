package io.pykmi.pma.dao;

import io.pykmi.pma.entities.Employee;
import io.pykmi.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
}
