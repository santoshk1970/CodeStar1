package net.amznsantosh.transform.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import net.amznsantosh.transform.controller.TransformAWSLambdaController;

/**
 * Spring configuration for sample application.
 */
@Configuration
@ComponentScan({ "net.amznsantosh.transform.configuration", 
	             "net.amznsantosh.transform.service"
	           })
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    /**
     * Retrieved from properties file.
     */
    @Value("${HelloWorld.SiteName}")
    private String siteName;

    @Bean
    public TransformAWSLambdaController helloWorld() {
        return new TransformAWSLambdaController(this.siteName);
    }

    /**
     * Required to inject properties using the 'Value' annotation.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
