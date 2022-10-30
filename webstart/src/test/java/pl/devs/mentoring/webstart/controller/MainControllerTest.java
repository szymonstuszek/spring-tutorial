package pl.devs.mentoring.webstart.controller;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class MainControllerTest {


    @Autowired
    private MainController mainController;

    @Test
    void test1() throws Exception {

        String expectedString = "Hi";

        //when

        //then
        assertThat(mainController.test().equals(expectedString));
    }
}