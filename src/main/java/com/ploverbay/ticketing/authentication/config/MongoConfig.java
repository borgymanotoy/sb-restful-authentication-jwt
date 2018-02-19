package com.ploverbay.ticketing.authentication.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;

@Configuration
@EnableMongoRepositories(basePackages = "com.ploverbay.ticketing.authentication")
@EncryptablePropertySource(name = "EncryptedProperties", value = {"classpath:/profiles/${profile:dev}/db.properties", "classpath:/profiles/${profile:dev}/application.properties"})
public class MongoConfig extends AbstractMongoConfiguration {

    @SuppressWarnings("unused")
    private static final String PROPERTY_NAME_AUTHENTICATION_DATABASE = "spring.data.mongodb.authentication-database";

    @SuppressWarnings("unused")
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.data.mongodb.username";

    @SuppressWarnings("unused")
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.data.mongodb.password";

    private static final String PROPERTY_NAME_DATABASE_NAME = "spring.data.mongodb.database";
    private static final String PROPERTY_NAME_DATABASE_HOST = "spring.data.mongodb.host";
    private static final String PROPERTY_NAME_DATABASE_PORT = "spring.data.mongodb.port";

    @Resource
    private Environment m_environment;


    @Override
    protected String getDatabaseName() {
        return m_environment.getRequiredProperty(PROPERTY_NAME_DATABASE_NAME);
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(m_environment.getRequiredProperty(PROPERTY_NAME_DATABASE_HOST),
                Integer.parseInt(m_environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PORT)));
    }

}