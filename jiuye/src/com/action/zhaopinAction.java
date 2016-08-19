package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TZhaopinDAO;
import com.model.TUser;
import com.model.TZhaopin;
import com.opensymphony.xwork2.ActionSupport;

public class zhaopinAction extends ActionSupport
{
    private int id;
    private String zhiwei;
    private String daiyui;
    private String xuliyaoqiu;
    private String gongzuodidian;
    private String gongzuojingyan;
    private String qitashuoming;
    private String zhaopinType;
    
    private String message;
	private String path;
	
	private TZhaopinDAO zhaopinDAO;
	
	
	public String zhaopinAddMy()
	{
		TZhaopin zhaopin=new TZhaopin();
		zhaopin.setDaiyui(daiyui);
		zhaopin.setDel("no");
		zhaopin.setGongzuodidian(gongzuodidian);
		zhaopin.setGongzuojingyan(gongzuojingyan);
		zhaopin.setQitashuoming(qitashuoming);
		zhaopin.setZhiwei(zhiwei);
		zhaopin.setXuliyaoqiu(xuliyaoqiu);
		zhaopin.setZhaopinType(zhaopinType);
		zhaopin.setFabushijian(new Date().toLocaleString());
		
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		zhaopin.setUserId(user.getUserId());//发布招聘信息的用户
		zhaopinDAO.save(zhaopin);
		this.setMessage("操作成功");
		this.setPath("zhaopinManaMy.action");
		return "succeed";
	}
	
	public String zhaopinDelMy()
	{
		TZhaopin zhaopin=zhaopinDAO.findById(id);
		zhaopin.setDel("yes");
		zhaopinDAO.attachDirty(zhaopin);
		this.setMessage("操作成功");
		this.setPath("zhaopinManaMy.action");
		return "succeed";
	}
	
	
	public String zhaopinManaMy()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TZhaopin where userId=? and del='no'";
		Object[] cn={user.getUserId()};
		List zhaopinList=zhaopinDAO.getHibernateTemplate().find(sql,cn);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhaopinList", zhaopinList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhaopin_all_shixi()
	{
		String sql="from TZhaopin where zhaopinType='shixizhaopin' and del='no' order by id desc";
		List zhaopinList=zhaopinDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhaopinList", zhaopinList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhaopin_all_jiuye()
	{
		String sql="from TZhaopin where zhaopinType='jiuyezhaopin' and del='no' order by id desc";
		List zhaopinList=zhaopinDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhaopinList", zhaopinList);
		return ActionSupport.SUCCESS;
	}
		
	public String zhaopinDetailQian()
	{
		TZhaopin zhaopin=zhaopinDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhaopin", zhaopin);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String zhaopinSearch()
	{
		String sql="from TZhaopin where zhiwei like '%"+zhiwei+"%'";
		List zhaopinList=zhaopinDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhaopinList", zhaopinList);
		return ActionSupport.SUCCESS;
	}

	public String getDaiyui()
	{
		return daiyui;
	}

	public String getZhaopinType()
	{
		return zhaopinType;
	}


	public void setZhaopinType(String zhaopinType)
	{
		this.zhaopinType = zhaopinType;
	}


	public void setDaiyui(String daiyui)
	{
		this.daiyui = daiyui;
	}

	public String getGongzuodidian()
	{
		return gongzuodidian;
	}

	public void setGongzuodidian(String gongzuodidian)
	{
		this.gongzuodidian = gongzuodidian;
	}

	public String getGongzuojingyan()
	{
		return gongzuojingyan;
	}

	public void setGongzuojingyan(String gongzuojingyan)
	{
		this.gongzuojingyan = gongzuojingyan;
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

	public String getQitashuoming()
	{
		return qitashuoming;
	}

	public void setQitashuoming(String qitashuoming)
	{
		this.qitashuoming = qitashuoming;
	}

	public String getXuliyaoqiu()
	{
		return xuliyaoqiu;
	}

	public void setXuliyaoqiu(String xuliyaoqiu)
	{
		this.xuliyaoqiu = xuliyaoqiu;
	}

	public TZhaopinDAO getZhaopinDAO()
	{
		return zhaopinDAO;
	}

	public void setZhaopinDAO(TZhaopinDAO zhaopinDAO)
	{
		this.zhaopinDAO = zhaopinDAO;
	}

	public String getZhiwei()
	{
		return zhiwei;
	}

	public void setZhiwei(String zhiwei)
	{
		this.zhiwei = zhiwei;
	}
	
}
