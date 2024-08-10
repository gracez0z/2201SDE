package org.ascending.training.repository;

import org.ascending.training.model.Employee;
import java.util.List;

public interface IEmployeeDao {
    void save(Employee employee);
    //retrieve
    List<Employee> getEmployees();
    //update
    Employee getById(Long id);
    // delete
    void delete(Employee employee);
}
