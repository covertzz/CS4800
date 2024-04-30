import java.util.List;

public class ProxyDriver {
    public void driver() {
        Integer songIdCounter = 0; 

        Spotify spotify = Spotify.getInstance();
        SongObject easy = new SongProxy("Easy", "Le Sserafim", "Easy", 165, songIdCounter++);
        SongObject swanSong = new SongProxy("Swan Song", "Le Sserafim", "Easy", 157, songIdCounter++);
        SongObject smart = new SongProxy("Smart", "Le Sserafim", "Easy", 166, songIdCounter++);
        SongObject weGotSoMuch = new SongProxy("We Got So Much", "Le Sserafim", "Easy", 166, songIdCounter++);
        SongObject lifeAintFair = new SongProxy("Life Ain't Fair, Higher Quality", "King Manyara RFII", "Life Ain't Fair, Higher Quality", 129, songIdCounter++);
        SongObject drown = new SongProxy("Drown", "Weston Estate", "Drown", 181, songIdCounter++);
        SongObject sixty = new SongProxy("Sixty", "Weston Estate", "Maggie Valley", 136, songIdCounter++);
        SongObject pears = new SongProxy("Pears", "Weston Estate", "Maggie Valley", 141, songIdCounter++);
        SongObject stoked = new SongProxy("Stoked", "Weston Estate", "Maggie Valley", 189, songIdCounter++);
        SongObject outside = new SongProxy("Outside", "Weston Estate", "Maggie Valley", 137, songIdCounter++);
        SongObject silence = new SongProxy("Silence", "Weston Estate", "Maggie Valley", 133, songIdCounter++);
        SongObject dasies = new SongProxy("Dasies", "Weston Estate", "Maggie Valley", 203, songIdCounter++);
        spotify.addSong(easy);
        spotify.addSong(swanSong);
        spotify.addSong(smart);
        spotify.addSong(weGotSoMuch);
        spotify.addSong(lifeAintFair);
        spotify.addSong(drown);
        spotify.addSong(sixty);
        spotify.addSong(pears);
        spotify.addSong(stoked);
        spotify.addSong(outside);
        spotify.addSong(silence);
        spotify.addSong(dasies);

        System.out.println("\nPlaying all songs from the album Easy:");
        List<SongObject> easyAlbum = spotify.searchByAlbum("Easy"); 
        for(SongObject song : easyAlbum) {
            song.playSong();
        }

        System.out.println("\nPlaying all songs by Weston Estate:");
        List<SongObject> westonEstateSongs = spotify.searchByArtist("Weston Estate");
        for(SongObject song: westonEstateSongs) {
            song.playSong();
        }

        System.out.println("\nPlaying song ID 4:");
        spotify.searchById(4).playSong();

        System.out.println("\nPlaying all songs with the title Easy:");
        List<SongObject> easySearch = spotify.searchByTitle("Easy"); 
        for(SongObject song : easySearch) {
            song.playSong();
        }

        System.out.println("\nPlaying all songs:");
        easy.playSong();
        swanSong.playSong();
        smart.playSong();
        weGotSoMuch.playSong();
        lifeAintFair.playSong();
        drown.playSong();
        sixty.playSong();
        pears.playSong();
        stoked.playSong();
        outside.playSong();
        silence.playSong();
        dasies.playSong();
    }

    
   
}
