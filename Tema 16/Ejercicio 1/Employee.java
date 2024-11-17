public class Employee {
    private String name;

    public Employee(String n){
        name = n;
    }

    public void printPay(){
        System.out.println(name + " --> " + getPay());
    }

    // This dummy method satisfies the compiler
    public double getPay(){
        return 0.0;
    }
}