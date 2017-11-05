package br.com.rogrs;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import br.com.rogrs.config.Constants;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Inject
    private Environment env;
    
    
    @PostConstruct
    public void initApplication() throws IOException {
        if (env.getActiveProfiles().length == 0) {
            log.warn("No Spring profile configured, running with default configuration");
        } else {
            log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
        }
    }

    public static void main(String[] args) throws UnknownHostException {
    	   SpringApplication app = new SpringApplication(Application.class);
           //app.setShowBanner(false);

           SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

           addDefaultProfile(app, source);
 
           Environment env = app.run(args).getEnvironment();
           log.info("Access URLs:\n----------------------------------------------------------\n\t" +
               "Local: \t\thttp://127.0.0.1:{}\n\t" +
               "External: \thttp://{}:{}\n----------------------------------------------------------",
               env.getProperty("server.port"),
               InetAddress.getLocalHost().getHostAddress(),
               env.getProperty("server.port"));

    }
    
    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }
    }
}
