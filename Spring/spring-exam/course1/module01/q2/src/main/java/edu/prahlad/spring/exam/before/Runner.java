package edu.prahlad.spring.exam.before;

import edu.prahlad.spring.exam.common.renderer.color.DefaultColorRenderer;
import edu.prahlad.spring.exam.common.renderer.color.RedColorRenderer;
import edu.prahlad.spring.exam.common.renderer.style.DefaultFontStyleRenderer;
import edu.prahlad.spring.exam.common.renderer.weight.DefaultFontWeightRenderer;

public class Runner {
    public static void main(String[] args) {
        TextRenderer textRenderer =  new TextRenderer(new DefaultFontStyleRenderer(), new DefaultColorRenderer(), new DefaultFontWeightRenderer());
        textRenderer.render("Default Rendering");

        TextRenderer redRenderer =  new TextRenderer(new DefaultFontStyleRenderer(), new RedColorRenderer(), new DefaultFontWeightRenderer());
        redRenderer.render("Red Color Rendering");
    }
}
