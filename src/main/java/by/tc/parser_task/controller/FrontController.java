package by.tc.parser_task.controller;

import by.tc.parser_task.controller.command.CommandDirector;
import by.tc.parser_task.controller.constant.AttributeKey;
import by.tc.parser_task.controller.constant.CommandConstant;
import by.tc.parser_task.controller.constant.JspPath;
import by.tc.parser_task.controller.output.PaginationHelper;
import by.tc.parser_task.entity.Gem;

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
    private CommandDirector director = new CommandDirector();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Gem> gems;
        String command = request.getParameter(CommandConstant.COMMAND);

        gems = director.getCommand(command).execute(request, response);

        request.setAttribute(AttributeKey.GEMS, gems);
        RequestDispatcher dispatcher = request.getRequestDispatcher(JspPath.OUTPUT_PAGE);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
