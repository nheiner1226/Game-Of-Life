import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    // Clip object defined outside of methods to allow all methods to access object
    Clip clip;


    // Starts the audio clip
    void playMusic(String musicLocation)    {

        try {

            File musicPath = new File(musicLocation);

            if (musicPath.exists())   {

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);

                // Instance of clip class created to run audio file
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

                // Music will loop until stopped
                clip.loop(Clip.LOOP_CONTINUOUSLY);

            }

            else    {
                System.out.println("File not found.");
            }

        }

        // Catch
        catch (Exception ex)    {
            ex.printStackTrace();
        }

    }


    // Stops the audio clip
    public void stopMusic(String musicLocation)     {

        try {

            File musicPath2 = new File(musicLocation);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath2);

            // Music clip is stopped
            clip.stop();

        }

        catch (Exception ex)    {
            ex.printStackTrace();
        }

    }

}
