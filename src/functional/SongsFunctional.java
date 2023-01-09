package functional;

import Interface.SongsInterface;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class SongsFunctional implements SongsInterface {
    ResultSet rs;
    public  void display(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("select song_name,genre,artist,album from songs");

            System.out.printf("%20s %30s %40s %50s\n\n", "SONG", "GENRE", "ARTIST", "ALBUM");


            while (rs.next()){
                System.out.printf("%20s %30s %40s %50s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
    public void displayArtist(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("select artist from songs  ");

            System.out.printf("%20s \n\n", "ARTIST");


            while (rs.next()){
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
    public void displayArtistSongs(String artistName){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps=con.prepareStatement("select song_name from songs where artist=?");
            ps.setString(1,artistName);
            rs= ps.executeQuery();

            System.out.printf("%20s \n\n", "SONGS BY  "+artistName);


            while (rs.next()){
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
    public void displayAlbum(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("select album from songs  ");

            System.out.printf("%20s \n\n", "ALBUM");


            while (rs.next()){
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
    public void displayAlbumSongs(String albumName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps = con.prepareStatement("select song_name from songs where album=?");
            ps.setString(1, albumName);
            rs = ps.executeQuery();

            System.out.printf("%20s \n\n", "SONGS OF  " + albumName);


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
    public void displayGenre(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("select genre from songs  ");

            System.out.printf("%20s \n\n", "GENRE");


            while (rs.next()){
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
    public void displayGenreSongs(String genreName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps = con.prepareStatement("select song_name from songs where genre=?");
            ps.setString(1, genreName);
            rs = ps.executeQuery();

            System.out.printf("%20s \n\n", "SONGS OF " + genreName);


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
    public String pathName(String songName){
        String pathName="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps = con.prepareStatement("select path_name from songs where song_name=?");
            ps.setString(1, songName);

            rs = ps.executeQuery();
            while (rs.next()) {
                pathName = rs.getString(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pathName;
    }

    public  void play(int song_id,String username){
        Scanner sc=new Scanner(System.in);
        ResultSet rs;

        try{
            while (song_id!=7){
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
                PreparedStatement ps = con.prepareStatement("select path_name from songs where song_id=?");
                ps.setInt(1, song_id);
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
                        System.out.println("P = play, S = pause, R = Reset, Q = Next Z=prev B=back");
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
                            song_id = song_id + 1;
                            if(song_id==7){
                                song_id=1;
                            }
                        }  if (response.equalsIgnoreCase("b")) {
                            Input input=new Input();
                            input.input(username);

                        }if(response.equalsIgnoreCase("z")){

                            clip.close();
                            t.stop();
                           song_id = song_id - 1;
                            play(song_id,username);
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
    public int songid(String songName){
        int song_id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps = con.prepareStatement("select song_id from songs where song_name=?");
            ps.setString(1, songName);

            rs = ps.executeQuery();
            while (rs.next()) {
                song_id = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return song_id;
    }


}
