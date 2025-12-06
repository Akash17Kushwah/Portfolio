package in.bushansirgur.personalportfolio.controller;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("GET /home renders the home view with the page title")
    void homePageRendersWithExpectedTitle() throws Exception {
        mockMvc.perform(get("/home"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(content().string(containsString("Akash Singh - Personal Portfolio")));
    }

    @Test
    @DisplayName("Home page includes key fragment placeholders")
    void homePageIncludesFragments() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(content().string(containsString("Hi there, I'm")))
            .andExpect(content().string(containsString("My Work")))
            .andExpect(content().string(containsString("Get In Touch")));
    }
}

