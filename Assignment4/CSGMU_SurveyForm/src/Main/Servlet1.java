/*Main servlet which is called when the url is given and has the doGet and doPost method*/
package Main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import beans.StudentBean;
import beans.DataBean;



public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet1() {
        super();
       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		StudentDAO student_dao= new StudentDAO();
		student_dao.datasave(request); //call is made to save from. Here "request" is carrying complete form
		double mean; // varaiable defined to calculate mean
		double std_dev; //variable defined to calculate standard deviation
		String val_processor=request.getParameter("data"); //string is defined to take the values from "data field"
		DataProcessor datatoprocess=new DataProcessor(); //object is created for data processor
		mean=datatoprocess.Mean(val_processor);//call for mean 
		std_dev=datatoprocess.StandardDeviation(val_processor,mean);//call for standard deviation
		DataBean dbbean=new DataBean();
		dbbean.setMean(mean);
		dbbean.setstDev(std_dev);
		
		String dbdata="";
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            Connection dbconnection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "ptomar", "oagrah");
	            Statement dbquery = dbconnection.createStatement();
	            ResultSet result = dbquery.executeQuery("select id from survey_details");
	            while (result.next()) {
	                dbdata=dbdata+result.getString(1)+",";
	            }
	            
	            dbconnection.close();
	           
	        } catch (Exception e) {
	        }
		 String[] valuesindata = dbdata.split(",");
		
		request.setAttribute("JId", valuesindata);
		HttpSession session = request.getSession();
		session.setAttribute("bean1", dbbean);			
		
		RequestDispatcher dispatcher;
		String jsppage;
		if (dbbean.getMean() >= 90) {
			jsppage = "/WEB-INF/WinnerAcknowledgement.jsp";
		} else {
			jsppage = "/WEB-INF/SimpleAcknowledgement.jsp";
		}

		dispatcher = request.getRequestDispatcher(jsppage);
		dispatcher.forward(request, response);
	}
    
	
	
	/**
	 * @see HttpServlet#doGET(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	// TODO Auto-generated method stub
		StudentDAO studentobject = new StudentDAO();
		String fetchstudent=request.getParameter("id");

		StudentBean studentdata=studentobject.dataRetrieve(fetchstudent);
		
		HttpSession session = request.getSession();
		session.setAttribute("studentdetails", studentdata);
		request.setAttribute("pid" , fetchstudent);
		
		String jspdata;
		if (studentdata != null)
		{  
			jspdata = "/WEB-INF/StudentDetails.jsp";
			}
		else
			//this part will never reached in our project scenario.
		{
			jspdata= "/WEB-INF/NoSuchStudent.jsp";
		}
		
		RequestDispatcher dispatcher; 
		dispatcher = request.getRequestDispatcher(jspdata); //request has been dispatched to the appropriate jsp page
		dispatcher.forward(request, response);
		
		
	}



}
