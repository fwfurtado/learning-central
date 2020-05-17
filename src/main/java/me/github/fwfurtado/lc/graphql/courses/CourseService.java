package me.github.fwfurtado.lc.graphql.courses;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.Course;
import me.github.fwfurtado.lc.graphql.courses.CourseMutationResolver.CourseInput;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    private final AddCourseMapper mapper;
    private final CourseRepository repository;

    public Course createCourseBy(CourseInput form) {
        var course = mapper.map(form);

        repository.save(course);

        return course;
    }
}
