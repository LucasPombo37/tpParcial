
package TpParcial;
import java.util.Scanner;

public class TpParcial {
    
    public static Scanner escaner = new Scanner(System.in);
    public static EmpresaTurismo empresa = new EmpresaTurismo();
    
    // Tipos de vehiculos
    public static final int TIPO_COLECTIVO = 1;
    public static final int TIPO_LANCHA = 2;
    public static final int TIPO_VAN = 3;
    
    // Opciones del menu
    public static final int OPCION_AGREGAR = 1;
    public static final int OPCION_MOSTRAR = 2;
    public static final int OPCION_SERVICIOS = 3; //realiza servicios turisticos
    public static final int OPCION_BUSCAR = 4;
    public static final int OPCION_CAPACIDAD = 5;
    public static final int OPCION_ORDEN_ANIO = 6;
    public static final int OPCION_ORDEN_CAPACIDAD = 7;
    public static final int OPCION_SALIR = 8;
    
    
    
    public static void mostrarMenu(){
            System.out.println("-- EMPRESA DE TURISMO --");
            System.out.println(OPCION_AGREGAR + " Agregar vehiculo");
            System.out.println(OPCION_MOSTRAR + " Mostrar todos los vehículos");
            System.out.println(OPCION_SERVICIOS + "Realizar servicios turísticos");
            System.out.println(OPCION_BUSCAR + " Buscar vehículo por patente");
            System.out.println(OPCION_CAPACIDAD + " Mostrar vehículo con capacidad mayor a..");
            System.out.println(OPCION_ORDEN_ANIO + " Mostrar vehículos ordenados por año de fabricación descendente..");
            System.out.println(OPCION_ORDEN_CAPACIDAD + " Mostrar vehículos ordenados por capacidad de pasajeros descendente");
            System.out.println(OPCION_SALIR + " Salir...");
            System.out.println(" Elija opcion: ");
    } // cierra mostrarMenu
    
    
    public static boolean procesarOpcion(int opcion){
        switch(opcion){
                case OPCION_AGREGAR:
                        System.out.println("Agregar vehiculo...");
                        agregarVehiculo();
                        break;
                case OPCION_MOSTRAR:
                        System.out.println("Mostrando vehiculos...");
                        mostrarTodosLosVehiculos();
                        break;
                case OPCION_SERVICIOS:                  
                        empresa.realizarServiciosTuristicos();
                        break;
                case OPCION_BUSCAR:
                        System.out.println("Ingrese patente a buscar: ");
                        String patente = escaner.nextLine();
                        Vehiculo encontrado = empresa.buscarVehiculoPorPatente(patente);
                        if(encontrado != null){
                            System.out.println("Vehiculo encontrado! " + encontrado);
                        }else{
                            System.out.println("No existe esa patente");
                        }
                        break;
                case OPCION_CAPACIDAD:
                        System.out.println("Ingrese capacidad minima: ");
                        int cap = escaner.nextInt();
                        escaner.nextLine();
                        empresa.mostrarVehiculosConCapacidadMayorA(cap);                       
                        break;
                case OPCION_ORDEN_ANIO:
                        System.out.println("Mostrar vehiculos ordenados por año de fabricacion...");
                        //6 - mostrarOrdenadosPorAnio();
                        break;                        
                case OPCION_ORDEN_CAPACIDAD:
                        System.out.println("Mostrar vehiculos ordenados por capacidad de pasajeros descendente...");
                        //7 - mostrarOrdenadosPorCapacidad();
                        break;                       
                case OPCION_SALIR:       
                        System.out.println("Salir...");                 
                        return true; //corta con el do while
                default:
                    System.out.println("Opción invalida");
                    break;
                } // llave del switch
                return false;
            } // cierra el metodo "procesarOpcion"
    
    //1
    public static void agregarVehiculo(){
        System.out.println(TIPO_COLECTIVO + "- Colectivo " + TIPO_LANCHA + "- Lancha " + TIPO_VAN + "- Van ");
        int tipo = Integer.parseInt(escaner.nextLine());
        System.out.println("Patente");
        String pat = escaner.nextLine();
        System.out.println("Marca");
        String mar = escaner.nextLine();
        System.out.println("Capacidad");
        int cap = Integer.parseInt(escaner.nextLine());
        System.out.println("Año");
        int anio = Integer.parseInt(escaner.nextLine());
        System.out.println("Extra true/false: ");
        boolean extra = Boolean.parseBoolean(escaner.nextLine());
        
        if(tipo == TIPO_COLECTIVO){
            empresa.agregarVehiculo(new ColectivoTuristico(pat,mar,cap,anio,extra)); // se agrega al array
        }
        else if(tipo == TIPO_LANCHA){
            empresa.agregarVehiculo(new LanchaTuristica(pat,mar,cap,anio,extra)); // se agrega al array
        }
        else if(tipo == TIPO_VAN){
            empresa.agregarVehiculo(new VanEjecutiva(pat,mar,cap,anio,extra)); // se agrega al array
        }
         
    }// cierra agregarVehiculo
    
    //2
    public static void mostrarTodosLosVehiculos(){
        empresa.mostrarTodosLosVehiculos();
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {   
        int opcion = 0;
        boolean salir = false;
        
        do{
           mostrarMenu();
           try {
               opcion = escaner.nextInt();
               escaner.nextLine();
               salir = procesarOpcion(opcion); //Llamamos al switch
           }catch(Exception e){ //abrimos CATH
               System.out.println("Tiene que ingresar un numero ");          
               escaner.nextLine();
           } // cerramos cath
        }while(!salir); // cierra el Do While
               
    } // llave del main   
} // llave de la clase
