package Package1;
import java.sql.Date;

public class Intern extends Employee {
	private String university;
	private String project;
	private double gpa;
//	private Date startDate;
	//private Date endDate;
	private double payrate;
	
	public void setUniversity(String S){
		this.university=S;
	}
	public String getUniversity(){
		return university;
	}
    
 /*   public void setStartDate(Date z){
	   this.startDate = z;
    }
    public Date getStartDate(){
	   return startDate;
    }
    public void setEndDate(Date y){
 	   this.endDate = y;
     }
     public Date getEndDate(){
 	   return endDate;
     }*/
    public void setProject(String x){
	    this.project = x;
     }
     public String getProject(){
	   return project;
     } 
     
     public void setGpa(double gpa){
    	 this.gpa = gpa;
     }
     public double getGpa(){
    	 return gpa;
     }
     public void setPayrate(double z){
 		this.payrate = z;
 	}
 	public double getPayrate(){
 		return payrate;
 	}
     
}
