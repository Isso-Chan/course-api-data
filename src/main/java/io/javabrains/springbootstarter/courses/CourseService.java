package io.javabrains.springbootstarter.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  //marks the class as Service--> create a new service and registers it
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*
       private List<Topic> topics= new ArrayList<>(Arrays.asList(
                    new Topic("spring", "Spring Framework", "Spring framework Description"),
                    new Topic("Java", "Core Java", "Core Java Description"),
                    new Topic("Javascript", "Javascript", "Javascript Description")
                    // Main method run edilince bu 3 satir json formatta local machinede görülür
                ));
     */

       public List<Course> getAllCourses(String topicId){
           List<Course> courses =new ArrayList<>();
           courseRepository.findByTopicId(topicId)
                   .forEach(courses::add);
           return courses;
       }

       public Course getCourse(String id){ //NOT: TopicRepository'de id String olarak tanimlandigi icin!!
           //return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
               //Get ile alinan degerin id'e esit olup olmadigi her seferinde kontrol ediliyor ve ilk topic'i return ediyor
           return courseRepository.findOne(id);
       }


        public void addCourse(Course course) {
           courseRepository.save(course);
        }

        public void updateCourse(Course course) {
            courseRepository.save(course);
        }

        public void deleteCourse(String id) {
           courseRepository.delete(id);
        }
}
