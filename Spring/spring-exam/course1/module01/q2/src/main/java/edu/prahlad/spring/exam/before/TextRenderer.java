package edu.prahlad.spring.exam.before;

import edu.prahlad.spring.exam.common.renderer.Renderer;
import edu.prahlad.spring.exam.common.renderer.color.FontColorRenderer;
import edu.prahlad.spring.exam.common.renderer.style.FontStyleRenderer;
import edu.prahlad.spring.exam.common.renderer.weight.FontWeightRenderer;

class TextRenderer {
    private final FontStyleRenderer fontStyleRenderer;
    private final FontColorRenderer fontColorRenderer;
    private final FontWeightRenderer fontWeightRenderer;

    public TextRenderer(FontStyleRenderer fontStyleRenderer, FontColorRenderer fontColorRenderer, FontWeightRenderer fontWeightRenderer) {
        this.fontStyleRenderer = fontStyleRenderer;
        this.fontColorRenderer = fontColorRenderer;
        this.fontWeightRenderer = fontWeightRenderer;
    }

    private String applyRendering(String text, Renderer... renderers){
        for (Renderer renderer: renderers){
            text = renderer.renderer(text);
        }

        return text;
    }

    void render(String text){
        String renderedText = applyRendering(text, fontStyleRenderer, fontColorRenderer, fontWeightRenderer);
        System.out.println(renderedText);
    }
}
