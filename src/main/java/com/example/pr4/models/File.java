package com.example.pr4.models;

import lombok.Data;

import java.io.InputStream;

@Data
public class File {
    String id;
    private String title;
    private InputStream stream;
}
