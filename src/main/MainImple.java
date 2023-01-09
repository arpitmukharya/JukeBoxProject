package main;

import functional.Input;
import functional.JukeBoxException;

public class MainImple {
    public static void main(String[] args) {
        try {

            Input input = new Input();
           String userName= input.login();
            input.input(userName);
        } catch (JukeBoxException e) {
            System.out.println(e.toString());
        }
    }
}
