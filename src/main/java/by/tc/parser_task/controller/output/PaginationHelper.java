package by.tc.parser_task.controller.output;

import by.tc.parser_task.entity.Gem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y50-70 on 26.11.2017.
 */
public class PaginationHelper {
    private List<Gem> gems;
    private int start;
    private int end;
    private int gemsPerPage;
    private int gemsCount;


    public PaginationHelper(){}

    public List<Gem> getGems(){
        return gems;
    }
    public void setPagination(List<Gem> gemList){
        this.gems = gemList;
        start = 0;
        gemsCount = gemList.size();
        gemsPerPage = Math.round((float)Math.sqrt(gemsCount));
        end = gemsPerPage;
    }
    public List<Gem> firstOutput(List<Gem> gemList){
        setPagination(gemList);
        return gems.subList(start,end);
    }
    public List<Gem> nextPageOutput(){
        List<Gem> sublist;
        System.out.println(gems.size()+ " size");
        if(end + gemsPerPage > gemsCount && start + gemsPerPage < gemsCount){
            start = (start + gemsPerPage)%gemsCount;
            System.out.println(start);
            sublist = new ArrayList<>();
            sublist.addAll(gems.subList(start, gemsCount));
            end = (end + gemsPerPage) % gemsCount;
            System.out.println(end);
            sublist.addAll(gems.subList(0, end));
            return sublist;
        }
        else {
            start = (start + gemsPerPage)%gemsCount;
            end = (end + gemsPerPage == gemsCount) ? (end + gemsPerPage) :((end + gemsPerPage) % gemsCount);
            System.out.println(start);
            System.out.println(end);
            return gems.subList(start, end);
        }
    }
    public List<Gem> previousPageOutput(){
        List<Gem> sublist;
        if(start - gemsPerPage < 0 && end - gemsPerPage >=0){
            sublist = new ArrayList<>();
            start = Math.floorMod(start - gemsPerPage, gemsCount);
            System.out.println(start);
            end = Math.floorMod(end - gemsPerPage, gemsCount) == 0 ? gemsCount : Math.floorMod(end - gemsPerPage, gemsCount);
            System.out.println(end);
            sublist.addAll(gems.subList(start, end));

            //sublist.addAll(gems.subList(0,end));
            return sublist;
        }
        else{
            start = (start - gemsPerPage) % gemsCount;
            end = (end - gemsPerPage) % gemsCount;
            return gems.subList(start, end);
        }
    }
}
