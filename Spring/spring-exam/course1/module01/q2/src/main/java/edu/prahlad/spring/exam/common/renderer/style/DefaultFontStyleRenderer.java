package edu.prahlad.spring.exam.common.renderer.style;

public class DefaultFontStyleRenderer implements FontStyleRenderer{
    @Override
    public String renderer(String text) {
        return "<default-style>" + text + "</default-style>";
    }
}
