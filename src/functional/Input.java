package functional;

import modelClass.Playlist;
import modelClass.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    SongsFunctional songsFunctional = new SongsFunctional();
    PodcastFunctional podcastFunctional = new PodcastFunctional();
    PlaylistFunctional playlistFunctional=new PlaylistFunctional();
   UsersFunctional usersFunctional=new UsersFunctional();
   EpisodesFunctional episodesFunctional=new EpisodesFunctional();

   public String login() throws JukeBoxException {
       String userNameUni = "";
       String userName = "";
       System.out.println("JUKE BOX!!");
       System.out.println();
       System.out.println("1)NEW LOGIN  2)EXISTING USER");
       int login = sc.nextInt();
       if (login == 1) {
           System.out.println("ENTER THE USER NAME");
           sc.nextLine();
           userName = sc.nextLine();
           System.out.println("ENTER PHONE NUMBER");
           long ph_no = sc.nextLong();
           Users users = new Users(userName, ph_no);
           int flash = usersFunctional.insertUser(users);
           if (flash > 0) {
               System.out.println("USER REGISTERED");
           }

       } else {

           System.out.println("ENTER THE USER NAME");
           sc.nextLine();
           userNameUni = sc.nextLine();

       }
       return userNameUni;
   }

    public void input(String userNameUni) throws JukeBoxException{


            try {

                int k1=1;
                do {


                    System.out.println("1)HOMEPAGE   2)CATALOG    3)CREATE CATALOG   4)CREATE PLAYLIST  5)MY PLAYLIST 6)EXIT");
                    int choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            songsFunctional.display();
                            System.out.println("\n");
                            podcastFunctional.display();
                            System.out.println("TO LISTEN  PRESS 1)SONGS  2)PODCAST 3) MAIN MENU");
                            int input6= sc.nextInt();
                            if(input6==1) {
                                System.out.println("ENTER THE SONG NAME: ");
                                sc.nextLine();
                                String song_name = sc.nextLine();
                                int song_id = songsFunctional.songid(song_name);
                                songsFunctional.play(song_id,userNameUni);
                            } else if (input6==2) {
                                System.out.println("ENTER PODCAST NAME");
                                sc.nextLine();
                                String podcast_name=sc.nextLine();
                                int podcast_id=podcastFunctional.podcastid(podcast_name);
                                podcastFunctional.play(podcast_id,userNameUni);
                            } else if (input6==3) {
                                input(userNameUni);
                            }
                            break;

                        case 2:
                            System.out.println("1)SONGS   2)PODCAST");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1) {
                                System.out.println("1)ARTIST  2)ALBUM  3)GENRE");
                                int choice3 = sc.nextInt();
                                switch (choice3) {
                                    case 1:
                                        songsFunctional.displayArtist();
                                        System.out.println("ENTER ARTIST NAME");
                                        sc.nextLine();
                                        String artistName = sc.nextLine();
                                        artistName = artistName.toLowerCase();
                                        songsFunctional.displayArtistSongs(artistName);
                                        System.out.println("ENTER THE SONG NAME: ");
                                        String song_name = sc.nextLine();
                                        int song_id = songsFunctional.songid(song_name);
                                        songsFunctional.play(song_id,userNameUni);
                                        break;
                                    case 2:
                                        songsFunctional.displayAlbum();
                                        System.out.println("ENTER ALBUM NAME");
                                        sc.nextLine();
                                        String albumName = sc.next();
                                        songsFunctional.displayAlbumSongs(albumName);
                                        System.out.println("ENTER THE SONG NAME: ");
                                         song_name = sc.nextLine();
                                         song_id = songsFunctional.songid(song_name);
                                        songsFunctional.play(song_id,userNameUni);
                                        break;
                                    case 3:
                                        songsFunctional.displayGenre();
                                        System.out.println("ENTER GENRE NAME");
                                        sc.nextLine();
                                        String genreName = sc.nextLine();
                                        songsFunctional.displayGenreSongs(genreName);
                                        System.out.println("ENTER THE SONG NAME: ");
                                        song_name = sc.nextLine();
                                         song_id = songsFunctional.songid(song_name);
                                        songsFunctional.play(song_id,userNameUni);
                                        break;
                                    default:throw new JukeBoxException("INVALID INPUT");

                                }

                            }else
                            if (choice2 == 2) {
                                System.out.println("1)PODCAST  2)PODCAST BY CELEBRITY");
                                int choice4 = sc.nextInt();
                                if (choice4 == 1) {
                                    podcastFunctional.displayPodcast();
                                    System.out.println("ENTER PODCAST NAME");
                                    sc.nextLine();
                                    String podcast_name=sc.nextLine();
                                    int podcast_id=podcastFunctional.podcastid(podcast_name);
                                    podcastFunctional.play(podcast_id,userNameUni);
                                } else if (choice4 == 2) {
                                    podcastFunctional.displayPodcast();
                                    System.out.println("SELECT THE CELEBRITY");
                                    sc.nextLine();
                                    String celebrityName = sc.nextLine();
                                    podcastFunctional.displayPodcastByCelebrities(celebrityName);
                                    System.out.println("ENTER PODCAST NAME");
                                    String podcast_name=sc.nextLine();
                                    int podcast_id=podcastFunctional.podcastid(podcast_name);
                                    podcastFunctional.play(podcast_id,userNameUni);
                                }else throw new JukeBoxException("INVALID INPUT");

                            }
                            break;
                        case 3:
                            int i = 1;
                            List<String> newList = new ArrayList<>();
                            do {
                                System.out.println("ENTER THE CONTENT 1)ALBUM 2)ARTIST 3)GENRE 4)PODCAST");
                                String arr = sc.next();
                                System.out.println("DO YOU WANT TO ADD MORE? PRESS 1 TO CONTINUE AND PRESS ANY NUMBER FOR LISTEN");
                                i = sc.nextInt();
                                newList.add(arr);
                            } while (i == 1);
                            for (int k = 0; k < newList.size(); k++) {
                                if (newList.get(k).equalsIgnoreCase("album")) {
                                    songsFunctional.displayAlbum();
                                    System.out.println("ENTER ALBUM NAME");
                                    String albumName = sc.next();
                                    songsFunctional.displayAlbumSongs(albumName);
                                } else if (newList.get(k).equalsIgnoreCase("artist")) {
                                    songsFunctional.displayArtist();
                                    System.out.println("ENTER ARTIST NAME");
                                    String artistName = sc.next();
                                    artistName = artistName.toLowerCase();
                                    songsFunctional.displayArtistSongs(artistName);
                                } else if (newList.get(k).equalsIgnoreCase("genre")) {
                                    songsFunctional.displayGenre();
                                    System.out.println("ENTER GENRE NAME");
                                    String genreName = sc.next();
                                    songsFunctional.displayGenreSongs(genreName);
                                } else if (newList.get(k).equalsIgnoreCase("podcast")) {
                                    System.out.println("1)PODCAST  2)PODCAST BY CELEBRITY");
                                    int choice4 = sc.nextInt();
                                    if (choice4 == 1) {
                                        podcastFunctional.displayPodcast();
                                    } else if (choice4 == 2) {
                                        podcastFunctional.displayPodcast();
                                        System.out.println("SELECT THE CELEBRITY");
                                        sc.nextLine();
                                        String celebrityName = sc.nextLine();
                                        podcastFunctional.displayPodcastByCelebrities(celebrityName);
                                    }
                                }
                            }
                                    System.out.println("TO LISTEN  PRESS 1)SONGS  2)PODCAST 3) MAIN MENU");
                                     input6= sc.nextInt();
                                    if(input6==1) {
                                        System.out.println("ENTER THE SONG NAME: ");
                                        sc.nextLine();
                                        String song_name = sc.nextLine();
                                        int song_id = songsFunctional.songid(song_name);
                                        songsFunctional.play(song_id,userNameUni);
                                    } else if (input6==2) {
                                        System.out.println("ENTER PODCAST NAME");
                                        sc.nextLine();
                                        String podcast_name=sc.nextLine();
                                        int podcast_id=podcastFunctional.podcastid(podcast_name);
                                        podcastFunctional.play(podcast_id,userNameUni);
                                    } else if (input6==3) {
                                        input(userNameUni);
                                    }


                            break;
                        case 4:
                            System.out.println("ENTER THE PLAYLIST NAME");
                            sc.nextLine();
                            String playListName = sc.nextLine();


                            songsFunctional.display();
                            System.out.println();
                            podcastFunctional.displayPodcast();
                            int i1 = 1;
                            int response = 0;

                            do {
                                System.out.println("CHOOSE TO ADD 1)SONGS  2)PODCAST");
                                int choice5 = sc.nextInt();
                                if (choice5 == 1) {
                                    System.out.println("ENTER SONG NAME");
                                    sc.nextLine();
                                    String songName = sc.nextLine();
                                    String pathName = songsFunctional.pathName(songName);
                                    Playlist playlist = new Playlist(userNameUni, playListName, songName, null, pathName);
                                    response = playlistFunctional.insertSong(playlist);
                                    if (response > 0) {
                                        System.out.println("SONG ADDED");
                                    }

                                } else if (choice5 == 2) {
                                    System.out.println("ENTER EPISODE NAME");
                                    sc.nextLine();
                                    String episodeName = sc.nextLine();
                                    String pathName = episodesFunctional.pathName(episodeName);
                                    Playlist playlist = new Playlist(userNameUni, playListName, null, episodeName, pathName);
                                    response = playlistFunctional.insertSong(playlist);
                                    if (response > 0) {
                                        System.out.println("PODCAST ADDED");
                                    }


                                }
                                System.out.println("DO YOU WANT TO ADD MORE? PRESS 1 TO CONTINUE O FOR HOMEPAGE");
                                i1 = sc.nextInt();

                            } while (i1 == 1);
                            input(userNameUni);
                            break;
                        case 5:

                            playlistFunctional.display(userNameUni);
                            System.out.println("TO LISTEN  PRESS 1)SONGS  2)PODCAST 3) MAIN MENU");
                             input6= sc.nextInt();
                            if(input6==1) {
                                System.out.println("ENTER THE SONG NAME: ");
                                sc.nextLine();
                                String song_name = sc.nextLine();
                                int song_id = songsFunctional.songid(song_name);
                                songsFunctional.play(song_id,userNameUni);
                            } else if (input6==2) {
                                System.out.println("ENTER PODCAST NAME");
                                sc.nextLine();
                                String podcast_name=sc.nextLine();
                                int podcast_id=podcastFunctional.podcastid(podcast_name);
                                podcastFunctional.play(podcast_id,userNameUni);
                            } else if (input6==3) {
                                input(userNameUni);
                            }break;
                        case 6:login();
                        break;

                        default:throw new JukeBoxException("INVALID INPUT");
                    }
                    System.out.println("DO YOU WANT TO EXIT OR LISTEN MORE? 0)EXIT  1)LISTEN MORE");
                    k1=sc.nextInt();
                }while (k1==1);

            } catch (JukeBoxException e){
                System.out.println(e.toString());
            }


        }
    }

