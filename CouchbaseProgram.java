/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.couchbase.couchbaseprogram;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.Scope;
import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author SQL CODIGO PARA LLENAR BASE DE DATOS NOSQL  EN COUCHBASE. STUDENT-BUCKET
*/ 
public class CouchbaseProgram {   
    public static void main(String[] args) {                            
// INICIO DEL PROGRAMA
    SelectOpcion select = new SelectOpcion();
    select.ObtenCaso();
    int opcion = select.getCaso(); 
    String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    switch(opcion){
        case 1 -> {
            System.out.println("******OPCION 1 AGREGAR UN ESTUDIANTE******");
            Conexion conectar = new Conexion();
            conectar.Credenciales(); //CREDENCIALES DEL CLUSTER
            conectar.Context(); //CONTEXTO DEL CLUSTER PARA EL QUERY           
            AddStudent student = new AddStudent();
            student.ClavesStudent();// INFORMACION DEL ESTUDIANTE
            Cluster cluster = Cluster.connect(conectar.getHost(),conectar.getUser(),conectar.getPassw());       
            Bucket bucket = cluster.bucket(conectar.getD1());      
            Scope scope = bucket.scope(conectar.getD2());     
            Collection collection1 = scope.collection(conectar.getD3());
            //JsonStudent
            JsonStudent Document1 = new JsonStudent(collection1,student.getId(),student.getClave(),student.getFecha());       
            cluster.disconnect();
        }
        case 2 -> {
            System.out.println("******OPCION 2 AGREGAR UN CURSO******");
            Conexion conectar = new Conexion();
            conectar.Credenciales(); //CREDENCIALES DEL CLUSTER
            conectar.Context(); //CONTEXTO DEL CLUSTER PARA EL QUERY 
            AddCourse curso = new AddCourse(); 
            curso.ClavesCourse(); //INFORMACION DEL CURSO
            Cluster cluster = Cluster.connect(conectar.getHost(),conectar.getUser(),conectar.getPassw());       
            Bucket bucket = cluster.bucket(conectar.getD1());      
            Scope scope = bucket.scope(conectar.getD2());     
            Collection collection1 = scope.collection(conectar.getD3());
            //Json curso
            JsonCourse Document2 = new JsonCourse(collection1,curso.getIdCourse(),curso.getCname(),curso.getCfaculty(),curso.getCcredits());
            cluster.disconnect();
            }
        case 3 -> {
            System.out.println("******OPCION 3 INSCRIBIR A UN CURSO******");
            Conexion conectar = new Conexion();
            conectar.Credenciales(); //CREDENCIALES DEL CLUSTER
            conectar.Context(); //CONTEXTO DEL CLUSTER PARA EL QUERY          
            RecuperarStudent alumno = new RecuperarStudent(); 
            RecuperarCurso curso = new RecuperarCurso(); 
            alumno.getKeysStudent();//SOLICITO DATOS DEL ALUMNO
            curso.getKeysCurso();//SOLICITO DATOS DEL CURSO
            Cluster cluster = Cluster.connect(conectar.getHost(),conectar.getUser(),conectar.getPassw());
            Bucket bucket = cluster.bucket(conectar.getD1());      
            Scope scope = bucket.scope(conectar.getD2());     
            Collection collection1 = scope.collection(conectar.getD3());
            
            JsonObject AlumnoInfo = JsonRecuperarStud(cluster,alumno.getName());           
            JsonObject CursoInfo =  JsonRecuperarCurso(cluster,curso.getName());
            JsonArray enrollments = JsonArray.create();//
            for(int a = 0;a<1;a++ ){
              enrollments.add(JsonObject.create()
                .put("course-id", CursoInfo.getString("id"))
                .put("date-enrolled", currentDate));
            AlumnoInfo.put("Enrollments", enrollments);
            collection1.upsert(AlumnoInfo.getString("id"),AlumnoInfo);//marca  
            }
            //
            cluster.disconnect();
            }
            default -> System.out.println("ESTA OPCION NO EXISTE");
    }                 
    }

    private static JsonObject JsonRecuperarStud(Cluster cluster, String name) {
        final QueryResult result = cluster.query("select META().id, src.* " +
                        "from `student-bucket`.`art-school-scope`.`student-record-collection` src " +
                        "where src.`name` = $name",
                QueryOptions.queryOptions()
                        .parameters(JsonObject.create()
                                .put("name", name)));

        for (JsonObject row : result.rowsAsObject()) {
                System.out.println("Found row: " + row);
            }
        return result.rowsAsObject().get(0);
    }

    private static JsonObject JsonRecuperarCurso(Cluster cluster, String curso) {
        final QueryResult result = cluster.query("select META().id, crc.* " +
                        "from `student-bucket`.`art-school-scope`.`course-record-collection` crc " +
                        "where crc.`course-name` = $courseName",
                QueryOptions.queryOptions()
                        .parameters(JsonObject.create()
                                .put("courseName", curso)));

        for (JsonObject row : result.rowsAsObject()) {
                System.out.println("Found row: " + row);
            }
    return result.rowsAsObject().get(0);
    }
}
