package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.request.Repository;
import com.example.demo.request.Request;

@Service
public class ExampleService {

	Repository repository;
	
	@Autowired
	public ExampleService(Repository repository) {
		this.repository = repository;
	}
	
	public List<String> get(Long end) {
		List<String> array = new ArrayList<>();
		for(int i=1;i<=end;i++) {
			if(isMultiple(i,3) && isMultiple(i,5) && isMultiple(i,7)) {
				array.add("BigBangTheory");
			}else if(isMultiple(i,3) && isMultiple(i,5)) {
				array.add("BigBang");
			}else if(isMultiple(i,3) && isMultiple(i,7)) {
				array.add("BigTheory");
			}else if(isMultiple(i,5) && isMultiple(i,7)) {
				array.add("BangTheory");
			}else if(isMultiple(i, 3)) {
				array.add("Big");
			}else if(isMultiple(i,5)) {
				array.add("Bang");
			}else if(isMultiple(i,7)) {
				array.add("Theory");
			}else {
				array.add(String.valueOf(i));
			}
		}
		repository.save(new Request(end.toString()));
		return array;
	}
	
	private boolean isMultiple(int input, int multiple) {
		return input % multiple == 0;
	}

}
