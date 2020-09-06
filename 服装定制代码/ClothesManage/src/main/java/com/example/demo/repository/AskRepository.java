package com.example.demo.repository;

import com.example.demo.entity.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AskRepository extends JpaRepository<Ask,Integer> {
    @Query(value = "select reply from chat where id=?",nativeQuery = true)
    public List<String> findask(@Param("id")Integer id);

    @Query(value = "select ask.reply as reply from chat,ask where ask.cid=chat.id and chat.id=?",nativeQuery = true)
    public String findreply(@Param("id")Integer id);

    @Query(value = "select ask.reply as reply from chat,ask where ask.cid=chat.id and chat.info=?",nativeQuery = true)
    public String findreplybyinfo(@Param("info")String info);
}
