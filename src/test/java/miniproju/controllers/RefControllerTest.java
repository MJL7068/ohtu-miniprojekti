/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.controllers;



import miniproju.models.Reference;
import miniproju.services.ReferenceServiceJpaImpl;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author ilkka
 */
public class RefControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReferenceServiceJpaImpl refService;

    // injects mock or spy fields into tested objects automatically
    @InjectMocks
    private RefController refController;

    @Before
    public void setUp() {
        // initializes fields annotated with Mockito annotations.
        MockitoAnnotations.initMocks(this);
        Reference reference = new Reference("testiviite");

        mockMvc = MockMvcBuilders.standaloneSetup(refController).build();

        when(refService.findWithId(1L)).thenReturn(reference);

    }

    @Test
    public void successfulGetToViewOneRefAddsReferenceToModelAndRenders() throws Exception {

        mockMvc.perform(get("/references/view/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(view().name("references/view"))
                .andExpect(model().attribute("ref", hasProperty("title", is("testiviite"))));

        verify(refService, times(1)).findWithId(1L);
        verifyNoMoreInteractions(refService);
    }

    @Test
    public void newRefIsRendered() throws Exception {
        mockMvc.perform(get("/references/ref_new"))
                .andExpect(status().isOk())
                .andExpect(view().name("references/ref_new"));
    }
    
    @Test
    public void editRefIsRendered() throws Exception {
        mockMvc.perform(get("/references/edit/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(view().name("references/ref_edit"));
    }

    @Test
    public void successfulPostToNewRefCreatesReferenceAndRenders() throws Exception {
        RequestBuilder req = post("/references/ref_new")
                .param("title", "testTitle")
                .param("year", "1")
                .accept(MediaType.ALL);
        
        mockMvc.perform(req)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
        
        verify(refService, times(1)).create(any());
        verifyNoMoreInteractions(refService);
    }
    
    @Test
    public void succesfulPostToEditRefUpdatesReferenceAndRenders() throws Exception {        
        RequestBuilder req = post("/references/{id}/edit", 1L)
                .param("title", "testTitle")
                .param("year", "1")
                .accept(MediaType.ALL);
        
        mockMvc.perform(req)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
        
        verify(refService, times(1)).findWithId(any());
        verify(refService, times(1)).update(any());
        verifyNoMoreInteractions(refService);
    }

}
