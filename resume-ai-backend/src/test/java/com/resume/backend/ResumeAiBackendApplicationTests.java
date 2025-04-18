package com.resume.backend;

import com.resume.backend.servie.ResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ResumeAiBackendApplicationTests {

	@Autowired
	private ResumeService resumeService;

	@Test
	void contextLoads() throws IOException {

		resumeService.generateResumeResponse("I am a mayur patil fullstack java developer with two years of experience. ");

	}

}
