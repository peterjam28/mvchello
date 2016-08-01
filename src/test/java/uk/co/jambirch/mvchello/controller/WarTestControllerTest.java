package uk.co.jambirch.mvchello.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import uk.co.jambirch.mvchello.service.WarTestService;
import uk.co.jambirch.mvchello.servlet3.WarTestWebConfig;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WarTestWebConfig.class})
@WebAppConfiguration
public class WarTestControllerTest {

    @Configuration
    static class TestContext
    {
        @Bean
        public WarTestService warTestService() {
            return Mockito.mock(WarTestService.class);
        }
    }

    private MockMvc mockMvc;

    @Autowired
    private WarTestService warTestServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(warTestServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testControllerDefault() throws Exception {
        when(warTestServiceMock.getTitle("")).thenReturn("Default");
        when(warTestServiceMock.getDesc()).thenReturn("WarTest JUnit tests - default");

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("mvchello"))
                .andExpect(forwardedUrl("/mvchello.jsp"))
                .andExpect(model().attribute("title", "Default"))
                .andExpect(model().attribute("msg", "WarTest JUnit tests - default"));

        verify(warTestServiceMock, times(1)).getTitle("");
        verify(warTestServiceMock, times(1)).getDesc();
        verifyNoMoreInteractions(warTestServiceMock);
    }

    @Test
    public void testControllerNamed() throws Exception {
        when(warTestServiceMock.getTitle("world.form")).thenReturn("Named");
        when(warTestServiceMock.getDesc()).thenReturn("WarTest JUnit tests - named");

        mockMvc.perform(get("/world.form"))
                .andExpect(status().isOk())
                .andExpect(view().name("mvchello"))
                .andExpect(forwardedUrl("/mvchello.jsp"))
                .andExpect(model().attribute("title", "Named"))
                .andExpect(model().attribute("msg", "WarTest JUnit tests - named"));

        verify(warTestServiceMock, times(1)).getTitle("world.form");
        verify(warTestServiceMock, times(1)).getDesc();
        verifyNoMoreInteractions(warTestServiceMock);
    }
}