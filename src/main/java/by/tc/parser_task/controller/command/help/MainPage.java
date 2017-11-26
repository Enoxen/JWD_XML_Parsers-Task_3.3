package by.tc.parser_task.controller.command.help;

import by.tc.parser_task.controller.command.Command;
import by.tc.parser_task.controller.constant.JspPath;
import by.tc.parser_task.entity.Gem;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 25.11.2017.
 */
public class MainPage implements Command {
    @Override
    public List<Gem> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(JspPath.MAIN_PAGE);
        dispatcher.forward(request, response);
        return null;
    }
}
