package by.tc.parser_task.controller.command;

import by.tc.parser_task.controller.command.help.DOMParse;
import by.tc.parser_task.controller.command.help.SaxParse;
import by.tc.parser_task.controller.command.help.StaxParse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class CommandDirector {
    private Map<String,Command> map = new HashMap<>();

    public CommandDirector(){
        map.put("SAX", new SaxParse());
        map.put("STAX", new StaxParse());
        map.put("DOM", new DOMParse());
    }

    public Command getCommand(String commandType){
        return map.get(commandType);
    }
}
