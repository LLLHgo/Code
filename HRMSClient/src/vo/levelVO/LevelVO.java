package vo.levelVO;

public class LevelVO {
    private int level;
    private String name;
    private int creditNeeded;
    public LevelVO(int level,String name,int creditNeeded){
    	this.setLevel(level);
    	this.setName(name);
    	this.setCreditNeeded(creditNeeded);
    }
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreditNeeded() {
		return creditNeeded;
	}
	public void setCreditNeeded(int creditNeeded) {
		this.creditNeeded = creditNeeded;
	}
}
