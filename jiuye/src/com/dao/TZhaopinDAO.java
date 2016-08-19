package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TZhaopin;

/**
 * Data access object (DAO) for domain model class TZhaopin.
 * 
 * @see com.model.TZhaopin
 * @author MyEclipse Persistence Tools
 */

public class TZhaopinDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TZhaopinDAO.class);

	// property constants
	public static final String ZHIWEI = "zhiwei";

	public static final String XULIYAOQIU = "xuliyaoqiu";

	public static final String DAIYUI = "daiyui";

	public static final String GONGZUODIDIAN = "gongzuodidian";

	public static final String GONGZUOJINGYAN = "gongzuojingyan";

	public static final String YOUXIAOQI = "youxiaoqi";

	public static final String QITASHUOMING = "qitashuoming";

	public static final String USER_ID = "userId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TZhaopin transientInstance)
	{
		log.debug("saving TZhaopin instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TZhaopin persistentInstance)
	{
		log.debug("deleting TZhaopin instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TZhaopin findById(java.lang.Integer id)
	{
		log.debug("getting TZhaopin instance with id: " + id);
		try
		{
			TZhaopin instance = (TZhaopin) getHibernateTemplate().get(
					"com.model.TZhaopin", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TZhaopin instance)
	{
		log.debug("finding TZhaopin instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TZhaopin instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TZhaopin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByZhiwei(Object zhiwei)
	{
		return findByProperty(ZHIWEI, zhiwei);
	}

	public List findByXuliyaoqiu(Object xuliyaoqiu)
	{
		return findByProperty(XULIYAOQIU, xuliyaoqiu);
	}

	public List findByDaiyui(Object daiyui)
	{
		return findByProperty(DAIYUI, daiyui);
	}

	public List findByGongzuodidian(Object gongzuodidian)
	{
		return findByProperty(GONGZUODIDIAN, gongzuodidian);
	}

	public List findByGongzuojingyan(Object gongzuojingyan)
	{
		return findByProperty(GONGZUOJINGYAN, gongzuojingyan);
	}

	public List findByYouxiaoqi(Object youxiaoqi)
	{
		return findByProperty(YOUXIAOQI, youxiaoqi);
	}

	public List findByQitashuoming(Object qitashuoming)
	{
		return findByProperty(QITASHUOMING, qitashuoming);
	}

	public List findByUserId(Object userId)
	{
		return findByProperty(USER_ID, userId);
	}

	public List findAll()
	{
		log.debug("finding all TZhaopin instances");
		try
		{
			String queryString = "from TZhaopin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TZhaopin merge(TZhaopin detachedInstance)
	{
		log.debug("merging TZhaopin instance");
		try
		{
			TZhaopin result = (TZhaopin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TZhaopin instance)
	{
		log.debug("attaching dirty TZhaopin instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TZhaopin instance)
	{
		log.debug("attaching clean TZhaopin instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TZhaopinDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TZhaopinDAO) ctx.getBean("TZhaopinDAO");
	}
}