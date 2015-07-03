package tool.mastery.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUtil {
	
	/**
	 * 输出map中所有的集合
	 * @param map
	 */
	public static <V, T> void showMap(Map<V, T> map) {
	 	Set<Map.Entry<V , T>> set = map.entrySet();
		for(Iterator<Map.Entry<V , T>> it = set.iterator() ; it.hasNext();) {
			Map.Entry<V , T> entry = it.next();
			System.out.println(entry.getKey() + "----->" + entry.getValue());
		}
	}
	
	/**
	 * 返回已经将map转换成Map.Entry<V , T>的list集合
	 * @param map
	 * @return
	 */
	public static <V, T> List<Map.Entry<V , T>> MapToList(Map<V, T> map) {
		Set<Map.Entry<V , T>> set = map.entrySet();
		List<Map.Entry<V , T>> list = new ArrayList<Map.Entry<V , T>>();
		for(Iterator<Map.Entry<V , T>> it = set.iterator() ; it.hasNext();) {
			Map.Entry<V , T> entry = it.next();
			list.add(entry);
		}
		return list;
	}
	
	/**
	 * 将传递过来的list集合转为全是Object对象的集合
	 * @param list
	 * @return
	 */
	public static <T> List<Object> listGeneralToObject(List<T> list) {
		List<Object> retList = new ArrayList<Object>();
		for(int i = 0 ; i < list.size() ; i ++) {
			retList.add(list.get(i));
		}
		return retList;
	}
	
}
