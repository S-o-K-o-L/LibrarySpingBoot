package com.example.library.repository;

import com.example.library.domain.entity.Chapter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Long> {
    Optional<Chapter> findByNumberAndBookId(Integer number, Long bookId);
    Optional<List<Chapter>> findChaptersByBookId(Long bookId);
}
