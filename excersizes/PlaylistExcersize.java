package excersizes;
import java.util.Arrays;

public class PlaylistExcersize {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        Song song = new Song("John Lemon", "Battery", 2);
        Song song2 = new Song("Jonathon Lenon", "The bee let it", 3);
        Song song3 = new Song("Steve Onion", "Mustard is good", 1);

        playlist.addSong(song);
        playlist.addSong(song2);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.printSongs();
        playlist.sortByLength();
        playlist.printSongs();

        playlist.playCurrentSong();
        playlist.playPreviousSong();
        playlist.playNextSong();
        playlist.playNextSong();
        playlist.playNextSong();
        playlist.removeSong(song);
        playlist.playCurrentSong();
    }
}

class Playlist {
    private static int SONGS_SIZE_INCREMENT = 2;

    private Song[] songs = new Song[SONGS_SIZE_INCREMENT];
    private int songsAddI = 0;
    private int songsPlayI = 0;

    public boolean addSong(final Song song){
        if(hasSong(song)){
            System.out.println("Song already exists in playlist");
            return false;
        }

        if(songsAddI == songs.length) expandSongsArr();
        songs[songsAddI] = song;
        songsAddI++;

        System.out.printf("\"%s\" was added to playlist\n", song.title);
        return true;
    }

    public boolean hasSong(final Song song){
        for(Song songInPlaylist : songs){
            if(songInPlaylist == song){
                return true;
            }
        }
        return false;
    }

    private void expandSongsArr(){
        final Song[] newSongsArr = new Song[songs.length + SONGS_SIZE_INCREMENT];

        for(int i = 0; i < songsAddI; i++){
            newSongsArr[i] = songs[i];
        }
        songs = newSongsArr;

        System.out.printf("***Expanded playlist size to %d***\n", songs.length);
    }

    public void playCurrentSong(){
        final Song song = songs[songsPlayI];
        if(song == null){
            System.out.println("Cannot play an empty playlist. Please, add a song.");
            return;
        }

        System.out.printf("Playing \"%s\" by %s\n", song.title, song.artist);
    }

    public void playNextSong(){
        final int newSongsPlayI = songsPlayI + 1;
        if(newSongsPlayI == songsAddI){
            System.out.println("End of the playlist.");
            return;
        }
        songsPlayI = newSongsPlayI;
        playCurrentSong();
    }

    public void playPreviousSong(){
        final int newSongsPlayI = songsPlayI - 1;
        if(newSongsPlayI == -1){
            Song firstSong = songs[songsPlayI];
            System.out.printf(
                "Cannot play a previous song. The song %s is the first song in the playlist.\n",
                firstSong.title
            );
            return;
        }
        songsPlayI = newSongsPlayI;
        playCurrentSong();
    }

    public void removeSong(Song song){
        for(int i = 0; i < songsAddI; i++){
            if(song == songs[i]){
                songs[i] = null;
                if(i <= songsPlayI) {
                    songsPlayI -= 1;
                }
            }
        }

        removeEmptySpaces();
    }

    private void removeEmptySpaces(){
        int moveDifference = 0;
        for(int i = 0; i < songsAddI; i++){
            songs[i + moveDifference] = songs[i];
            if(songs[i] == null){
                moveDifference -= 1;
            }
        }
        if (songsAddI < songs.length){
            songs[songsAddI-1] = null;
        }
        songsAddI += moveDifference;
    }

    public void sortByLength(){
        songsPlayI = 0;
        Arrays.sort(songs, (song1, song2) -> {
            if(song1 == null) return Integer.MAX_VALUE;
            if(song2 == null) return Integer.MIN_VALUE;
            return ((Song) song1).length - ((Song) song2).length;
        });
    }

    public void printSongs(){
        System.out.println(Arrays.toString(songs));
    }
}

class Song {
    final String artist;
    final String title;
    final int length;

    public Song(String artist, String title, int length) {
        this.artist = artist;
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Song)) return false;
        Song compareTo = (Song) obj;
        return (this.artist == compareTo.artist) && (this.title == compareTo.title) && (this.length == compareTo.length);
    }

    @Override
    public String toString() {
        String string = String.format("%s by %s", title, artist);
        return string;
    }
}
