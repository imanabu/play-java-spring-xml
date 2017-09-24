package modules;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.guice.module.SpringModule;

// This is not needed if the AnnotationConfig stuff is enabled in spring.xml
// To disable this, look in application.conf

public class MySpringModule extends SpringModule {
    public MySpringModule() {
        super(new AnnotationConfigApplicationContext(AppConfig.class));
    }
}
