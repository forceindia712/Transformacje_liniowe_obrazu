import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Przyciemnienie {

    BufferedImage image;
    int szerokosc;
    int wysokosc;

    public Przyciemnienie() {

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

                    double a = 0.05, n = 2;


                    int red_pnym = (int) ((int) Math.pow(a*red, n));

                    int green_pnym = (int) ((int) Math.pow(a*green, n));

                    int blue_pnym = (int) ((int) Math.pow(a*blue, n));


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
            File ouptut = new File("przyciemnione.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }
}