package me.erano.com.example2;

import me.erano.com.example2.Template.TemplateType;

public class TemplateFactory {

    public static Template createTemplateFor(TemplateType type) {
        switch (type) {
            case Email:
                return new OrderEmailTemplate();
            default:
                throw new IllegalArgumentException("Unknown TemplateType");
        }

    }

}
