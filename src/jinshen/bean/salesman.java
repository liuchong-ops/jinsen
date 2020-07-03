package jinshen.bean;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class salesman {
	
	private Date   yarddate;
	private String carNumber;
	private String yard;
	private String surveyor;

@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
   public String getSurveyor() {
 	     return surveyor;
    }
    public void setSurveyor(String surveyor) {
 	    this.surveyor = surveyor;
    }
}
