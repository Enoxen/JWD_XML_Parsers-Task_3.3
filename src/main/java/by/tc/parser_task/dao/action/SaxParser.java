package by.tc.parser_task.dao.action;

import by.tc.parser_task.dao.constant.TagName;
import by.tc.parser_task.entity.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class SaxParser extends DefaultHandler {
    private List<Gem> gems = new ArrayList<>();
    private Gem gem;
    private StringBuilder text;

    public SaxParser(){}

    public  List<Gem> getGems(){
        return gems;
    }
    @Override
    public void startDocument(){
        System.out.println("Parsing started");
    }

    @Override
    public void endDocument(){
        System.out.println("Parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        text = new StringBuilder();
        if(qName.equals(TagName.NAME)){
            gem = new Gem();
            gem.setId(Integer.parseInt(attributes.getValue(TagName.ID)));
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length){
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)throws SAXException{
        switch (qName){
            case TagName.NAME:
                gem.setName(text.toString()); break;
            case TagName.PRECIOUSNESS:
                gem.setPreciousness(text.toString()); break;
            case TagName.COLOR:
                gem.setColor(text.toString()); break;
            case TagName.SHINE:
                gem.setShine(text.toString()); break;
            case TagName.TRANSPARENCY:
                gem.setTransparency(text.toString()); break;
            case TagName.VALUE:
                gem.setValue(Float.parseFloat(text.toString())); break;
            case TagName.GEM:
                gems.add(gem);
                gem = null;
                break;
        }
    }
}
