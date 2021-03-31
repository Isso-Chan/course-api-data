package io.javabrains.springbootstarter.Topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> { //bütün common methodlar bu generic CrudRepository interfac icinde

    //CrudRepository<Calistigimiz Entity class ve type olarak String alir>





}
