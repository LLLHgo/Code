package po;

public class MarketingPO {
    private String name;
    private String password;
    private String marketingID;
    private String telephone;
    public MarketingPO(){

    }
    public MarketingPO(String name,String password,String marketingID,String telephone){
    	this.setName(name);
    	this.setPassword(password);
    	this.setMarketingID(marketingID);
    	this.setTelephone(telephone);
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMarketingID() {
		return marketingID;
	}
	public void setMarketingID(String marketingID) {
		this.marketingID = marketingID;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
    }
}
