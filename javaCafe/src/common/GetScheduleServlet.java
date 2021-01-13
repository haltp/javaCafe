package common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getSchedules")
public class GetScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetScheduleServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		List<Schedule> list = dao.getScheduleList();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");

		String json = "[";
		int cnt = 1;
		for (Schedule sch : list) {
			json += "{";
			json += "\"title\":\"" + sch.getTitle() + "\"";
			json += ",\"start\":\"" + sch.getStartDay() + "\"";
			json += ",\"end\":\"" + sch.getEndDay() + "\"";
			json += ",\"url\":\"" + sch.getUrl() + "\"";
			json += "}";
			if(list.size() !=cnt++) { //마지막에 쉼표빼기위해
				json += ",";
			}
		}
		json += "]";
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
