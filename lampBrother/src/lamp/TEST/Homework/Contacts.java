package lamp.TEST.Homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 通讯录
 * @author Jeff
 *
 */
public class Contacts {
	
	private  Map<Integer , Contact> contactsMap = new HashMap<Integer , Contact>();
	private int id = 1;
	//增
	public void add (Contact c)
	{
		contactsMap.put(id ++, c);
	}
	//改
	public void update(int id , Contact c)
	{
		Contact contact = find(id);
		contact.setName(c.getName());
		contact.setPhoneNumber(c.getPhoneNumber());
	}
	//删
	public void delete(int id)
	{
		contactsMap.remove(id);
	}
	//查
	public Contact find(int id)
	{
		
		return contactsMap.get(id);
	}
	//获取所有的联系人
	 public Map<Integer , Contact> getContacts()
	 {
		 return contactsMap;
	 }
}
