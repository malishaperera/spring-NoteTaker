package lk.ijse.note.notetaker.config;


import jdk.jfr.Enabled;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.note.notetaker")
@EnableWebMvc
public class WebAppConfig {

}
