package by.tc.parser_task.controller.command.help;

import by.tc.parser_task.controller.command.Command;
import by.tc.parser_task.controller.output.PaginationHelper;
import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.service.ParseService;
import by.tc.parser_task.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class SaxParse implements Command {
    @Override
    public List<Gem> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory = ServiceFactory.getInstance();
        ParseService parseService = factory.getParseService();
        HttpSession session = request.getSession(false);
        session.invalidate();
        List<Gem> parsedGems = parseService.parseSax();
        System.out.println(parsedGems.size());
        session = request.getSession(true);
        session.setAttribute("all_gems", parsedGems);

        PaginationHelper pagination = new PaginationHelper();
        return pagination.firstOutput(parsedGems);
    }
}
