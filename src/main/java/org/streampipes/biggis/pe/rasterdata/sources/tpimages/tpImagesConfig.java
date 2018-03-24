package org.streampipes.biggis.pe.rasterdata.sources.tpimages;

import org.streampipes.config.SpConfig;
import org.streampipes.container.model.PeConfig;

public enum tpImagesConfig implements PeConfig {
    INSTANCE;

    private SpConfig config;
    private final static String HOST = "host";
    private final static String PORT = "port";
    private final static String KAFKA_HOST = "kafka_host";
    private final static String KAFKA_PORT = "kafka_port";

    private final static String SERVICE_ID = "pe/org.streampipes.biggis.pe.rasterdata.sources.tpimages";
    private final static String SERVICE_NAME = "service_name";
    private final static String appName = "Rasterdata-Test-Sources";

    tpImagesConfig() {
        //TUTORIAL: Change this topic to the package name of the project
        config = SpConfig.getSpConfig(SERVICE_ID);
        
        //TUTORIAL: Must be the same as service name in docker-compose file
        config.register(HOST, "rasterdata-adapter", "Hostname for the pe templates project");
        config.register(PORT, 8090, "Port for the pe slack integration");
        config.register(KAFKA_HOST, "kafka", "Host for kafka of the pe sinks project");
        config.register(KAFKA_PORT, 9092, "Port for kafka of the pe sinks project");

        config.register(SERVICE_NAME, appName, "The name of the service");
    }

    public String getHost() {
        return config.getString(HOST);
    }

    public int getPort() {
        return config.getInteger(PORT);
    }

    public String getKafkaHost() {
        return config.getString(KAFKA_HOST);
    }

    public int getKafkaPort() {
        return config.getInteger(KAFKA_PORT);
    }

    public String getKafkaUrl() {
        return getKafkaHost() + ":" + getKafkaPort();
    }

    public static final String iconBaseUrl = tpImagesConfig.INSTANCE.getHost() + "/img";

    public static final String getIconUrl(String pictureName) {
        return iconBaseUrl + "/" + pictureName + ".png";
    }

    @Override
    public String getId() {
        return SERVICE_ID;
    }

    @Override
    public String getName() {
        return config.getString(SERVICE_NAME);
    }

    public String getAppName() {
        return appName;
    }
}
