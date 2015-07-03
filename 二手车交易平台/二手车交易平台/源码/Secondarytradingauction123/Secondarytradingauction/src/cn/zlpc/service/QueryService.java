package cn.zlpc.service;

import java.util.ArrayList;
import java.util.List;

import tool.mastery.core.ClassUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.service.support.VoSupport;
import cn.zlpc.vo.Page;

public class QueryService {
	
	private List<Object> allList;
	private String voName;

	public QueryService(String voName) {
		this.voName = voName;
	}

	/**
	 * @param query
	 *            查询的条件和值，query.get(0)为条件，query.get(1)为值
	 * @param page
	 * @return
	 * @throws ErrorException
	 */
	public List<Object> getResult(List<String> query, Page page)
			throws ErrorException {
		// TODO Auto-generated method stub
		// 判断是否是由单表构成的视图
		List<Object> list = new ArrayList<Object>();
		List<Object> retList = new ArrayList<Object>();
		Class<?> voClass = ClassUtil.getClassByClassName(voName);
		// 对page对象进行处理
		page = processPage(page);
		try {
			if (VoSupport.isSinglePo(voName)) {
				BaseDao baseDao = new BaseDao();
				if (query == null) {
					list = baseDao.queryForSingle(voClass,
							page.getFirstIndex(), page.getMaxSize(), null,
							null, null, false);
				} else if (query.size() == 0) {
					list = baseDao.queryForSingle(voClass,
							page.getFirstIndex(), page.getMaxSize(), null,
							null, null, false);
				} else {
					list = baseDao.queryForSingle(voClass,
							page.getFirstIndex(), page.getMaxSize(), null,
							query.get(0), query.get(1), false);
				}

			} else {
				MultiTableDao sd = null;
				try {
					Class<?> clazz = ClassUtil.getClassByName(ClassUtil.BASE_PACKAGE_NAME + ".dao.impl." + voName + "DaoImpl");
					Object bean = clazz.newInstance();
					if(bean instanceof MultiTableDao) {
						sd = (MultiTableDao)bean;
					}else {
						throw new ErrorException("错误！该类未实现MultiTableDao接口");
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("类不存在！请检查该类命名是否正确！");
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list = listVo(page, query, sd);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new ErrorException(e.getMessage());
		}
		allList = list;
		page.setCount(allList.size());
		int firstIndex = page.getFirstIndex();
		int maxSize = page.getMaxSize();
		if (maxSize != 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i >= firstIndex && i < firstIndex+maxSize) {
					retList.add(list.get(i));
				}
			}
		} else {
			return list;
		}
		return retList;
	}

	/**
	 * 根据传递条件的查询
	 * 
	 * @param page
	 * @param query
	 * @param sd
	 * @return
	 * @throws DBException
	 */
	private List<Object> listVo(Page page, List<String> query, MultiTableDao sd)
			throws DBException {
		List<Object> list = new ArrayList<Object>();
		if (query == null) {
			list = sd.listVo(page, null, null);
		} else if (query.size() == 0) {
			list = sd.listVo(page, null, null);
		} else {
			list = sd.listVo(page, query.get(0), query.get(1));
		}
		return list;
	}

	/**
	 * 对page对象进行处理，如果对象为空，则设置初始情况，使得查询所有
	 * 
	 * @param page
	 */
	private Page processPage(Page page) {
		if (page == null) {
			page = new Page();
			page.setPage(1);
			page.setMaxSize(0);
		}
		return page;
	}

	public List<Object> getAllList() {
		return allList;
	}

}
