package proj.stepUp.vo;

import proj.stepUp.util.PagingUtil;

public class SearchVO extends PagingUtil {
	private String searchType;
	private String searchValue;
	private int[] sizeKind;
	private int priceMin;
	private int priceMax;
	private int[] prdType;
		
	public int[] getSizeKind() {
		return sizeKind;
	}
	public void setSizeKind(int[] sizeKind) {
		this.sizeKind = sizeKind;
	}
	public int[] getPrdType() {
		return prdType;
	}
	public void setPrdType(int[] prdType) {
		this.prdType = prdType;
	}
	public String getSearchType() {
		return searchType;
	}
	public int getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}
	public int getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}	
	
}
