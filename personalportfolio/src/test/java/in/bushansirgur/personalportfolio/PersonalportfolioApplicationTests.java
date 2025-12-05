package in.bushansirgur.personalportfolio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
class PersonalportfolioApplicationTests {

    @Test
    @DisplayName("Application context loads without issues")
    void contextLoads() {
        // Intentionally left blank - failure means context could not start.
    }

    @Test
    @DisplayName("Main method runs Spring Boot")
    void mainRunsApplication() {
        try (ConfigurableApplicationContext context =
                 org.springframework.boot.SpringApplication.run(
                     PersonalportfolioApplication.class, new String[] {})) {
            assertThat(context).isNotNull();
        }
    }
}

