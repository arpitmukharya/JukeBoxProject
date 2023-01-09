package modelClass;

public class Songs {
    private String song_name;
    private String genre;
    private String artist;
    private String album;
    private String path_name;
    private int song_id;

    public Songs() {
    }

    public Songs(String song_name, String genre, String artist, String album, String path_name, int song_id) {
        this.song_name = song_name;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.path_name = path_name;
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPath_name() {
        return path_name;
    }

    public void setPath_name(String path_name) {
        this.path_name = path_name;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "song_name='" + song_name + '\t' +
                ", genre='" + genre + '\t' +
                ", artist='" + artist + '\t' +
                ", album='" + album + '\t' +
                ", path_name='" + path_name + '\t' +
                ", song_id=" + song_id +
                '}';
    }
}
