package TpParcial;

public class LanchaTuristica extends Vehiculo{
    private String tipoMotor;
    
    public LanchaTuristica(String patente, String marca, int capacidad, int anio, String tipoMotor){
        super(patente,marca,capacidad,anio);
        this.tipoMotor = tipoMotor;
    } //constructor
            
    public String getTipoMotor(){
        return tipoMotor;
    }
    
    @Override
    public String toString(){
        return super.toString() + " - Tipo: Lancha - Motor: " + tipoMotor;
    }
} //clase

