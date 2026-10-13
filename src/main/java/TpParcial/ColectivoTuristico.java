package TpParcial;

public class ColectivoTuristico extends Vehiculo{
    private int cantidadPisos ;
    
    public ColectivoTuristico(String patente, String marca, int capacidad, int anio, int cantidadPisos){
        super(patente,marca,capacidad,anio);
        this.cantidadPisos = cantidadPisos;    
    } // constructor
    
    public int getCantidadPisos(){
        return cantidadPisos;
    }
    
    @Override
    public String toString(){
        return super.toString() + " - Tipo: Colectivo - Pisos: " + cantidadPisos;
    } 
}// clase
