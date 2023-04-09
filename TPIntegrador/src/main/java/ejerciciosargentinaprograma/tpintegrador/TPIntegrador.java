
package ejerciciosargentinaprograma.tpintegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TPIntegrador {

    public static void main(String[] args) {
        /* inicializar en la lectura de datos */
        int puntos=0, i=0;
        int ronda=0;
        String jug = "";
        List <Partido> partidoList = new ArrayList();
        List <Partido> partidoRondaList = new ArrayList();
        List <Jugador> jugadores = new ArrayList();
        
        
        /* Leer los partidos */
        try {
            for(String linea: Files.readAllLines(Paths.get("C:\\Users\\Joaquin\\Documents\\TP integrador\\TP-ArgPrograma\\TPIntegrador\\src\\main\\java\\ejerciciosargentinaprograma\\tpintegrador\\resultados.csv.txt")))
            {  
                int rondaf = Integer.parseInt(linea.split(";")[0]);
                if (rondaf!=ronda && i>0){
                    Ronda rondaList = new Ronda(String.valueOf(ronda), partidoRondaList);
                    partidoRondaList.clear();
                }
                System.out.println(linea);
                /* Leo partido */
                ronda = Integer.parseInt(linea.split(";")[0]);

                String eq1 = linea.split(";")[1];
                int golesEquipo1 = Integer.parseInt(linea.split(";")[2]);
                int golesEquipo2 = Integer.parseInt(linea.split(";")[3]);
                String eq2 = linea.split(";")[4];

                Equipo equipo1 = new Equipo(eq1,eq1);
                Equipo equipo2 = new Equipo(eq2,eq2);

                Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);

                partidoList.add(partido);
                partidoRondaList.add(partido);
            i++;
            
                
            } 
            i=0;
                /* Leo pronostico */
            for(String linea2: Files.readAllLines(Paths.get("C:\\Users\\Joaquin\\Documents\\TP integrador\\TP-ArgPrograma\\TPIntegrador\\src\\main\\java\\ejerciciosargentinaprograma\\tpintegrador\\pronostico.csv.txt")))
            {   
                String jugProx = linea2.split(";")[0];
                if (!jugProx.equals(jug) && i>0){
                    Jugador jugador = new Jugador(jug, puntos);
                    jugadores.add(jugador);
                    puntos=0;
                    i=0;
                }
                
                jug = linea2.split(";")[0];
                System.out.println(linea2);
                String equiPro = linea2.split(";")[1];

                Equipo equipoPronostico = new Equipo(equiPro,equiPro);

                /* Si es X en el primero queda GANADOR, en el segundo EMPATE  */
                String gana = linea2.split(";")[2];
                String empata = linea2.split(";")[3];
                String pierde = linea2.split(";")[4];
                ResultadoEnum res = null;
                if (gana.equals("X")){
                    res = ResultadoEnum.GANADOR;
                }
                if (empata.equals("X")){
                    res = ResultadoEnum.EMPATE;
                }
                 if (pierde.equals("X")){
                    res = ResultadoEnum.PERDEDOR;
                }
                 System.out.println(res);
               Pronostico pron = new Pronostico(partidoList.get(i), equipoPronostico, res);
               
                puntos = puntos + pron.puntos();
                i++;
            }
            Jugador jugador = new Jugador(jug, puntos);
            jugadores.add(jugador);
            
            
            System.out.println("-------------\nResultados:\n");
            for (Jugador juga: jugadores){
                System.out.println(juga.getNombre() + ": " + juga.getPuntos());
                
            }


            } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        
              
    }
}
