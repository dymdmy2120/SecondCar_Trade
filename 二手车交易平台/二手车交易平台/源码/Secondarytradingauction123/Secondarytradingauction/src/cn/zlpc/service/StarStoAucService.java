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
public class StarStoAucService {
	private BaseDao base = null;
	private String operate = null;
	private Bid bid = null;
    private String bid_id=null;
	public StarStoAucService(String operate,String bid_id) {
		//base = new AuctionMangDaoImpl();// 创建一个dao层对象
		base=new BaseDao();
		bid = new Bid();
		this.operate = operate;
        this.bid_id=bid_id;
	}

	public Boolean executeOperate() throws DBException {
		if(bid_id!=null){
		Integer bidInt=Integer.valueOf(bid_id);
		bid.setBid_id(bidInt);
		}
		System.out.println(bid.getBid_id());
		if (operate.equals("start")) {
			bid.setBeginAuction(1);
		} else if (operate.equals("stop")) {
			bid.setStopAuction(1);
			bid.setBeginAuction(0);
		}
		return updateStartAc(bid);
	}

	private Boolean updateStartAc(Object entity) throws DBException {
		return base.update(entity);
	}

}
