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
import com.virtusa.lms.entity.Role;
import com.virtusa.lms.entity.User;

@SuppressWarnings("deprecation")
@Repository
public class UserDao implements UserDaoInterface {
	static final  Logger logger = Logger.getLogger(UserDao.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int saveUser(User user) {
		return (int) this.hibernateTemplate.save(user);
	}

	public User checkUser(String username) {
		User user = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if(session!=null) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("username"), username));
			Query<User> q = session.createQuery(cq);
			user = q.uniqueResult();
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		finally {
			if (session != null) {
			session.close();}
		}
		return user;
	}

	public List<Role> getAllRoles() {
		return this.hibernateTemplate.loadAll(Role.class);
	}

	public User validateUser(String username, String password) {
		User user = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if(session!=null) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password)));
			Query<User> q = session.createQuery(cq);
			user = q.uniqueResult();
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		finally {
			if (session != null) {
			session.close();}
		}
		return user;
	}
}
