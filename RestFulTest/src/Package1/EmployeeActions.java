package Package1;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*; 
import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EmployeeActions {
	public Configuration cfg;
	public SessionFactory factory;
	
	public EmployeeActions(){
		cfg=new Configuration().configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	
	public ArrayList<Employee> getAllEmployees(){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List list = query.list();
		ArrayList<Employee> result = new ArrayList<Employee>();
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			Employee it =(Employee)itr.next();
			result.add(it);
			itr.remove();
		}
		t.commit();
		session.close();
		return result;
	}
	
	public Employee getEmployee(long id){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Employee where Emp_ID= :id");
		query.setParameter("id", id);
		List list = query.list();
		Employee result = null;
		Iterator itr = list.iterator();
		if(itr.hasNext()){
			Employee it =(Employee)itr.next();
			result = it;
			itr.remove();
		}
		t.commit();
		session.close();
		return result;
	}
	
	public FullTimeEmployee getFullDetails(long id){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
	    FullTimeEmployee result =null;
	    Query query = session.createQuery("from FullTimeEmployee where Emp_ID= :id");
		query.setParameter("id", id);
		List list = query.list();
		Iterator itr = list.iterator();
	    if(itr.hasNext()){
	    	FullTimeEmployee it = (FullTimeEmployee)itr.next();
	    	result = it;
	    	itr.remove();
	    }
	    return result;
		
		
	}
	
	public ArrayList<FullTimeEmployee> getAllFullTime(){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from FullTimeEmployee");
		ArrayList<FullTimeEmployee> result = new ArrayList<FullTimeEmployee>();
		List list = query.list();
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			FullTimeEmployee temp = (FullTimeEmployee)itr.next();
			result.add(temp);
		}
		return result;
	}
	
	public boolean putFullTime(long id, String fname, String lname, String mname, String type, String manager,  String team, String permit, long salary) throws Exception{
		FullTimeEmployee e = new FullTimeEmployee();
		e.setEmpId(id);
		e.setEmpFirstName(fname);
		e.setEmpLastName(lname);
		e.setEmpMiddleName(mname);
		e.setEmpType(type);
		e.setManager(manager);
		e.setTeam(team);
		e.setWorkPermit(permit);
		e.setSalary(120000);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean result;
		try{
			session.persist(e);
			result = true;
		   
		}
		catch(Exception s){
			result = false;
		}
		finally{
			t.commit();
			session.close();
		}
		
		return result;
	}
	
	public ArrayList<PartTimeEmployee> getAllPartTime(){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from PartTimeEmployee");
		ArrayList<PartTimeEmployee> result = new ArrayList<PartTimeEmployee>();
		List list = query.list();
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			PartTimeEmployee temp = (PartTimeEmployee)itr.next();
			result.add(temp);
		}
		return result;
	}
	
	public PartTimeEmployee getPartDetails(long id){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
	    PartTimeEmployee result =null;
	    Query query = session.createQuery("from PartTimeEmployee where Emp_ID= :id");
		query.setParameter("id", id);
		List list = query.list();
		Iterator itr = list.iterator();
	    if(itr.hasNext()){
	    	PartTimeEmployee it = (PartTimeEmployee)itr.next();
	    	result = it;
	    	itr.remove();
	    }
	    return result;
		
		
	}
	public ArrayList<Intern> getIntern(){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Intern");
		ArrayList<Intern> result = new ArrayList<Intern>();
		List list = query.list();
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			Intern temp = (Intern)itr.next();
			result.add(temp);
		}
		return result;
	}
	public Intern getInternDetails(long id){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
	    Intern result =null;
	    Query query = session.createQuery("from Intern where Emp_ID= :id");
		query.setParameter("id", id);
		List list = query.list();
		Iterator itr = list.iterator();
	    if(itr.hasNext()){
	    	Intern it = (Intern)itr.next();
	    	result = it;
	    	itr.remove();
	    }
	    return result;
		
		
	}
	
	public boolean updateFullTime(long id, String js) throws ParseException{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
	    FullTimeEmployee result =null;
	    Query query = session.createQuery("from FullTimeEmployee where Emp_ID= :id");
		query.setParameter("id", id);
		List list = query.list();
		Iterator itr2 = list.iterator();
	    if(itr2.hasNext()){
	    	FullTimeEmployee it = (FullTimeEmployee)itr2.next();
	    	result = it;
	    	itr2.remove();
	    }
	    if(result!=null){
		 JSONParser jsonparser = new JSONParser();
		 JSONObject jsonobject = (JSONObject)jsonparser.parse(js);
		 Iterator itr = jsonobject.entrySet().iterator();
		 while(itr.hasNext()){
			Map.Entry it = (Map.Entry)itr.next();
	        switch ((String)it.getKey()) {
			case "Emp_ID":
				result.setEmpId((long)it.getValue());
				break;
			case "FirstName":
				result.setEmpFirstName((String)it.getValue());
				break;
			case "LastName":
				result.setEmpLastName((String)it.getValue());
				break;
			case "MiddleName":
				result.setEmpMiddleName((String)it.getValue());
				break;
			case "Type":
				result.setEmpType((String)it.getValue());
				break;
			case "Manager":
				result.setManager((String)it.getValue());
                break;
			case "Team":
				result.setTeam((String)it.getValue());
				break;
			case "WorkPermit":
				result.setWorkPermit((String)it.getValue());
				break;
			case "Salary":
				result.setSalary((long)it.getValue());
				break;
			default:
				break;
			}
	        itr.remove();
			
		 }
		 session.persist(result);
		 t.commit();
		 session.close();
		 return true;
	    }
		
		return false;
	}
	
	public boolean deleteFullTime(long id){
		Session session=factory.openSession();   
	    Transaction t=session.beginTransaction(); 
	    FullTimeEmployee result = null;
	    Query query = session.createQuery("from FullTimeEmployee where Emp_ID= :id");
		query.setParameter("id", id);
		List list = query.list();
		if(list.size()>1 || list.size()<0)
			return false;
		Iterator itr = list.iterator();
	    if(itr.hasNext()){
	    	FullTimeEmployee it = (FullTimeEmployee)itr.next();
	    	result = it;
	    	itr.remove();
	    }
	    session.delete(result);
	    t.commit();
	    session.close();
	    return true;
	}
	
    

}
