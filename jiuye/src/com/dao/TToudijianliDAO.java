package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TToudijianli;

/**
 * Data access object (DAO) for domain model class TToudijianli.
 * 
 * @see com.model.TToudijianli
 * @author MyEclipse Persistence Tools
 */

public class TToudijianliDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TToudijianliDAO.class);

	// property constants
	public static final String STU_ID = "stuId";

	public static final String ZHAOPIN_ID = "zhaopinId";

	public static final String SHIJIAN = "shijian";

	public static final String FUJIAN = "fujian";

	public static final String FUJIAN_YUANSHIMING = "fujianYuanshiming";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TToudijianli transientInstance)
	{
		log.debug("saving TToudijianli instance");
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

	public void delete(TToudijianli persistentInstance)
	{
		log.debug("deleting TToudijianli instance");
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

	public TToudijianli findById(java.lang.Integer id)
	{
		log.debug("getting TToudijianli instance with id: " + id);
		try
		{
			TToudijianli instance = (TToudijianli) getHibernateTemplate().get(
					"com.model.TToudijianli", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TToudijianli instance)
	{
		log.debug("finding TToudijianli instance by example");
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
		log.debug("finding TToudijianli instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from TToudijianli as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStuId(Object stuId)
	{
		return findByProperty(STU_ID, stuId);
	}

	public List findByZhaopinId(Object zhaopinId)
	{
		return findByProperty(ZHAOPIN_ID, zhaopinId);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findByFujian(Object fujian)
	{
		return findByProperty(FUJIAN, fujian);
	}

	public List findByFujianYuanshiming(Object fujianYuanshiming)
	{
		return findByProperty(FUJIAN_YUANSHIMING, fujianYuanshiming);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TToudijianli instances");
		try
		{
			String queryString = "from TToudijianli";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TToudijianli merge(TToudijianli detachedInstance)
	{
		log.debug("merging TToudijianli instance");
		try
		{
			TToudijianli result = (TToudijianli) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TToudijianli instance)
	{
		log.debug("attaching dirty TToudijianli instance");
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

	public void attachClean(TToudijianli instance)
	{
		log.debug("attaching clean TToudijianli instance");
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

	public static TToudijianliDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TToudijianliDAO) ctx.getBean("TToudijianliDAO");
	}
}