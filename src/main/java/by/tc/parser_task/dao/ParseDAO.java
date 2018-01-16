package by.tc.parser_task.dao;

import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.dao.exception.DAOException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public interface ParseDAO {
    List<Gem> parseSax() throws DAOException;
    List<Gem> parseStax() throws DAOException;
    List<Gem> parseDOM() throws DAOException;
}
