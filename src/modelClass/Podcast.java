package modelClass;

import javax.xml.crypto.Data;


public class Podcast {
    private String speaker;
    private Data date;
    private String podcast_name;

    public Podcast() {
    }

    public Podcast(String speaker, Data date, String podcast_name) {
        this.speaker = speaker;
        this.date = date;
        this.podcast_name = podcast_name;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    public String getPodcast_name() {
        return podcast_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "speaker='" + speaker + '\'' +
                ", date=" + date +
                ", podcast_name='" + podcast_name + '\'' +
                '}';
    }
}
