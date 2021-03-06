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
import classes.Group;
import utilities.DatabaseAccess;

/************************************************************************
 * Project: COMP3095_team_dns
 * Assignment: Assignment #2
 * Authors: Sergio Santilli, Dylan Roberts, Nooran El-Sherif, Sean Price
 * Student Numbers: 100727526, 100695733, 101015020
 * Date: 30/12/2017
 * Description: ViewGroupsHandler- handles requests for groups/view.jsp
 ***********************************************************************/
@WebServlet(name = "ViewGroup", urlPatterns = { "/ViewGroup" })
public class ViewGroupsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewGroupsHandler() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Department> departmentList = DatabaseAccess.selectDepartments();
		String selectedDep = request.getParameter("dep");
		
		try {
			// Load with defaults on original GET request
			if (!departmentList.isEmpty() && selectedDep == null) 
			{
				request.setAttribute("departments", departmentList);
				
				ArrayList<Group> groupList = DatabaseAccess.selectGroupsByDepartment(1);
				request.setAttribute("groups", groupList);
			} 
			// reload with correct department on department selection change
			else if (!departmentList.isEmpty() && selectedDep != null) 
			{
				request.setAttribute("departments", departmentList);
				
				ArrayList<Group> groupList = DatabaseAccess
						.selectGroupsByDepartment(Integer.parseInt(selectedDep) + 1);
				
				request.setAttribute("groups", groupList);
				request.setAttribute("selected", selectedDep);
			} 
			else 
			{
				request.setAttribute("error", "empty list");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		request.getRequestDispatcher("/group/view.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Finds all department by Id selected. Finds Group ID by the selected GroupName
		HttpSession session = request.getSession();
		String groupName = request.getParameter("group");	
		int depId = Integer.parseInt(request.getParameter("department"));
		Department department = DatabaseAccess.selectDepartmentById(depId);
		int groupId = DatabaseAccess.getGroupIdByGroupName(groupName);
		//Adds all employee from selected group into a list.
		//Displays list of employees along with department and group name
		ArrayList<Employee> employeesList = DatabaseAccess.selectEmployeesByGroupId(groupId);
		session.setAttribute("employeesList", employeesList);
		session.setAttribute("depName", department.getDepartmentName());
		session.setAttribute("grpName", groupName);
		doGet(request, response);
		request.getRequestDispatcher("/group/view.jsp").forward(request, response);
		
		
		
	}

}
