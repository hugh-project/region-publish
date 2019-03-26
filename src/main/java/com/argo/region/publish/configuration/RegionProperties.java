package com.argo.region.publish.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for region publish service
 */
@ConfigurationProperties("region")
public class RegionProperties {
    /**
     * Response configuration
     */
    private final Response response = new Response();
    public Response getResponse() { return response; }

    /**
     * Data source of region publish service
     */
    private final DataSource dataSource = new DataSource();
    public DataSource getDataSource() { return dataSource; }

    private final MQ mq = new MQ();
    public MQ getMq() { return mq;}

    private final Cache cache = new Cache();
    public Cache getCache() {return cache;}


    /**
     * Configuration properties for region data source
     */
    public static class DataSource {
        /**
         * Uri to MongoDb
         */
        private String uri = "mongodb://localhost:27017/argo-master";
        public void setUri(String uri) { this.uri = uri; }
        public String getUri() { return uri; }

        /**
         * Name of database
         */
        private String database = "argo-master";
        public void setDatabase(String database) { this.database = database; }
        public String getDatabase() { return database; }

        /**
         * Name of region collection
         */
        private String collection = "regions";
        public void setCollection(String collection) { this.collection = collection; }
        public String getCollection() { return collection; }

        private int max = 5000;
        private int min = 5;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    /**
     * Configuration for response
     */
    public static class Response {
        private int max = 1000;
        public int getMax() { return max; }
        public void setMax(int max) { this.max = max; }
    }

    public static class Cache {
        private int time = 60;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public static class MQ {
        private int maxThreads = 10;
        private int maxCount = 50;

        public int getMaxThreads() {
            return maxThreads;
        }

        public void setMaxThreads(int maxThreads) {
            this.maxThreads = maxThreads;
        }

        public int getMaxCount() {
            return maxCount;
        }

        public void setMaxCount(int maxCount) {
            this.maxCount = maxCount;
        }
    }
}
