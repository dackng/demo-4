package com.example.demo.api;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.util.FileTestUtil;
import com.example.demo.util.RequestTestMockUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = Controller.class)
public class ControllerTest {

	private static final String ENDPOINT = "/api";
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ExampleService exampleService;
    
    @Test
	public void givenRequest_whenGetRepresentation_thenReturnRepresentationOk() throws Exception {
    	String jsonExpected = FileTestUtil.readFile("/json/getRepresentations.json");
		Long input = 105L;
		
        given(exampleService.get(input))
        	.willReturn(RequestTestMockUtil.getRepresentationsMock());
		
		mockMvc.perform(get(ENDPOINT+"/"+input)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonExpected))
				.andExpect(status().isOk());
	}

    @Test
	public void givenRequest_whenGetRepresentation_thenReturnBadRequest() throws Exception {
    	Long input = null;
		mockMvc.perform(get(ENDPOINT+"/"+input)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
}
