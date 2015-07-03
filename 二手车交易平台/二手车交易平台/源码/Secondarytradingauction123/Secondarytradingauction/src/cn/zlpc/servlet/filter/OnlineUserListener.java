package cn.zlpc.servlet.filter;

import java.util.List;
import java.util.Map.Entry;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import tool.mastery.core.CollectionUtil;

/**
 * Application Lifecycle Listener implementation class OnlineUserListener
 *
 */
@WebListener
public class OnlineUserListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineUserListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se) {
        // TODO Auto-generated method stub
    	//清空所有的登陆用户
    	List<Entry<String, String>>  list = CollectionUtil.MapToList(OnlineUser.STORE);
    	for(int i = 0 ; i < list.size() ; i ++) {
    		Entry<String, String> entry = list.get(i);
    		//如果在这个session内的id注销，则清楚掉这个用户 
    		if(entry.getValue().equalsIgnoreCase(se.getSession().getId())) {
    			OnlineUser.STORE.remove(entry.getKey());
    		}
    	}
    }
	
}
