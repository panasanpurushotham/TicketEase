package com.ticketease.movie_service.repository;

import com.ticketease.movie_service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByGenre(String genre);
    List<Movie> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
}

