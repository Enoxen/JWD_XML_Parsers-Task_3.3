package by.tc.parser_task.service.impl;


import by.tc.parser_task.dao.DAOFactory;
import by.tc.parser_task.dao.ParseDAO;
import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.service.ParseService;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class ServiceImpl implements ParseService {
    @Override
    public List<Gem> parseSax()  {
        try {
            DAOFactory factory = DAOFactory.getInstance();
            ParseDAO parse = factory.getParseDao();
            List<Gem> gems = parse.parseSax();
            return gems;
        }
        catch (SAXException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Gem> parseStax() {

        DAOFactory factory = DAOFactory.getInstance();
        ParseDAO parse = factory.getParseDao();

        return parse.parseStax();


    }

    @Override
    public List<Gem> parseDOM() {

        DAOFactory factory = DAOFactory.getInstance();
        ParseDAO parse = factory.getParseDao();
        return parse.parseDOM();
    }
}
