package com.example;

public interface ExternalApi {
    String getData();

    String fetchDataById(int id);

    void connect();

    void disconnect();
}
