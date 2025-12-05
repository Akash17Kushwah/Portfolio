package in.bushansirgur.personalportfolio.templates;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HomeTemplateTest {

    private static final Path TEMPLATE_PATH =
        Path.of("src/main/resources/templates/home.html");

    @Test
    @DisplayName("Home template exists and is readable")
    void templateFileIsPresent() throws IOException {
        assertThat(Files.exists(TEMPLATE_PATH)).isTrue();
        assertThat(Files.isRegularFile(TEMPLATE_PATH)).isTrue();
        assertThat(Files.size(TEMPLATE_PATH)).isGreaterThan(0);
    }

    @Test
    @DisplayName("Home template includes every expected fragment")
    void templateIncludesAllFragments() throws IOException {
        String template = Files.readString(TEMPLATE_PATH);
        List<String> fragments = List.of(
            "fragments/header",
            "fragments/hero",
            "fragments/experience",
            "fragments/about",
            "fragments/projects",
            "fragments/achievements",
            "fragments/contact",
            "fragments/footer"
        );

        fragments.forEach(fragment ->
            assertThat(template)
                .as("Fragment placeholder %s should exist", fragment)
                .contains(fragment)
        );
    }
}

