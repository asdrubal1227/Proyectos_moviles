package practica1moviles;
//
import java.util.Scanner;


public class Prestamos {
    
    private String cedula;
    private String Nombre1;
    
     public void prestar(){
     Scanner teclado = new Scanner(System.in);
     System.out.println("Ingrese Numero de cedula");
     this.cedula=teclado.next();  
     
    //esta saltando a preguntar por el telefono 
 }
      public void  mostrar(){
     System.out.println("Nombre: "+Nombre1);
     System.out.println("Cedula: "+cedula);
      }
     public String getNombre1() {
        return Nombre1;
    }

    public void setNombre1(String Nombre1) {
        this.Nombre1 = Nombre1;
    }

    public String getcedula() {
        return cedula;
    }

    public void setcedula(String cedula) {
        this.cedula = cedula;
    }
    
}
