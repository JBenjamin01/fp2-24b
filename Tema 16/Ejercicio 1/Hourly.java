public class Hourly extends Employee {
    private double hourlyRate;
    private double hours = 0.0;

    public Hourly(String n, double rate){
        super(n);
        hourlyRate = rate;
    }

    public double getPay(){
        double pay = hourlyRate * hours;
        return pay;
    }
    
    public void addHours(double h){
        hours += h;
    }
}