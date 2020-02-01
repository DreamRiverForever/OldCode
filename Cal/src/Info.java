import java.util.Date;

public class Info {
    private int id;
    private String op;
    private String result;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Info(String op, String result, Date date) {
        this.op = op;
        this.result = result;
        this.date = date;
    }
    public Info() {
    }

    public String getOp() {
        return op;
    }

    public String getResult() {
        return result;
    }

    public Date getDate() {
        return date;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
