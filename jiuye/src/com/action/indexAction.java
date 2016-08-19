package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TNewsDAO;
import com.dao.TZhaopinDAO;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TNewsDAO newsDAO;
	private TZhaopinDAO zhaopinDAO;
	
	public TNewsDAO getNewsDAO()
	{
		return newsDAO;
	}
	public void setNewsDAO(TNewsDAO newsDAO)
	{
		this.newsDAO = newsDAO;
	}
	public TZhaopinDAO getZhaopinDAO()
	{
		return zhaopinDAO;
	}
	public void setZhaopinDAO(TZhaopinDAO zhaopinDAO)
	{
		this.zhaopinDAO = zhaopinDAO;
	}
	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		
				
		String sql1="from TZhaopin where del='no' order by id desc";
		List zhaopinList=zhaopinDAO.getHibernateTemplate().find(sql1);
		request.put("zhaopinList", zhaopinList);
		return ActionSupport.SUCCESS;
	}
	
}
