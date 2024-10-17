import java.util.*;
public class Dj {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String abc = "abcdefghijklmnopqrstu";
        String laLetra = sc.next();
        char letra = laLetra.charAt(0);
        System.out.println(letra);
        System.out.print(abc.indexOf(letra));
    }
}
