package TpParcial;

import java.util.Comparator;



public class ComparadorPorCapacidadPasajeros implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo v1, Vehiculo v2){
        return Integer.compare(v2.getCapacidad(), v1.getCapacidad());
    }
    
}
