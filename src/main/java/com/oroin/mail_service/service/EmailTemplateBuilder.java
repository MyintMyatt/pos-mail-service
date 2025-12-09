package com.oroin.mail_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailTemplateBuilder {

    private final SpringTemplateEngine engine;

    public String buildEmailTemplateThymleaf(String bodyHtml) {
        Context ctx = new Context();
        ctx.setVariable("body", bodyHtml);

        return engine.process("layout/base-email", ctx);
    }

    public String buildEmailTemplatePure(String bodyHtml) {

        try {
            String template = new String(
                    getClass().getResourceAsStream("/templates/otp-email-template.html").readAllBytes()
            );

            // Replace placeholder with body HTML
            return template.replace("{{body}}", bodyHtml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
