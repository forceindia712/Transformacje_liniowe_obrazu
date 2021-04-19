import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Rozjasnienie {

    BufferedImage image;
    int szerokosc;
    int wysokosc;

    public Rozjasnienie() {

        try {
            File input = new File("C:\\Users\\Albert\\Desktop\\ratusz.jpg");

            image = ImageIO.read(input);
            szerokosc = image.getWidth();
            wysokosc = image.getHeight();

            for(int i=0; i<wysokosc; i++){
                for(int j=0; j<szerokosc; j++){

                    Color c = new Color(image.getRGB(j, i));

                    int red = (c.getRed());
                    int green = (c.getGreen());
                    int blue = (c.getBlue());

                    double a = 40, n = 0.33;


                    int red_pnym = (int) ((int) a*Math.pow(red, n));

                    int green_pnym = (int) ((int) a*Math.pow(green, n));

                    int blue_pnym = (int) ((int) a*Math.pow(blue, n));


                    if (red_pnym  >=0 && red_pnym  <=255)
                        red = red_pnym;

                    if (green_pnym >=0 && green_pnym <=255)
                        green = green_pnym ;

                    if (blue_pnym >=0 && blue_pnym <=255)
                        blue = blue_pnym;


                    Color newColor = new Color(red, green,blue);
                    image.setRGB(j,i,newColor.getRGB());

                } 
            }

            File ouptut = new File("rozjasnione.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }
}