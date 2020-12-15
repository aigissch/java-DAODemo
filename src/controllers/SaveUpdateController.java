package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAOImpl;
import models.Staff;
import models.Staff.Gender;

/**
 * Servlet implementation class SaveUpdateController
 */
@WebServlet("/SaveUpdateController")
public class SaveUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idStaff = Integer.parseInt(request.getParameter("idStaffUpdate"));

		Staff staff = new Staff();
		try {
			staff = new StaffDAOImpl().searchById(idStaff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("staff", staff);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String name;
			int id;
			int idDepartment;
			Gender gender;
			
			System.out.println("idStaffUpdate");
			
			id=0;
			//id = request.getParameter("idStaffUpdate") != "" ? Integer.parseInt(request.getParameter("idStaffUpdate")) : 0;
					
			name = request.getParameter("name");
			idDepartment = Integer.parseInt(request.getParameter("idDepartment"));
			gender = Gender.valueOf(request.getParameter("gender"));
			
			
			if (id > 0) {
				// Edit  
				try {
					Staff editStaff = new Staff(id, name, idDepartment, gender);
					new StaffDAOImpl().update(editStaff);

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Edit Staff");

			} else {
				// New  
				Staff addStaff = new Staff(id, name, idDepartment, gender);
				new StaffDAOImpl().save(addStaff);
				System.out.println("New Staff");

			} 
		response.sendRedirect("index.jsp");
	}

}
