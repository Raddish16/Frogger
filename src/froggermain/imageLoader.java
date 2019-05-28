/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggermain;

/**
 *
 * @author Yasuki
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class imageLoader {

    public static BufferedImage loadImage(String path)
    {
        try {
            return ImageIO.read(imageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
