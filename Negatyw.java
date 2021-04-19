import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Negatyw {

    BufferedImage image;
    int szerokosc;
    int wysokosc;

    public Negatyw() {
        try {
            File input = new File("C:\\Users\\Albert\\Desktop\\ratusz.jpg");

            image = ImageIO.read(input);
            szerokosc = image.getWidth();
            wysokosc = image.getHeight();

            for(int i=0; i<wysokosc; i++){

                for(int j=0; j<szerokosc; j++){

                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed());
                    int green = (int)(c.getGreen());
                    int blue = (int)(c.getBlue());

                    int red_pnym = 255-red;
                    int green_pnym = 255-green;
                    int blue_pnym = 255-blue;

                    if (red_pnym  >=0 && red_pnym  <=255)
                        red = red_pnym;

                    if (green_pnym >=0 && green_pnym <=255)
                        green = green_pnym;

                    if (blue_pnym >=0 && blue_pnym <=255)
                        blue = blue_pnym;

                    Color newColor = new Color(red, green,blue);
                    image.setRGB(j,i,newColor.getRGB());
                } 
            }

            File ouptut = new File("negatyw.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }
}