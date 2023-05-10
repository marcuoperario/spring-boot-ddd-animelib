package com.sunognaisda.animelib.domain.service;

import com.sunognaisda.animelib.domain.model.Anime;
import com.sunognaisda.animelib.domain.model.Watchlist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimeService {
    void deleteAnimeById(Anime anime);
}
