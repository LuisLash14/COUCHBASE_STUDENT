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
public class RecuperarCurso {
    String name;
    public void getKeysCurso(){
        Scanner entrada = new Scanner(System.in);        
        System.out.println("******DATOS DEL CURSO******");
        System.out.println("Introduzca el nombre del curso: ");
        name = entrada.nextLine();                    
    }
    public String getName(){
        return(name);
    }
}
