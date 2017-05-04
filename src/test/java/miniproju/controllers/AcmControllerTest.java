package miniproju.controllers;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author matleino
 */
public class AcmControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private AcmController acmController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(acmController).build();
    }

    @Test
    public void acmWorksWithCorrectUrl() throws Exception {
        String testUrl = "http://dl.acm.org/citation.cfm?id=2380552.2380613&coll=DL&dl=GUIDE&CFID=293493744&CFTOKEN=23554239";
        MvcResult result = mockMvc.perform(get("/acm/" + testUrl)).andReturn();
        
        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("Three Years of Design-based Research to Reform a Software Engineering Curriculum"));
    }
    
    @Test
    public void acmDoesntWorkWithIncorrectUrl() throws Exception {
        String testUrl = "asddasdas";
        RequestBuilder req = get("/acm/" + testUrl)
                .param("id", testUrl);

        mockMvc.perform(req)
                .andExpect(status().is4xxClientError());
    }
    
    @Test
    public void acmDoesntWorkWithEmptyUrl() throws Exception {
        String testUrl = "";
        RequestBuilder req = get("/acm/" + testUrl)
                .param("id", testUrl);

        mockMvc.perform(req)
                .andExpect(status().is4xxClientError());
    }

}
