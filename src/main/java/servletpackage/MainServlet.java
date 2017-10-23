package servletpackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VkMessageServlet", urlPatterns = "/vk")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VkMessageSender sender = new VkMessageSender(request, response);
        String user = request.getParameter("name");
        String message = request.getParameter("text");

        sender.SendMessage(new Integer(226525873), "HelloWorld");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
            out.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<title>My first application server</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "Send message to user:<br>\n" +
                    "<form action=\"vk\" method = \"post\">\n" +
                    "<i>vk.com/</i>\n" +
                    "<input maxlength=\"25\" size=\"10\" placeholder=\"enter id here\" name = \"id\"><br>\n" +
                    "Your message:<br>\n" +
                    "<textarea rows=\"5\" cols=\"27\" name=\"text\">Hello, world!</textarea><br>\n" +
                    "<input type=\"submit\" value=\"Send\"><br><br><br>\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }
}
