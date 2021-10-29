package edu.prahlad.spring.exam.after;

import edu.prahlad.spring.exam.common.renderer.color.RedColorRenderer;

public class Runner {
    public static void main(String[] args) {
        TextRenderer textRenderer = new TextRenderer.TextRendererBuilder().build();
        textRenderer.render("Default Rendering");

        TextRenderer redRenderer = new TextRenderer.TextRendererBuilder()
                .withFontColorRenderer(new RedColorRenderer())
                .build();
        redRenderer.render("Red Color Rendering");
    }
}
