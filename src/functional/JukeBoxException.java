package functional;

public class JukeBoxException extends Exception{
    String s;

    public JukeBoxException(String s) {
        this.s = s;
    }

   public String toString(){
        return s;
   }
}
