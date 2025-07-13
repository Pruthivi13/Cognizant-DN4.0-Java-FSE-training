package com.example;

public class MyService {
    private final ExternalApi api;
    private Logger logger;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public MyService(ExternalApi api, Logger logger) {
        this.api = api;
        this.logger = logger;
    }

    public String fetchData() {
        return api.getData();
    }

    public String getDataById(int id) {
        return api.fetchDataById(id);
    }

    public void processAndLog(String input) {
        if (logger != null) {
            logger.log("Processing input: " + input);
        }
    }

    public String getTwoCallsCombined() {
        return api.getData() + " & " + api.getData();
    }

    public String getDataWithConnection() {
        api.connect();
        String data = api.getData();
        api.disconnect();
        return data;
    }

    public void logOrThrow(String message) {
        if (logger != null) {
            logger.log(message);
        }
    }

}
