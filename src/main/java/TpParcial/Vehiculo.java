package TpParcial;

public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String patente;
    private String marca;
    private int capacidad;
    private int anio;
    
    public Vehiculo(String patente, String marca, int capacidad, int anio){
        this.patente = patente;
        this.marca = marca;
        this.capacidad = capacidad;
        this.anio = anio;
    } // constructor
    
    public String getPatente(){
        return this.patente;
    }
    
    public int getCapacidad(){
        return this.capacidad;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public int getAnio(){
        return this.anio;
    }
    
    @Override
    public String toString(){
        return "Patente: " + patente + " - Marca : " + marca + " - Capacidad: " + capacidad + " - Anio: " + anio;
    }
    
    public void realizarServicioTuristico(){
        System.out.println("!!!=== Realizando servicio turistico: "+ this.toString());
    }
   
    @Override
    public int compareTo(Vehiculo otro){
        return Integer.compare(this.anio, otro.anio);
    }
    
} // clase
