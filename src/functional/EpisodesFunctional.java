package functional;

import Interface.EpisodeInterface;

import java.sql.*;

public class EpisodesFunctional implements EpisodeInterface {
    ResultSet rs;
    public String pathName(String episodeName){
        String pathName="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Admin@123");
            PreparedStatement ps = con.prepareStatement("select path_name from episodes where episode_name=?");
            ps.setString(1, episodeName);

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
}
