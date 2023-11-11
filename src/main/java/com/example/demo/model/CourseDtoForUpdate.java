package com.example.demo.model;

import lombok.Data;

@Data
public class CourseDtoForUpdate {
     private String name;
     private String spec;
     private int maxStudents;
     private int creditHour;

}
