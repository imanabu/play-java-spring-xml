package services;

import org.springframework.beans.factory.annotation.Autowired;
import play.*;
import play.libs.ws.WSClient;

import javax.inject.Inject;
import javax.inject.Named;

@Named // OK so is @Component
public class MyService {

    final WSClient wsclient;
    final Configuration config;
    final OtherService otherService;

    // @Autowired will not inject any of them
    // Do not activate the Spring facet, it will break
    @Inject // It has to be @Inject
    public MyService(Configuration config,
                     WSClient wsclient, OtherService otherService) {
        this.wsclient = wsclient;
        this.config = config;
        this.otherService = otherService;
        if (wsclient == null) {
            Logger.error("Configuration did not inject");
            throw new ExceptionInInitializerError("Too bad");
        }
        if (config == null) {
            Logger.error("Configuration did not inject");
            throw new ExceptionInInitializerError("Too bad");
        }
        if (otherService == null) {
            Logger.error("OtherService did not inject");
            throw new ExceptionInInitializerError("Too bad");
        }

        Logger.info("MyService is ready for use");
    }

    public String doService() {
        String loc = config.getString("spring.context.location", "");
        return loc;
    }

}
