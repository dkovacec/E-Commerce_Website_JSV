package com.brigths.Final.Countdown.Project;

import com.brigths.Final.Countdown.Project.service.FileStorageService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalCountdownProjectApplication implements CommandLineRunner {

	@Resource
	FileStorageService fileStorageService;

	public static void main(String[] args) {
		SpringApplication.run(FinalCountdownProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//    storageService.deleteAll();
		fileStorageService.init();
	}
}
