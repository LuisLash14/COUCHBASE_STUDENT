/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.couchbase.couchbaseprogram;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;
import java.util.Scanner;
/**
 *
 * @author SQL
 */
public class AddCourse {
    String idCourse,Cname,Cfaculty;
    int Ccredits;
    public void  ClavesCourse(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("******DATOS DEL CURSO******");
        System.out.println("Introduzca el ID del Curso");
        idCourse = entrada.nextLine();
        System.out.println("Introduzca el nombre del Curso");
        Cname = entrada.nextLine();      
        System.out.println("Introduzca la facultad del Curso");
        Cfaculty= entrada.nextLine(); 
        System.out.println("Introduzca los creditos del Curso");
        Ccredits= entrada.nextInt();
    }     
    public String getIdCourse(){
        return(idCourse);
    }
    public String getCname(){
        return(Cname);
    }
    public String getCfaculty(){
        return(Cfaculty);
    }
    public int getCcredits(){
        return(Ccredits);
    }
}
