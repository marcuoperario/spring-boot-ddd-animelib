package com.sunognaisda.animelib.domain.repository;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.sunognaisda.animelib.domain.model.Anime;
import com.sunognaisda.animelib.domain.model.Watchlist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE, columnSensing = true)
@DataSet("db/datasets/watchlist.xml")
public class WatchlistRepositoryTests {
    @Autowired
    private WatchlistRepository watchlistRepository;

    @Test
    @Order(1)

    void testGetWatchlistByUserId_ListComplete() {
        long userId = 1;

        List<Anime> watchlist = watchlistRepository.getWatchlistByUserId(userId);

        assertThat(watchlist.size()).isEqualTo(2);
    }
}
