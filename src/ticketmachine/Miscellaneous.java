/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Radu
 */
public class Miscellaneous {

    //Method for error sound
    public void error_click() {

        try {
            File sound = new File("error.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        } catch (Exception e) {
            System.out.println("The audio file is missing!");
        }
    }

    //Method for correct sound
    public void correct_click() {

        try {
            File sound = new File("correct.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        } catch (Exception e) {
            System.out.println("The audio file is missing!");
        }
    }
}
