package jinshen.bean;

import java.sql.Date;

public class outyard {
	private double workid;
	private Date   yarddate;
	private String carNumber;
	private String yard;
	private double batchNum;
	private String surveyor;
	public double getWorkid() {
		return workid;
	}
	public void setWorkid(double workid) {
		this.workid = workid;
	}
    
    public Date getYarddate() {
    	return yarddate;
    }
    public void setYarddate(Date yarddate) {
    	this.yarddate = yarddate;
    }
    
	public String getCarNumber() {
	     return carNumber;
   }
   public void setCarNumber(String carNumber) {
  	    this.carNumber = carNumber;
   }
   public String getYard() {
	   return yard;
   }
   public void setYard(String yard) {
	   this.yard = yard;
   }
   public double getBatchNum() {
	     return batchNum;
   }
   public void setBatchNum(double batchNum) {
 	   this.batchNum = batchNum;
   }
   public String getSurveyor() {
   	     return surveyor;
   }
   public void setSurveyor(String surveyor) {
   	this.surveyor = surveyor;
   }

}
