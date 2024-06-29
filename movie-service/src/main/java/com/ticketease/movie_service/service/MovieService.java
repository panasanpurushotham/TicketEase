package com.ticketease.movie_service.service;

import com.ticketease.movie_service.dto.MovieRequest.MovieRequestDto;
import com.ticketease.movie_service.dto.MovieResponse.MovieResponseDto;
import com.ticketease.movie_service.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie saveMovie(MovieRequestDto dto);
    MovieResponseDto getMovieDetails(Long id);
    List<MovieResponseDto> getAllMovies();
    Movie updateMovie(Long id, MovieRequestDto dto);
    void deleteMovie(Long id);
    List<MovieResponseDto> searchMoviesByTitle(String title);
    List<MovieResponseDto> filterMoviesByGenre(String genre);
    List<MovieResponseDto> filterMoviesByReleaseDate(String startDate, String endDate);
}

