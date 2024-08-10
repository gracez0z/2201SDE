package org.ascending.training.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DepartmentJDBCDaoImplTest {
    DepartmentJDBCDaoImpl departmentDao;

    @Before
    public void setup() {
        departmentDao = new DepartmentJDBCDaoImpl();
    }

    @After
    public void teardown() {
        departmentDao = null;
    }


    @Test
    public void getDepartmentsTest() {
//        DepartmentDao departmentDao = new DepartmentDao();
        assertEquals(0, departmentDao.getDepartments().size());
    }

    //CRUD
//    @Test
//    public void createDepartmentsTest() {
////        DepartmentDao departmentDao = new DepartmentDao();
//        assertEquals(0, departmentDao.getDepartments().size());
//    }

    public void updateDepartmentsTest() {
//        DepartmentDao departmentDao = new DepartmentDao();
    }

    public void deleteDepartmentsTest() {
//        DepartmentDao departmentDao = new DepartmentDao();
    }
}
