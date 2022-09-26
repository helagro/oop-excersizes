public class PlaylistExcersize {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        Song song = new Song("John Lemon", "Battery", 300);
        Song song2 = new Song("Jonathon Lenon", "The bee let it", 300);
        Song song3 = new Song("Steve Onion", "Mustard is good", 300);

        playlist.addSong(song);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.playCurrentSong();
    }
}

class Playlist {
    private Song[] songs = new Song[10];
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
        final Song[] newSongsArr = new Song[songs.length + 10];

        for(int i = 0; i <= songsAddI; i++){
            newSongsArr[i] = songs[i];
        }
        songs = newSongsArr;
    }

    public void playCurrentSong(){
        final Song song = songs[songsPlayI];
        if(song == null){
            System.out.println("Cannot play an empty playlist. Please, add a song.");
        }

        System.out.printf("Playing %s by %s\n", song.title, song.artist);
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
}
