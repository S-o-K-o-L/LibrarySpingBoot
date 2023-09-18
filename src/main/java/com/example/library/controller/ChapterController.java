package com.example.library.controller;

import com.example.library.domain.entity.Chapter;
import com.example.library.service.ChapterService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book/{bookId}/chapter")
@CacheConfig(cacheNames = "chapterCache")
public class ChapterController {
    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping
    @Cacheable
    public List<Chapter> findAllChapter(@PathVariable("bookId") Long bookId) {
        return chapterService.findAllByBookId(bookId);
    }

    @GetMapping("/{id}")
    @Cacheable
    public Optional<Chapter> findChapterById(@PathVariable("id") Long id) {
        return chapterService.findChapterById(id);
    }

    @PostMapping
    @Cacheable(key = "#chapter.number")
    public Chapter saveChapter(@RequestBody Chapter chapter) {
        return chapterService.saveChapter(chapter);
    }

    @PutMapping("/{id}")
    @CachePut(key = "#chapter.number")
    public Chapter updateChapter(@RequestBody Chapter chapter, @PathVariable Long id) {
        return chapterService.updateChapter(id, chapter);
    }

    @DeleteMapping("/{id}")
    @CacheEvict
    public void deleteChapter(@PathVariable("id") Long id) {
        chapterService.deleteChapter(id);
    }
}
