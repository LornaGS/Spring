package com.qa.mockmvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"classpath:person-schema.sql", "classpath:person-data.sql"})
public class PersonControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception{

        Person newPerson = new Person( "bob", "Builder", 42);
        String newPersonAsJson = this.mapper.writeValueAsString(newPerson);
        RequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/create")
                .content(newPersonAsJson)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Person createdPerson = new Person(1, "bob", "Builder", 42);
        String createdPersonAsJson = this.mapper.writeValueAsString(createdPerson);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdPersonAsJson);

        this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
};

@Test
    void testGet() throws Exception{



      RequestBuilder mockRequest = MockMvcRequestBuilders
              .get("/get/1");


      ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

      Person existingPerson = new Person(1,"Alice", "Engineer", 30);
      String existingPersonAsJson = this.mapper.writeValueAsString(existingPerson);
      ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingPersonAsJson);

      this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);


};

@Test
    void testGetAll() throws Exception {

    RequestBuilder mockRequest = MockMvcRequestBuilders
            .get("/getAll");

    ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
    List<Person> getPerson = new ArrayList<>();
    Person existingPerson = new Person(1, "Alice", "Engineer", 30);
    Person existingPerson2 = new Person(2, "Alice2", "Engineer2", 32);
    getPerson.add(existingPerson);
    getPerson.add(existingPerson2);

    String existingPersonAsJson = this.mapper.writeValueAsString(getPerson);
    ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingPersonAsJson);

    this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

}

@Test
void testNotFound() throws Exception{

        RequestBuilder mockRequest = MockMvcRequestBuilders
                .get("/get/1");
         ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
            Person existingPerson = new Person(1, "Alice", "Engineer", 30);
            String existingPersonAsJson = this.mapper.writeValueAsString(existingPerson);
            ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingPersonAsJson);

             this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

    }

  @Test
  void testDelete() throws Exception{


      RequestBuilder mockRequest = MockMvcRequestBuilders.delete("/remove/1");
      ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
      Person exisitingPerson = new Person(2, "Alice", "Engineer", 30 );

      //convert to json using mapper
      String existingPersonasJson = this.mapper.writeValueAsString(exisitingPerson);

      ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingPersonasJson);

      // this is the test
      this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);


  }

  @Test
    void testUpdate() throws Exception{

      RequestBuilder mockRequest = MockMvcRequestBuilders.patch("/update/1");
      ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
      Person existingPerson = new Person(2, "Alice", "Engineer", 30);

      String existPersonasJson  = this.mapper.writeValueAsString(existingPerson);
      ResultMatcher checkBody = MockMvcResultMatchers.content().json(existPersonasJson) ;

      this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

  }
}


