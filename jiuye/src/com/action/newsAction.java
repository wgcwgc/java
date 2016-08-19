package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGonggaoDAO;
import com.dao.TNewsDAO;
import com.model.TNews;
import com.opensymphony.xwork2.ActionSupport;

public class newsAction extends ActionSupport
{
	private int newsId;
	private String newsTitle;
	private String newsContent;
	
	private String message;
	private String path;
	
	private TNewsDAO newsDAO;
	
	
	public String newsAdd()
	{
		TNews news=new TNews();
		news.setNewsTitle(newsTitle);
		news.setNewsContent(newsContent);
		news.setNewsDate(new Date().toLocaleString());
		newsDAO.save(news);
		this.setMessage("操作成功");
		this.setPath("newsMana.action");
		return "succeed";
	}
	
	public String newsMana()
	{
		List newsList=newsDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("newsList", newsList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String newsDel()
	{
		TNews news=newsDAO.findById(newsId);
		newsDAO.delete(news);
		this.setMessage("操作成功");
		this.setPath("newsMana.action");
		return "succeed";
	}
	
	public String newsDetailHou()
	{
		TNews news=newsDAO.findById(newsId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("news", news);
		return ActionSupport.SUCCESS;
	}
	
	
	public String newsAll()
	{
		List newsList=newsDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("newsList", newsList);
		
		return ActionSupport.SUCCESS;
	}
	
	public String newsDetailQian()
	{
		TNews news=newsDAO.findById(newsId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("news", news);
		
		return ActionSupport.SUCCESS;
	}
	
	
	

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getNewsContent()
	{
		return newsContent;
	}

	public void setNewsContent(String newsContent)
	{
		this.newsContent = newsContent;
	}

	public TNewsDAO getNewsDAO()
	{
		return newsDAO;
	}

	public void setNewsDAO(TNewsDAO newsDAO)
	{
		this.newsDAO = newsDAO;
	}

	public int getNewsId()
	{
		return newsId;
	}

	public void setNewsId(int newsId)
	{
		this.newsId = newsId;
	}

	public String getNewsTitle()
	{
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle)
	{
		this.newsTitle = newsTitle;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
}
