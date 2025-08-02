import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Bai1_login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Bai1_login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Bai1_login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String useName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        if ("hai23".equals(useName) && "123".equals(passWord)) {
            request.setAttribute("user", "hai23");
            RequestDispatcher rd = request.getRequestDispatcher("Bai1_Suscess.jsp");
            rd.forward(request, response); 
        } else {
            // Nếu sai, redirect đến trang lỗi
            response.sendRedirect("Bai1_Enro.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Login servlet for checking credentials and forwarding accordingly";
    }
}
