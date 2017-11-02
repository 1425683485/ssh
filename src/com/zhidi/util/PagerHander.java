package com.zhidi.util;

public class PagerHander {

	//每页显示总数
	private Integer pageSize;
	//第几页
	private Integer pageNum;
	//总页数
	private Integer totalPage;
	//查询的数据总数
	private Integer totalRows;
	
	public PagerHander() {
		super();
	}
	
	public PagerHander(Integer pageSize, Integer pageNum) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}


	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		if (pageNum < 1){
			pageNum = 1;
		}
		if (pageNum >= getTotalPage()){
			pageNum = getTotalPage();
		}
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotalPage() {
		if (pageSize > 0){
			totalPage = (totalRows-1)/pageSize+1;
		}
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	@Override
	public String toString() {
		return "PagerHander [pageSize=" + pageSize + ", pageNum=" + pageNum
				+ ", totalPage=" + totalPage + ", totalRows=" + totalRows + "]";
	}
	
}
