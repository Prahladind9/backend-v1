package edu.prahlad.spring.exam.common.renderer.style;

public class ItalicFontStyleRenderer implements FontStyleRenderer{
    @Override
    public String renderer(String text) {
        return "<italic-style>" + text + "</italic-style>";
    }
}
