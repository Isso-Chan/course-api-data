package io.javabrains.springbootstarter.courses;

import io.javabrains.springbootstarter.Topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity // JPA bu classtan olusturulacak instancelerin Relational Database icinde sütun olarak eklenecegini tanimliyor.
public class Course {

    @Id // Table icinde alttaki satiri PRIMARY KEY olarak alacagini bilir.
    private String id;
    private String name;
    private String description;
    @ManyToOne // Bircok kurs topic ile ilskili olabilir. Buna da ManyToOne iliskisi deniyor.    //Bu amacla bu annotation kullaniliyor-->Javax pacakage
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String description, String topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic=new Topic(topicId,"","");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
