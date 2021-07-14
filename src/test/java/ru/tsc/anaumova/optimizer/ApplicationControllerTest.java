package ru.tsc.anaumova.optimizer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.tsc.anaumova.optimizer.component.Bootstrap;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = TestConfig.class)
public class ApplicationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private Bootstrap bootstrap;

    @Before
    public void init() {
        bootstrap = mock(Bootstrap.class);
        doNothing().when(bootstrap).startOptimize(new ArrayList<>(), new Safe(10));
    }


    @Test
    public void getItemsListTest() throws Exception {
        final String jsonString = "[{\"title\": \"item - 1\", \"size\": \"10\", \"cost\": \"100\"}]";

        mockMvc.perform(post("/get-items")
                .param("itemsString", jsonString)
                .param("safeCapacity", "10"))
                .andExpect(status().isOk());

    }

}
