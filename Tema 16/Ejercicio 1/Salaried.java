public class Salaried extends Employee {
    private double salary;

    public Salaried(String n, double s){
        super(n);
        salary = s;
    }

    public double getPay(){
        return salary;
    }
}