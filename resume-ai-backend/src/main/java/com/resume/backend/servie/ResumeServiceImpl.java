package com.resume.backend.servie;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
public class ResumeServiceImpl implements ResumeService{

    private ChatClient chatClient;

    public ResumeServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @Override
    public String generateResumeResponse(String userResumeDescription) throws IOException {

        String promptString = this.loadPromptFroFile("resume_prompt.txt");
        String promptContent = this.putValuesToTemplate(promptString,Map.of(
                "userDescription", userResumeDescription
        ));
        Prompt prompt = new Prompt(promptContent);
        String responce = chatClient.prompt(prompt).call().content();
        //modify :
        return responce;
    }

    String loadPromptFroFile(String filename) throws IOException {

        Path path = new ClassPathResource(filename).getFile().toPath();
        return Files.readString(path);

    }

    String putValuesToTemplate(String tamplate, Map<String,String> values) {
        for (Map.Entry<String,String> entry : values.entrySet()) {

            tamplate=tamplate.replace("{" + entry.getKey() + "}", entry.getValue());

        };
        return tamplate;
    }

}
