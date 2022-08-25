/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.couchbase.couchbaseprogram;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;

/**
 *
 * @author SQL
 */
public class JsonCourse {
    public JsonCourse(Collection collection,String ID,String name,String faculty,int credits){
        JsonObject course = JsonObject.create()
                .put("course-name", name)
                .put("faculty", faculty)
                .put("credit-points", credits);

        collection.upsert(ID, course);
    }
}
