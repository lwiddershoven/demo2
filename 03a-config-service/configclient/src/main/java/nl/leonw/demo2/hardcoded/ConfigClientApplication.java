package nl.leonw.demo2.hardcoded;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(ConfigClientApplication.class, args);

        var someComponent = ctx.getBean(SomeComponent.class);
        System.out.println(someComponent);

        System.out.println("------The End--------");

    }

}

@Component
class SomeComponent {

    private Environment everythingAndTheKitchenSink;

    private DataSourceProperties dataSourceProperties;
    private Demo2Props demo2Props;

    public SomeComponent(Environment environment, DataSourceProperties dataSourceProperties, Demo2Props demo2Props) {
        this.everythingAndTheKitchenSink = environment;
        this.dataSourceProperties = dataSourceProperties;
        this.demo2Props = demo2Props;
    }

    // Open DataSourceAutoConfiguration
    @Override
    public String toString() {
        return "SomeComponent{\n" +
                ",\n @ConfigurationProperties dataSourceProperties.url=" + dataSourceProperties.getUrl() +
                ",\n @ConfigurationProperties dataSourceProperties.platform=" + dataSourceProperties.getPlatform() +
                ",\n @ConfigurationProperties demo2.one=" + demo2Props.getOne() +
                ",\n @ConfigurationProperties demo2.two=" + demo2Props.getTwo() +
                "\n" +
                ",\n Environment datasource url=" + String.join(",", everythingAndTheKitchenSink.getProperty("spring.datasource.url")) +
                ",\n Environment active profiles=" + String.join(",", everythingAndTheKitchenSink.getActiveProfiles()) +
                "\n}";
    }
}

@Data
@Component // Normally activated with EnableConfigurationProperties
@ConfigurationProperties("demo2")
class Demo2Props {
    private String one = "one";
    private String two;
}