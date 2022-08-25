/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.couchbase.couchbaseprogram;
import java.util.Scanner;
/**
 *
 * Conexión Con couchbase localhost//administrator-1//123456
 */
public class Conexion {   
      String D1;   
      String D2;
      String D3;
      String host;
      String user;
      String passw;     
    
    public void Credenciales(){
        Scanner entrada = new Scanner(System.in); 
        System.out.println("******OBTENCION DE DATOS DEL CLUSTER******");
        System.out.println("Introduzca la dir. del host: ");
        host = entrada.nextLine();
        System.out.println("Introduzca el usuario: ");
        user = entrada.nextLine();
        System.out.println("Introduzca el password: ");
        passw = entrada.nextLine();
        System.out.println("******DATOS INGRESADOS******");
        System.out.println("HOST: "+host+"\nUser: "+user+"\nPassword:"+passw);
    }
    public void Context(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("******CONTEXTO DEL QUERY******");
        System.out.println("Introduzca el nombre del bucket: ");
        D1= entrada.nextLine();
        System.out.println("Introduzca el nombre del scope: ");
        D2= entrada.nextLine();
        System.out.println("Introduzca el nombre de collection: ");
        D3= entrada.nextLine();
        System.out.println("******CONTEXTO INGRESADO****** ");
        System.out.println("BUCKET: "+D1 +"\nSCOPE: "+D2 + "\nCollection: "+D3);
    }    
    
    public String getHost(){
        return(host);
    } 
    public String getUser(){
        return(user);
    } 
    public String getPassw(){
        return(passw);
    } 
    public String getD1(){
        return(D1);
    } 
    public String getD2(){
        return(D2);
    } 
    public String getD3(){
        return(D3);
    } 
}
  
