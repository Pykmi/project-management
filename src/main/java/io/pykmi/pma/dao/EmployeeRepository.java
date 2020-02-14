package io.pykmi.pma.dao;

import io.pykmi.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
