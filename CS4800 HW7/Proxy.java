import java.util.ArrayList;
import java.util.List;

interface SongService {
    SongObject searchById(Integer songID);
    List<SongObject> searchByTitle(String title);
    List<SongObject> searchByAlbum(String album);
    List<SongObject> searchByArtist(String artist);
}

class Spotify implements SongService {
    private ArrayList<SongObject> listOfSongs = new ArrayList<>();
    private static Spotify spotify = null;

    private Spotify(){}

    public static Spotify getInstance() {
        if(spotify == null) {
            spotify = new Spotify();
        }
        return spotify; 
    }


    public void addSong(SongObject song) {
        listOfSongs.add(song);
    }

    public SongObject searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        for(SongObject song : listOfSongs) {
            if(song.getID() == songID) {
                return song;
            }
        }
        return null;
    }

    public List<SongObject> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<SongObject> songsWithTitle = new ArrayList<SongObject>();

        for(SongObject song : listOfSongs) {
            if(song.getTitle().equals(title)) {
                songsWithTitle.add(song);
            }
        }
        return songsWithTitle;
    }
    
    public List<SongObject> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
            } catch (Exception e) {}

        List<SongObject> songsFromAlbum = new ArrayList<SongObject>();

        for(SongObject song : listOfSongs) {
            if(song.getAlbum().equals(album)) {
                songsFromAlbum.add(song);
            }
        }
        return songsFromAlbum;
    }

    public List<SongObject> searchByArtist(String artist) {
        try {
            Thread.sleep(1000);
            } catch (Exception e) {}

        List<SongObject> songsFromArtist = new ArrayList<SongObject>();

        for(SongObject song : listOfSongs) {
            if(song.getArtist().equals(artist)) {
                songsFromArtist.add(song);
            }
        }
        return songsFromArtist;
    }
}

interface SongObject {
    void playSong();
    public Integer getID();
    public String getTitle();
    public String getArtist();
    public String getAlbum();
}

class Song implements SongObject{
    String title;
    String artist;
    String album;
    int duration;
    Integer songID;

    public Song(String title, String artist, String album, int duration, Integer songID) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.songID = songID;
    }

    public void playSong() {
        int seconds = duration % 60;
        int minutes = (duration - seconds) / 60;
        System.out.println(title + " by " + artist + " from the album " + album + " is being played for " + minutes+ " minutes and " + seconds + " seconds");
    }

    public Integer getID() {
        return songID;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }
}

class SongProxy implements SongObject {
    String title;
    String artist;
    String album;
    int duration;
    Integer songID;
    Song song;
    
    public SongProxy(String title, String artist, String album, int duration, Integer songID) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration; 
        this.songID = songID;
    }

    public void playSong() {
        if(song == null) {
            song = new Song(title, artist, album, duration, songID);
        }
        song.playSong();
    }

    public Integer getID() {
        return songID;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }
}
