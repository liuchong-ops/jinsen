package jinshen.bean;

import java.sql.Date;

public class workpage {
	private double workid;
	private double cutNum;
	private Date   cutdate;
	private String cutSite;
	private String checkSite;
	private String carNumber;
	private String surveyor;
	private String forester;
	private String woodmanage;
	private double batchNum;
	private double tolTree;
	private double tolStere;
	public double getWorkid() {
		return workid;
	}
	public void setWorkid(double workid) {
		this.workid = workid;
	}
	
	public double getCutNum() {
	     return cutNum;
    }
    public void setCutNum(double cutNum) {
    	this.cutNum = cutNum;
    }
    
    public Date getCutdate() {
    	return cutdate;
    }
    public void setCutdate(Date cutdate) {
    	this.cutdate = cutdate;
    }
    
    public String getCutSite() {
    	return cutSite;
    }
    public void setCutSite(String cutSite) {
    	this.cutSite = cutSite;
    }
    
    public String getCheckSite() {
    	return checkSite;
    }
    public void setCheckSite(String checkSite) {
    	this.checkSite = checkSite;
    }
    
	public String getCarNumber() {
	     return carNumber;
    }
    public void setCarNumber(String carNumber) {
   	    this.carNumber = carNumber;
    }
   
    public String getSurveyor() {
    	return surveyor;
    }
    public void setSurveyor(String surveyor) {
    	this.surveyor = surveyor;
    }
    
    public String getForester() {
    	return forester;
    }
    public void setForester(String forester) {
    	this.forester = forester;
    }
    
    public String getWoodmanage() {
    	return woodmanage;
    }
    public void setWoodmanage(String woodmanage) {
    	this.woodmanage = woodmanage;
    }
    
	public double getBatchNum() {
	     return batchNum;
   }
   public void setBatchNum(double batchNum) {
   	this.batchNum = batchNum;
   }
	public double getTolTree() {
		return tolTree;
	}
	public void setTolTree(double tolTree) {
		this.tolTree = tolTree;
	}
	public double getTolStere() {
		return tolStere;
	}
	public void setTolStere(double tolStere) {
		this.tolStere = tolStere;
	}
}
    