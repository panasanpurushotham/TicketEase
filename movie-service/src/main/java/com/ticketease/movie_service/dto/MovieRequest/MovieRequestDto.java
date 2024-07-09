
package com.ticketease.movie_service.dto.MovieRequest;

import com.fasterxml.jackson.annotation.*;



import java.time.LocalDate;

public class MovieRequestDto {

        private String title;
        private String description;
        private String director;
        private String genre;
        private int duration; // duration in minutes

    @JsonProperty("release_Date")
    private LocalDate releaseDate; // Assuming date as String for simplicity
    @JsonProperty("image_url")
    private String imageUrl;

        // Getters and Setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }



    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

    @Override
    public String toString() {
        return "MovieRequestDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", releaseDate='" + releaseDate + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}


