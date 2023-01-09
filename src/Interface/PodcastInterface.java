package Interface;

public interface PodcastInterface {
    public  void display();
    void displayPodcast();
    void displayPodcastByCelebrities(String celebrity);
    void play(int podcast_id,String username);
    int podcastid(String podcastName);
}
