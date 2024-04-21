package com.devsuperior.uri2611;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\n**** SQL NATIVE");
		List<MovieMinDTO> resultProjection = repository.search1("action")
				.stream().map(x -> new MovieMinDTO(x.getId(), x.getName())).toList();
		
		for (MovieMinDTO movieMinDTO : resultProjection) {
			System.out.println(movieMinDTO);
		}
		System.out.println("\n\n");
		
		
		System.out.println("\n**** JPQL");
		List<MovieMinDTO> resultJPQL = repository.search2("action");
		
		for (MovieMinDTO dto : resultJPQL) {
			System.out.println(dto);
		}
		System.out.println("\n\n");
		
		
		
		
	}
}
