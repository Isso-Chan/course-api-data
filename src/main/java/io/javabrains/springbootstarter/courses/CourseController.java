package io.javabrains.springbootstarter.courses;

import io.javabrains.springbootstarter.Topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //creates an instance
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")   //GET request default olarak aliniyor (method specify edilmezse).
    // Yani Bu methot herhangi bir GET methoduna /topics icin islem yapiyor
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")  //{id} yazarak dinamik yapiliyor, böylelikle her seferinde id degisiyor
    public Course getCourse(@PathVariable String id){  // @Parhvariable ile "/topics/{id}" icindeki id iliskilendirilmis oluyor
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")  // burada hangi method ile iliskilendirilecegi
    // tarif edilmis oluyor->POST  Yani bu method gelen requstin POST olmasina bakip topics degerine göre islem yapiyor
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){ //id dinamik olacagindan ayni sekilde
        // @Pathvariable buraya eklendi
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
