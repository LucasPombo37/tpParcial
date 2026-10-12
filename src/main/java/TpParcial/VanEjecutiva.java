package TpParcial;



public class VanEjecutiva extends Vehiculo {
    private boolean asientoCuero;
    
    public VanEjecutiva(String patente, String marca, int capacidad, int anio, boolean extra){
        super(patente,marca,capacidad,anio);
        this.asientoCuero = extra;
       
    } // constructor    
   
    @Override
    public String toString(){
        return super.toString() + " - Tipo: Van Ejecutiva - Asiento Cuero: " + (asientoCuero ? "Si" : "No");
    }
    
    
    
    
} //clase
