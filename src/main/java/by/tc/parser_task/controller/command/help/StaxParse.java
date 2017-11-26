package by.tc.parser_task.controller.command.help;

import by.tc.parser_task.controller.command.Command;
import by.tc.parser_task.controller.constant.AttributeKey;
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
public class StaxParse implements Command {
    @Override
    public List<Gem> execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        ParseService parseService = factory.getParseService();

        Gem gem = new Gem();
        gem.setValue(10);
        gem.setColor("blue");
        gem.setTransparency("sdf");
        gem.setPreciousness("sdfsd");
        gem.setShine("fghfgh");
        gem.setId(5);
        gem.setName("fg");

        HttpSession session = request.getSession();
        List<Gem> parsedGems = parseService.parseStax();
        parsedGems.add(gem);
        session.setAttribute(AttributeKey.ALL_GEMS, parsedGems);
        PaginationHelper pagination = new PaginationHelper();
        return pagination.firstOutput(parsedGems);

    }
}
