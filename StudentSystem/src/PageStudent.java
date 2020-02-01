import java.util.List;

public class PageStudent {
    //封装分页数据，学生集合，总记录数，总的页，当前页，每页显示的记录数
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalSize;
    private List<Student> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public List<Student> getList() {
        return list;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
