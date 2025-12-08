package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class problema105 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] semana = {"MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};
        float[][] cuantiasSemanales = new float[1000][6];
        float entrada = 0;
        int numSemanas = 0;

        for (int i = 0; i < cuantiasSemanales.length; i++) {
            if (entrada != -1)
                for (int j = 0; j < cuantiasSemanales[i].length; j++) {
                    entrada = input.nextFloat();
                    if (entrada != -1)
                        cuantiasSemanales[i][j] = entrada;
                    else if (entrada == -1)
                        break;
                    if(j == 0)
                        numSemanas++;
                }
            else if (entrada == -1)
                break;
        }

        int indexMax = 0, indexMin = 0;


        for (int i = 0; i < numSemanas; i++) {
            float maxCuantity = cuantiasSemanales[i][0];
            float minCuantity = cuantiasSemanales[i][0];
            float mediaSemanal = 0;

            for (int j = 0; j < cuantiasSemanales[i].length; j++) {
                mediaSemanal += cuantiasSemanales[i][j];

                if(maxCuantity <= cuantiasSemanales[i][j]) {
                    maxCuantity = cuantiasSemanales[i][j];
                    indexMax = j;

                }
                if(minCuantity >= cuantiasSemanales[i][j]) {
                    minCuantity = cuantiasSemanales[i][j];
                    indexMin = j;
                }
            }
            if(cuantiasSemanales[i][5] < (mediaSemanal/6))
                System.out.println(semana[indexMax] + " " + semana[indexMin] + " NO");
            if(cuantiasSemanales[i][5] > (mediaSemanal/6))
                System.out.println(semana[indexMax] + " " + semana[indexMin] + " SI");
            if(cuantiasSemanales[i][5] == (mediaSemanal/6))
                System.out.println(semana[indexMax] + " " + semana[indexMin] + " EMPATE");
        }

    }
}
