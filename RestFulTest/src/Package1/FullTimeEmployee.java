package Package1;

//import java.util.Date;



public class FullTimeEmployee extends Employee {
   private String team;
   private String workPermit;
   private long salary;
   
   public void setTeam(String x){
	   this.team =x;
   }
   
   public String getTeam(){
	   return team;
   }
    
   public void setWorkPermit(String y){
	   this.workPermit=y;
   }
   public String getWorkPermit()
   {
	   return workPermit;
   }
   
   public void setSalary(long a){
	   this.salary = a;
   }
   public long getSalary(){
	   return salary;
   }
	

}