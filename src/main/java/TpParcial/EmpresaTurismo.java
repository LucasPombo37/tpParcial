
package TpParcial;

import java.util.ArrayList;

public class EmpresaTurismo {
    private ArrayList<Vehiculo> vehiculos;
    
    public EmpresaTurismo(){
        vehiculos = new ArrayList<>();
    }
    
    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
        System.out.println("Vehiculo agregado");
    }
    
    public void mostrarTodosLosVehiculos(){
        for(Vehiculo v : vehiculos){
            System.out.println(v);
        } //cerramos el ciclo
    }
    
    public void realizarServiciosTuristicos(){
        if(vehiculos.size() == 0){
            System.out.println("No hay vehiculos cargados ");
            return;
        }
        System.out.println("!!!=== INICINDO SERVICIO TURISTICO ===!!!");
        for(Vehiculo v: vehiculos){
            v.realizarServicioTuristico();
        }
    }
    
    public Vehiculo buscarVehiculoPorPatente(String patente){
            for(Vehiculo v:vehiculos){
                if(v.getPatente() != null && v.getPatente().equals(patente)){
                    return v;
            }     
        }
        return null;
    }
    
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
    }
    
    
} // llave de la clase
