package by.tc.parser_task.service;

import by.tc.parser_task.service.impl.ServiceImpl;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final ParseService parseService = new ServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }
    public ParseService getParseService(){
        return parseService;
    }
}
