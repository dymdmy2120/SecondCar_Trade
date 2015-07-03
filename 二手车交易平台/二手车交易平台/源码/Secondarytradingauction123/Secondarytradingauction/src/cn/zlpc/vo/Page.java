package cn.zlpc.vo;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private int page = 1; // 当前的页面
	private int firstIndex; // 通过页面拿到值
	private int maxSize = 2; // 默认是在一个页面中显示10行
	private int count;
	private int showNum = 5;// 在页面中显示的可以做切换的数据
	private List<Integer> linkNum;
	private int lastPage;

	public int getLastPage() {
		if (maxSize != 0) {
			if(count % maxSize == 0) {
				lastPage = count / maxSize;
			}else {
				lastPage = count / maxSize + 1;
			}
		}
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public List<Integer> getLinkNum() {
		linkNum = new ArrayList<Integer>();
		int i = 0;
		int j = page;
		int totolPage = (count % maxSize == 0) ? count / maxSize : (count
				/ maxSize + 1);
		showNum = (totolPage < showNum) ? totolPage : showNum;
		if ((page - showNum) <= 1) {
			j = 2;
		} else {
			j = page - showNum;
		}

		for (; j < page; j++) {
			linkNum.add(j);
		}

		linkNum.add(page);

		for (j = page + 1;; i++, j++) {
			if (i == showNum || j > totolPage) {
				break;
			}
			linkNum.add(j);
		}

		if (linkNum.get(0) != 1) {
			linkNum.add(0, 1);
		}
		return linkNum;

	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getFirstIndex() {
		return (page - 1) * maxSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getCount() {
		return count;
	}

	public int getShowNum() {
		return showNum;
	}

	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
