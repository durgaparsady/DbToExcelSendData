package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.helper.Helper;
import com.example.demo.repository.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo repo;
	public ByteArrayInputStream getActualData() throws IOException {
		List<Category> all=repo.findAll();
		
		System.out.println(all);
		ByteArrayInputStream byteArrayInputStream=Helper.DatabaseToExcel(all); 
			return byteArrayInputStream;
	}

}
