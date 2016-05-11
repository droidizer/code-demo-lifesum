package com.lifesumtest.app;

public enum Environment {

    Development(Constants.BASE_URL);

    public static Environment active = Development;
    public final String baseUrl;

    Environment(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private static class Constants {
        public static final String BASE_URL = "https://api.lifesum.com/icebox/v1";
    }

}

