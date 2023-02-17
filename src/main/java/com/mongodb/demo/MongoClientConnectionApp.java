package com.mongodb.demo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.demo.service.EmployeeService;
import org.bson.Document;

public class MongoClientConnectionApp {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("firstTry");
            MongoCollection<Document> collection = database.getCollection("movies");
//            AddressService addressService = new AddressService();
//            addressService.addAddress(collection);

            EmployeeService employeeService = new EmployeeService();
//            employeeService.addEmployee(collection);
//            employeeService.addMovies(collection);
            employeeService.getMovies(collection);
        }catch (MongoException me) {
            System.err.println("There is someting wrong with MongoDB configurations: " + me);
        }
    }
}
