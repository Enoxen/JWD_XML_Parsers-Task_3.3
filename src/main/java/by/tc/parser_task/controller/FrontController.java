package by.tc.parser_task.controller;

import by.tc.parser_task.controller.command.CommandDirector;
import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.service.ParseService;
import by.tc.parser_task.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class FrontController extends HttpServlet {
    private ServiceFactory factory = ServiceFactory.getInstance();
    private ParseService parseService = factory.getParseService();
    private CommandDirector director = new CommandDirector();
    private List<Gem> gems = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String command = request.getParameter("command");
        gems = director.getCommand(command).execute();
        request.setAttribute("gems", gems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/output.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
