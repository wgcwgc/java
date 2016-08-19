package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TStuDAO;
import com.dao.TUserDAO;
import com.model.TStu;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
    private int userId;
	private String userName;
	private String userPw;
	private String userRealname;
	private String userAddress;
	private String userSex;
	private String userTel;
	private String userEmail;
	private String userQq;
	private String userType;
	
   
	
	
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	private TStuDAO stuDAO;
	
	
	public String userAdd()
	{
		TUser user=new TUser();
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserEmail(userEmail);
		user.setUserSex(userSex);
		user.setUserQq(userQq);
		user.setUserDel("no");
		userDAO.save(user);
		
		this.setMessage("操作成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	public String userEdit()
	{
		TUser user=userDAO.findById(userId);
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserEmail(userEmail);
		user.setUserSex(userSex);
		user.setUserQq(userQq);
		user.setUserDel("no");
		userDAO.attachDirty(user);
		Map session= ServletActionContext.getContext().getSession();
		session.put("user", user);
		return "successAdd";
	}
	
	
	public String userLogin()
	{
		
		if(userType.equals("qiye"))
		{
			String sql="from TUser where userName=? and userPw=? and userDel='no'";
			Object[] con={userName,userPw};
			List userList=userDAO.getHibernateTemplate().find(sql,con);
			if(userList.size()==0)
			{
				this.setMessage("用户名或密码错误");
				this.setPath("qiantai/default.jsp");
			}
			else
			{
				 Map session= ServletActionContext.getContext().getSession();
				 TUser user=(TUser)userList.get(0);
				 session.put("user", user);
				 session.put("userType", "qiye");
				 this.setMessage("成功登录");
				 this.setPath("qiantai/default.jsp");
			}
		}
		if(userType.equals("stu"))
		{
			String sql="from TStu where loginName=? and loginPw=? and del='no'";
			Object[] con={userName,userPw};
			List stuList=stuDAO.getHibernateTemplate().find(sql,con);
			if(stuList.size()==0)
			{
				this.setMessage("用户名或密码错误");
				this.setPath("qiantai/default.jsp");
			}
			else
			{
				 Map session= ServletActionContext.getContext().getSession();
				 TStu stu=(TStu)stuList.get(0);
				 session.put("userType", "stu");
				 session.put("user", stu);
				 
				 this.setMessage("成功登录");
				 this.setPath("qiantai/default.jsp");
			}
		}
		
		return "succeed";
	}
	
	
	public String userLogout()
	{
		Map session= ServletActionContext.getContext().getSession();
		session.remove("userType");
		session.remove("user");
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	public String userXinxi()
	{
		TUser user=userDAO.findById(userId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userMana()
	{
		List userList=userDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String getUserAddress()
	{
		return userAddress;
	}

	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public String getUserType()
	{
		return userType;
	}
	public void setUserType(String userType)
	{
		this.userType = userType;
	}
	public String getUserQq()
	{
		return userQq;
	}

	public void setUserQq(String userQq)
	{
		this.userQq = userQq;
	}

	public String getUserRealname()
	{
		return userRealname;
	}

	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}

	public String getUserSex()
	{
		return userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	public String getUserTel()
	{
		return userTel;
	}

	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}

	public int getUserId()
	{
		return userId;
	}


	public void setUserId(int userId)
	{
		this.userId = userId;
	}


	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
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


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}
	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}

	
}
