package Test;

import Experement.Pictures.Picture;
import Mathamatics.Plane.ComplexPlane;

public class PictureTestRun {
    public static void main(String[] args){
        Picture.init();
        Picture pic = new Picture(new ComplexPlane(), 0, 0, "test.png");
        pic.generatePicture();
    }
}
