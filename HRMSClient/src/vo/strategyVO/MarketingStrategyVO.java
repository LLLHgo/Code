package vo.strategyVO;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import Enum.*;
import vo.*;

public class MarketingStrategyVO {
    private marketingStrategy type;
    private Date startTime;
    private Date endTime;
    private double discount;
    private ArrayList<String> businessArea;
    private ArrayList<HotelinfoVO> hotels;
    private Image poster;
    private String position;
    private int minSum;
    private int minRooms;
    private LevelVO Levels;
    private ArrayList<VIPType> vipKinds;
	public marketingStrategy getType() {
		return type;
	}
	public void setType(marketingStrategy type) {
		this.type = type;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Image getPoster() {
		return poster;
	}
	public void setPoster(Image poster) {
		this.poster = poster;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public ArrayList<String> getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(ArrayList<String> businessArea) {
		this.businessArea = businessArea;
	}
	public ArrayList<HotelinfoVO> getHotels() {
		return hotels;
	}
	public void setHotels(ArrayList<HotelinfoVO> hotels) {
		this.hotels = hotels;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getMinSum() {
		return minSum;
	}
	public void setMinSum(int minSum) {
		this.minSum = minSum;
	}
	public int getMinRooms() {
		return minRooms;
	}
	public void setMinRooms(int minRooms) {
		this.minRooms = minRooms;
	}
	public LevelVO getLevels() {
		return Levels;
	}
	public void setLevels(LevelVO levels) {
		Levels = levels;
	}
	public ArrayList<VIPType> getVipKinds() {
		return vipKinds;
	}
	public void setVipKinds(ArrayList<VIPType> vipKinds) {
		this.vipKinds = vipKinds;
	}


}
