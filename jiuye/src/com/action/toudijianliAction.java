package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TToudijianliDAO;
import com.model.TStu;
import com.model.TToudijianli;
import com.opensymphony.xwork2.ActionSupport;

public class toudijianliAction extends ActionSupport
{
	private int id;
	private int zhaopinId;
	private String fujian;
	private String fujianYuanshiming;
	 
	private String message;
	private String path;
	

	private TToudijianliDAO toudijianliDAO;
	
	
	public String toudijianliAddMy()
	{
		TToudijianli toudijianli=new TToudijianli();
		
		Map session= ServletActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("user");
		toudijianli.setStuId(stu.getStuId());
		toudijianli.setZhaopinId(zhaopinId);
		toudijianli.setShijian(new Date().toLocaleString());
		toudijianli.setFujian(fujian);
		toudijianli.setFujianYuanshiming(fujianYuanshiming);
		toudijianliDAO.save(toudijianli);
		this.setMessage("²Ù×÷³É¹¦");
		this.setPath("index.action");
		return "succeed";
	}
	
	
	
	public String toudijianliManaMy()
	{
		Map session= ServletActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("user");
		String sql="from TToudijianli where stuId="+stu.getStuId();
		List toudijianliList=toudijianliDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("toudijianliList", toudijianliList);
		return ActionSupport.SUCCESS;
	}

	
	public String toudijianliChakan_qiye()
	{
		String sql="from TToudijianli where zhaopinId="+zhaopinId;
		List toudijianliList=toudijianliDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("toudijianliList", toudijianliList);
		return ActionSupport.SUCCESS;
	}


	public String getFujian()
	{
		return fujian;
	}



	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}



	public String getFujianYuanshiming()
	{
		return fujianYuanshiming;
	}



	public void setFujianYuanshiming(String fujianYuanshiming)
	{
		this.fujianYuanshiming = fujianYuanshiming;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}


	public TToudijianliDAO getToudijianliDAO()
	{
		return toudijianliDAO;
	}



	public void setToudijianliDAO(TToudijianliDAO toudijianliDAO)
	{
		this.toudijianliDAO = toudijianliDAO;
	}



	public int getZhaopinId()
	{
		return zhaopinId;
	}



	public void setZhaopinId(int zhaopinId)
	{
		this.zhaopinId = zhaopinId;
	}
	
	 
}
