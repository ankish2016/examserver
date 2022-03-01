package com.exam.server;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.exam.server.service.UserService;

@SpringBootApplication 
public class ExamServerApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}
	@Autowired 
    private UserService userService;
	@Override
	public void run(String... args) throws Exception {

	}
}
