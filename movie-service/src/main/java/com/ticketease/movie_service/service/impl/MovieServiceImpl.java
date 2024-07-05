package com.ticketease.movie_service.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.ticketease.movie_service.dto.MovieRequest.MovieRequestDto;
import com.ticketease.movie_service.dto.MovieResponse.MovieResponseDto;
import com.ticketease.movie_service.entity.Movie;
import com.ticketease.movie_service.mapper.MapperUtil;
import com.ticketease.movie_service.repository.MovieRepository;
import com.ticketease.movie_service.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class MovieServiceImpl implements MovieService {
        private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

        @Autowired
        MovieRepository movieRepository;

        @Override
        public Movie saveMovie(MovieRequestDto dto) {

            Movie movie = MapperUtil.toMovieEntity(dto);
            logger.info(" output " + movie.toString());

            return movieRepository.save(movie);
        }

        @Override
        public MovieResponseDto getMovieDetails(Long id) {
            Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            return MapperUtil.toMovieResponseDto(movie);
        }

        @Override
        public List<MovieResponseDto> getAllMovies() {
            return movieRepository.findAll().stream()
                    .map(movie ->MapperUtil.toMovieResponseDto(movie))
                    .collect(Collectors.toList());
        }

        @Override
        public Movie updateMovie(Long id, MovieRequestDto dto) {
            Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            Movie newmovie = MapperUtil.toUpdateMovieEntity(movie, dto);
            return movieRepository.save(newmovie);
        }

        @Override
        public void deleteMovie(Long id) {
            Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            movieRepository.delete(movie);
        }

        @Override
        public List<MovieResponseDto> searchMoviesByTitle(String title) {
            return movieRepository.findByTitleContaining(title).stream()
                    .map(movie ->MapperUtil.toMovieResponseDto(movie))
                    .collect(Collectors.toList());
        }

        @Override
        public List<MovieResponseDto> filterMoviesByGenre(String genre) {
            return movieRepository.findByGenre(genre).stream()
                    .map(movie -> MapperUtil.toMovieResponseDto(movie))
                    .collect(Collectors.toList());
        }

        @Override
        public List<MovieResponseDto> filterMoviesByReleaseDate(String startDate) {
            LocalDate start = LocalDate.parse(startDate);

            return movieRepository.findByReleaseDate(start).stream()
                    .map(movie ->MapperUtil.toMovieResponseDto(movie))
                    .collect(Collectors.toList());
        }
    }


