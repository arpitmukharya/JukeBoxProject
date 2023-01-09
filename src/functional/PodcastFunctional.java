package functional;

import Interface.PodcastInterface;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class PodcastFunctional implements PodcastInterface {
    ResultSet rs;
    public  void display(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("select p.speaker,p.podcast_name,e.date from podcast p join episodes e where p.podcast_name=e.podcast_name;");

            System.out.printf("%20s %30s %40s  \n\n", "SPEAKER", "PODCAST NAME","DATE");


            while (rs.next()){
                System.out.printf("%20s %30s %40S \n", rs.getString(1),  rs.getString(2),rs.getDate(3));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public  void displayPodcast(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("select p.speaker,p.podcast_name,e.episode_name from podcast p join episodes e where e.podcast_name=p.podcast_name");

            System.out.printf("%20s %30s %40s \n\n", "SPEAKER", "PODCAST_NAME","EPISODE NAME");


            while (rs.next()){
                System.out.printf("%20s %30s %40S\n", rs.getString(1), rs.getString(2),rs.getString(3));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public  void displayPodcastByCelebrities(String celebrity){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps = con.prepareStatement("select podcast_name from podcast where speaker=?");
            ps.setString(1, celebrity);
            rs = ps.executeQuery();

            System.out.printf("%20s \n\n", "PODCAST OF " + celebrity);


            while (rs.next()) {
                System.out.printf("%20s \n", rs.getString(1));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public  void play(int podcast_id,String userName){
        Scanner sc=new Scanner(System.in);
        ResultSet rs;

        try{
            while (podcast_id!=6){
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
                PreparedStatement ps = con.prepareStatement("select path_name from episodes where podcast_id=?");
                ps.setInt(1, podcast_id);
                rs = ps.executeQuery();
                while( rs.next()) {
                    String response = "";

                    File file = new File(rs.getString(1));
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    int delay=1000;

                    long length = (clip.getMicrosecondLength() / 1000);
                    Timer t= new Timer(delay, new ActionListener() {
                        private long time=length;

                        public void actionPerformed(ActionEvent e) {
                            if (time>=0){
                                long s=((time/1000)%60);
                                long m=((time/1000)/60%60);
                                long h=((((time/1000)/60)/60)%60);
                                System.out.print("\r"+h+":"+m+":"+s);
                                time-=1000;
                            }

                        }
                    });


                    while (!response.equals("Q")) {
                        System.out.println("P = play, S = pause, R = Reset, Q = Next, Z=Prev B=Back ");
                        System.out.print("Enter your choice: ");
                        response = sc.next();
                        response = response.toUpperCase();
                        if (response.equalsIgnoreCase("p")) {
                            clip.start();
                            t.start();


                        }  if (response.equalsIgnoreCase("s")) {
                            clip.stop();
                            t.stop();
                        }  if (response.equalsIgnoreCase("r")) {
                            clip.setMicrosecondPosition(0);
                        }  if (response.equalsIgnoreCase("q")) {

                            clip.close();
                            t.stop();
                            podcast_id = podcast_id + 1;
                            if(podcast_id==6){
                                podcast_id=1;
                            }
                        }  if (response.equalsIgnoreCase("b")) {
                               Input input=new Input();
                               input.input(userName);
                        } if(response.equalsIgnoreCase("z")){

                            clip.close();
                            t.stop();
                            podcast_id = podcast_id - 1;
                            play(podcast_id,userName);
                        }


                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (JukeBoxException e){
            System.out.println(e.toString());
        }
    }
    public int podcastid(String podcastName){
        int podcast_id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps = con.prepareStatement("select podcast_id from episodes where podcast_name=?");
            ps.setString(1, podcastName);

            rs = ps.executeQuery();
            while (rs.next()) {
                podcast_id = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return podcast_id;
    }


}
