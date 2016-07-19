package Package1;

public class Employee {
 private long empId;
 private String empLastName;
 private String empFirstName;
 private String empMiddleName;
 private String empType;
 private String manager;
 public void setEmpId(long x ){
	 this.empId = x;
 }
 public long getEmpId(){
	 return empId;
 }
 public void setEmpLastName(String lname){
	 this.empLastName = lname;
 }
 public String getEmpLastName(){
	 return empLastName;
 }
 
 public void setEmpFirstName(String fname){
	 this.empFirstName = fname;
 }
 public String getEmpFirstName(){
	 return empFirstName;
 }
 public void setEmpMiddleName(String mname){
	 this.empMiddleName=mname;
 }
 public String getEmpMiddleName(){
	 return empMiddleName;
 }
 public void setEmpType(String type){
	 this.empType=type;
 }
 
 public String getEmpType(){
	 return empType;
 }
 public void setManager(String manager){
	 this.manager=manager;
 }
 public String getManager(){
	 return manager;
 }
}
