package by.tc.parser_task.controller.command;

import by.tc.parser_task.controller.command.help.*;

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
        map.put("main", new MainPage());
        map.put("UP", new ChangePage());
        map.put("DOWN", new ChangePage());
    }

    public Command getCommand(String commandType){
        return map.get(commandType);
    }
}
