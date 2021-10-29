package edu.prahlad.spring.exam.common.renderer.weight;

public class BoldFontWeightRenderer implements FontWeightRenderer {
    @Override
    public String renderer(String text) {
        return "<italic-weight>" + text + "</italic-weight>";
    }
}
