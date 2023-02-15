package fp;

import java.util.Objects;

public class Estacion implements Comparable<Estacion> {

    private String nombre;
    private Integer puestos;
    private Integer disponibles;
    private Coordenadas ubicacion;

    public Integer getVacios() {
        return puestos - disponibles;
    }

    public Boolean tieneDisponibles() {
        return disponibles >= 1;
    }

    public Estacion(String nombre, Integer puestos, Integer disponibles, Coordenadas ubicacion) {
        this.nombre = nombre;
        if (puestos <= 0) {
            throw new IllegalArgumentException("El número de puestos debe ser mayor que 0");
        }
        this.puestos = puestos;
        if (disponibles < 0 || disponibles > puestos) {
            throw new IllegalArgumentException(
                    "El número de bicicletas disponibles debe ser mayor o igual que 0 y menor o igual que el número de puestos");
        }
        this.disponibles = disponibles;
        this.ubicacion = ubicacion;
    }

    public Estacion(String s) { // "087_PLAZANUEVA,40,35,37.38896647697466,-5.995294220038549"
        String[] trozos = s.split(",");
        this.nombre = trozos[0];
        this.puestos = Integer.valueOf(trozos[1]);
        this.disponibles = Integer.valueOf(trozos[2]);
        this.ubicacion = new Coordenadas(Double.valueOf(trozos[3]), Double.valueOf(trozos[4]));
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        if (disponibles < 0 || disponibles > puestos) {
            throw new IllegalArgumentException(
                    "El número de bicicletas disponibles debe ser mayor o igual que 0 y menor o igual que el número de puestos");
        }
        this.disponibles = disponibles;
    }

    
    public String getNombre() {
        return nombre;
    }

    public Integer getPuestos() {
        return puestos;
    }

    public Coordenadas getUbicacion() {
        return ubicacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estacion other = (Estacion) obj;
        return Objects.equals(nombre, other.nombre);
    }

    @Override
    public int compareTo(Estacion o) {
        return nombre.compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return "Estacion [nombre=" + nombre + ", puestos=" + puestos + ", disponibles=" + disponibles + ", ubicacion="
                + ubicacion + "]";
    }

}
