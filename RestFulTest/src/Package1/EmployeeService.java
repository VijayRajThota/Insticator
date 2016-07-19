package Package1;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.cedarsoftware.util.io.*;
import com.cedarsoftware.*;

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
	public Response getEmployee(@PathParam("id") long id){
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
		String json = JsonWriter.objectToJson(result);
		System.out.println(json);
		
		return Response.status(200).entity(finalresult.toJSONString()).build();
		
	}
	@GET
	@Path("/employee/fulltime/{id}")
	public Response getFullTime(@PathParam("id") long id){
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
	@Path("/employee/parttime/{id}")
	public Response getPartTime(@PathParam("id") long id){
		PartTimeEmployee result = e.getPartDetails(id);
		JSONObject finalresult = new JSONObject();
		if(result!=null){
			finalresult.put("id", result.getEmpId());
			finalresult.put("Last Name",result.getEmpLastName());
			finalresult.put("First Name", result.getEmpFirstName());
			finalresult.put("Employement Type", result.getEmpType());
			finalresult.put("Manager", result.getManager());
			finalresult.put("Team", result.getTeam());
			finalresult.put("Project", result.getProject());
			finalresult.put("Salaray", result.getPayrate());
			
		}
		else
			finalresult.put("message", "Invalid selection");
		
		
	    return Response.status(200).entity(finalresult.toJSONString()).build();
		
	}
	@GET
	@Path("/employee/intern/{id}")
	public Response getInternDetails(@PathParam("id") long id){
		Intern result = e.getInternDetails(id);
		JSONObject finalresult = new JSONObject();
		if(result!=null){
			finalresult.put("id", result.getEmpId());
			finalresult.put("Last Name",result.getEmpLastName());
			finalresult.put("First Name", result.getEmpFirstName());
			finalresult.put("Employement Type", result.getEmpType());
			finalresult.put("Manager", result.getManager());
			finalresult.put("University",result.getUniversity());
			finalresult.put("GPA", result.getGpa());
			finalresult.put("Project", result.getProject());
			finalresult.put("Salaray", result.getPayrate());
			
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
	@GET
	@Path("/employee/partime")
	public Response getAllPartTime(){
		ArrayList<PartTimeEmployee> result = e.getAllPartTime();
		ArrayList<JSONObject> finalresult = new ArrayList<JSONObject>();
		for(int i=0;i<result.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("id", result.get(i).getEmpId());
			temp.put("Last Name",result.get(i).getEmpLastName());
			temp.put("First Name", result.get(i).getEmpFirstName());
			temp.put("Employement Type", result.get(i).getEmpType());
			temp.put("Manager", result.get(i).getManager());
			temp.put("Team", result.get(i).getTeam());
			temp.put("Project",result.get(i).getProject());
			temp.put("Salaray", result.get(i).getPayrate());
			finalresult.add(temp);
		}
		return Response.status(200).entity(finalresult.toString()).build();
	}
	@GET
	@Path("/employee/intern")
	public Response getIntern(){
		ArrayList<Intern> result = e.getIntern();
		ArrayList<JSONObject> finalresult = new ArrayList<JSONObject>();
		for(int i=0;i<result.size();i++){
			JSONObject temp = new JSONObject();
			temp.put("id", result.get(i).getEmpId());
			temp.put("Last Name",result.get(i).getEmpLastName());
			temp.put("First Name", result.get(i).getEmpFirstName());
			temp.put("Employement Type", result.get(i).getEmpType());
			temp.put("Manager", result.get(i).getManager());
            temp.put("University", result.get(i).getUniversity());
            temp.put("GPA", result.get(i).getGpa());
			temp.put("Project",result.get(i).getProject());
			temp.put("Salaray", result.get(i).getPayrate());
			finalresult.add(temp);
		}
		return Response.status(200).entity(finalresult.toString()).build();
	}
	
	@POST
	@Path("/employee/fulltime")
	@Consumes("application/json")
	public Response putFullTime(InputStream input) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		JSONObject result = new JSONObject();
		StringBuffer crunchifyBuilder = new StringBuffer();
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
		String js = new String(crunchifyBuilder);
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject)jsonparser.parse(js);
		
		long id = (long)jsonobject.get("Emp_ID");
		String fname =(String)jsonobject.get("FirstName");
		String lname =(String)jsonobject.get("LastName");
		String mname =(String)jsonobject.get("MiddleName");
		String type =(String)jsonobject.get("Emp_Type");
		String manager=(String)jsonobject.get("Manager");
		String team =(String)jsonobject.get("Team");
		String permit=(String)jsonobject.get("WorkPermit");
		long salary =(long)jsonobject.get("Salary");
		System.out.println("1");
		boolean result1 = e.putFullTime(id,fname,lname,mname,type,manager,team,permit,salary);
		if(result1==true){
			result.put("message","success");
		}
		else
			result.put("message","failure");
		
		return Response.status(200).entity(result.toJSONString()).build();
		
	}
	@PUT
	@Path("/employee/fulltime/{id}")
	@Consumes("application/json")
	public Response updateFullTime(@PathParam("id") int id,InputStream input) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		JSONObject result = new JSONObject();
		StringBuffer crunchifyBuilder = new StringBuffer();
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
		String js = new String(crunchifyBuilder);
		boolean finalresult = e.updateFullTime(id,js);
		if(finalresult==true)
			result.put("message", "success");
		else
			result.put("message", "update unsuccessful");
		return Response.status(200).entity(result.toJSONString()).build();
	}
	
	@DELETE
	@Path("/employee/fulltime/{id}")
	public Response deleteFullTime(@PathParam("id") int id){
		boolean result = e.deleteFullTime(id);
		JSONObject finalresult = new JSONObject();
		if(result==true)
			finalresult.put("message", "success");
		else
			finalresult.put("message", "update unsuccessful");
		return Response.status(200).entity(finalresult.toJSONString()).build();
	}
	

	
}
