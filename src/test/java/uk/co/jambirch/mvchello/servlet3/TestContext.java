package uk.co.jambirch.mvchello.servlet3;

import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import uk.co.jambirch.mvchello.service.WarTestService;

@Configuration
public class TestContext {

    @Bean
    public WarTestService warTestService() {
        return Mockito.mock(WarTestService.class);
    }
}