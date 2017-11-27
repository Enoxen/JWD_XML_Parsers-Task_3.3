package by.tc.parser_task.dao.impl;

import by.tc.parser_task.dao.ParseDAO;
import by.tc.parser_task.dao.action.DomParser;
import by.tc.parser_task.dao.action.SaxParser;
import by.tc.parser_task.dao.action.StaxParser;
import by.tc.parser_task.dao.constant.FilePath;
import by.tc.parser_task.entity.Gem;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class DaoImpl implements ParseDAO {

    @Override
    public List<Gem> parseSax() throws SAXException, IOException {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SaxParser handler = new SaxParser();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(FilePath.FILE_PATH));
            return handler.getGems();
        }
        catch (SAXException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Gem> parseStax() {
        StaxParser parser = new StaxParser();
        parser.buildListOfGems(FilePath.FILE_PATH);
        return parser.getGems();
    }

    @Override
    public List<Gem> parseDOM() {
        DomParser parser = new DomParser();
        parser.buildListOfGems(FilePath.FILE_PATH);
        return parser.getGems();
    }
}
