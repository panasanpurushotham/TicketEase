package com.ticketease.movie_service.service.impl;



import com.ticketease.movie_service.dto.MovieRequest.MovieRequestDto;
import com.ticketease.movie_service.dto.MovieResponse.MovieResponseDto;
import com.ticketease.movie_service.entity.Movie;
import com.ticketease.movie_service.mapper.DtoToEntityMapper;
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

        @Autowired
        DtoToEntityMapper mapper;

        @Autowired
        MovieRepository movieRepository;

        @Override
        public Movie saveMovie(MovieRequestDto dto) {
            Movie movie = mapper.mapToEntity(dto, Movie.class);
            return movieRepository.save(movie);
        }

        @Override
        public MovieResponseDto getMovieDetails(Long id) {
            Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            return mapper.mapToEntity(movie, MovieResponseDto.class);
        }

        @Override
        public List<MovieResponseDto> getAllMovies() {
            return movieRepository.findAll().stream()
                    .map(movie -> mapper.mapToEntity(movie, MovieResponseDto.class))
                    .collect(Collectors.toList());
        }

        @Override
        public Movie updateMovie(Long id, MovieRequestDto dto) {
            Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//            mapper.mapToExistingEntity(dto, movie);
            return movieRepository.save(movie);
        }

        @Override
        public void deleteMovie(Long id) {
            Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            movieRepository.delete(movie);
        }

        @Override
        public List<MovieResponseDto> searchMoviesByTitle(String title) {
            return movieRepository.findByTitleContaining(title).stream()
                    .map(movie -> mapper.mapToEntity(movie, MovieResponseDto.class))
                    .collect(Collectors.toList());
        }

        @Override
        public List<MovieResponseDto> filterMoviesByGenre(String genre) {
            return movieRepository.findByGenre(genre).stream()
                    .map(movie -> mapper.mapToEntity(movie, MovieResponseDto.class))
                    .collect(Collectors.toList());
        }

        @Override
        public List<MovieResponseDto> filterMoviesByReleaseDate(String startDate, String endDate) {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            return movieRepository.findByReleaseDateBetween(start, end).stream()
                    .map(movie -> mapper.mapToEntity(movie, MovieResponseDto.class))
                    .collect(Collectors.toList());
        }
    }


