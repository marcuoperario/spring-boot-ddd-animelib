package com.sunognaisda.animelib.application.rest;

import com.sunognaisda.animelib.application.dto.ErrorContent;
import com.sunognaisda.animelib.application.dto.anime.AnimeCreateRequest;
import com.sunognaisda.animelib.application.dto.anime.AnimeResponse;
import com.sunognaisda.animelib.domain.mapper.AnimeMapper;
import com.sunognaisda.animelib.domain.model.Anime;
import com.sunognaisda.animelib.domain.model.Watchlist;
import com.sunognaisda.animelib.domain.service.AnimeService;
import com.sunognaisda.animelib.domain.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/anime")
@CrossOrigin
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @PostMapping("add")
    public void addAnime(@RequestBody Anime anime) {
        animeService.addAnime(anime);
    }

    @GetMapping("")
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

    @GetMapping("{anime_id}")
    public Anime getAnimeById(@PathVariable("anime_id") long animeId) {
        return animeService.getAnimeById(animeId);
    }

    @PutMapping("{anime_id}")
    public void updateAnimeById(@PathVariable("anime_id") long animeId, @RequestBody Anime anime) {
        anime.setId(animeId);
        animeService.updateAnimeById(anime);
    }

    @DeleteMapping("{anime_id}")
    public void deleteAnimeById(@PathVariable("anime_id") long animeId) {
        animeService.deleteAnimeById(animeId);
    }
}
