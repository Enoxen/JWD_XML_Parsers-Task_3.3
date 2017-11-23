package by.tc.parser_task.controller;

import by.tc.parser_task.service.ParseService;
import by.tc.parser_task.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class FrontController extends HttpServlet {
    private ServiceFactory factory = ServiceFactory.getInstance();
    private ParseService parseService = factory.getParseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
