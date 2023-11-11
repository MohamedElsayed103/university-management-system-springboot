package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDto;
import com.example.demo.model.CourseDtoForUpdate;
import com.example.demo.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> createCourse(@RequestBody CourseDto courseDto){
      return ResponseEntity.status(201).body(courseService.createCourse(courseDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id){
        return ResponseEntity.ok().body(courseService.getCourseById(id));
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Course> updateCourse(@PathVariable String id ,@RequestBody CourseDtoForUpdate course){
        return ResponseEntity.ok().body(courseService.updateCourse(id , course));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> allCourses(){
        return ResponseEntity.ok().body(courseService.getAllCourses());
    }
}