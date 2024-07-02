
package com.ticketease.movie_service.dto.MovieRequest;

    public class MovieRequestDto {

        private String title;
        private String description;
        private String director;
        private String genre;
        private int duration; // duration in minutes
        private String releaseDate; // Assuming date as String for simplicity
        private String imageurl;

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

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getImageUrl() {
            return imageurl;
        }

        public void setImageUrl(String imageurl) {
            this.imageurl = imageurl;
        }
    }


