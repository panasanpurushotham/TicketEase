package com.ticketease.movie_service.mapper;

import com.ticketease.movie_service.dto.MovieRequest.MovieRequestDto;
import com.ticketease.movie_service.dto.MovieResponse.MovieResponseDto;
import com.ticketease.movie_service.entity.Movie;

public class MapperUtil {

    // Convert Movie entity to MovieResponseDto
    public static MovieResponseDto toMovieResponseDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        movieResponseDto.setDirector(movie.getDirector());
        movieResponseDto.setGenre(movie.getGenre());
        movieResponseDto.setDuration(movie.getDuration());
        movieResponseDto.setReleaseDate(movie.getReleaseDate());
        movieResponseDto.setImageUrl(movie.getImageUrl());
        return movieResponseDto;
    }

    // Convert MovieResponseDto to Movie entity
    public static Movie toMovieEntity(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
//        movie.setId(movieRequestDto.getId());
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        movie.setDirector(movieRequestDto.getDirector());
        movie.setGenre(movieRequestDto.getGenre());
        movie.setDuration(movieRequestDto.getDuration());
        movie.setReleaseDate(movieRequestDto.getReleaseDate());
        movie.setImageUrl(movieRequestDto.getImageUrl());
        return movie;
    }

    public static Movie toUpdateMovieEntity(Movie movie, MovieRequestDto dto) {
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setDirector(dto.getDirector());
        movie.setGenre(dto.getGenre());
        movie.setDuration(dto.getDuration());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setImageUrl(dto.getImageUrl());
        return movie;
    }
}
