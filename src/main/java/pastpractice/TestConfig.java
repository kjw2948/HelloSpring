package pastpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public Service testService() {
        return new TestService();
    }

    @Bean
    public Service sampleService() {
        return new SampleService();
    }
}
