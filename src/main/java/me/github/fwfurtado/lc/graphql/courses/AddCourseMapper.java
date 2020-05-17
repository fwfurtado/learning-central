package me.github.fwfurtado.lc.graphql.courses;

import me.github.fwfurtado.lc.domain.models.Course;
import me.github.fwfurtado.lc.infra.Mapper;
import org.springframework.stereotype.Component;

import static me.github.fwfurtado.lc.graphql.courses.CourseMutationResolver.*;

@Component
public class AddCourseMapper implements Mapper<CourseInput, Course> {

    @Override
    public Course map(CourseInput input) {
       return new Course(input.getCode(), input.getName(), input.getDescription(), input.getWorkload());
    }

}
