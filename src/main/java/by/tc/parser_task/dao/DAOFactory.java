package by.tc.parser_task.dao;

import by.tc.parser_task.entity.Gem;
import by.tc.parser_task.dao.impl.DaoImpl;

import java.util.List;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final ParseDAO parseDao = new DaoImpl();

    private DAOFactory(){}

    public ParseDAO getUserDao(){
        return parseDao;
    }
    public static DAOFactory getInstance(){
        return instance;
    }
}
