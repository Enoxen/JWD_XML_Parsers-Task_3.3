package by.tc.parser_task.controller.command.help;

import by.tc.parser_task.controller.command.Command;
import by.tc.parser_task.controller.constant.AttributeKey;
import by.tc.parser_task.controller.output.PaginationHelper;
import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.service.ParseService;
import by.tc.parser_task.service.ServiceFactory;
import by.tc.parser_task.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class DOMParse implements Command {
    private static final Logger logger = LogManager.getLogger(DOMParse.class);
    @Override
    public List<Gem> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        ParseService parseService = factory.getParseService();
        HttpSession session = request.getSession(false);
        List<Gem> parsedGems = null;
        try {
            parsedGems = parseService.parseDOM();
        } catch (ServiceException e) {
            logger.error(e.getMessage() + e.getStackTrace());
        }
        session.setAttribute(AttributeKey.ALL_GEMS, parsedGems);
        PaginationHelper pagination = new PaginationHelper();
        return pagination.firstOutput(parsedGems);
    }
}
