package com.mongodb.demo.service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.demo.entities.Address;
import com.mongodb.demo.entities.Employee;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

public class EmployeeService {
    public void addEmployee(MongoCollection<Document> collection) {
        try {
            Employee employee = new Employee("Michaela", 4000);
            Address address = new Address("Devijka", "Kamycka", 53, "Praha", "17600");
            employee.setAddress(address);
            Gson gson = new Gson();
            BasicDBObject dbObject = BasicDBObject.parse(gson.toJson(employee));
            Document person2 = new Document();
            person2.append("register2", dbObject);
            collection.insertOne(person2);
            System.out.println("Registered successfully");
        } catch (Exception e) {
            System.err.println("Something went wrong during registration");
        }
    }
    public void addMovies(MongoCollection<Document> collection){

        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("name", "Hard Target")
                    .append("type", "Adventure")
                    .append("actors", Arrays.asList("Cuneyt Arkin", "Tarik Akan", "Kemal Sunal")));
            System.out.println("Registered successfully");
        } catch (MongoException me) {
            System.err.println("Something went wrong during registration: " + me);
        }
    }

    public void getMovies(MongoCollection<Document> collection){

        try {
            FindIterable<Document> iterable = collection.find(eq("adi","Hard Target"));
            MongoCursor<Document> cursor = iterable.iterator();
            while(cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
            System.out.println(collection.find(eq("adi","Hard Target")));
        } catch (MongoException me) {
            System.err.println("Kayıt edilirken hata oluştu: " + me);
        }
    }
}
