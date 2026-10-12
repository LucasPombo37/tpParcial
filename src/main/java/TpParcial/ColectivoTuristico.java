package TpParcial;




public class ColectivoTuristico extends Vehiculo{
 
    private boolean doblePiso;
    
    public ColectivoTuristico(String patente, String marca, int capacidad, int anio, boolean doblePiso){
        super(patente,marca,capacidad,anio);
        this.doblePiso = doblePiso;    
    } // constructor
    
    @Override
    public String toString(){
        return super.toString() + " - Tipo: Colectivo - Doble Piso: " + (doblePiso ? "Si" : "No");
    }
    
    
    
}// clase
