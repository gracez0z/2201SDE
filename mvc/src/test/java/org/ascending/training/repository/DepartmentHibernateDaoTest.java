package org.ascending.training.repository;

import org.ascending.training.model.Department;
import org.ascending.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.List;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
@Profile("unit")
public class DepartmentHibernateDaoTest {
    @Mock
    private SessionFactory mockSessionFactory;
//    @Autowired
//    SessionFactory mockSessionFactory;
    @Mock
    private Session mockSession;
    @Mock
    private Query mockQuery;

    private IDepartmentDao departmentDao;

    @Before
    public void setup() {
        initMocks(this);
        departmentDao = new DepartmentHibernateDaoImpl();
    }

    @Test
    public void getDepartmentsTest_happyPath() {
        Department department = new Department(1, "Zhang3", "random", "US");
        List<Department> result = List.of(department);

        try (MockedStatic mockedStatic = mockStatic(HibernateUtil.class)) {
            mockedStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doNothing().when(mockSession).close();

            List<Department> actualResult = departmentDao.getDepartments();
            assertEquals(result, actualResult);
        }
    }

    @Test
    public void getDepartmentsTest_getHibernateException() {
        Department department = new Department(1, "Zhang3", "random", "US");
        List<Department> result = List.of(department);

        try (MockedStatic mockStatic = mockStatic(HibernateUtil.class)) {
            mockStatic.when(HibernateUtil::getSessionFactory).thenReturn(mockSessionFactory);

            when(mockSessionFactory.openSession()).thenReturn(mockSession);
            when(mockSession.createQuery(any(String.class))).thenReturn(mockQuery);
            when(mockQuery.list()).thenReturn(result);
            doThrow(HibernateException.class).when(mockSession).close();

            assertThrows(HibernateException.class, () -> departmentDao.getDepartments());
        }
    }
}



