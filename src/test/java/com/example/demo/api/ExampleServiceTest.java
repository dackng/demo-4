package com.example.demo.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.request.Repository;
import com.example.demo.util.RequestTestMockUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleServiceTest {

	@MockBean
	private Repository repository;
	
	private ExampleService exampleService;
	private List<String> resourceExpected;
	
	@Before
    public void setup() {
		exampleService = new ExampleService(repository);
		resourceExpected = RequestTestMockUtil.getRepresentationsMock();
    }
	
	@Test
	public void givenInput_whenGetRepresentations_thenReturnList() {
		Long input = 105L;
		
        List<String> resource = exampleService.get(input);
		
        Assert.assertEquals(resourceExpected, resource);
	}
}
