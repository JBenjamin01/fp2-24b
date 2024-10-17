public class Car {
    private String make;
    private int year;
    private String color;

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car makeCopy() {
        Car copy = new Car();
        copy.setMake(this.make);
        copy.setYear(this.year);
        copy.setColor(this.color);
        return copy;
    }
}