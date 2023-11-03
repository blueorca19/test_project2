package ait.album.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Interface {
    boolean addPhoto(Photo photo);
    void setUrl(String url);

    boolean removePhoto(int photoId, int albumId);

    boolean updatePhoto(int photoId, int albumId, String url);

    Photo getPhotoFromAlbum(int photoId, int albumId);

    Photo[] getAllPhotoFromAlbum(int albumId);

    Photo[] getPhotoBetweenDate(LocalDateTime dateFrom, LocalDateTime dateTo);


    int size();
}
