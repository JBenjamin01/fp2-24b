import java.util.*;
public class Concesionario {
    private String nombreEmpresa;
    private Gerente elGerente;
    private ArrayList<Vendedor> personal = new ArrayList<Vendedor>();
    private ArrayList<Auto> autos = new ArrayList<Auto>();

    public Concesionario(String nombre, Gerente gerente){
        nombreEmpresa = nombre;
        elGerente = gerente;
    }

    public void addAuto(Auto auto){
        autos.add(auto);
    }
    public void addVendedor(Vendedor vendedor){
        personal.add(vendedor);
    }
    public void imprimirEstatus(){
        System.out.println();
        System.out.println("Nombre de la empresa: " + nombreEmpresa);
        System.out.println("Gerente:\n" + elGerente);

        System.out.println("\nAutos en stock:");
        for(Auto auto : autos){
            System.out.println("- " + auto);
        }

        System.out.println("\nPersonal del concesionario:");
        for(Vendedor vendedor : personal){
            System.out.println("- " + vendedor);
        }
        System.out.println();
    }
}