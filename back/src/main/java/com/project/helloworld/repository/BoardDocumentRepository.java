package com.project.helloworld.repository;


import com.project.helloworld.domain.User;
import com.project.helloworld.elkStack.domain.BoardDocument;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDocumentRepository extends ElasticsearchRepository<BoardDocument, Long> {

  List<BoardDocument> findByTitleContaining(String keyword);
}