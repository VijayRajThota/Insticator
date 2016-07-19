package Package1;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

import java.util.*;


@Path("/Service")
public class EmployeeService {
	EmployeeActions e = new EmployeeActions();
	
	@GET
	@Path("/employees")
	public Response getAllEmployees(){
		ArrayList<Employee> result = e.getAllEmployees();
		ArrayList<JSONObject> x = new ArrayList<JSONObject>();
		for(int i=0;i<result.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("id", result.get(i).getEmpId());
			temp.put("Last Name",result.get(i).getEmpLastName());
			temp.put("First Name", result.get(i).getEmpFirstName());
			temp.put("Employement Type", result.get(i).getEmpType());
			temp.put("Manager", result.get(i).getManager());
			x.add(temp);
		}
		return Response.status(200).entity(x.toString()).build();	
		
	}
	
	@GET
	@Path("/employee/{id}")
	public Response getEmployee(@PathParam("id") int id){
		Employee result = e.getEmployee(id);
		JSONObject finalresult = new JSONObject();
		if(result!=null){	
			finalresult.put("id", result.getEmpId());
			finalresult.put("Last Name",result.getEmpLastName());
			finalresult.put("First Name", result.getEmpFirstName());
			finalresult.put("Employement Type", result.getEmpType());
			finalresult.put("Manager", result.getManager());
		}
		else
		   finalresult.put("result", "No employee found");
		
		return Response.status(200).entity(finalresult.toJSONString()).build();
		
	}
	@GET
	@Path("/employee/fulltime/{id}")
	public Response getFullTime(@PathParam("id") int id){
		FullTimeEmployee result = e.getFullDetails(id);
		JSONObject finalresult = new JSONObject();
		if(result!=null){
			finalresult.put("id", result.getEmpId());
			finalresult.put("Last Name",result.getEmpLastName());
			finalresult.put("First Name", result.getEmpFirstName());
			finalresult.put("Employement Type", result.getEmpType());
			finalresult.put("Manager", result.getManager());
			finalresult.put("Team", result.getTeam());
			finalresult.put("Work Permit", result.getWorkPermit());
			finalresult.put("Salaray", result.getSalary());
			
		}
		else
			finalresult.put("message", "Invalid selection");
		
		
	    return Response.status(200).entity(finalresult.toJSONString()).build();
		
	}
	
	@GET
	@Path("/employee/fulltime")
	public Response getAllFullTime(){
		ArrayList<FullTimeEmployee> result = e.getAllFullTime();
		ArrayList<JSONObject> finalresult = new ArrayList<JSONObject>();
		for(int i=0;i<result.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("id", result.get(i).getEmpId());
			temp.put("Last Name",result.get(i).getEmpLastName());
			temp.put("First Name", result.get(i).getEmpFirstName());
			temp.put("Employement Type", result.get(i).getEmpType());
			temp.put("Manager", result.get(i).getManager());
			temp.put("Team", result.get(i).getTeam());
			temp.put("Work Permit", result.get(i).getWorkPermit());
			temp.put("Salaray", result.get(i).getSalary());
			finalresult.add(temp);
		}
		return Response.status(200).entity(finalresult.toString()).build();
	}
	
	@POST
	@Path("/employee/fulltime")
	@Consumes("application/json")
	public Response putFullTime(InputStream input) throws Exception{
		System.out.println("hello");
		System.out.println(input.toString());
		return Response.status(200).build();
		
	}
	
/*
   @POST
   @Path("/users/{id}")
   @Consumes("application/json")
   public Response updateUser(@PathParam("id") int id,InputStream incomingData) throws Exception {
        Employee temp = e.getEmployee(id);
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        StringBuilder crunchifyBuilder = new StringBuilder();
        String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
     //  String output = "The input you sent is :" + input;
	    
	    System.out.println(crunchifyBuilder.toString());
	    System.out.println("output");
	    
    //    JSONObject outputJsonObj = new JSONObject();
     //   outputJsonObj.put("output", output);

       // return outputJsonObj;
	    return Response.status(200).entity(crunchifyBuilder.toString()).build();
	  }
   @GET
   @Path("/user/{id}")
   @Produces("application/json")
   public Response getUser(@PathParam("id") int id){
	   Employee temp = e.getEmployee(id);
	   JSONObject result = new JSONObject();
	   result.put("id", temp.getEmpId());
	   result.put("LastName", temp.getEmpLastName());
       result.put("FirstName", temp.getEmpFirstName());
       result.put("MiddleName", temp.getEmpMiddleName());
       int type = temp.getEmpType();
       result.put("Employement_Type",e.getEmployementType(type) );
	   return Response.status(200).entity(result.toJSONString()).build();
	   
   }
   @GET
   @Path("/user/{id}/details")
   @Produces("application/json")
   public Response getFullDetails(@PathParam("id") int id){
	   Employee temp = e.getEmployee(id);
	   JSONObject result = new JSONObject();
	   if(temp.getEmpType()==1){
		   FullTimeEmployee e1 = e.getFullDetails(id);

		   result.put("id", e1.getEmpId());
		   result.put("Manager", e1.getManager());
		   result.put("Work Permit",e1.getWorkPermit());
		   result.put("Team", e1.getTeam());
		   result.put("salary", e1.getSalary());
		   
		   
	   }
	   return Response.status(200).entity(result.toJSONString()).build();
   }
   
*/
}
