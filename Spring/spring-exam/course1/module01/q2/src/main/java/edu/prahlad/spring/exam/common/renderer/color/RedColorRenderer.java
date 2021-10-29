package edu.prahlad.spring.exam.common.renderer.color;

public class RedColorRenderer implements FontColorRenderer{
    @Override
    public String renderer(String text) {
        return "<red-color>" + text + "</red-color>";
    }
}
