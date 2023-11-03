package ait.album.test;

import ait.album.dao.AlbumImpl;
import ait.album.model.Interface;
import ait.album.model.Photo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceTest {
    Interface inter;
    Photo[] ph;
    LocalDate now = LocalDate.now();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Создаем объекты для тестирования
        //  inter = new AlbumImpl();
        ph = new Photo[7];
        ph[0] = new Photo(1, 1, "Title1", "URL1", now.minusDays(7));
        ph[1] = new Photo(1, 2, "Title2", "URL2", now.minusDays(6));
        ph[2] = new Photo(1, 3, "Title3", "URL3", now.minusDays(5));
        ph[3] = new Photo(2, 4, "Title4", "URL4", now.minusDays(4));
        ph[4] = new Photo(2, 5, "Title5", "URL5", now.minusDays(3));
        ph[5] = new Photo(1, 6, "Title6", "URL6", now.minusDays(2));
        for (int i = 0; i < ph.length; i++) {
            inter.addPhoto(ph[i]);
        }
    }

    @Test
    public void addPhoto() {
        assertFalse(inter.addPhoto(null));
        assertFalse(inter.addPhoto(ph[1]));
        Photo photo = new Photo(1, 5, "title1", "url5", now.minusDays(3));
        assertTrue(inter.addPhoto(photo));
        assertEquals(7, inter.size());
        photo = new Photo(1,6, "title6", "url6", now.plusDays(5));
        assertFalse(inter.addPhoto(photo));

    }

    @Test
    public void removePhoto(int photoId, int albumId) {
        inter.addPhoto(ph[0]);
        assertTrue(inter.removePhoto(1, 1));
        assertFalse(inter.removePhoto(1, 2));
        assertEquals(5,inter.size());

    }

    @org.junit.jupiter.api.Test
    public void updatePhoto(int photoId, int albumId, String url) {
        inter.addPhoto(ph[0]);
        assertTrue( inter.updatePhoto(1, 1, "url1"));
        assertFalse( inter.updatePhoto(2, 2, "url2"));

    }

    @org.junit.jupiter.api.Test
    void getPhotoFromAlbum() {
        inter.addPhoto(ph[0]);
        assertEquals(ph[0], inter.getPhotoFromAlbum(1, 1));
        assertNull( inter.getPhotoFromAlbum(2, 2));
    }

    @org.junit.jupiter.api.Test
    void getAllPhotoFromAlbum() {
        inter.addPhoto(ph[0]);
        inter.addPhoto(ph[1]);
        assertEquals(2, inter.getAllPhotoFromAlbum(1).length);
    }

    @org.junit.jupiter.api.Test
    void getPhotoBetweenDate() {
        inter.addPhoto(ph[0]);
        inter.addPhoto(ph[1]);
        inter.addPhoto(ph[2]);
        assertEquals(2, inter.getPhotoBetweenDate(now.minusDays(7), now.minusDays(5)).length);
        assertEquals(0, inter.getPhotoBetweenDate(now.minusDays(1), now).length);
    }

    @org.junit.jupiter.api.Test
    void size() {
        inter.addPhoto(ph[0]);
        inter.addPhoto(ph[1]);
        assertEquals(2, inter.size());
    }
}