package lamp.TEST.Homework;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用HashMap模拟通讯录，实现对通讯录的维护操作（CRUD）
 * 联系人：contact
 * 通讯录：contacts
 * @author Jeff
 *
 */
public class Test {
	public static void main(String[] args) {
		Contacts cs = new Contacts();
		System.out.println("-----------添加联系人—----------");
		cs.add(new Contact("123" , "123"));
		cs.add(new Contact("1234" , "1234"));
		cs.add(new Contact("12345" , "12345"));
		
		Map<Integer , Contact> maps = cs.getContacts();
		Set<Integer> keyset = maps.keySet();
		Iterator<Integer> iters = keyset.iterator();
		while(iters.hasNext()){
			Integer key = iters.next();
			System.out.println("id: " + maps.get(key));
		}
		
		System.out.println("-----------添加联系人—----------");
//		cs.update(1234, c);
	}
}
