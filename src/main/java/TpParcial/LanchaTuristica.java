package TpParcial;


public class LanchaTuristica extends Vehiculo{
    private boolean techoCubierto;
    
    public LanchaTuristica(String patente, String marca, int capacidad, int anio, boolean techoCubierto){
        super(patente,marca,capacidad,anio);
        this.techoCubierto = techoCubierto;
        
    } //constructor
            
    @Override
    public String toString(){
        return super.toString() + " - Tipo: Lancha - Techo Cubierto: " + (techoCubierto ? "Si" : "No");
    }
    
  
} //clase

