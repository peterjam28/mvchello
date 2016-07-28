package uk.co.jambirch.mvchello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.co.jambirch.mvchello.service.WarTestService;

import java.util.Map;

@Controller
public class WarTestController {
    private final WarTestService helloWorldService;

    @Autowired
    public WarTestController(WarTestService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping(value = "/")
    public String index(Map<String, Object> model) {
        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());

        return "index";
    }

    @GetMapping(value = "/{name:.+}")
    public String hello(@PathVariable("name") String name, Map<String, Object> model) {
        model.put("title", helloWorldService.getTitle(name));
        model.put("msg", helloWorldService.getDesc());

        return "index";

    }

}