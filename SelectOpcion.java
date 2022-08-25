/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.couchbase.couchbaseprogram;

import java.util.Scanner;

/**
 *
 * @author SQL
 */
public class SelectOpcion {
    int caso;
    public void ObtenCaso (){
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n******DIGITE EL NUMERO DE UNA OPCION:****** \nAGREGAR ESTUDIANTE: 1 \nAGREGAR CURSO: 2 \nINSCRIBIR A UN CURSO: 3 \nSALIR: 4 ");
        caso = entrada.nextInt();
    }
    public int getCaso(){
        return(caso);
    }
}
