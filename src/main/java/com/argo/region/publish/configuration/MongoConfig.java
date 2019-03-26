package com.argo.region.publish.configuration;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@EnableConfigurationProperties(RegionProperties.class)
public class MongoConfig {

    @Autowired
    private RegionProperties properties;

    @Bean
    public MongoMappingContext mongoMappingContext() {
        return new MongoMappingContext();
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder()
                                                                   .connectionsPerHost(properties.getDataSource().getMax())
                                                                   .minConnectionsPerHost(properties.getDataSource().getMin());
        return new SimpleMongoDbFactory(new MongoClientURI(properties.getDataSource().getUri(),builder));
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter() {
        DefaultDbRefResolver refResolver = new DefaultDbRefResolver(this.mongoDbFactory());
        MappingMongoConverter converter = new MappingMongoConverter(refResolver, this.mongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(this.mongoDbFactory(),this.mappingMongoConverter());
    }
}
