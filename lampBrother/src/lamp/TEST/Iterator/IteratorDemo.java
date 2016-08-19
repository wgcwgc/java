package lamp.TEST.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * 使用Iterator 迭代器遍历集合
 * @author Jeff
 *
 */
 
public class IteratorDemo
{
	public static void iterator(Collection<String> c)
	{
		//获取迭代器对象
		Iterator <String> iter = c.iterator();
		while(iter.hasNext())
		{
			String s = iter.next();
			System.out.println(s);
		}
	}

	public static void main(String[] args)
	{
		//list集合
		List<String> list = new ArrayList<String>();
		list.add("feichengwurao");
		list.add("yuehuizhuanjia");
		list.add("wuzishenm de ");
		list.add("babaqunala");
		list.add("running man");
		//迭代输出
		iterator(list);
		
		System.out.println("------------------------");
		
		//set集合
		Set<String> set = new HashSet<String>();
		set.add("feichengwurao");
		set.add("yuehuizhuanjia");
		set.add("wuzishenm de ");
		set.add("babaqunala");
		set.add("running man");
		iterator(set);
	}
}
