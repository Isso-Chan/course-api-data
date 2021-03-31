package io.javabrains.springbootstarter.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //creates an instance
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")   //GET request default olarak aliniyor (method specify edilmezse).
    // Yani Bu methot herhangi bir GET methoduna /topics icin islem yapiyor
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")  //{id} yazarak dinamik yapiliyor, böylelikle her seferinde id degisiyor
    public Topic getTopic(@PathVariable String id){  // @Parhvariable ile "/topics/{id}" icindeki id iliskilendirilmis oluyor
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")  // burada hangi method ile iliskilendirilecegi
    // tarif edilmis oluyor->POST  Yani bu method gelen requstin POST olmasina bakip topics degerine göre islem yapiyor
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){ //id dinamik olacagindan ayni sekilde
        // @Pathvariable buraya eklendi
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
