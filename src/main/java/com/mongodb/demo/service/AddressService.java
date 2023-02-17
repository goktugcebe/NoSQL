package com.mongodb.demo.service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.demo.entities.Address;
import com.mongodb.demo.entities.Employee;
import org.bson.Document;

public class AddressService {

    public void addAddress(MongoCollection<Document> collection) {
        try {
            Employee employee = new Employee("Vaclav",3500);
            Address address = new Address("Mamesti Miru", "Lucemburska", 35, "Praha", "16606");
            address.setEmployee(employee);
            Gson gson = new Gson();
            BasicDBObject dbObject = BasicDBObject.parse(gson.toJson(address));
            Document person = new Document();
            person.append("register1", dbObject);

            collection.insertOne(person);
            System.out.println("Registered successfully");
        }catch (Exception e) {
            System.err.println("Something went wrong while registering");
        }


    }
}
