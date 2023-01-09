package functional;
import modelClass.Playlist;
import modelClass.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JukeBoxTest {
  SongsFunctional s1;
    @BeforeEach
    void setUp(){
         s1=new SongsFunctional();
    }
    @AfterEach
    void tearDown(){
        s1=null;
    }
    @Test
     public void getPath(){
        assertEquals("C:\\Users\\Win\\IdeaProjects\\musicDemo\\New folder\\kesariya.wav.wav",s1.pathName("kesariya"));
        assertEquals("C:\\Users\\Win\\IdeaProjects\\musicDemo\\New folder\\Read All Over - Nathan Moore (1).wav",s1.pathName("read all over"));
    }
    public void getId(){
        assertEquals(2,s1.songid("kesariya"));
        assertEquals(6,s1.songid("srivalli"));
    }
    EpisodesFunctional e1;
    @BeforeEach
    void setUp1(){
        e1=new EpisodesFunctional();
    }
    @AfterEach
    void tearDown1(){
        e1=null;
    }
    @Test
    public void getPathName(){
        assertEquals("C:\\Users\\Win\\IdeaProjects\\JAP_c7_s1_PROJECT_JDBC\\sunriser.wav",e1.pathName("morning talks"));
        assertEquals("C:\\Users\\Win\\IdeaProjects\\JAP_c7_s1_PROJECT_JDBC\\moonriser.wav",e1.pathName("night talks"));
    }
    PlaylistFunctional p1;
    Playlist playlist=new Playlist();
    @BeforeEach
    void setUp2(){
        p1=new PlaylistFunctional();
    }
    @AfterEach
    void tearDown2(){
        p1=null;
    }
    @Test
    public void addSong(){
        assertEquals(1,p1.insertSong(new Playlist("arpit","manali_Trance","kesariya",null,"C:\\Users\\Win\\IdeaProjects\\musicDemo\\New folder\\kesariya.wav.wav")));
        assertEquals(1,p1.insertSong(new Playlist("adarsh","jazzy",null,"positivity","C:\\Users\\Win\\IdeaProjects\\JAP_c7_s1_PROJECT_JDBC\\mindset.wav")));
    }
    PodcastFunctional pd1;
    @BeforeEach
    void  setUp3(){
        pd1=new PodcastFunctional();
    }
    @AfterEach
    void tearDown3(){
        pd1=null;
    }
    @Test
    public void podcastId(){
        assertEquals(1,pd1.podcastid("sunriser"));
        assertEquals(2,pd1.podcastid("moonriser"));
    }
    UsersFunctional u1;
    @BeforeEach
    void setup4(){
        u1=new UsersFunctional();
    }
    @AfterEach
    void tearDown4(){
        u1=null;
    }
    public void addUser(){
        assertEquals(1,u1.insertUser(new Users("Puja",746573847)));
        assertEquals(1,u1.insertUser(new Users("nitin",845645655)));
    }
}
