package ejerciciosargentinaprograma.tpintegrador;

import java.util.ArrayList;
import java.util.List;


public class Ronda {
    private String nro;
    private List <Partido> partidos;
    private List <Pronostico> pronosticos;
    private List <Partido> listaPartidos = new ArrayList();

    public Ronda(String nro, List<Partido> partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public int puntos() {
        int totalPuntos = 0;
        for (Pronostico p : pronosticos) {
            for (Partido partido : partidos) {
                if (p.getPartido().equals(partido)) {
                    if (p.getResultado() == partido.resultado(p.getEquipo())) {
                        totalPuntos++;
                    }
                }
            }
        }
        return totalPuntos;
    }
}