package functional;

import Interface.UserInterface;
import modelClass.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UsersFunctional implements UserInterface {
    public int insertUser(Users users) {
        int result=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Admin@123");
            PreparedStatement ps = con.prepareStatement("insert into users values(?,?)");
            ps.setString(1,users.getUser_name());
            ps.setLong(2,users.getPh_no());

            result=ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
