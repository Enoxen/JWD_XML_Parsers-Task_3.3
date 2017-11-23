package by.tc.parser_task.dao;

import by.tc.parser_task.entity.Gem;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public interface ParseDAO {
    List<Gem> parseSax() throws SAXException, IOException;
    List<Gem> parseStax();
    List<Gem> parseDOM();
}
