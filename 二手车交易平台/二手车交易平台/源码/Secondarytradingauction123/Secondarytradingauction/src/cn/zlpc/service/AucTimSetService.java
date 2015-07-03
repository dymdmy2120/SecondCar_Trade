/**
 * 
 */
package cn.zlpc.service;

import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.po.Bid;

/**
 * @author ASUS
 * 
 */
public class AucTimSetService {
	private BaseDao base = null;
	private Bid bid = null;

	public AucTimSetService(Bid bid) {
		this.bid = bid;
		base = new BaseDao();
	}

	public Boolean executeSetTime() throws DBException {
		Boolean flag = null;
		Integer b = bid.getBid_id();
		bid.setBeginAuction(new Integer(0));
		bid.setStopAuction(new Integer(0));
		if (b.intValue() == 0) {
			flag = base.save(bid);

		} else if (b.intValue() > 0) {
			flag = base.update(bid);
		}

		return flag;
	}

}
