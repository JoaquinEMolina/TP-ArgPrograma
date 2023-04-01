
package ejerciciosargentinaprograma.tpintegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TPIntegrador {

    public static void main(String[] args) {
        /* inicializar en la lectura de datos */
        int puntos=0, i=0;
         Partido[] partidoArray = new Partido[2];
        /* Leer los partidos */
        try {
            for(String linea: Files.readAllLines(Paths.get("C:\\Users\\Joaquin\\Documents\\TP integrador\\TP-ArgPrograma\\TPIntegrador\\src\\main\\java\\ejerciciosargentinaprograma\\tpintegrador\\resultados.csv.txt")))
            {   
                System.out.println(linea);
                /* Leo partido */
                String eq1 = linea.split(";")[0];
                int golesEquipo1 = Integer.parseInt(linea.split(";")[1]);
                int golesEquipo2 = Integer.parseInt(linea.split(";")[2]);
                String eq2 = linea.split(";")[3];
                
                Equipo equipo1 = new Equipo(eq1,eq1);
                Equipo equipo2 = new Equipo(eq2,eq2);
                
                Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);
             
               
                partidoArray[i] = partido;
                i++;
            }
               i=0;
                /* Leo pronostico */
            for(String linea2: Files.readAllLines(Paths.get("C:\\Users\\Joaquin\\Documents\\TP integrador\\TP-ArgPrograma\\TPIntegrador\\src\\main\\java\\ejerciciosargentinaprograma\\tpintegrador\\pronostico.csv.txt")))
            {
                System.out.println(linea2);
                String equiPro = linea2.split(";")[0];

                Equipo equipoPronostico = new Equipo(equiPro,equiPro);

                /* Si es X en el primero queda GANADOR, en el segundo EMPATE  */
                String gana = linea2.split(";")[1];
                String empata = linea2.split(";")[2];
                String pierde = linea2.split(";")[3];
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
               Pronostico pron = new Pronostico( partidoArray[i], equipoPronostico, res);


                puntos = puntos + pron.puntos();

                i++;

            }

            System.out.println("PUNTOS: "+puntos);


            } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        
              
    }
}
