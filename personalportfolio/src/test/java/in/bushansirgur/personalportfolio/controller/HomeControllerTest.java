package in.bushansirgur.personalportfolio.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest(name = "GET {0} resolves the home template")
    @ValueSource(strings = {"/", "/home"})
    @DisplayName("Mapped paths resolve the home template")
    void mappedPathsRenderHomeView(String path) throws Exception {
        mockMvc.perform(get(path))
            .andExpect(status().isOk())
            .andExpect(view().name("home"));
    }
}

