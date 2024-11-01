package vn.thinhtn.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${player.username}")
    private String name;

    @GetMapping("")
    public String hello() {
        return "Hello " + name;
    }
}
