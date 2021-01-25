package com.example.demo.sql.Repo;

import java.util.List;

import com.example.demo.sql.Model.MessagesTable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<MessagesTable, Long> {
    // List<MessagesTable> findByMessage(String message);
}
