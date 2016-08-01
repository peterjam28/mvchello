package uk.co.jambirch.mvchello.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.co.jambirch.mvchello.servlet3.WarTestRootConfig;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WarTestRootConfig.class})
public class WarTestServiceTest {

    @Autowired
    WarTestService warTestService;

    @Test
    public void testGetDesc()
    {
        assertEquals("Spring MVC Hello World Example", warTestService.getDesc());
    }

    @Test
    public void testGetTitleEmpty()
    {
        assertEquals("Hello World", warTestService.getTitle(""));
    }

    @Test
    public void testGetTitleName()
    {
        assertEquals("Hello fred", warTestService.getTitle("fred"));
    }
}
