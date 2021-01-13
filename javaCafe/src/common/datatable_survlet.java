package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/datatable")
public class datatable_survlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public datatable_survlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		List<EmployeeVO> list = dao.getEmptable();
		PrintWriter out = response.getWriter();

		String json = "[";
		int cnt = 1;
		for (EmployeeVO emp : list) {
			json += "{";
			json += "\"id\":\"" + emp.getEmployeeId() + "\"";
			json += "\"firstName\":\"" + emp.getFirstName() + "\"";
			json += "\"lastName\":\"" + emp.getLastName() + "\"";
			json += "\"email\":\"" + emp.getEmail() + "\"";
			json += "\"phoneNumber\":\"" + emp.getPhoneNumber() + "\"";
			json += "\"hireDate\":\"" + emp.getHireDate() + "\"";
			json += "\"jobId\":\"" + emp.getJobId() + "\"";
			json += "\"salary\":\"" + emp.getSalary() + "\"";
			json += "}";
			if (list.size() != cnt++) {
				json += ",";
			}
		}
		json += "]";

		out.print(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
