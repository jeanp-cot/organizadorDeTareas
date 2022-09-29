public class Coordenada {
    private final int coordenadaEnX;
    private final int coordenadaEnY;

    public Coordenada(int coordenadaEnX, int coordenadaEnY) {
        this.coordenadaEnX = coordenadaEnX;
        this.coordenadaEnY = coordenadaEnY;
    }

    public int getX() {
        return coordenadaEnX;
    }

    public int getY() {
        return coordenadaEnY;
    }

    @Override
    public String toString() {
        return "Coordenada{"+ coordenadaEnX +
                "," + coordenadaEnY +
                '}';
    }
}
