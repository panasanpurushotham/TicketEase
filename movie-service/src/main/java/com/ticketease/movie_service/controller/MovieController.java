package com.ticketease.movie_service.controller;




import com.ticketease.movie_service.dto.MovieRequest.MovieRequestDto;
import com.ticketease.movie_service.dto.MovieResponse.MovieResponseDto;
import com.ticketease.movie_service.entity.Movie;
import com.ticketease.movie_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

    @RestController
    @RequestMapping("/api/movies")
    @CrossOrigin(origins = "http://localhost:4200")
    public class MovieController {

        @Autowired
        private MovieService movieService;

        @PostMapping("/create")
        public ResponseEntity<Void> createMovie(@RequestBody MovieRequestDto requestDto) {
            Movie movie = movieService.saveMovie(requestDto);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(movie.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }

        @GetMapping("/{id}")
        public ResponseEntity<MovieResponseDto> getMovie(@PathVariable Long id) {
            return ResponseEntity.ok(movieService.getMovieDetails(id));
        }

        @GetMapping("/all")
        public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
            return ResponseEntity.ok(movieService.getAllMovies());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieRequestDto requestDto) {
            return ResponseEntity.ok(movieService.updateMovie(id, requestDto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/searchbytitle")
        public ResponseEntity<List<MovieResponseDto>> searchMoviesByTitle(@RequestParam String title) {
            return ResponseEntity.ok(movieService.searchMoviesByTitle(title));
        }

        @GetMapping("/searchbygenre")
        public ResponseEntity<List<MovieResponseDto>> filterMoviesByGenre(@RequestParam String genre) {
            return ResponseEntity.ok(movieService.filterMoviesByGenre(genre));
        }

        @GetMapping("/searchbydate")
        public ResponseEntity<List<MovieResponseDto>> filterMoviesByReleaseDate(@RequestParam String startDate, @RequestParam String endDate) {
            return ResponseEntity.ok(movieService.filterMoviesByReleaseDate(startDate, endDate));
        }
    }


