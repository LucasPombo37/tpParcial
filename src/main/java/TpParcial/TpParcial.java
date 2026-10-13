
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
            System.out.println(OPCION_MOSTRAR + " Mostrar todos los vehiculos");
            System.out.println(OPCION_SERVICIOS + " Realizar servicios turisticos");
            System.out.println(OPCION_BUSCAR + " Buscar vehiculo por patente");
            System.out.println(OPCION_CAPACIDAD + " Mostrar vehiculo con capacidad mayor a..");
            System.out.println(OPCION_ORDEN_ANIO + " Mostrar vehiculos ordenados por anio de fabricacion descendente..");
            System.out.println(OPCION_ORDEN_CAPACIDAD + " Mostrar vehiculos ordenados por capacidad de pasajeros descendente");
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
                    try{
                        System.out.println("Ingrese capacidad minima: ");
                        int cap = escaner.nextInt();
                        empresa.mostrarVehiculosConCapacidadMayorA(cap);  
                        }catch (NumberFormatException e){
                            System.out.println("Error: Tenes que ingresar un numero para la capacidad");
                        }    
                              
                        break;
                case OPCION_ORDEN_ANIO:
                        System.out.println("Mostrar vehiculos ordenados por año de fabricacion...");
                        empresa.mostrarVehiculosOrdenadosPorAnio();
                        break;                        
                case OPCION_ORDEN_CAPACIDAD:
                        System.out.println("Mostrar vehiculos ordenados por capacidad de pasajeros descendente...");
                        
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
        while(true){
            try{     
                System.out.println(TIPO_COLECTIVO + "- Colectivo " + TIPO_LANCHA + "- Lancha " + TIPO_VAN + "- Van ");
                int tipo = Integer.parseInt(escaner.nextLine());
                System.out.println("Patente");
                String pat = escaner.nextLine();
                System.out.println("Marca");
                String mar = escaner.nextLine();
                System.out.println("Capacidad");
                int cap = Integer.parseInt(escaner.nextLine());
                System.out.println("Anio");
                int anio = Integer.parseInt(escaner.nextLine());
                
                boolean agregado = false;
                if(tipo == TIPO_COLECTIVO){
                    System.out.println("Cantidad de pisos 1 o 2: ");
                    int cantidadPisos = Integer.parseInt(escaner.nextLine());
                    agregado = empresa.agregarVehiculo(new ColectivoTuristico(pat,mar,cap,anio,cantidadPisos)); // se agrega al array
                }
                else if(tipo == TIPO_LANCHA){
                    System.out.println("Tipo motor NAFTA/DIESEL/ELECTRICO: ");
                    String motor = escaner.nextLine();
                    agregado = empresa.agregarVehiculo(new LanchaTuristica(pat,mar,cap,anio,motor)); // se agrega al array
                }
                else if(tipo == TIPO_VAN){
                    System.out.println("Tiene aire true/false: ");
                    boolean tieneAire = Boolean.parseBoolean(escaner.nextLine());
                    agregado = empresa.agregarVehiculo(new VanEjecutiva(pat,mar,cap,anio,tieneAire)); // se agrega al array
                }
                if(agregado){
                    System.out.println("Vehículo agregado correctamente");
                    break;
                }
                } catch(NumberFormatException e){
                    System.out.println("Error: Intentalo denuevo");
                }
        } //cierre ciclo
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
