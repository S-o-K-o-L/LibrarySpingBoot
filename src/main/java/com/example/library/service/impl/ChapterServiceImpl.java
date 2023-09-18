package com.example.library.service.impl;

import com.example.library.domain.entity.Chapter;
import com.example.library.repository.ChapterRepository;
import com.example.library.service.ChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChapterServiceImpl implements ChapterService {
    private final ChapterRepository chapterRepository;

    public ChapterServiceImpl(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Chapter> findChapterById(Long id) {
        return chapterRepository.findById(id);
    }

    @Override
    @Transactional
    public Chapter saveChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Chapter> findChapterByNumberAndBookId(Integer number, Long idBook) {
        return chapterRepository.findByNumberAndBookId(number, idBook);
    }

    @Override
    @Transactional
    public Chapter updateChapter(Long id, Chapter chapter) {
        Chapter chapterForUpdate = chapterRepository.findById(id).orElse(new Chapter());
        chapterForUpdate.setNumber(chapter.getNumber());
        chapterForUpdate.setContent(chapter.getContent());
        chapterForUpdate.setBook(chapter.getBook());
        return chapterRepository.save(chapterForUpdate);
    }

    @Override
    @Transactional
    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Chapter> findAllByBookId(Long bookId) {
        return chapterRepository.findChaptersByBookId(bookId).orElse(new ArrayList<>());
    }
}
