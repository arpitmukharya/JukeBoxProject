package functional;

import Interface.PlaylistInterface;
import modelClass.Playlist;

import java.sql.*;

public class PlaylistFunctional implements PlaylistInterface {
    ResultSet rs;
    public int insertSong(Playlist playlist){
        int result=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Admin@123");
            PreparedStatement ps = con.prepareStatement("insert into playlist values(?,?,?,?,?)");
            ps.setString(1,playlist.getUser_name());
            ps.setString(2,playlist.getPlaylist_name());
            ps.setString(3,playlist.getSong_name());
            ps.setString(4,playlist.getEpisode_name());
            ps.setString(5,playlist.getPath_name());
            result=ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public  void display(String userName){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");

            Statement ps = con.createStatement();
            rs = ps.executeQuery("select user_name,playlist_name,song_name,episode_name from playlist where user_name='"+userName+"'");

            System.out.printf("%20s %30s %40s %50s\n\n", "USER NAME", "PLAYLIST NAME", "SONG NAME", "EPISODE NAME");


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
}
