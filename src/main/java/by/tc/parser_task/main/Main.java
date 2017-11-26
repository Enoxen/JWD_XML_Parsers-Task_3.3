package by.tc.parser_task.main;

import by.tc.parser_task.dao.DAOFactory;
import by.tc.parser_task.dao.ParseDAO;

import by.tc.parser_task.entity.Gem;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class Main {
    public static void main(String[] args){
        DAOFactory instance = DAOFactory.getInstance();
        ParseDAO parseDao = instance.getParseDao();
        try {
            List<Gem> gems = parseDao.parseSax();
            System.out.println(gems);
        }catch (SAXException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }




    }
}
