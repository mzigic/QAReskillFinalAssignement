package com.projectname.e2e.tests.data.model.common;

public class Platforms {
    public enum Platform {
        ANDROID("Android"), IOS("iOS");

        private final String platform;

        Platform(String platform) {
            this.platform = platform;
        }

        public String getValue() {
            return this.platform;
        }
    }
}
