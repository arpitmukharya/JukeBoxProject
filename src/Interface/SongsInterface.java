package Interface;

public interface SongsInterface {
    public  void display();
    public void displayArtist();
    void displayArtistSongs(String artistName);
    void displayAlbum();
    void displayAlbumSongs(String albumName);
    void displayGenre();
    void displayGenreSongs(String genreName);
    String pathName(String songName);
    void play(int song_id,String username);
    int songid(String songName);
}
