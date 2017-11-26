package by.tc.parser_task.controller.command;

import by.tc.parser_task.controller.command.help.*;
import by.tc.parser_task.controller.constant.CommandConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class CommandDirector {
    private Map<String,Command> map = new HashMap<>();

    public CommandDirector(){
        map.put(CommandConstant.SAX, new SaxParse());
        map.put(CommandConstant.STAX, new StaxParse());
        map.put(CommandConstant.DOM, new DOMParse());
        map.put(CommandConstant.MAIN, new MainPage());
        map.put(CommandConstant.UP, new ChangePage());
        map.put(CommandConstant.DOWN, new ChangePage());
    }

    public Command getCommand(String commandType){
        return map.get(commandType);
    }
}
