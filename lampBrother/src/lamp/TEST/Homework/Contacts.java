package lamp.TEST.Homework;

import java.util.HashMap;
import java.util.Map;

/**
 * ͨѶ¼
 * @author Jeff
 *
 */
public class Contacts {
	
	private  Map<Integer , Contact> contactsMap = new HashMap<Integer , Contact>();
	private int id = 1;
	//��
	public void add (Contact c)
	{
		contactsMap.put(id ++, c);
	}
	//��
	public void update(int id , Contact c)
	{
		Contact contact = find(id);
		contact.setName(c.getName());
		contact.setPhoneNumber(c.getPhoneNumber());
	}
	//ɾ
	public void delete(int id)
	{
		contactsMap.remove(id);
	}
	//��
	public Contact find(int id)
	{
		
		return contactsMap.get(id);
	}
	//��ȡ���е���ϵ��
	 public Map<Integer , Contact> getContacts()
	 {
		 return contactsMap;
	 }
}
