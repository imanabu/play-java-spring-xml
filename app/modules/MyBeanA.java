package modules;

import com.google.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component
public class MyBeanA {
    @Autowired
    private MyBeanB myBeanB;

    public String getMessage() {
        return myBeanB.getMessage();
    }
}
