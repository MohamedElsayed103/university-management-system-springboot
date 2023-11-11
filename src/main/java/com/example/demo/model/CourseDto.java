package com.example.demo.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class CourseDto {
     private String name;
     private String id;
     private String spec;
     private int maxStudents;
     private int creditHour;

}
