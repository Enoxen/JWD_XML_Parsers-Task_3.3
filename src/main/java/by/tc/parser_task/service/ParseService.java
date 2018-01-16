package by.tc.parser_task.service;

import by.tc.parser_task.dao.exception.DAOException;
import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public interface ParseService {
    List<Gem> parseSax() throws ServiceException;
    List<Gem> parseStax() throws ServiceException;
    List<Gem> parseDOM() throws ServiceException;
}
