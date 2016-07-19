package Package1;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*; 

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
	
	public Employee getEmployee(int id){
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
	
	public FullTimeEmployee getFullDetails(int id){
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
    
 /* 
	public ArrayList<Employee> getEmployees(){
		Session session=factory.openSession();   
	    Transaction t=session.beginTransaction(); 
	    ArrayList<Employee> result = new ArrayList<Employee>();
	    Query query=session.createQuery("from Employee");
        List<Employee> temp = query.list();
	    Iterator itr = temp.iterator();
	    while(itr.hasNext()){
	    	Employee it = (Employee)itr.next();
	    	result.add(it);
	    	itr.remove();
	    }
	    t.commit();
	    session.close();
	    return result;
	}
   
	public Employee getEmployee(int id){
		Session session=factory.openSession();   
	    Transaction t=session.beginTransaction(); 
	    Employee result = null;
	    Query query = session.createQuery("FROM Employee WHERE Emp_ID= :id");
	    query.setParameter("id", id);
	    List<Employee> temp = query.list();
	    Iterator itr = temp.iterator();
	    if(itr.hasNext()){
	    	Employee it = (Employee)itr.next();
	        result=it;	
	    }
	    t.commit();
	    session.close();
	    return result;
	    
	}
	
	public void addEmployee(int id,String fname,String lname, String mname, int type){
		Session session=factory.openSession();   
	    Transaction t=session.beginTransaction(); 
	    Employee e = new Employee();
	    e.setEmpId(id);
	    e.setEmpFirstName(fname);
	    e.setEmpLastName(lname);
	    e.setEmpMiddleName(mname);
	    e.setEmpType(type);
	    
	    session.persist(e); 
	      
	    t.commit();
	    session.close(); 
	    
	}
	
	public String getEmployementType(int id){
		Session session=factory.openSession();   
	    Transaction t=session.beginTransaction();
	    EmployeeTypes temp = null;
	    Query query = session.createQuery("FROM EmployeeTypes WHERE ID= :id");
	    query.setParameter("id", id);
	    List<EmployeeTypes> temp2 = query.list();
	    Iterator itr = temp2.iterator();
	    if(itr.hasNext()){
	    	EmployeeTypes it = (EmployeeTypes)itr.next();
	        temp=it;
	        itr.remove();
	    }
	    String result = temp.getName();
	    t.commit();
	    session.close();
	    return result;
	    
	}
	
	public FullTimeEmployee getFullDetails(int id){
		Session session=factory.openSession();   
	    Transaction t=session.beginTransaction();
	    FullTimeEmployee result = null;
	    Query query = session.createQuery("FROM FullTimeEmployee WHERE Emp_ID= :id");
	    query.setParameter("id", id);
	    List<FullTimeEmployee> temp = query.list();
	    Iterator itr = temp.iterator();
	    if(itr.hasNext()){
	    	FullTimeEmployee it = (FullTimeEmployee)itr.next();
	        result=it;
	        itr.remove();
	    }
	    t.commit();
	    session.close();
	    return result;
	}*/

}
