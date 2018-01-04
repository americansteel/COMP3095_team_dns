package servlets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Department;
import classes.Employee;
import classes.ReportTemplate;
import classes.Report;
import utilities.DatabaseAccess;
import utilities.HelperUtility;

/**
 * Servlet implementation class ViewReportHandler
 */
@WebServlet("/reports/ViewReport")
public class ViewReportHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ViewReportHandler() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//first gets directed to this from view report link
		HttpSession session = request.getSession();
		try {
			//get a list of templates to populate drop down box
			ArrayList<ReportTemplate> templates =
						DatabaseAccess.getAllReportTemplates();
			session.setAttribute("templates", templates);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//dispatch to view.jsp
		request.getRequestDispatcher("/reports/view.jsp").forward(request,response);
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//when dropdown selection changes = submits to here
		HttpSession session = request.getSession();
		
		//get the selected template from dropdown
		String selectedTemplate = request.getParameter("templateId");
		int templateId = 0;
		if(session.getAttribute("templateId")!=null)
		{
			templateId = (Integer)session.getAttribute("templateId");
		}
		else{
			
		try{
			templateId = Integer.parseInt(selectedTemplate);
			session.setAttribute("selectedTemplate", templateId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		//check if selected department is populated
		String selectedDepartment = request.getParameter("departmentId");
		if(selectedDepartment == null || HelperUtility.isMissing(selectedDepartment)) //if its not populated
		{
			Department department = new Department();
			try {
				//get the department from the template dept id
				ReportTemplate choiceTemplate = DatabaseAccess.getReportTemplateById(templateId);
				department = DatabaseAccess.selectDepartmentById(choiceTemplate.getDepartmentId());
				//populate the dropdown
				session.setAttribute("department", department);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//send back to the view.jsp
			request.getRequestDispatcher("/reports/view.jsp").forward(request, response);
			return; //exit
			
		}
		//if the department is populated, get the selected department
		int departmentId = Integer.parseInt(selectedDepartment);
		session.setAttribute("selectedDepartment", departmentId); //save so jsp can correctly choose option from dropdown
			
		String selectedReport = request.getParameter("reportId"); //get selected report
		if(selectedReport == null)//if no report
		{
			try
			{
				//populate dropdown of reports
				ArrayList<Report> reports = DatabaseAccess.getReportsByTemplateId(templateId);
				session.setAttribute("reports", reports);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//forward to the view.jsp
		request.getRequestDispatcher("/reports/view.jsp").forward(request, response);
		
		
	}

}