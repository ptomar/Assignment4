/* In the java file we are saving the form data into the database and retreiving data 
 *  from the database on user request
 */
package Main;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.StudentBean;



public class StudentDAO {
	
	//saving data intot the database
	public void datasave(HttpServletRequest request) throws ServletException,
    IOException {
		
		  StudentBean setStudentBean = new StudentBean();
			
		  //fetching out data from the form
		    String name = request.getParameter("name");
		    String email = request.getParameter("email");
		    String address = request.getParameter("address");
		    
		    String zip = request.getParameter("zip");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        
	        String phone = request.getParameter("cellphone");
	        String url = request.getParameter("url");
	        String date = request.getParameter("dos");
	        
	        String month = request.getParameter("month");
	        String year = request.getParameter("year");
	        String ID = request.getParameter("id");
	        
	        String[] camp = request.getParameterValues("camp");
	        String university = request.getParameter("university");
	        String recommend = request.getParameter("recommend");
	        String comments = request.getParameter("comments");
	        	        
	       
	        
	        //setting the fetched datausing class Student Bean	              
	        setStudentBean.setName(name);
	        setStudentBean.setEmail(email);
	        setStudentBean.setZip(zip);
	        setStudentBean.setAddress(address);
	        setStudentBean.setCity(city);
	        setStudentBean.setState(state);
	        setStudentBean.setPhone(phone);
	        setStudentBean.setUrl(url);
	        setStudentBean.setDate(date);
	        setStudentBean.setMonth(month);
	        setStudentBean.setYear(year);
	        setStudentBean.setId(ID);
	        setStudentBean.setUniversity(university);
	        setStudentBean.setRecommend(recommend);
	        setStudentBean.setComment(comments);
	        String valuesForCampus="";
	        for (int i = 0; i < camp.length; i++) {
	        	valuesForCampus = valuesForCampus + camp[i] + " ";
            }
	        setStudentBean.setCamp(valuesForCampus);
	       
	      
	        try
		       {
		    	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException ex) {
	        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
		
	       
	        	        
	        try {
	        	 
	        	 Connection dbconnection;
	        	 dbconnection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "ptomar", "oagrah");
	                
//	String sql1 = "select * from survey_details";
//	PreparedStatement p1 = con.prepareStatement(sql1);
//	p1.executeQuery();

	        	 
//		String sql2 = "insert into survey_details values ()";
//	    	PreparedStatement p1 = con.prepareStatement(sql1);
//	        p1.executeQuery()
	            String sql = "insert into survey_details values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	     
	            
	            //preparing and iserting values into the database
	            PreparedStatement prepared = dbconnection.prepareStatement(sql);
	            System.out.println("Connection established");
	            prepared.setString(1, setStudentBean.getId());
	            prepared.setString(2, setStudentBean.getName());
	            prepared.setString(3, setStudentBean.getAddress());
	            prepared.setString(6, setStudentBean.getZip());
	            prepared.setString(4, setStudentBean.getCity());
	            prepared.setString(5, setStudentBean.getState());
	            prepared.setString(7, setStudentBean.getPhone());
	            prepared.setString(8, setStudentBean.getEmail());
	            prepared.setString(9, setStudentBean.getUrl());
	            prepared.setString(10, setStudentBean.getDate());
	            prepared.setString(11, setStudentBean.getCamp());
	            prepared.setString(12, setStudentBean.getUniversity());
	            prepared.setString(13, setStudentBean.getComment());
	            prepared.setString(14, setStudentBean.getMonth());
	            prepared.setString(15, setStudentBean.getYear());
	            prepared.setString(16, setStudentBean.getRecommend());
	            
	           
	              prepared.executeUpdate();
	              prepared.close();
	            if (dbconnection != null) {
	            	dbconnection.close();
	            }
	        } 
	        catch (SQLException ex) 
	        {

	        	System.out.println("connection error");
	        }
        
	}
	
	 //Data retrieval process from the database
	
	    public StudentBean dataRetrieve(String id) {
	        StudentBean studentBean2 = new StudentBean();
	 System.out.println("entered");
	        try {
	        	
	        	
//	        	String sql3 = "select * from survey_details";
//	        	PreparedStatement p3 = con.prepareStatement(sql3);
//	        	p3.executeQuery();

	        	        	 
//	        		String sql4 = "insert into survey_details values ()";
//	        	    	PreparedStatement p4 = con.prepareStatement(sql4);
//	        	        p4.executeQuery
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            Connection dbconnection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "ptomar", "oagrah");
	            Statement dbquery = dbconnection.createStatement();
	            System.out.println(id);
	            id="'"+id+"'";
	            System.out.println("Select * from survey_details where id =" + id);
	            ResultSet result = dbquery.executeQuery("Select * from survey_details where id =" + id);
	            //retreiveing data from the database
	            while (result.next()) {
	            	System.out.println("Data retrieveal in process");
	            	studentBean2.setId(result.getString(1));
	            	studentBean2.setName(result.getString(2));
	            	studentBean2.setAddress(result.getString(3));
	            	studentBean2.setZip(result.getString(6));
	            	studentBean2.setCity(result.getString(4));
	            	studentBean2.setState(result.getString(5));
	            	studentBean2.setPhone(result.getString(7));
	            	studentBean2.setEmail(result.getString(8));
	            	studentBean2.setUrl(result.getString(9));
	            	studentBean2.setDate(result.getString(10));
	            	studentBean2.setCamp(result.getString(11));
	            	studentBean2.setUniversity(result.getString(12));
	            	studentBean2.setComment(result.getString(13));
	            	studentBean2.setMonth(result.getString(14));
	            	studentBean2.setYear(result.getString(15));	                
	            	studentBean2.setRecommend(result.getString(16));
	                System.out.println("Data retrieved");


	            }
	           System.out.println("exit");
	            System.out.println(studentBean2.getRecommend());
	            dbconnection.close();
	           
	        } catch (Exception e) {
	        }
	        
       return studentBean2; 
	    }


}
