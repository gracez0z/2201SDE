package org.ascending.training.repository;

import org.ascending.training.model.Department;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentHibernateDaoImpl implements IDepartmentDao {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentHibernateDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Department department) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                logger.error("Save transaction failed. Rollback");
                transaction.rollback();
            }
            logger.error("Unable to save department or unable to close session", e);
        }
    }

    @Override
    public List<Department> getDepartments() {
        logger.info("Start to getDepartments from Postgres via Hibernate.");

        List<Department> departments = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "from Department"; //"from Department d JOIN FETCH d.employees where d.id=employxxxx"
            Query<Department> query = session.createQuery(hql);

            departments = query.list();

            session.close();
        } catch (HibernateException e) {
            logger.error("Open session exception or close session exception", e);
            throw e;
        }

        logger.info("Get departments {}", departments);
        return departments;
    }

    @Override
    public Department getById(Long id) {
        Session s = sessionFactory.openSession();
        String hql = "FROM Department d where id= :ID";
//        String hql = "FROM Department d JOIN FETCH d.employees where d.id=:Id";
        try {
            Query<Department> query = s.createQuery(hql);
            query.setParameter("ID", id);
            Department result = query.uniqueResult();
            s.close();
            return result;
        } catch (HibernateException e) {
            logger.error("Session close exception try again", e);
            s.close();
            return null;
        }
    }

    @Override
    public boolean delete(Department department) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                logger.error("Delete transaction failed. Rollback");
                transaction.rollback();
            }
            logger.error("Unable to delete department or unable to close session", e);
        }
        return true;
    }

    @Override
    public Department getDepartmentEagerBy(Long id) {
        String hql = "FROM Department d LEFT JOIN FETCH d.employees where d.id = :Id"; //LEFT JOIN FETCH: HQL里面的left join
        Session session = sessionFactory.openSession();
        try {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("Id", id);
            Department result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("failed to retrieve data record", e);
            session.close();
            return null;
        }
    }

    @Override
    public Department update(Department department) {
        Session s = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = s.beginTransaction();
            s.update(department);
            transaction.commit();
            Department d = getById(department.getId());
            s.close();
            return d;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            logger.error("failed to insert record", e);
            s.close();
            return null;
        }
    }
}
