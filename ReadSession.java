package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ReadSession")
public class ReadSession extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Session Value</h2>");

        if (session != null) {

            String username = (String) session.getAttribute("username");

            if (username != null) {
                out.println("Username: " + username);
            } else {
                out.println("Session variable not found.");
            }

        } else {

            out.println("No session found.");
        }

        out.println("</body>");
        out.println("</html>");
    }
}