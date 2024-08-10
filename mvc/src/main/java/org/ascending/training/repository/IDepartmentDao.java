package org.ascending.training.repository;

import org.ascending.training.model.Department;

import java.util.List;

public interface IDepartmentDao {

    // Create
    void save(Department department);
    List<Department> getDepartments(); // R

    // update
    Department getById(Long id); //update = get + ..... + save

    //Delete
    boolean delete(Department department);

    Department getDepartmentEagerBy(Long id);

    Department update(Department department);
}
