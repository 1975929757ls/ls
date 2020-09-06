package com.example.demo.repository;

import com.example.demo.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
    @Query(value = "select user.name,user.id,chat.info from user,chat where user.id=chat.cid",nativeQuery = true)
    public List<String> findname();

    @Query(value = "SELECT user.`name` AS username FROM USER ,chat WHERE user.`id`=chat.`cid` and chat.id=?",nativeQuery = true)
    public String find(@Param("id") Integer id);

    @Query(value = "select info from chat where cid=?",nativeQuery = true)
    public List<String> findinfo(@Param("cid")Integer cid);

    @Query(value = "select id from chat where cid=?",nativeQuery = true)
    public List<Integer> findid(@Param("cid")Integer cid);
}
