package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TZhaopinhui;

/**
 * Data access object (DAO) for domain model class TZhaopinhui.
 * 
 * @see com.model.TZhaopinhui
 * @author MyEclipse Persistence Tools
 */

public class TZhaopinhuiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TZhaopinhuiDAO.class);

	// property constants
	public static final String MINGCHENG = "mingcheng";

	public static final String SHIJIAN = "shijian";

	public static final String DIDIAN = "didian";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TZhaopinhui transientInstance)
	{
		log.debug("saving TZhaopinhui instance");
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

	public void delete(TZhaopinhui persistentInstance)
	{
		log.debug("deleting TZhaopinhui instance");
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

	public TZhaopinhui findById(java.lang.Integer id)
	{
		log.debug("getting TZhaopinhui instance with id: " + id);
		try
		{
			TZhaopinhui instance = (TZhaopinhui) getHibernateTemplate().get(
					"com.model.TZhaopinhui", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TZhaopinhui instance)
	{
		log.debug("finding TZhaopinhui instance by example");
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
		log.debug("finding TZhaopinhui instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TZhaopinhui as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMingcheng(Object mingcheng)
	{
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findByDidian(Object didian)
	{
		return findByProperty(DIDIAN, didian);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TZhaopinhui instances");
		try
		{
			String queryString = "from TZhaopinhui";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TZhaopinhui merge(TZhaopinhui detachedInstance)
	{
		log.debug("merging TZhaopinhui instance");
		try
		{
			TZhaopinhui result = (TZhaopinhui) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TZhaopinhui instance)
	{
		log.debug("attaching dirty TZhaopinhui instance");
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

	public void attachClean(TZhaopinhui instance)
	{
		log.debug("attaching clean TZhaopinhui instance");
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

	public static TZhaopinhuiDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TZhaopinhuiDAO) ctx.getBean("TZhaopinhuiDAO");
	}
}