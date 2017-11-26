package by.tc.parser_task.controller.command.help;
import by.tc.parser_task.controller.command.Command;
import by.tc.parser_task.controller.output.PaginationFactory;
import by.tc.parser_task.controller.output.PaginationHelper;
import by.tc.parser_task.entity.Gem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Created by Y50-70 on 24.11.2017.
 */
public class ChangePage implements Command {

    private PaginationFactory factory = PaginationFactory.getInstance();


    @Override
    public List<Gem> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaginationHelper helper = factory.getPaginationHelper();
        HttpSession session = request.getSession();
        if(helper.getGems() == null) {
            List<Gem> gems = (List<Gem>) session.getAttribute("all_gems");
            System.out.println(gems);
            helper.setPagination(gems);
        }
        if(request.getParameter("command").equals("DOWN")){
            return helper.nextPageOutput();
        }
        else{
            if(request.getParameter("command").equals("UP")){
               return helper.previousPageOutput();
            }
        }

    return null;
    }



}
