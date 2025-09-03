package com.bsit.codegeneration.pojo;

public class SampleView {

    private String name;

    private String age;

    public SampleView() {
    }

    public SampleView(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static class Builder {

        private SampleView instance = new SampleView();

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder age(String age) {
            instance.setAge(age);
            return this;
        }

        public SampleView build() {
            return instance;
        }
    }
}
