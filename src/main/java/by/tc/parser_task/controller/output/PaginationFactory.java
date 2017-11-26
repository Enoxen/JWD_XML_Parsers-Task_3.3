package by.tc.parser_task.controller.output;

/**
 * Created by Y50-70 on 26.11.2017.
 */
public class PaginationFactory {
    private static final PaginationFactory instance = new PaginationFactory();
    private final PaginationHelper paginationHelper = new PaginationHelper();

    private PaginationFactory(){}

    public static PaginationFactory getInstance(){
        return instance;
    }
    public PaginationHelper getPaginationHelper(){
        return paginationHelper;
    }
}
