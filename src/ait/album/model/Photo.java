package ait.album.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public abstract class Photo {
    protected int albumId;
    protected int photoId;
    private String title;
    private String url;
    private LocalDate date;
    public Photo(int albumId, int photoId, String title, String url, LocalDate date) {
        this.photoId = photoId;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.date = date;
    }


    public int getAlbumId() {
        return albumId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return albumId == photo.albumId && photoId == photo.photoId && Objects.equals(title, photo.title) && Objects.equals(url, photo.url) && Objects.equals(date, photo.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, photoId, title, url, date);
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Photo{" +
                "albumId=" + albumId +
                ", photoId=" + photoId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

}



