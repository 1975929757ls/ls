package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.AskRepository;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.UserRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatRepository chatRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AskRepository askRepository;
    @PostMapping("/add")
    public String addinfo(@RequestBody Chatvalue chatvalue){
        Chat result=new Chat();
        int id=userRepository.findId(chatvalue.getName());
        result.setCid(id);
        result.setInfo(chatvalue.getInfo());
        chatRepository.save(result);
        return "success";
    }
    @GetMapping("/info")
    public List<Chatvalue> findinfo(){
        List<Chat> list=chatRepository.findAll();
        List<Chatvalue> r=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Chatvalue chatvalue=new Chatvalue();
            chatvalue.setInfo(list.get(i).getInfo());
            String name=chatRepository.find(list.get(i).getId());
            chatvalue.setName(name);
            chatvalue.setId(list.get(i).getId());
            r.add(chatvalue);
        }
        return r;
    }
    @GetMapping("/username")
    public List<String> findname(){
        return chatRepository.findname();
    }
    @PostMapping("/addreply")
    public String add(@RequestBody Ask ask){
        System.out.println(ask.toString());
        askRepository.save(ask);
        return "success";
    }
    @GetMapping("/zhan/{name}")
    public List<Allchat> findinfo(@PathVariable("name") String name){
        System.out.println(name);
        int cid=userRepository.findId(name);
        List<Allchat> result=new ArrayList<>();
        List<String> info=chatRepository.findinfo(cid);
        for(int i=0;i<info.size();i++){
            Allchat allchat=new Allchat();
            allchat.setInfo(info.get(i));
            String s=info.get(i);
            String res=askRepository.findreplybyinfo(s);
            allchat.setReply(askRepository.findreplybyinfo(info.get(i)));
            result.add(allchat);
        }
        return result;
    }
}
