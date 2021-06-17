package Test;

import Experement.Pictures.Picture;

public class PictureTestRun {
    public static void main(String[] args){
        Picture.init();
        Picture pic = new Picture(null, 0, 0, "test.png");
        pic.generatePicture();
    }
}
