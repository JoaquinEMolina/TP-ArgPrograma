package ejerciciosargentinaprograma.tpintegrador;


public class Ronda {
    private String nro;
    private Partido[] partidos;
    private Pronostico[] pronosticos;

    public Ronda(String nro, Partido[] partidos, Pronostico[] pronosticos) {
        this.nro = nro;
        this.partidos = partidos;
        this.pronosticos = pronosticos;
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