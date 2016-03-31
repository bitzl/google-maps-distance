package com.bitzl.open.data.distance.heatmap.model.api;


public class Detail {
    private String text;
    private Long value;

    public Detail() {}

    public Detail(String text, Long value) {
        setText(text);
        setValue(value);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
