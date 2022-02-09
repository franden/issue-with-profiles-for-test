package org.company.product.control;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.configuration.ConfigUtils;
import io.quarkus.runtime.configuration.ProfileManager;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigSource;

public class MongoDbConfiguration implements ConfigSource {

    MongoDbClientDummy mongoDbClient;

    public MongoDbConfiguration() {
        System.out.println("MongoDbConfiguration: Active Profile:" + ProfileManager.getActiveProfile());
        Config config = ConfigUtils.configBuilder(true, false, LaunchMode.NORMAL).build();

        mongoDbClient = new MongoDbClientDummy(config.getValue("mongo.connection-string", String.class));
    }

    @Override
    public Set<String> getPropertyNames() {
        return mongoDbClient.getPropertyNames();
    }

    @Override
    public String getValue(String key) {
        return mongoDbClient.getValue(key);
    }

    @Override
    public String getName() {
        return "MongoDbConfiguration";
    }
}
