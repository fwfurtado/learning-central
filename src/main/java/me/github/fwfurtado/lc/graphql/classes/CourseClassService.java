package me.github.fwfurtado.lc.graphql.classes;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.CourseClass;
import me.github.fwfurtado.lc.exceptions.CourseNotFoundException;
import me.github.fwfurtado.lc.exceptions.InstructorNotFoundException;
import me.github.fwfurtado.lc.graphql.classes.ClassSubscriptionResolver.StudentRegisteredEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.FluxSink;

import java.time.LocalDateTime;
import java.util.UUID;

import static me.github.fwfurtado.lc.graphql.classes.CourseClassMutationResolver.*;

@Service
@AllArgsConstructor
public class CourseClassService {

    private final FindInstructorById instructorRepository;
    private final FindCourseById courseRepository;
    private final FindStudentById studentRepository;
    private final CourseClassRepository repository;
    private final FluxSink<StudentRegisteredEvent> emitter;

    public ClassView createClassBy(ClassInput form) {

        var instructorId = form.getInstructorId();
        var instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new InstructorNotFoundException("Cannot find any instructor with id " + instructorId));

        var courseId = form.getCourseId();
        var course = courseRepository.findById(courseId)
                        .orElseThrow(() -> new CourseNotFoundException("Cannot find any course with id " + courseId));

        var courseClass = new CourseClass(form.getStartDate(), course, instructor);

        repository.save(courseClass);

        return buildView(courseClass);
    }

    @NotNull
    private ClassView buildView(CourseClass courseClass) {
        return new ClassView() {
            @Override
            public UUID getId() {
                return courseClass.getId();
            }

            @Override
            public LocalDateTime getStart() {
                return courseClass.getStart();
            }

            @Override
            public UUID getCourseId() {
                return courseClass.getCourse().getId();
            }

            @Override
            public UUID getInstructorId() {
                return courseClass.getInstructor().getId();
            }
        };
    }

    public ClassView registerStudentBy(StudentRegistrationInput form) {

        var classId = form.getClassId();
        var courseClass = repository.findById(classId).orElseThrow();
        var student = studentRepository.findById(form.getStudentId()).orElseThrow();

        courseClass.registerStudent(student);

        repository.save(courseClass);

        emitter.next(new StudentRegisteredEvent(classId, student));

        return buildView(courseClass);
    }
}
