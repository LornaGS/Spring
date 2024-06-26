//package com.qa.LBG_spring_2;
//// must start or end with a a word 'Test'
//// avoid the templation to call them just 'Test'
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.qa.domain.Cat;
//import org.hibernate.query.results.ResultBuilder;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@SpringBootTest //loads the whole application so we can test it
//@AutoConfigureMockMvc //tells Spring to set up the MockMVC obj
//public class CatControllerIntegrationTest {
//
//    @Autowired // replaces the construtor as Junit doesnt actually instantiate test classes
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper // converts obj to json string so no need to write it out in json format
//
//    //one test per method
//    @Test
//    void testCreate() throws Exception{
//
//            String reqBody = this.mapper.
//
//        //requirements : URL, POST, body, header?
//        //test: body, status code
//
//        Cat toCreate = new Cat(null, "Tiddle","blue",4,"Rt",5)
//
//        ResultBuilder req = MockMvcRequestBuilders.post("/cat/new").content("json").contentType(MediaType.APPLICATION_JSON);
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json("");
//
//        //perform the request and check it
//        this.mvc.perform(req).andExpect(checkStatus).andexpect(checkBody)
//
//    }
//
//
//}
