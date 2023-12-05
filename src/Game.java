import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game 
{
    //game system
    private Scanner get  = new Scanner(System.in);
    private Clip clip;

    //game asset
    private Text text;

    private Character monika, serena;

    private static boolean game_running = true;

    public void start()
    {
        //story
        text = new Text();
        text.skip_or_not();

        play_sound();

        game_setup();
        start_playing();

        close_bgm();
    }

    private void create_character(int who)
    {
        String[] info = text.return_info_or_dialog(0, who);
        int lv = text.return_lv(who);
        boolean wing = text.return_wing(who);
        Accessory[] equipment = text.return_equipment(who);
        Weapon[] weapon_have = text.weapon_have(who);
        float[] stat = text.return_stat(who);
        String[] word = text.return_info_or_dialog(1, who);

        if(who == 0)serena = new Main_Character(info, lv, wing, equipment, weapon_have, stat, word);
        else monika = new Enemy_class(info, lv, wing, equipment, weapon_have, stat, word);
    }

    private void game_setup()
    {
        create_character(0);
        create_character(1);
    }

    private String[] choice = 
    {
        "\nWhat should I do?",
        "Check my status (0)",
        "Attack her(1)",
        "Talk to her(2)",
        "Do nothing(else)\n"
    };

    private void start_playing()
    {
        while(game_running)
        {
            for(String i: choice) System.out.println(i);
        }
    }

    //method in game
    private void play_sound()
    {
        try {
            File file = new File("Rolling cup.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(-1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Handle the exception here
            e.printStackTrace(); // Or handle it based on your application's logic
        }
    }

    private void close_bgm()
    {
        clip.stop();
    }

    static public void typping_effect(String input)
    {
        try
        {
            int size = input.length();
            for(int i = 0; i < size; i++)
            {
                System.out.print(input.charAt(i));
                Thread.sleep(5);
            } 
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

    static public void end()
    {
        game_running = false;
    }
}
