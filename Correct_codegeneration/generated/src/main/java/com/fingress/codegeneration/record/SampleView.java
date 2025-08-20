package com.bsit.codegeneration.record;

public record SampleView(String name, String age) {

    public static class Builder {

        private String name;

        private String age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public SampleView build() {
            return new SampleView(name, age);
        }
    }
}
