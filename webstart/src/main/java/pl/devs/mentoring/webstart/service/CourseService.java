package pl.devs.mentoring.webstart.service;

import org.springframework.stereotype.Service;
import pl.devs.mentoring.webstart.exception.CourseNotFoundException;
import pl.devs.mentoring.webstart.model.Course;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void initCourses() {
        courses.add(new Course(
                1L,
                "Git basics",
                "John",
                "Tools",
                "Basics of Git version control")
        );
        courses.add(new Course(
                2L,
                "Java concurrency",
                "Marc",
                "Programming",
                "Java multithreading and concurrency")
        );
        courses.add(new Course(
                3L,
                "SQL Procedures",
                "Steven",
                "Programming",
                "Writing performant procedures in SQL")
        );
        courses.add(new Course(
                4L,
                "Algorithm interview prep",
                "Steven",
                "Interview",
                "Solving algorithms")
        );
    }

    public List<Course> getCourses(List<String> categories) {
        return categories != null ? courses.stream()
                    .filter(course -> categories.stream()
                            .anyMatch(category -> course.getCategory().equals(category)))
                    .collect(Collectors.toList())
                : courses;
    }

    public Course getCourse(Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException(id));
    }
}
