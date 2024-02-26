package com.virtusa.lms.repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.virtusa.lms.entity.Employee;
import com.virtusa.lms.entity.User;

@SuppressWarnings("deprecation")
@Repository
public class EmployeeDao implements EmployeeDaoInterface{
	static final Logger logger = Logger.getLogger(EmployeeDao.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void deleteEmp(int empId) throws NullPointerException {
		try {
			Employee employee = this.hibernateTemplate.get(Employee.class, empId);
			if(employee!=null) {
			this.hibernateTemplate.delete(employee.getUser());
			this.hibernateTemplate.delete(employee);
		}
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	@Transactional
	public void updateEmp(Employee empolyee) {
		this.hibernateTemplate.merge(empolyee);

	}

	@Transactional
	public void updateUser(User user) {
		this.hibernateTemplate.merge(user);
	}

	public List<Employee> getAllEmployees()  {
		List<Employee> employees=null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if(session!=null) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			cq.select(root);
			Query<Employee> q = session.createQuery(cq);
			employees= q.getResultList();
		}
		} catch (Exception ex) {
			logger.error(ex);
		}
		finally {
			if (session != null) {
			session.close();}
		}
		return employees;
	}

	public Employee getEmp(int empId) {
		Employee emp = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if(session!=null) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			cq.select(root).where(cb.equal(root.get("empId"), empId));
			Query<Employee> q = session.createQuery(cq);
			emp = q.uniqueResult();
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		finally {
			if (session != null) {
			session.close();}
		}
		return emp;
	}

}
