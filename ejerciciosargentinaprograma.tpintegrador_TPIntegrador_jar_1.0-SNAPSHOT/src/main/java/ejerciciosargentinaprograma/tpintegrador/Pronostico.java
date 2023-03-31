package ejerciciosargentinaprograma.tpintegrador;


public class Pronostico {
    Partido partido;
    Equipo equipo;
    ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }
    
   /* Suma un punto al resultado acertado */
    public int  puntos(){
        /* Calculo el resultado del equipo en el partido */
        ResultadoEnum res = partido.resultado(equipo);
        int puntos = 0;
        
        /* Acá compara x ejemplo EMPATE == VICTORIA */
        if (resultado == res){
            puntos = 1;
        }
        return puntos;
        
    }
    
    
    
}
