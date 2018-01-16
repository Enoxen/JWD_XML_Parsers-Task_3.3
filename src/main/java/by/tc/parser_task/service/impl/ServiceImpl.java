package by.tc.parser_task.service.impl;


import by.tc.parser_task.dao.DAOFactory;
import by.tc.parser_task.dao.ParseDAO;
import by.tc.parser_task.dao.exception.DAOException;
import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.service.ParseService;
import by.tc.parser_task.service.exception.ServiceException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class ServiceImpl implements ParseService {
    @Override
    public List<Gem> parseSax() throws ServiceException {
        try {
            DAOFactory factory = DAOFactory.getInstance();
            ParseDAO parse = factory.getParseDao();
            List<Gem> gems = parse.parseSax();
            return gems;
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Gem> parseStax() throws ServiceException {

        DAOFactory factory = DAOFactory.getInstance();
        ParseDAO parse = factory.getParseDao();
        try {
            return parse.parseStax();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Gem> parseDOM() throws ServiceException {

        DAOFactory factory = DAOFactory.getInstance();
        ParseDAO parse = factory.getParseDao();
        try {
            return parse.parseDOM();
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
