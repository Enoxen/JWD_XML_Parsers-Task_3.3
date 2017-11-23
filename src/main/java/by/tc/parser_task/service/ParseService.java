package by.tc.parser_task.service;

import by.tc.parser_task.entity.Gem;

import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public interface ParseService {
    List<Gem> parseSax();
    List<Gem> parseStax();
    List<Gem> parseDOM();
}
