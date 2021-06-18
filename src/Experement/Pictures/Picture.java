package Experement.Pictures;

import Mathamatics.Plane.ComplexPlane;
import Mathamatics.Plane.PolarPlane;
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
        Picture.pictureWidth = 1366;
        Picture.pictureHeight = 768;
    }

    public static void init(int pictureWidth, int pictureHeight){
        Picture.pictureWidth = pictureWidth;
        Picture.pictureHeight = pictureHeight;
    }

    public Picture(Plane plane, int width, int height){
        this.plane = plane;
        this.width = width;
        this.height = height;
        this.fileName = "res/experement/MyPlane.png";

        this.image = new BufferedImage(Picture.pictureWidth, Picture.pictureHeight, BufferedImage.TYPE_INT_RGB);
    }

    public Picture(Plane plane, int width, int height, String fileName){
        this.plane = plane;
        this.width = width;
        this.height = height;
        this.fileName = "res\\experement\\" + fileName;

        this.image = new BufferedImage(Picture.pictureWidth, Picture.pictureHeight, BufferedImage.TYPE_INT_RGB);
    }

    public void generatePicture(){
        File img = null;

        int r, g, b, p;

        if(this.plane == null){
            for(int y = 0; y < Picture.pictureHeight; y++){
                for(int x = 0; x < Picture.pictureWidth; x++){
                    r = 255;
                    g = 255;
                    b = 255;

                    p = (r << 16) | (g << 8) | b;

                    this.image.setRGB(x, y ,p);
                }
            }
        }else {

            String planeType = this.plane.getPlaneName();

            if (planeType.equals(ComplexPlane.class.getName())) {
                for (int y = 0; y < Picture.pictureHeight; y++) {
                    for (int x = 0; x < Picture.pictureWidth; x++) {
                        r = 255;
                        g = 255;
                        b = 255;

                        p = (r << 16) | (g << 8) | b;

                        this.image.setRGB(x, y, p);
                    }
                }
            } else if (planeType.equals(PolarPlane.class.getName())) {
                for (int y = 0; y < Picture.pictureHeight; y++) {
                    for (int x = 0; x < Picture.pictureWidth; x++) {
                        r = 255;
                        g = 255;
                        b = 255;

                        p = (r << 16) | (g << 8) | b;

                        this.image.setRGB(x, y, p);
                    }
                }
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
