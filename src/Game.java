import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game 
{
    //game system
    private Clip clip;

    //game asset
    private Text text;

    private Character enemy, mc;


    public void start()
    {
        //story
        text = new Text();
        text.skip_or_not();

        play_sound();

        game_setup();

        close_bgm();
    }

    private void game_setup()
    {
        mc Serena = new Main_Character();
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
}
