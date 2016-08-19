package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TZhaopinhuiDAO;
import com.model.TAdmin;
import com.model.TZhaopinhui;
import com.opensymphony.xwork2.ActionSupport;

public class zhaopinhuiAction extends ActionSupport
{
	private int id;
	private String mingcheng;
	private String shijian;
	private String didian;
	 
	private String message;
	private String path;
	
	private TZhaopinhuiDAO zhaopinhuiDAO;
	
	public String zhaopinhuiAdd()
	{
		TZhaopinhui zhaopinhui=new TZhaopinhui();
		zhaopinhui.setMingcheng(mingcheng);
		zhaopinhui.setShijian(shijian);
		zhaopinhui.setDidian(didian);
		zhaopinhui.setDel("no");
		zhaopinhuiDAO.save(zhaopinhui);
		
		this.setMessage("操作成功");
		this.setPath("zhaopinhuiMana.action");
		return "succeed";
	}
	
	public String zhaopinhuiDel()
	{
		TZhaopinhui zhaopinhui=zhaopinhuiDAO.findById(id);
		zhaopinhui.setDel("yes");
		zhaopinhuiDAO.attachDirty(zhaopinhui);
		this.setMessage("删除成功");
		this.setPath("zhaopinhuiMana.action");
		return "succeed";
	}
	
	public String zhaopinhuiMana()
	{
		String sql="from TZhaopinhui where del='no'";
		List zhaopinhuiList=zhaopinhuiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhaopinhuiList", zhaopinhuiList);
		return ActionSupport.SUCCESS;
	}
	
	

	public String zhaopinhuiAll()
	{
		String sql="from TZhaopinhui where del='no'";
		List zhaopinhuiList=zhaopinhuiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhaopinhuiList", zhaopinhuiList);
		return ActionSupport.SUCCESS;
	}


	public String getDidian()
	{
		return didian;
	}



	public void setDidian(String didian)
	{
		this.didian = didian;
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



	public String getMingcheng()
	{
		return mingcheng;
	}



	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	public String getShijian()
	{
		return shijian;
	}



	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}



	public TZhaopinhuiDAO getZhaopinhuiDAO()
	{
		return zhaopinhuiDAO;
	}



	public void setZhaopinhuiDAO(TZhaopinhuiDAO zhaopinhuiDAO)
	{
		this.zhaopinhuiDAO = zhaopinhuiDAO;
	}
	
}
