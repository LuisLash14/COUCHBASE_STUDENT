/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.couchbase.couchbaseprogram;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;

/**
 *
 * @author SQL
 */
public class JsonStudent {
    public JsonStudent(Collection collection,String Id,String name,String fecha){
        JsonArray enrollments = JsonArray.create();//                         
        JsonObject Student = JsonObject.create()
                .put("name",name)
                .put("date-of-birth",fecha)
                .put("Enrollments", enrollments);
        
        collection.upsert(Id,Student);
    }
}
