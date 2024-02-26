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
import com.virtusa.lms.entity.Leave;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.entity.LeaveMaster;

@SuppressWarnings("deprecation")
@Repository
public class LeaveDao implements LeaveDaoInterface {
	static final Logger logger = Logger.getLogger(LeaveDao.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int saveLeaveMaster(LeaveMaster leaveMaster) {
		return (int) this.hibernateTemplate.save(leaveMaster);
	}

	@Transactional
	public void deleteLvm(int lvmId) {
		try {
			LeaveMaster leaveMaster = this.hibernateTemplate.get(LeaveMaster.class, lvmId);
			if (leaveMaster != null) {
				this.hibernateTemplate.delete(leaveMaster);
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	@Transactional
	public void deleteLvb(int lvbId) {
		try {
			LeaveBalance leaveBalance = this.hibernateTemplate.get(LeaveBalance.class, lvbId);
			if (leaveBalance != null) {
				this.hibernateTemplate.delete(leaveBalance);
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public List<LeaveMaster> getLeaveMasters() {
		List<LeaveMaster> leaveMasters = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if (session != null) {
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<LeaveMaster> cq = cb.createQuery(LeaveMaster.class);
				Root<LeaveMaster> root = cq.from(LeaveMaster.class);
				cq.select(root);
				Query<LeaveMaster> q = session.createQuery(cq);
				leaveMasters = q.getResultList();
			}
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return leaveMasters;
	}
	public List<Leave> getLeaves() {
		List<Leave> leaves = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if (session != null) {
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<Leave> cq = cb.createQuery(Leave.class);
				Root<Leave> root = cq.from(Leave.class);
				cq.select(root);
				Query<Leave> q = session.createQuery(cq);
				leaves = q.getResultList();
			}
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return leaves;
	}
	public LeaveMaster getLvm(int lvmId) {
		LeaveMaster lvm = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if (session != null) {
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<LeaveMaster> cq = cb.createQuery(LeaveMaster.class);
				Root<LeaveMaster> root = cq.from(LeaveMaster.class);
				cq.select(root).where(cb.equal(root.get("lvmId"), lvmId));
				Query<LeaveMaster> q = session.createQuery(cq);
				lvm = q.uniqueResult();
				return lvm;
			}
		} catch (Exception ex) {
			logger.error(ex);
			
		} 
		finally {
			if (session != null) {
				
				session.close();
			}
			
		}
		return null;
		
	}

	public LeaveBalance findExsisting(int empId, int lvmId) {
		LeaveBalance user = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if (session != null) {
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<LeaveBalance> cq = cb.createQuery(LeaveBalance.class);
				Root<LeaveBalance> root = cq.from(LeaveBalance.class);
				cq.select(root).where(cb.and(cb.equal(root.get("empId"), empId), cb.equal(root.get("lvmId"), lvmId)));
				Query<LeaveBalance> q = session.createQuery(cq);
				user = q.uniqueResult();
			}
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}
	

	public List<LeaveBalance> getLeaveBalances() {
		List<LeaveBalance> leaveBalances = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if (session != null) {
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<LeaveBalance> cq = cb.createQuery(LeaveBalance.class);
				Root<LeaveBalance> root = cq.from(LeaveBalance.class);
				cq.select(root);
				Query<LeaveBalance> q = session.createQuery(cq);
				leaveBalances = q.getResultList();
			}
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return leaveBalances;
	}

	public LeaveMaster getLvm(String lvmName) {
		LeaveMaster lvm = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if (session != null) {
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<LeaveMaster> cq = cb.createQuery(LeaveMaster.class);
				Root<LeaveMaster> root = cq.from(LeaveMaster.class);
				cq.select(root).where(cb.equal(root.get("lvmName"), lvmName));
				Query<LeaveMaster> q = session.createQuery(cq);
				lvm = q.uniqueResult();
			}
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lvm;
	}

	public LeaveMaster checkLvm(String lvmName, String lvmAbbr) {
		LeaveMaster lvm = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if (session != null) {
				CriteriaBuilder cb = session.getCriteriaBuilder();
				CriteriaQuery<LeaveMaster> cq = cb.createQuery(LeaveMaster.class);
				Root<LeaveMaster> root = cq.from(LeaveMaster.class);
				cq.select(root)
						.where(cb.and(cb.equal(root.get("lvmName"), lvmName), cb.equal(root.get("lvmAbbr"), lvmAbbr)));
				Query<LeaveMaster> q = session.createQuery(cq);
				lvm = q.uniqueResult();
			}
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lvm;
	}
	
	public Leave getLeave(int lvId) {
		Leave leave = null;
		SessionFactory sf = this.hibernateTemplate.getSessionFactory();
		Session session = null;
		try {
			if (sf != null) {
				session = sf.openSession();
			}
			if(session!=null) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Leave> cq = cb.createQuery(Leave.class);
			Root<Leave> root = cq.from(Leave.class);
			cq.select(root).where(cb.equal(root.get("lvId"), lvId));
			Query<Leave> q = session.createQuery(cq);
			leave = q.uniqueResult();
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		finally {
			if (session != null) {
			session.close();}
		}
		return leave;
	}
	
	@Transactional
	public void updateLeave(LeaveMaster leave) {
		this.hibernateTemplate.update(leave);
	}

	@Transactional
	public int saveLvb(LeaveBalance leaveBalance) {
		return (int) this.hibernateTemplate.save(leaveBalance);
	}
	@Transactional
	public void updateLvb(LeaveBalance leaveBalance) {
		 this.hibernateTemplate.update(leaveBalance);
	}
	@Transactional
	public int applyLeave(Leave leave) {
		return (int) this.hibernateTemplate.save(leave);
	}
	@Transactional
	public void updateLeave(Leave leave) {
		this.hibernateTemplate.update(leave);
	}
	@Transactional
	public void deleteLeave(Leave leave) {
		this.hibernateTemplate.delete(leave);
	}
	
}
