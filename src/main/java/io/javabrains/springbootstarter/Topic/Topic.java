package io.javabrains.springbootstarter.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA bu classtan olusturulacak instancelerin Relational Database icinde sütun olarak eklenecegini tanimliyor.
public class Topic {

    @Id // Table icinde alttaki satiri PRIMARY KEY olarak alacagini bilir.
    private String id;
    private String name;
    private String description;

    public Topic() {
    }

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}
