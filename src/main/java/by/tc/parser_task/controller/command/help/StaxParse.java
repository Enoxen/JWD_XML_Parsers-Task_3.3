package by.tc.parser_task.controller.command.help;

import by.tc.parser_task.controller.command.Command;
import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.service.ParseService;
import by.tc.parser_task.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class StaxParse implements Command {
    @Override
    public List<Gem> execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = ServiceFactory.getInstance();
        ParseService parseService = factory.getParseService();
        return parseService.parseStax();
    }
}
