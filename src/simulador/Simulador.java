/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author The Strength
 */
public class Simulador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        double rand;
        int estrategiaB[][] = { {1,2,3,4,5},
                                {5,4,3,2,1}
                              };
        int op;
        double cont[] = new double[4];
        double cont2[] = new double[2];
        double disparosTotales = 0;
        
        int N;
        
        for(int i = 0; i < cont.length; i++){
            cont[i] = 0;
        }
        
        for(int i = 0; i < cont2.length; i++){
            cont2[i] = 0;
        }
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Ingrese el valor de N: ");
        N = Integer.parseInt(entrada.readLine());
        System.out.println("");
        for(int i = 0; i < N; i++){
            rand = random.nextDouble();
            
            if(rand < 0.5){
                op = 0;
                cont2[0]++;
            }else{
                op = 1;
                cont2[1]++;
            }
            
            rand = random.nextDouble();
            if(rand < 0.375){
                cont[0]++;
                disparosTotales += impacto(1,2,estrategiaB[op]);
            }else if(rand >= 0.375 && rand < 0.5 ){
                cont[1]++;
                disparosTotales += impacto(2,3,estrategiaB[op]);
            }else if(rand >= 0.5 && rand < 0.625){
                cont[2]++;
                disparosTotales += impacto(3,4,estrategiaB[op]);
            }else if(rand >= 0.625){
                cont[3]++;
                disparosTotales += impacto(4,5,estrategiaB[op]);
            } 
        }
        
        System.out.println("N: " + N);
        System.out.println("Estrategia A del jugador A seleccionada un " + (cont[0]/N)*100 + "% de las veces");
        System.out.println("Estrategia B del jugador A seleccionada un " + (cont[1]/N)*100 + "% de las veces");
        System.out.println("Estrategia C del jugador A seleccionada un " + (cont[2]/N)*100 + "% de las veces");
        System.out.println("Estrategia D del jugador A seleccionada un " + (cont[3]/N)*100 + "% de las veces");
        System.out.println("Estrategia 1 (12345) del jugador B seleccionada un " + (cont2[0]/N)*100 + "% de las veces");
        System.out.println("Estrategia 37 (54321) del jugador B seleccionada un " + (cont2[1]/N)*100 + "% de las veces");
        System.out.println("Valor promedio del juego: " + disparosTotales/N);
    }
    
    public static int impacto(int a, int b, int[]jugada){
        int disparos = 0;
        int aciertos = 0;
        for(int i = 0; i < jugada.length; i++){
            if(jugada[i] == a || jugada[i] == b){
                aciertos++;
            }
            disparos++;
            if(aciertos == 2){
                break;
            }
        }
        return disparos;
    }
    
}
