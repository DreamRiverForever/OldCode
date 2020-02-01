import java.util.Date;

public class Info {
    private int id;
    private double height;
    private double weight;
    private Date date;

    public Info(int id, double height, double weight,Date date) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public Date getDate() {
        return date;
    }


}
