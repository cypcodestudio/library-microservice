package com.cypcode.library_microservice;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hackerrank.test.utility.ResultMatcher;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createBook() throws Exception{
    	String book1 = "{\n"
    			+ "  \"title\": \"Test\",\n"
    			+ "  \"description\": \"Test\",\n"
    			+ "  \"category\": {\n"
    			+ "    \"title\": \"Test\",\n"
    			+ "    \"description\": \"Test\"\n"
    			+ "  },\n"
    			+ "  \"authors\": [\n"
    			+ "    {\n"
    			+ "      \"name\": \"Test\",\n"
    			+ "      \"email\": \"Test\"\n"
    			+ "    }\n"
    			+ "  ]\n"
    			+ "}";
    	 mockMvc.perform(post("/book")
                         .contentType(MediaType.APPLICATION_JSON_UTF8)
                         .content(book1)).andExpect(status().isCreated());
    	 
    	 
    	 
    	 String book2 = "{\n"
     			+ "  \"title\": \"Test2\",\n"
     			+ "  \"description\": \"Test2\",\n"
     			+ "  \"category\": {\n"
     			+ "    \"title\": \"Test2\",\n"
     			+ "    \"description\": \"Test2\"\n"
     			+ "  },\n"
     			+ "  \"authors\": [\n"
     			+ "    {\n"
     			+ "      \"name\": \"Test2\",\n"
     			+ "      \"email\": \"Test2\"\n"
     			+ "    }\n"
     			+ "  ]\n"
     			+ "}";
     	 mockMvc.perform(post("/book")
                          .contentType(MediaType.APPLICATION_JSON_UTF8)
                          .content(book2)).andExpect(status().isCreated());
    }
    
    @Test
    void getAllBooks() throws Exception{
    	 assertTrue(mockMvc.perform(get("/book"))
                                 .andExpect(status().isOk())
                                 .andReturn()
                                 .getResponse()
                                 .getContentAsString(),
                         true);
    }
    
    @Test
    void filterBooksById() throws Exception{
    	 assertTrue(mockMvc.perform(get("/book/filter?id=1"))
                                 .andExpect(status().isOk())
                                 .andReturn()
                                 .getResponse()
                                 .getContentAsString(),
                         true);
    }
    
    @Test
    void deleteBooksById() throws Exception{
    	 mockMvc.perform(MockMvcRequestBuilders.delete("/book?id=1")).andExpect(status().isOk());
    }

}
