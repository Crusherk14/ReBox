package servletpackage;

import javax.servlet.ServletException;
import java.io.IOException;

public interface MessageSender {
    void SendMessage(Integer user, String message) throws ServletException, IOException;
}
