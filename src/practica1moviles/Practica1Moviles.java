package practica1moviles;
//
import java.util.ArrayList;
import java.util.Scanner;

public class Practica1Moviles {
        static  Prestamos prestamo= new Prestamos();
        static  Gestion gestion= new Gestion(); 
        static ArrayList<Gestion> fichas = new ArrayList<Gestion>();
        static ArrayList<Prestamos> fichasp = new ArrayList<Prestamos>();
        static Scanner teclado= new Scanner (System.in);
        static boolean veri=false;

    public static void main(String[] args) {int elige;
    int selec; 
    String Nombre;
     String autor;
     String cedula;
     int año,este = 0;
      String codigo;
     int cantidad;
     String area;
     String Busca,buscanom;
        
        while (true){
        System.out.println("/////////////////");
            System.out.println("Menu");
            System.out.println("/////////////////");
            System.out.println("1. Gestion");
            System.out.println("2. Prestamos");
            System.out.println("/////////////////");
            System.out.println("Seleccione una opción del menu");
            elige= teclado.nextInt();
            switch(elige){
            case 1:
                System.out.println("/////////////////");
                System.out.println("Menu");
                System.out.println("/////////////////");
                System.out.println("1. Ingresar libro");
                System.out.println("2. Actualizar libro");
                System.out.println("3. Eliminar libro");
                System.out.println("4. Buscar libro");
                System.out.println("/////////////////");
                System.out.println("Seleccione una opción del menu");
                selec= teclado.nextInt(); 
                switch(selec){
                    case 1:
                        gestion.datos();
                        Nombre=gestion.getNombre();
                        año=gestion.getaño();
                        autor=gestion.getautor();
                        cantidad=gestion.getcantidad();
                        area=gestion.getarea();
                        codigo=gestion.getcodigo();                  

                        Gestion aux = new Gestion();
                        aux.setNombre(Nombre);
                        aux.setaño(año);
                        aux.setcantidad(cantidad);
                        aux.setarea(area);
                        aux.setcodigo(codigo);
                        aux.setautor(autor);
                        fichas.add(aux);                   
                            veri=false;
                    break;//
                    case 2:                    
                        System.out.println("Ingrese Nombre de Libro a actualizar");
                        teclado.nextLine();
                        buscanom=teclado.nextLine();
                        este=recorrer(buscanom);
                        if(veri==true){
                        gestion.datos();
                        Nombre=gestion.getNombre();
                        año=gestion.getaño();
                        autor=gestion.getautor();
                        cantidad=gestion.getcantidad();
                        area=gestion.getarea();
                        codigo=gestion.getcodigo();
                        Gestion aux1 = new Gestion();
                        aux1.setNombre(Nombre);
                        aux1.setaño(año);
                        aux1.setcantidad(cantidad);
                        aux1.setarea(area);
                        aux1.setcodigo(codigo);
                        aux1.setautor(autor);
                        fichas.set(este,aux1);
                        } else {
                            System.out.println("Este libro no se encuentra en la base de datos");
                        }
                        veri=false;
                    break;
                    case 3:
                        System.out.println("Ingrese Nombre de Libro a eliminar");
                        teclado.nextLine();
                        buscanom=teclado.nextLine();                    
                        este=recorrer(buscanom);
                        if(veri == true){
                        fichas.remove(este);
                            System.out.println("El libro ha sido removido");
                        } else {
                            System.out.println("Este libro no se encuentra en la base de datos");
                        }
                        veri=false;
                    break;
                    case 4:
                        //disco.ver_datos();                    
                        System.out.println("Ingrese Nombre a buscar");
                        teclado.nextLine();
                        buscanom=teclado.nextLine();
                        este=recorrer(buscanom);
                        if(veri == true){
                            gestion= fichas.get(este);
                            gestion.Buscar(); 
                        } else {
                            System.out.println("Este libro no se encuentra en la base de datos");

                        }                      
                            veri=false;
                    break;
                    default:
                        System.out.println("ingreso una opción incorrecta, intente de nuevo");
                    break;
                }
            break;
            case 2:
            System.out.println("/////////////////");
            System.out.println("Menu");
            System.out.println("/////////////////");
            System.out.println("1. Prestar libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Libros prestados");
            System.out.println("/////////////////");
            System.out.println("Seleccione una opción del menu");
            selec= teclado.nextInt();
            
            switch(selec){
                case 1:
                    System.out.println("Ingrese Nombre de Libro a prestar");
                    teclado.nextLine();
                    buscanom=teclado.nextLine();
                    //prestamo.prestar();
                    este=recorrer(buscanom);
                    
                        if(veri){
                    gestion= fichas.get(este);
                     Nombre=gestion.getNombre();
                    año=gestion.getaño();
                    autor=gestion.getautor();
                    cantidad=(gestion.getcantidad()-1);
                    area=gestion.getarea();
                    codigo=gestion.getcodigo();
                    Gestion aux2 = new Gestion();
                    aux2.setNombre(Nombre);
                    aux2.setaño(año);
                    aux2.setcantidad(cantidad);
                    aux2.setarea(area);
                    aux2.setcodigo(codigo);
                    aux2.setautor(autor);
                    fichas.set(este,aux2);
                    
                    prestamo.prestar();
                    Nombre=gestion.getNombre();
                    cedula=prestamo.getcedula();
                    Prestamos aux4 = new Prestamos();
                    aux4.setNombre1(Nombre);
                    aux4.setcedula(cedula);
                         fichasp.add(aux4);                    
                            veri=false;
                        } else {
                            System.out.println("Este libro no se encuentra en la base de datos");

                        }   
                break;
                case 2:
                    
                    System.out.println("Ingrese Nombre de Libro a devolver");
                    teclado.nextLine();
                    buscanom=teclado.nextLine();
                    
                    for(int i = 0;i<fichasp.size();i++){
                        prestamo= fichasp.get(i);
                        Busca=prestamo.getNombre1();
                        if (buscanom.equals(Busca)){
                            este=i;
                            veri=true;
                        }
                    }
                    if(veri){
                    prestamo= fichasp.get(este);
                    fichasp.remove(este);
                    este=recorrer(prestamo.getNombre1());
                    gestion=fichas.get(este);
                    Nombre=gestion.getNombre();
                    año=gestion.getaño();
                    autor=gestion.getautor();
                    cantidad=(gestion.getcantidad()+1);
                    area=gestion.getarea();
                    codigo=gestion.getcodigo();
                    Gestion aux3 = new Gestion();
                    aux3.setNombre(Nombre);
                    aux3.setaño(año);
                    aux3.setcantidad(cantidad);
                    aux3.setarea(area);
                    aux3.setcodigo(codigo);
                    aux3.setautor(autor);
                    fichas.set(este,aux3);                    
                            veri=false;
                        } else {
                            System.out.println("Este libro no esta en prestamo");

                        }   
                    break;
                         
                     case 3:
                         for(int i = 0;i<fichasp.size();i++){
                    prestamo= fichasp.get(i);
                    prestamo.mostrar();
                    if(fichasp.size()==0){
                            System.out.println("No hay libros en prestamo");
                            }
                         }
                         break;
                default:
                    System.out.println("ingreso una opción incorrecta, intente de nuevo");
                    break;
            }
            break;
            default:
                System.out.println("ingreso una opción incorrecta, intente de nuevo");
            break;
        }
             
           
        }
       
    }
    public static int recorrer(String nomb){
        int este=0;      
         for(int i = 0;i<fichas.size();i++){
            gestion= fichas.get(i);             
            if (nomb.equals(gestion.getNombre())){
                este=i;
                veri=true;
            }
        }
        return este;
    }
}
