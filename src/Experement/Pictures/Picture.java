package Experement.Pictures;

import Mathamatics.Plane.Plane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Picture {

    private static int pictureWidth, pictureHeight;

    private final Plane plane;
    private final int width, height;
    private final BufferedImage image;
    private final String fileName;

    public static void init(){
        Picture.pictureWidth = 768;
        Picture.pictureHeight = 1366;
    }

    public static void init(int pictureWidth, int pictureHeight){
        Picture.pictureWidth = pictureWidth;
        Picture.pictureHeight = pictureHeight;
    }

    public Picture(Plane plane, int width, int height){
        this.plane = plane;
        this.width = width;
        this.height = height;
        this.fileName = "res/MyPlane.png";

        this.image = new BufferedImage(Picture.pictureWidth, Picture.pictureHeight, BufferedImage.TYPE_INT_RGB);
    }

    public Picture(Plane plane, int width, int height, String fileName){
        this.plane = plane;
        this.width = width;
        this.height = height;
        this.fileName = "res\\" + fileName;

        this.image = new BufferedImage(Picture.pictureWidth, Picture.pictureHeight, BufferedImage.TYPE_INT_RGB);
    }

    public void generatePicture(){
        File img = null;

        float freq = 0.02f;

        for(int y = 0; y < Picture.pictureHeight; y++){
            for(int x = 0; x < Picture.pictureWidth; x++){
                int r = (int) ((Math.sin(x * freq) + Math.sin(y * freq)) * 100);
                int g = (int) ((Math.sin(x * freq)) * 100);
                int b = (int) ((Math.sin(y * freq)) * 100);

                int p = (r << 16) | (g << 8) | b;

                this.image.setRGB(x, y ,p);
            }
        }

        try {
            img = new File(this.fileName);
            ImageIO.write(this.image, "png", img);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
