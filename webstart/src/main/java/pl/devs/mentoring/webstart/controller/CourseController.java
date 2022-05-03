package pl.devs.mentoring.webstart.controller;

import org.springframework.web.bind.annotation.*;
import pl.devs.mentoring.webstart.model.Course;
import pl.devs.mentoring.webstart.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> getCourses(@RequestParam(required = false, value = "category") List<String> categories) {
        return courseService.getCourses(categories);
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }
}
