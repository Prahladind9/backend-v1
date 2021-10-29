package edu.prahlad.spring.exam.common.renderer.weight;

public class DefaultFontWeightRenderer implements FontWeightRenderer {
    @Override
    public String renderer(String text) {
        return "<default-weight>" + text + "</default-weight>";
    }
}
