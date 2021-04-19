import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;



class Main {

    String sc = "C:\\Users\\Albert\\Desktop\\ratusz.jpg";

    private JPanel

    panel = new JPanel(new GridLayout(1,1)),
    panel1 = new JPanel(new GridLayout(1,10));
    		
    private Button przycisk = new Button("Oryginal");
    private Button przycisk1 = new Button("Negatyw");
    private Button przycisk2 = new Button("Rozjasnienie");
    private Button przycisk3 = new Button("Przyciemnienie");
    private Button przycisk4 = new Button("Wyjscie");


    class Picture extends Canvas {

        public BufferedImage loadImage(String sciezka) throws IOException {

            try
            {
                return ImageIO.read(new File(sciezka));
            }
            catch (Exception e)
            {
                System.out.println(e);
                System.exit(0);
                return null;
            }
        }
        public void paint(Graphics g) {

            BufferedImage obrazek = null;

            try {

                obrazek = loadImage(sc);

            }
            catch (IOException e) {

                e.printStackTrace();
            }

            g.drawImage(obrazek, obrazek.getMinX(), obrazek.getMinY(), this);
        }
    }

    private Canvas canvas = new Picture();

    public Main() {

        JFrame frame = new JFrame("Obraz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setResizable(false);
        
        panel.setBorder(new TitledBorder("Rysunek"));
        
        panel1.setBorder(new TitledBorder("Menu"));

        panel.add(canvas);

        panel1.add(przycisk);
        panel1.add(przycisk1);
        panel1.add(przycisk2);
        panel1.add(przycisk3);
        panel1.add(przycisk4);
        panel1.setBounds(1100, 880, 800, 160);

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel);


        przycisk.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {

                                     new Rozjasnienie();
                                     sc = "C:\\Users\\Albert\\Desktop\\ratusz.jpg";
                                     canvas.repaint();
                                 }
                             }
        );

        przycisk1.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {

                                     new Negatyw();
                                     sc = "negatyw.jpg";
                                     canvas.repaint();
                                 }
                             }
        );

        przycisk2.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {

                                     new Rozjasnienie();
                                     sc = "rozjasnione.jpg";
                                     canvas.repaint();
                                 }
                             }
        );

        przycisk3.addActionListener(new ActionListener() {
    
                                 public void actionPerformed(ActionEvent e) {

                                     new Przyciemnienie();
                                     sc = "przyciemnione.jpg";
                                     canvas.repaint();
                                 }
                             }
        );

        przycisk4.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {

                                     System.exit(0);
                                 }
                             }
        );

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}