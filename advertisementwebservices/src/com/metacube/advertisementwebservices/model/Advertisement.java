package com.metacube.advertisementwebservices.model;

public class Advertisement{
	private int advertisementId;
	private String advertisementTitle;
	private String advertisementDescription;
	private int categoryId;
	
	public int getAdvertisementId() {
		return advertisementId;
	}
	public void setAdvertisementId(int advId) {
		this.advertisementId = advId;
	}
	public String getAdvertisementTitle() {
		return advertisementTitle;
	}
	public void setAdvertisementTitle(String advTitle) {
		this.advertisementTitle = advTitle;
	}
	public String getAdvertisementDescription() {
		return advertisementDescription;
	}
	public void setAdvertisementDescription(String advescription) {
		this.advertisementDescription = advescription;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}	
}
