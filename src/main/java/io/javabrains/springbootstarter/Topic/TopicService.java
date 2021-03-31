package io.javabrains.springbootstarter.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service  //marks the class as Service--> create a new service and registers it
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    /*
       private List<Topic> topics= new ArrayList<>(Arrays.asList(
                    new Topic("spring", "Spring Framework", "Spring framework Description"),
                    new Topic("Java", "Core Java", "Core Java Description"),
                    new Topic("Javascript", "Javascript", "Javascript Description")
                    // Main method run edilince bu 3 satir json formatta local machinede görülür
                ));
     */

       public List<Topic> getAllTopics(){
           //return topics;
           List<Topic> topics=new ArrayList<>();
           topicRepository.findAll()
                   .forEach(topics::add);
           return topics;
       }

       public Topic getTopic(String id){ //NOT: TopicRepository'de id String olarak tanimlandigi icin!!
           //return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
               //Get ile alinan degerin id'e esit olup olmadigi her seferinde kontrol ediliyor ve ilk topic'i return ediyor
           return topicRepository.findOne(id);
       }


        public void addTopic(Topic topic) {
           topicRepository.save(topic);
        }

        public void updateTopic(String id, Topic topic) {
            topicRepository.save(topic);
        }

        public void deleteTopic(String id) {
           topicRepository.delete(id);
        }
}
