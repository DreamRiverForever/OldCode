public class StudentInfo {
    private double averge;
    private double variance;
    private double rate;

    public StudentInfo(double averge, double variance, double rate) {
        this.averge = averge;
        this.variance = variance;
        this.rate = rate;
    }

    public StudentInfo() {

    }

    public double getAverge() {
        return averge;
    }

    public double getVariance() {
        return variance;
    }

    public double getRate() {
        return rate;
    }

    public void setAverge(double averge) {
        this.averge = averge;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
