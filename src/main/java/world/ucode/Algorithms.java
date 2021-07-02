package world.ucode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Algorithms {
    public static void applyAlgorithms(BufferedImage image, int pixel, int num) {
        switch (num) {
            case 0: {
                rectangle(image, pixel);
                break;
            }
            case 1: {
                triangle(image, pixel);
                break;
            }
            default: System.out.println("Invalid algorithms type");
        }
    }

    public static String getAlgorithm(int num) {
        if (num == 0) {
            return "rectangle";
        } else {
            return "triangle";
        }
    }

    public static void rectangle(BufferedImage image, int pixSize) {
        // Get the raster data (array of pixels)
        assert image != null;
        Raster src = image.getData();
        // Create an identically-sized output raster
        WritableRaster dest = src.createCompatibleWritableRaster();
        // Loop through every PIX_SIZE pixels, in both x and y directions
        for(int y = 0; y < src.getHeight(); y += pixSize) {
            for(int x = 0; x < src.getWidth(); x += pixSize) {
                // Copy the pixel
                int[] pixel = new int[3];
                pixel = src.getPixel(x, y, pixel);
                // "Paste" the pixel onto the surrounding PIX_SIZE by PIX_SIZE neighbors
                // Also make sure that our loop never goes outside the bounds of the image
                for(int yd = y; (yd < y + pixSize) && (yd < dest.getHeight()); yd++) {
                    for(int xd = x; (xd < x + pixSize) && (xd < dest.getWidth()); xd++)
                        dest.setPixel(xd, yd, pixel);
                }
            }
        }
        // Save the raster back to the Image
        image.setData(dest);
    }

    private static void triangle(BufferedImage image, int pixel) {
        int[] colorFirstTriangle = new int[3]; // int[0] RED, int[1] GREEN,  int[2] BLUE
        int[] colorSecondTriangle = new int[3];
        int countPixelFirst = 0;
        int countPixelSecond = 0;

        for (int y = 0; y < image.getHeight(); y += pixel) {
            for (int x = 0; x < image.getWidth(); x += pixel) {
                for (int ky = 0; ky < pixel && (y + ky) < image.getHeight(); ky++) {
                    for (int kx = 0; kx < pixel && (x + kx) < image.getWidth(); kx++) {
                        Color pRGB = new Color(image.getRGB(x + kx, y + ky));
                        if (kx > ky) {
                            countPixelFirst++;
                            colorFirstTriangle[0] += pRGB.getRed();
                            colorFirstTriangle[1] += pRGB.getGreen();
                            colorFirstTriangle[2] += pRGB.getBlue();
                        } else {
                            countPixelSecond++;
                            colorSecondTriangle[0] += pRGB.getRed();
                            colorSecondTriangle[1] += pRGB.getGreen();
                            colorSecondTriangle[2] += pRGB.getBlue();
                        }
                    }
                }
                if (countPixelFirst != 0) {
                    colorFirstTriangle[0] /= countPixelFirst;
                    colorFirstTriangle[1] /= countPixelFirst;
                    colorFirstTriangle[2] /= countPixelFirst;
                }
                if (countPixelSecond != 0) {
                    colorSecondTriangle[0] /= countPixelSecond;
                    colorSecondTriangle[1] /= countPixelSecond;
                    colorSecondTriangle[2] /= countPixelSecond;
                }
                Color first = new Color(colorFirstTriangle[0], colorFirstTriangle[1], colorFirstTriangle[2]);
                Color second = new Color(colorSecondTriangle[0], colorSecondTriangle[1], colorSecondTriangle[2]);
                for (int ky = 0; ky < pixel && (y + ky) < image.getHeight(); ky++) {
                    for (int kx = 0; kx < pixel && (x + kx) < image.getWidth(); kx++) {
                        if (kx > ky) {
                            image.setRGB(x + kx, y + ky, first.getRGB());
                        } else {
                            image.setRGB(x + kx, y + ky, second.getRGB());
                        }
                    }
                }
                colorSecondTriangle[0] = 0;
                colorSecondTriangle[1] = 0;
                colorSecondTriangle[2] = 0;
                colorFirstTriangle[0] = 0;
                colorFirstTriangle[1] = 0;
                colorFirstTriangle[2] = 0;
                countPixelFirst = 0;
                countPixelSecond = 0;
            }
        }
    }
}
