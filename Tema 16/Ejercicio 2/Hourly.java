public class Hourly extends Employee {
    private double hourlyRate;
    private double hours = 0.0;

    public Hourly(String n, double rate) {
        super(n);
        hourlyRate = rate;
    }

    @Override
    public double getPay() {
        return hourlyRate * hours;
    }

    public void addHours(double h) {
        hours += h;
    }

    @Override
    public String toString() {
        return super.toString() + " (Hourly)";
    }
}