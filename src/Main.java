import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Trabajo> listaDeTrabajos = new ArrayList<>();

        listaDeTrabajos.add(new Trabajo("A", new Coordenada(-1, 1), 2.30));
        listaDeTrabajos.add(new Trabajo("B", new Coordenada(4, 5), 1));
        listaDeTrabajos.add(new Trabajo("C", new Coordenada(2, 7), 2.50));
        listaDeTrabajos.add(new Trabajo("D", new Coordenada(-4, 4), 0.45));


        System.out.println(listaDeTrabajos);

        System.out.println(Arrays.toString(ordenarLaListaDeTrabajosPorDistanciasIniciandoDesdeUnPunto(listaDeTrabajos, listaDeTrabajos.get(0))));
        System.out.println(ordenarLaListaDeTrabajosPorTiempoQueTardaDeMayorAMenor(listaDeTrabajos));

    }

    private static ArrayList<Trabajo> ordenarLaListaDeTrabajosPorTiempoQueTardaDeMayorAMenor(ArrayList<Trabajo> listaDeTrabajos) {
        //Creamos un comparador
        listaDeTrabajos.sort(new CompararPorTiempoQueTarda());
        return listaDeTrabajos;
    }

    private static Trabajo[] ordenarLaListaDeTrabajosPorDistanciasIniciandoDesdeUnPunto(ArrayList<Trabajo> listaDeTrabajos, Trabajo trabajoInicial) {

        colocarElTrabajoInicialEnElPrimerPuesto(listaDeTrabajos, trabajoInicial);

        Trabajo[] trabajosOrdenados = new Trabajo[listaDeTrabajos.size()];
        trabajosOrdenados = listaDeTrabajos.toArray(trabajosOrdenados);



        for (int i = 0; i < trabajosOrdenados.length - 1; i++) {//EL menos uno es porque el ultimo valor ya no es necesario compararlo
            double auxiliarParaCompararDistancias = calcularLaDistanciaEntreDosTrabajos(trabajosOrdenados[i], trabajosOrdenados[i + 1]);//referencia
            for (int j = i; j < trabajosOrdenados.length; j++) {
                if (calcularLaDistanciaEntreDosTrabajos(trabajosOrdenados[i], trabajosOrdenados[j]) < auxiliarParaCompararDistancias && !trabajosOrdenados[i].equals(trabajosOrdenados[j])) {
                    Trabajo auxiliarParaOrdenar = trabajosOrdenados[i+1];//Se pone "i+1" porque "i" es donde iniciamos pero estamos ordenando el destino
                    trabajosOrdenados[i+1] = trabajosOrdenados[j];
                    trabajosOrdenados[j] = auxiliarParaOrdenar;
                }
            }
        }

        return trabajosOrdenados;
    }

    private static double calcularLaDistanciaEntreDosTrabajos(Trabajo trabajoDeInicio, Trabajo trabajoDeDestino) {
        //Teorema de pitagoras
        return Math.sqrt(Math.pow(trabajoDeInicio.getX() - trabajoDeDestino.getX(), 2) + Math.pow(trabajoDeInicio.getY() - trabajoDeDestino.getY(), 2));
    }

    private static void colocarElTrabajoInicialEnElPrimerPuesto(ArrayList<Trabajo> listaDeTrabajos, Trabajo trabajoInicial) {
        //Porque el usuario escoge desde que punto quiere iniciar
        listaDeTrabajos.remove(trabajoInicial);
        listaDeTrabajos.add(0, trabajoInicial);
    }
}