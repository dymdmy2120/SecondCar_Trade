package cn.zlpc.service.support;

public abstract class VoAdapter {
	/**
	 * 将对应的视图vo转换的操作vo，或者是逆转换
	 * 
	 * @param voClass
	 * @param vo
	 * @return
	 * @throws ErrorException
	 */
	public abstract Object convertVo(Class<?> voClass, Object vo)
			throws Exception;
}
