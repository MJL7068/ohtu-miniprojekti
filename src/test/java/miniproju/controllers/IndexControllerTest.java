package miniproju.controllers;

import miniproju.services.ReferenceServiceJpaImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author matleino
 */
public class IndexControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ReferenceServiceJpaImpl refService;

    // injects mock or spy fields into tested objects automatically
    @InjectMocks
    private IndexController indexController;

    @Before
    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }


    @Test
    public void indexIsRendered() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                /*.andExpect(view().name("/"))*/;
    }
    

}
