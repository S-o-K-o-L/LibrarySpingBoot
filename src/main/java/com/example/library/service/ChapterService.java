package com.example.library.service;

import com.example.library.domain.entity.Book;
import com.example.library.domain.entity.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ChapterService {
    Optional<Chapter> findChapterById(Long id);
    Chapter saveChapter(Chapter chapter);
    Optional<Chapter> findChapterByNumberAndBookId(Integer number, Long idBook);
    Chapter updateChapter(Long id, Chapter chapter);
    void deleteChapter(Long id);
    List<Chapter> findAllByBookId(Long bookId);
}
