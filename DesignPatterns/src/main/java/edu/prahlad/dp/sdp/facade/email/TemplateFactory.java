package edu.prahlad.dp.sdp.facade.email;

public class TemplateFactory {
    public static Template createTemplateFor(Template.TemplateType type) {
        switch (type) {
            case Email:
                return new OrderEmailTemplate();
            default:
                throw new IllegalArgumentException("Unknown TemplateType");
        }

    }
}
