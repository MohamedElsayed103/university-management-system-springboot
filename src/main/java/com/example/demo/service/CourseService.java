package com.example.demo.service;

import com.example.demo.exceptions.OptionalEmpty;
import com.example.demo.model.Course;
import com.example.demo.model.CourseDto;
import com.example.demo.model.CourseDtoForUpdate;
import com.example.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class CourseService {
    private final CourseRepository courseRepository ;

    public Course createCourse(
            CourseDto courseDto
    ){
        Course c = Course
                .builder()
                .courseName(courseDto.getName())
                .id(courseDto.getId())
                .creditHours(courseDto.getCreditHour())
                .maxStudents(courseDto.getMaxStudents())
                .specialization(courseDto.getSpec())
                .build();
        return courseRepository.save(c);
    }
    public Course updateCourse(String id , CourseDtoForUpdate course)  {

        Optional<Course> course1 = courseRepository.findById(id);
        if (course1.isPresent()){
            Course c = course1.get();

            c.setCourseName(course.getName());
            c.setMaxStudents(course.getMaxStudents());
            c.setSpecialization(course.getSpec());
            c.setCreditHours(course.getCreditHour());
            return courseRepository.save(c);
        }
        else try {
            throw new OptionalEmpty("No such course found");
        } catch (OptionalEmpty e) {
            throw new RuntimeException(e);
        }


    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public Course getCourseById(String id)  {

        Optional<Course> course =courseRepository.findById(id);

        if (course.isPresent())
             return course.get();
        else try {
            throw new OptionalEmpty("No such course found");
        } catch (OptionalEmpty e) {
            throw new RuntimeException(e);
        }
    }
}
