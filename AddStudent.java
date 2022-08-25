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
public class AddStudent {
    String id;
    String clave;
    int Dia,mes,año;
    String fecha;
     
    public void ClavesStudent(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("******DATOS DEL ESTUDIANTE******");
        System.out.println("Introduzca el ID del documento: ");
        id = entrada.nextLine();
        System.out.println("Introduzca el nombre: ");
        clave = entrada.nextLine();      
        System.out.println("Introduzca fecha de nacimiento: Formato: AAAA-MM-DD");
        fecha= entrada.nextLine();   
    }
    public String getClave(){
        return(clave);
    }
    public String getId(){
        return(id);
    }   
     public String getFecha(){
        return(fecha);
    }
}
