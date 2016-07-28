package uk.co.jambirch.mvchello.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WarTestService {
    public String getDesc() {
        return "Spring MVC Hello World Example";
    }

    public String getTitle(String name) {
        if (StringUtils.isEmpty(name)) {
            return "Hello World";
        } else {
            return "Hello " + name;
        }
    }

}