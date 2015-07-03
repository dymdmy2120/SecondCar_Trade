package tool.mastery.log;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * 封装log4j并调用其的工具类
 * 
 * @author Administrator
 * 
 */
public class LogUtil {

	private static Logger logger;

	static {
		logger = Logger.getLogger(LogUtil.class);
	}

	/**
	 * 通过properties文件在配置Logger类
	 * 
	 * @return
	 */
	private static void getLoggerByProperties() {
		URL url = LogUtil.class.getClassLoader()
				.getResource("log4j.properties");
		PropertyConfigurator.configure(url);
	}

	/**
	 * 通过XML文件在配置Logger类
	 * 
	 */
	private static void getLoggerByXml() {
		URL url = LogUtil.class.getClassLoader().getResource("log4j.xml");
		DOMConfigurator.configure(url);
	}

	/**
	 * 
	 * 配置logger
	 */
	private static void config() {
		ClassLoader thisClassLoader = LogUtil.class.getClassLoader();

		if (thisClassLoader.getResource("log4j.properties") == null
				&& thisClassLoader.getResource("log4j.xml") == null) {
			throw new RuntimeException("属性文件不存在!");
		}
		if (thisClassLoader.getResource("log4j.xml") != null) {
			getLoggerByXml();
		} else if (thisClassLoader.getResource("log4j.properties") != null) {
			getLoggerByProperties();
		}

	}

	/**
	 * 判断此配置是否存在
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private static boolean isExistConfig() {
		ClassLoader thisClassLoader = LogUtil.class.getClassLoader();

		if (thisClassLoader.getResource("log4j.properties") == null
				|| thisClassLoader.getResource("log4j.xml") == null) {
			return false;
		}
		return true;
	}

	/**
	 * 获得对应的日志
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		/*
		 * if(!isExistConfig()) { getLoggerByProperties(); }
		 */
		// 配置logger
		config();
		return logger;

	}

	public static void setWebRootPath(HttpServletRequest request) {
		if (System.getProperty("webroot") == null) {
			String path = request.getServletContext().getRealPath("/");
			System.setProperty("webroot", path);
		}
	}
}
