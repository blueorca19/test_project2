package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlbumImpl extends Photo {
    private static final int MAX_PHOTOS = 7;
    public ConcretePhoto[] photos;
    public int size;


    public AlbumImpl(int albumId, int photoId, String title, String url, LocalDate date) {
        this.photos = new ConcretePhoto[MAX_PHOTOS];
        this.photos[0] = new ConcretePhoto(albumId, photoId, title, url, date);
        this.size = 1;
    }
    public class ConcretePhoto extends Photo {

        public ConcretePhoto(int albumId, int photoId, String title, String url, LocalDate date) {
            super(albumId, photoId, title, url, date);
        }
    }

    @Override
    public void addPhoto(Photo photo) {
        if (size < MAX_PHOTOS) {
            if (photo instanceof ConcretePhoto) {
                photos[size++] = (ConcretePhoto) photo;
            } else {
                System.out.println("Неправильный тип фотографии. Ожидается ConcretePhoto.");
            }
        } System.out.println("Альбом полон, невозможно добавить больше фотографий.");
    }

        @Override
        public void removePhoto(int photoId, int albumId) {
            for (int i = 0; i < size; i++) {
                if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                    // Сдвигаем оставшиеся элементы влево
                    for (int j = i; j < size - 1; j++) {
                        photos[j] = photos[j + 1];
                    }
                    photos[size - 1] = null;
                    size--;
                    return;
                }
            }
            System.out.println("Фотография с ID " + photoId + " в альбоме с ID " + albumId + " не найдена.");
        }


        @Override
        public void updatePhoto(int photoId, int albumId, String url) {
            for (int i = 0; i < size; i++) {
                if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                    photos[i].setUrl(url);
                    return;
                }
            }
            System.out.println("Фотография с ID " + photoId + " в альбоме с ID " + albumId + " не найдена.");
        }

        @Override
        public Photo getPhotoById(int photoId) {
            for (int i = 0; i < size; i++) {
                if (photos[i].getPhotoId() == photoId) {
                    return photos[i];
                }
            }
            System.out.println("Фотография с ID " + photoId + " не найдена в альбоме.");
            return null;
        }
}


