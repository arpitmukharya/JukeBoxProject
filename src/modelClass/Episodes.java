package modelClass;

import java.util.Date;

public class Episodes {
    private String podcast_name;
    private String episode_name;
    private Date date;
    private String path_name;
    private int podcast_id;

    public Episodes() {
    }

    public Episodes(String podcast_name, String episode_name, Date date, String path_name, int podcast_id) {
        this.podcast_name = podcast_name;
        this.episode_name = episode_name;
        this.date = date;
        this.path_name = path_name;
        this.podcast_id = podcast_id;
    }

    public String getPodcast_name() {
        return podcast_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public String getEpisode_name() {
        return episode_name;
    }

    public void setEpisode_name(String episode_name) {
        this.episode_name = episode_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPath_name() {
        return path_name;
    }

    public void setPath_name(String path_name) {
        this.path_name = path_name;
    }

    public int getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(int podcast_id) {
        this.podcast_id = podcast_id;
    }

    @Override
    public String toString() {
        return "Episodes{" +
                "podcast_name='" + podcast_name + '\'' +
                ", episode_name='" + episode_name + '\'' +
                ", date=" + date +
                ", path_name='" + path_name + '\'' +
                ", podcast_id=" + podcast_id +
                '}';
    }
}
