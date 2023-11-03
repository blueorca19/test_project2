import ait.album.dao.AlbumImpl;
import ait.album.model.Photo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
 
        int albumId = 1;
        int photoId = 1;
        String title = "Photo 1";
        String url = "url1";
        LocalDate date = LocalDate.now();

        // Создаем объект AlbumImpl
        AlbumImpl album = new AlbumImpl(albumId, photoId, title, url, date);

        // Добавляем фотографии
        Photo photo2 = new Photo(1, 2, "Photo 2", "url2", LocalDate.now());
        Photo photo3 = new Photo(1, 3, "Photo 3", "url3", LocalDate.now());

        album.addPhoto(photo2);
        album.addPhoto(photo3);

        // Выводим информацию о фотографиях в альбоме
        System.out.println("Фотографии в альбоме:");
        for (int i = 0; i < album.size; i++) {
            System.out.println(album.photos[i]);
        }

        // Удаляем фотографию
        int photoToRemove = 2;
        int albumIdToRemove = 1;
        album.removePhoto(photoToRemove, albumIdToRemove);

        // Выводим информацию о фотографиях в альбоме после удаления
        System.out.println("Фотографии в альбоме после удаления:");
        for (int i = 0; i < album.size; i++) {
            System.out.println(album.photos[i]);
        }
    }
}
