
package TpParcial;

import java.util.ArrayList;
import java.util.Collections;


public class EmpresaTurismo {
    private ArrayList<Vehiculo> vehiculos;
    public EmpresaTurismo(){
        vehiculos = new ArrayList<>();
    }
    
    public boolean agregarVehiculo(Vehiculo v){
        if(v.getPatente() == null || v.getPatente().equals("") || v.getPatente().replace(" ","").equals("")){
            System.out.println("Error: La patente no puede estar vacia" );
            return false;
        }//primer if
        for(Vehiculo aux:vehiculos){
            if(aux.getPatente().toUpperCase().equals(v.getPatente().toUpperCase())){
                System.out.println("Error: Ya existe un vehiculo con la patente " + v.getPatente());   
                return false;
            }
        }//ciclo 
        if(v.getCapacidad() <= 0){
            System.out.println("Error: La capacidad debe ser mayor a 0");
            return false;
        }     
        if(v.getAnio()< 1990){
            System.out.println("Error: El anio debe ser 1990 o superior"); 
            return false;
        }
        if(v.getAnio() > 2026){
            System.out.println("Error: El anio no puede ser mayor a 2026");
            return false;
        }
        if(v instanceof ColectivoTuristico){
            ColectivoTuristico c = (ColectivoTuristico) v;
            if(c.getCantidadPisos() != 1 && c.getCantidadPisos() != 2){
                System.out.println("Error: El colectivo debe tener 1 o 2 pisos");
                return false;
            }
        }
        if(v instanceof LanchaTuristica){
            LanchaTuristica l = (LanchaTuristica) v;
            String motor = l.getTipoMotor().toUpperCase();
            if(!motor.equals("NAFTA") && !motor.equals("DIESEL") && !motor.equals("ELECTRICO")){
                System.out.println("Error: Tipo de motor no valido");
                return false;
            }
        }
        vehiculos.add(v);
        System.out.println("Vehiculo agregado");
        return true;
        
    } //Llave de agregarVehiculo
    
    public void mostrarTodosLosVehiculos(){
        if(!hayVehiculos()){
            return;
        }    
        for(Vehiculo v : vehiculos){
            System.out.println(v);
        } //cerramos el ciclo
    }//Llave de mostrarTodosLosVehiculos
    
    public void realizarServiciosTuristicos(){
        if(!hayVehiculos()){
            return;
        }
        System.out.println("!!!=== INICINDO SERVICIO TURISTICO ===!!!");
        for(Vehiculo v: vehiculos){
            v.realizarServicioTuristico();
        }
    }//Llave de realizarServiciosTuristicos
    
    public Vehiculo buscarVehiculoPorPatente(String patente){
            for(Vehiculo v:vehiculos){
                if(v.getPatente() != null && v.getPatente().equals(patente)){
                    return v;
            }     
        }
        return null;
    }//Llave de buscsarVehiculoPorPatente
    
    public void mostrarVehiculosConCapacidadMayorA(int capacidadMinima){
        boolean encontro = false;       
        for(Vehiculo v:vehiculos){
            if(v.getCapacidad() > capacidadMinima){
                System.out.println("VEHICULO ENCONTRADO!");
                System.out.println(v);
                encontro = true;
            }
        }
        if(!encontro){
            System.out.println("No hay vehiculos con capacidad mayor a " + capacidadMinima);                  
        }
    }//Llave de mostrarVehiculosConCapacidadMayorA
    
    public void mostrarVehiculosOrdenadosPorAnio(){
        if(!hayVehiculos()){
            return;
        }   
        Collections.sort(vehiculos, Collections.reverseOrder());
        System.out.println("=== Vehiculos ordenados por anio ===");
        for(Vehiculo v : vehiculos){
            System.out.println(v);
        }
    }//Llave de mostrarVehiculosOrdenadosPorAnio
    
    private boolean hayVehiculos(){
        if(vehiculos == null || vehiculos.size() == 0){
            System.out.println("Error: No hay vehiculos cargados");
            return false;
        }
        return true;
    }//llave de hayVehiculos
    
    public void ordenarPorCapacidadDesc(){
        if(!hayVehiculos()){
            return;
        }
        Collections.sort(vehiculos, new ComparadorPorCapacidadPasajeros());
        
        for(Vehiculo v: vehiculos){
            System.out.println(v);
        }
    
    }//llave de ordenadoPorCapacidadDesc
} // llave de la clase
