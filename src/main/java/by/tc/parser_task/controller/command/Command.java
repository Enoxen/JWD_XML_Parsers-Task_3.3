package by.tc.parser_task.controller.command;

import by.tc.parser_task.entity.Gem;

import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public interface Command {
    List<Gem> execute();
}
