import java.util.Comparator;

public class CompararPorTiempoQueTarda implements Comparator<Trabajo> {
    @Override
    public int compare(Trabajo o1, Trabajo o2) {
        return -Double.compare(o1.getTiempoQueTarda(), o2.getTiempoQueTarda());
    }
}
