public class Trabajo {

    private final String nombreDelTrabajo;
    private final Coordenada coordenada;
    private final double tiempoQueTardaEnRealizarElTrabajo;

    public Trabajo(String nombreDelTrabajo, Coordenada coordenada, double tiempoQueTardaEnRealizarElTrabajo) {
        this.nombreDelTrabajo = nombreDelTrabajo;
        this.coordenada = coordenada;
        this.tiempoQueTardaEnRealizarElTrabajo = tiempoQueTardaEnRealizarElTrabajo;
    }

    @Override
    public String toString() {
        return "Trabajo{" + nombreDelTrabajo +
                ", coordenada=" + coordenada +
                ", tiempo=" + tiempoQueTardaEnRealizarElTrabajo +
                '}';
    }

    public int getX() {
        return coordenada.getX();
    }

    public int getY() {
        return coordenada.getY();
    }

    public double getTiempoQueTarda() {
        return tiempoQueTardaEnRealizarElTrabajo;
    }
}
