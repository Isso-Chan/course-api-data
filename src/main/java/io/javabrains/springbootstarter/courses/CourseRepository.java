package io.javabrains.springbootstarter.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> { //bütün common methodlar bu generic CrudRepository interfac icinde

    //CrudRepository<Calistigimiz Entity class ve type olarak String alir>

    /*
    //Kurslari NAME property'e göre arayarak getirir.Adinda NAME var !!!
    public List<Course> findByName(String name);

    //Kurslari Decription  property'e göre arayarak getirir.Adinda DECRIPTION var !!!
    public List<Course> findByDescription(String desc);
     */

    //Kurslari TopicId property"e göre bulmayi planladik
    public List<Course> findByTopicId(String topicId);




}
