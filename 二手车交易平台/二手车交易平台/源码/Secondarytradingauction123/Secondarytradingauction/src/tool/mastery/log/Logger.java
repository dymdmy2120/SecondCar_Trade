package tool.mastery.log;

import java.text.MessageFormat;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;


/**
 * 
 * 封装log4j要素：
	1、对外不暴露log4j的包名和类名。
	2、保护日志发生现场LocationInfo（日志发生时的类、方法、类文件及行数）。
	3、方便的格式化日志字符串,MessageFormat.format()。
	4、保持效率。
	5、方便使用。 
 * @author Administrator
 *
 */
public class Logger {
	
	private final org.apache.log4j.Logger logger;
	
	private static final String FQCN;
	
	static {
		FQCN = Logger.class.getName();
	}
	
	private Logger() {
		logger = org.apache.log4j.Logger.getRootLogger();
	}
	
	private Logger(Class<?> clazz) {
		logger = org.apache.log4j.Logger.getLogger(clazz);
	}
	
	public static Logger getLogger(Class<?> clazz) {
		return new Logger(clazz);
	}
	
	public static Logger getRootLogger() {
		return new Logger();
	}
	
	/**
	 * 对org.apache.log4j.Logger的trace方法的封装
	 * @param message
	 */
	public void trace(Object message) {
		if(logger.isTraceEnabled()) {
			forcedLog(logger , Level.TRACE , message);
		}
	}
	
	public void trace(Object message , Throwable t) {
		if(logger.isTraceEnabled()) {
			forcedLog(logger , Level.TRACE , message , t);
		}
	}

	public void trace(String pattern , Object ... arguments) {
		if(logger.isTraceEnabled()) {
			forcedLog(logger , Level.TRACE , format(pattern , arguments));
		}
	}
	
	public void trace(String pattern , Throwable t , Object ... arguments ) {
		if(logger.isTraceEnabled()) {
			forcedLog(logger , Level.TRACE , format(pattern , arguments) , t);
		}
	}
	
	/**
	 * 对org.apache.log4j.Logger的debug方法的封装
	 * @param message
	 */
	public void debug(Object message) {
		if(logger.isDebugEnabled()) {
			forcedLog(logger , Level.DEBUG , message);
		}
	}
	
	public void debug(Object message , Throwable t) {
		if(logger.isDebugEnabled()) {
			forcedLog(logger , Level.DEBUG , message , t);
		}
	}
	
	public void debug(String pattern , Object ... arguments) {
		if(logger.isDebugEnabled()) {
			forcedLog(logger , Level.DEBUG , format(pattern , arguments));
		}
	}
	
	public void debug(String pattern , Throwable t , Object ... arguments ) {
		if(logger.isDebugEnabled()) {
			forcedLog(logger , Level.DEBUG , format(pattern , arguments) , t);
		}
	}
	
	/**
	 * 对org.apache.log4j.Logger的info方法的封装
	 * @param message
	 */
	public void info(Object message) {
		if(logger.isInfoEnabled()) {
			forcedLog(logger , Level.INFO , message);
		}
	}
	
	public void info(Object message , Throwable t) {
		if(logger.isInfoEnabled()) {
			forcedLog(logger , Level.INFO , message , t);
		}
	}
	
	public void info(String pattern , Object ... arguments) {
		if(logger.isInfoEnabled()) {
			forcedLog(logger , Level.INFO , format(pattern , arguments));
		}
	}
	
	public void info(String pattern , Throwable t , Object ... arguments ) {
		if(logger.isInfoEnabled()) {
			forcedLog(logger , Level.INFO , format(pattern , arguments) , t);
		}
	}
	
	/**
	 * 对org.apache.log4j.Logger的warn方法的封装
	 * @param message
	 */
	public void warn(Object message) {
		if(logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger , Level.WARN , message);
		}
	}
	
	public void warn(Object message , Throwable t) {
		if(logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger , Level.WARN , message , t);
		}
	}
	
	public void warn(String pattern , Object ... arguments) {
		if(logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger , Level.WARN , format(pattern , arguments));
		}
	}
	
	public void warn(String pattern , Throwable t , Object ... arguments ) {
		if(logger.isEnabledFor(Level.WARN)) {
			forcedLog(logger , Level.WARN , format(pattern , arguments) , t);
		}
	}
	
	/**
	 * 对org.apache.log4j.Logger的error方法的封装
	 * @param message
	 */
	public void error(Object message) {
		if(logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger , Level.ERROR , message);
		}
	}
	
	public void error(Object message , Throwable t) {
		if(logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger , Level.ERROR , message , t);
		}
	}
	
	public void error(String pattern , Object ... arguments) {
		if(logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger , Level.ERROR , format(pattern , arguments));
		}
	}
	
	public void error(String pattern , Throwable t , Object ... arguments ) {
		if(logger.isEnabledFor(Level.ERROR)) {
			forcedLog(logger , Level.ERROR , format(pattern , arguments) , t);
		}
	}
	
	/**
	 * 对org.apache.log4j.Logger的fatal方法的封装
	 * @param message
	 */
	public void fatal(Object message) {
		if(logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger , Level.FATAL , message);
		}
	}
	
	public void fatal(Object message , Throwable t) {
		if(logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger , Level.FATAL , message , t);
		}
	}
	
	public void fatal(String pattern , Object ... arguments) {
		if(logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger , Level.FATAL , format(pattern , arguments));
		}
	}
	
	public void fatal(String pattern , Throwable t , Object ... arguments ) {
		if(logger.isEnabledFor(Level.FATAL)) {
			forcedLog(logger , Level.FATAL , format(pattern , arguments) , t);
		}
	}
	
	public void assertLog(boolean assertion , String message) {
		if(!assertion) {
			forcedLog(logger , Level.ERROR , message);
		}
	}
	
	private static String format(String pattern, Object[] arguments) {
		// TODO Auto-generated method stub
		return MessageFormat.format(pattern, arguments);
	}

	private static void forcedLog(org.apache.log4j.Logger logger, Level level,
			Object message, Throwable t) {
		// TODO Auto-generated method stub
		logger.callAppenders(new LoggingEvent(FQCN , logger , level , message , t));
	}

	private static void forcedLog(org.apache.log4j.Logger logger, Level level,
			Object message) {
		// TODO Auto-generated method stub
		logger.callAppenders(new LoggingEvent(FQCN , logger , level , message , null));
	}
}
