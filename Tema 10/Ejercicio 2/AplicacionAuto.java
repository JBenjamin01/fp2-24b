public class AplicacionAuto {
    public static void main(String[] args){

        Car johnCar = new Car();
        Car stacyCar;
        
        johnCar.setMake("Honda");
        johnCar.setYear(2003);
        johnCar.setColor("silver");
        stacyCar = johnCar.makeCopy();

        if(johnCar.equals(stacyCar))
            System.out.println("iguales");
        else
            System.out.println("diferentes");
        
    }
}