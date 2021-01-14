package jcafe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PostProductServlet")
public class PostProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PostProductServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String itemNo = request.getParameter("itemNo");
		String item = request.getParameter("item");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		int pri = Integer.parseInt(price);
		String content = request.getParameter("content");
		String likeIt = request.getParameter("likeIt");
		int like = Integer.parseInt(likeIt);
		String image = request.getParameter("image");
		
		System.out.println(itemNo);
		System.out.println(item);
		System.out.println(category);
		System.out.println(price);
		System.out.println(content);
		System.out.println(likeIt);
		System.out.println(image);
		
		ProductVO vo = new ProductVO();
		vo.setItemNO(itemNo);
		vo.setItem(item);
		vo.setCategory(category);
		vo.setPrice(pri);
		vo.setContent(content);
		vo.setLikeIt(like);
		vo.setImage(image);
		
		ProductDAO dao = new ProductDAO();
		dao.insertProduct(vo);
		
		String script = "<script>location.href='jcafe/cafeList.html'</script>";
		response.getWriter().append(script);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
