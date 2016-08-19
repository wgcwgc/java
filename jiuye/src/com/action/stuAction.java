package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TStuDAO;
import com.model.TStu;
import com.opensymphony.xwork2.ActionSupport;

public class stuAction extends ActionSupport
{
	private int stuId;
	private String stuXuehao;
	private String stuRealname;
	private String stuSex;
	private String stuAge;
	private String stuZhengzhimianmao;
	private String stuCard;
	private String loginName;
	private String loginPw;
	 
	private String message;
	private String path;
	private TStuDAO stuDAO;
	
	private String filename;
    private String fujianFileName;
	
	
	
	public String stuAdd()
	{
		TStu stu=new TStu();
		stu.setStuXuehao(stuXuehao);
		stu.setStuRealname(stuRealname);
		stu.setStuSex(stuSex);
		stu.setStuAge(stuAge);
		stu.setStuZhengzhimianmao(stuZhengzhimianmao);
		stu.setStuCard(stuCard);
		stu.setLoginName(loginName);
		stu.setLoginPw(loginPw);
		stu.setDel("no");
		stuDAO.save(stu);
		return "successAdd";
	}
	

	public String stuDel()
	{
		TStu stu=stuDAO.findById(stuId);
		stu.setDel("yes");
		stuDAO.attachDirty(stu);
		this.setMessage("删除成功");
		this.setPath("stuMana.action");
		return "succeed";
	}
	
	
	public String stuMana()
	{
		List stuList=stuDAO.getHibernateTemplate().find("from TStu where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("stuList", stuList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String stuEditByMe()
	{
		Map session= ServletActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("stu");
		stu.setStuXuehao(stuXuehao);
		stu.setStuRealname(stuRealname);
		stu.setStuSex(stuSex);
		stu.setStuAge(stuAge);
		stu.setStuZhengzhimianmao(stuZhengzhimianmao);
		stu.setStuCard(stuCard);
		stu.setLoginName(loginName);
		stu.setLoginPw(loginPw);
		stu.setDel("no");
		stuDAO.attachDirty(stu);
		session.put("stu", stu);
		this.setMessage("操作成功");
		this.setPath("astu/userinfo/stuinfo.jsp");
		return "succeed";
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
	public String getFilename()
	{
		return filename;
	}
	public void setFilename(String filename)
	{
		this.filename = filename;
	}
	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}
	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getStuAge()
	{
		return stuAge;
	}
	public String getLoginName()
	{
		return loginName;
	}
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}
	public String getLoginPw()
	{
		return loginPw;
	}
	public void setLoginPw(String loginPw)
	{
		this.loginPw = loginPw;
	}
	public void setStuAge(String stuAge)
	{
		this.stuAge = stuAge;
	}
	public String getStuCard()
	{
		return stuCard;
	}
	public void setStuCard(String stuCard)
	{
		this.stuCard = stuCard;
	}
	public int getStuId()
	{
		return stuId;
	}
	public void setStuId(int stuId)
	{
		this.stuId = stuId;
	}
	public String getStuRealname()
	{
		return stuRealname;
	}
	public void setStuRealname(String stuRealname)
	{
		this.stuRealname = stuRealname;
	}
	public String getStuSex()
	{
		return stuSex;
	}
	public void setStuSex(String stuSex)
	{
		this.stuSex = stuSex;
	}
	public String getStuXuehao()
	{
		return stuXuehao;
	}
	public void setStuXuehao(String stuXuehao)
	{
		this.stuXuehao = stuXuehao;
	}
	public String getFujianFileName()
	{
		return fujianFileName;
	}
	public void setFujianFileName(String fujianFileName)
	{
		this.fujianFileName = fujianFileName;
	}
	public String getStuZhengzhimianmao()
	{
		return stuZhengzhimianmao;
	}
	public void setStuZhengzhimianmao(String stuZhengzhimianmao)
	{
		this.stuZhengzhimianmao = stuZhengzhimianmao;
	}
}
