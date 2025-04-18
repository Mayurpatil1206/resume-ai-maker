package com.resume.backend.servie;

import java.io.IOException;

public interface ResumeService {

    String generateResumeResponse(String userResumeDescription) throws IOException;
}
