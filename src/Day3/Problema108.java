package Day3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problema108 {
    public static void main(String[] args) {
        // Hecho y funcionando pero con Run-time-error, no se me ocurre que caso lo puede estar provocando
        // Categorías: D(Desayunos) A(Comidas) M(Meriendas) I(Cenas) C(Copas)
        // Entrada(Fin del Día): N 0

        Scanner sc = new Scanner(System.in);

        Map<String, Double> map = new HashMap<>();
        String dia = " ";
        double entrada = 1;

        map.put("DESAYUNOS", 0.0);
        map.put("COMIDAS", 0.0);
        map.put("MERIENDAS", 0.0);
        map.put("CENAS", 0.0);
        map.put("COPAS", 0.0);

        while (dia != "N" && entrada != 0) {
            dia = sc.next().toUpperCase();
            entrada = sc.nextDouble();
            switch (dia) {
                case "D":
                    map.put("DESAYUNOS", entrada);
                    break;
                case "A":
                    map.put("COMIDAS", entrada);
                    break;
                case "M":
                    map.put("MERIENDAS", entrada);
                    break;
                case "I":
                    map.put("CENAS", entrada);
                    break;
                case "C":
                    map.put("COPAS", entrada);
                    break;
            }
        }

        String diaMax = "", diaMin = "";
        double diaValorMax = 0, diaValorMin = 1, media = 0;
        int empateMax = 0, empateMin = 0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() == diaValorMax){
                empateMax++;
            } else if(entry.getValue() > diaValorMax){
                diaValorMax = entry.getValue();
                diaMax = entry.getKey();
            }
            if(entry.getValue() == diaValorMin){
              empateMin++;
            } else if(entry.getValue() < diaValorMin){
                diaValorMin = entry.getValue();
                diaMin = entry.getKey();
            }
            media += entry.getValue();
        }
        String mediaAdv = "";
        if((media/5) > map.get("COPAS"))
            mediaAdv = "SI";
        else
            mediaAdv = "NO";

        if(empateMin != 0 && empateMax != 0){
            System.out.println("EMPATE#EMPATE#" + mediaAdv);
        }
        else if(empateMin != 0 && empateMax == 0)
            System.out.println(diaMax + "#EMPATE#" + mediaAdv);
        else if(empateMax != 0 && empateMin == 0)
            System.out.println("EMPATE#" + diaMin + "#" + mediaAdv);

        if(empateMax == 0 && empateMin == 0)
            System.out.println(diaMax + "#" + diaMin + "#" + mediaAdv);
    }
}
