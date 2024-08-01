package pastpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    }
}
