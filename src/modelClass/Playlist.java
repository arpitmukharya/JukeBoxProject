package modelClass;

public class Playlist {
    private String user_name;
    private String playlist_name;
    private String song_name;
    private String episode_name;
    private String path_name;

    public Playlist() {
    }

    public Playlist(String user_name, String playlist_name, String song_name, String episode_name, String path_name) {
        this.user_name = user_name;
        this.playlist_name = playlist_name;
        this.song_name = song_name;
        this.episode_name = episode_name;
        this.path_name = path_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getEpisode_name() {
        return episode_name;
    }

    public void setEpisode_name(String episode_name) {
        this.episode_name = episode_name;
    }

    public String getPath_name() {
        return path_name;
    }

    public void setPath_name(String path_name) {
        this.path_name = path_name;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "user_name='" + user_name + '\'' +
                ", playlist_name='" + playlist_name + '\'' +
                ", song_name='" + song_name + '\'' +
                ", episode_name='" + episode_name + '\'' +
                ", path_name='" + path_name + '\'' +
                '}';
    }
}
