package edu.prahlad.spring.exam.common.renderer.color;

public class DefaultColorRenderer implements FontColorRenderer{
    @Override
    public String renderer(String text) {
        return "<default-color>" + text + "</default-color>";
    }
}
