package org.ascending.training.repository;

import org.ascending.training.ApplicationBootstrap;
import org.ascending.training.model.Department;
import org.ascending.training.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class DepartmentHibernateDaoImplTest{
    @Autowired
    private IDepartmentDao departmentHibernateDao;
    @Autowired
    private IEmployeeDao employeeHibernateDao;
    private Department d1;
    private Employee e1;
    private Employee e2;

    @Before
    public void setUp() {
//        departmentHibernateDao = new DepartmentHibernateDaoImpl();
        //STEP1: save record in one side
        d1 = new Department();
        d1.setName("hr");
        d1.setDescription("random description");
        d1.setLocation("US");
        departmentHibernateDao.save(d1);

        // STEP2: save record in many side
//        employeeHibernateDao = new EmployeeHibernateDaoImpl();
        e1 = new Employee();
        e1.setId((long) (Math.random()*(100L - 1L)));
        e1.setName("Zhang3");
        e1.setAddress("US");
        e1.setDepartment(d1);
        employeeHibernateDao.save(e1);

        e2 = new Employee();
        e2.setId((long) (Math.random()*(100L - 1L)));
        e2.setName("Li4");
        e2.setAddress("US");
        e2.setDepartment(d1);
        employeeHibernateDao.save(e2);
    }

    @After
    public void tearDown() {
        //STEP1: delete record in many side
        employeeHibernateDao.delete(e1);
        employeeHibernateDao.delete(e2);
        //STEP2: delete record in one side
        departmentHibernateDao.delete(d1);
    }

    @Test
    public void getDepartmentsTest() {
        assertEquals(3, departmentHibernateDao.getDepartments().size());
    }

    @Test
    public void getDepartmentEagerByTest() {
        Department department = departmentHibernateDao.getDepartmentEagerBy(d1.getId());
        assertNotNull(department);
        assertEquals(department.getName(), d1.getName());
        assertTrue(department.getEmployees().size() > 0);
    }
}