package com.ticketease.movie_service.service.impl;

import com.ticketease.movie_service.dto.MovieRequest.MovieRequestDto;
import com.ticketease.movie_service.dto.MovieResponse.MovieResponseDto;
import com.ticketease.movie_service.entity.Movie;
import com.ticketease.movie_service.mapper.MapperUtil;
import com.ticketease.movie_service.repository.MovieRepository;
import com.ticketease.movie_service.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private JmsTemplate jmsTemplate;


    @Override
    @Transactional
    public Movie saveMovie(MovieRequestDto dto) {
        Movie movie = MapperUtil.toMovieEntity(dto);
        logger.info("Saving movie: {}", movie);

        movie = movieRepository.save(movie);

        // Send message with movie ID to JMS queue
        sendMovieIdToQueue(movie.getId());

        return movie;
    }

    @Override
    public MovieResponseDto getMovieDetails(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return MapperUtil.toMovieResponseDto(movie);
    }

    @Override
    public List<MovieResponseDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(MapperUtil::toMovieResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Movie updateMovie(Long id, MovieRequestDto dto) {
        Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Movie updatedMovie = MapperUtil.toUpdateMovieEntity(movie, dto);
        return movieRepository.save(updatedMovie);
    }

    @Override
    @Transactional
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        movieRepository.delete(movie);
    }

    @Override
    public List<MovieResponseDto> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title).stream()
                .map(MapperUtil::toMovieResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieResponseDto> filterMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre).stream()
                .map(MapperUtil::toMovieResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieResponseDto> filterMoviesByReleaseDate(String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        return movieRepository.findByReleaseDate(start).stream()
                .map(MapperUtil::toMovieResponseDto)
                .collect(Collectors.toList());
    }

    private void sendMovieIdToQueue(Long movieId) {
        jmsTemplate.convertAndSend("movieQueue", movieId.toString());
        logger.info("Sent movie ID {} to JMS queue", movieId);
    }
}
