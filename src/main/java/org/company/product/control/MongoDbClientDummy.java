package org.company.product.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MongoDbClientDummy {

    private String mongoConnectionString;

    Map<String, String> mongoDB;

    public MongoDbClientDummy(String mongoConnectionString) {
        this.mongoConnectionString = mongoConnectionString;

        //establish connection to mongodb with the mongoConnectionString
        mongoDB = new HashMap<>();
    }

    public Set<String> getPropertyNames() {
        return mongoDB.keySet();
    }

    public String getValue(String key) {
        return mongoDB.get(key);
    }
}
