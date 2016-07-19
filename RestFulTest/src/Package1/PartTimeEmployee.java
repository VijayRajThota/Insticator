package Package1;
import java.sql.Date;

public class PartTimeEmployee extends Employee{
   
	private int project;
	private int team;
	//private Date start_date;
	private double payrate;
	
	/*public void setStartDate(Date z){
		   this.start_date = z;
	   }
	public Date getStartDate(){
		   return start_date;
	   }*/
	public void setProject(int x){
		this.project = x;
	}
	public int getProject(){
		return project;
	}
	public void setTeam(int y){
		this.project = y;
	}
	public int getTeam(){
		return team;
	}
	
	public void setPayrate(double z){
		this.payrate = z;
	}
	public double getPayrate(){
		return payrate;
	}
	
}
