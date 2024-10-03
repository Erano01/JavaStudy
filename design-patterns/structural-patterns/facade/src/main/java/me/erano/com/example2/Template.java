package me.erano.com.example2;

public abstract class Template {
    public enum TemplateType {Email, NewsLetter};

    public abstract String format(Object obj);
}
