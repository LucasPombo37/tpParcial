package TpParcial;
public class VanEjecutiva extends Vehiculo {
    private boolean aireAcondicionado;
    
    public VanEjecutiva(String patente, String marca, int capacidad, int anio, boolean aireAcondicionado){
        super(patente,marca,capacidad,anio);
        this.aireAcondicionado = aireAcondicionado;
    } // constructor    
   
    public boolean isAireAcondicionado(){
        return aireAcondicionado;
    }
    
    public boolean getAireAcondicionado(){
        return aireAcondicionado;
    }
    
    @Override
    public String toString(){
        return super.toString() + " - Tipo: Van Ejecutiva - Aire acondicionado" + (aireAcondicionado ? "Si" : "No");
    }  
} //clase
