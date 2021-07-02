package world.ucode;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Filters {

    public static void applyFilters(BufferedImage image, int num) {

        if (num > 0 && num <= 4) {
            switch (num) {
                case 1: {gray(image); break;}
                case 2: {red(image); break;}
                case 3: {window(image); break;}
                case 4: {rainbow(image); break;}
                default: break;
            }
        } else if (num != 0) {
            System.out.println("Invalid filter type");
        }
    }

    public static String getFilter(int num) {
        switch (num) {
            case 0: return "none";
            case 1: return "gray";
            case 2: return "red";
            case 3: return "window";
            case 4: return "rainbow";
            default: return "unknown";
        }
    }

    private static void gray(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color c = new Color(image.getRGB(x, y));

                int avr = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                Color newPixel = new Color(avr, avr, avr);

                image.setRGB(x, y, newPixel.getRGB());
            }
        }
    }

    private static void red(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color c = new Color(image.getRGB(x, y));

                Color newPixel = new Color(255, c.getGreen(), c.getBlue());

                image.setRGB(x, y, newPixel.getRGB());
            }
        }
    }

    private static void window(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                Color newPixel = new Color(image.getRGB(x, y));

                if (x <= 10 || x >= w - 10 || y <= 10 || y >= h - 10) {
                    newPixel = new Color(102, 51, 0);
                }
                if (w >= h) {
                    newPixel = setWin(newPixel, x, y, w, h);
                }
                if (w < h) {
                    newPixel = setWin(newPixel, y, x, h, w);
                }

                image.setRGB(x, y, newPixel.getRGB());
            }
        }
    }
    private static Color setWin(Color c, int x, int y, int w, int h) {
        if ((x >= w / 4 - 3 && x <= w / 4 + 3) ||
                (x >= w / 2 - 3 && x <= w / 2 + 3) ||
                (x >= (3 * w) / 4 - 3 && x <= (3 * w) / 4 + 3) ||
                (y >= h / 2 - 3 && y <= h / 2 + 3)) {
            return new Color(102, 51, 0);
        }
        return c;
    }

    private static void rainbow(BufferedImage image) {
        int h = image.getHeight();

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < h; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color newPixel = c;

                int avr = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                if (avr >= 128) {
                    newPixel = setRainbowMax(y, h, avr);
                } else {
                    newPixel = setRainbowMin(y, h, avr);
                }


                image.setRGB(x, y, newPixel.getRGB());
            }
        }
    }

    private static Color setRainbowMax(int y, int h, int avr) {
        Color c;
        if (y <= h / 7) {
            c = new Color(255, 2 * avr - 255, 2 * avr - 255);
        } else if (y <= (2 * h) / 7) {
            c = new Color(255, (int)Math.floor(1.2 * avr - 51), 2 * avr - 255);
        } else if (y <= (3 * h) / 7) {
            c = new Color(255, 255, 2 * avr - 255);
        } else if (y <= (4 * h) / 7) {
            c = new Color(2 * avr - 255, 255, 2 * avr - 255);
        } else if (y <= (5 * h) / 7) {
            c = new Color(2 * avr - 255, 2 * avr - 255, 255);
        } else if (y <= (6 * h) / 7) {
            c = new Color((int)Math.floor(1.2 * avr - 51), 2 * avr - 255, 255);
        } else {
            c = new Color((int)Math.floor(0.4 * avr + 153), 2 * avr - 255, (int)Math.floor(0.4 * avr + 153));
        }
        return c;
    }

    private static Color setRainbowMin(int y, int h, int avr) {
        Color c;
        if (y <= h / 7) {
            c = new Color(2 * avr, 0, 0);
        } else if (y <= (2 * h) / 7) {
            c = new Color(2 * avr, (int)Math.floor(0.8 * avr), 0);
        } else if (y <= (3 * h) / 7) {
            c = new Color(2 * avr, 2 * avr, 0);
        } else if (y <= (4 * h) / 7) {
            c = new Color(0, 2 * avr, 0);
        } else if (y <= (5 * h) / 7) {
            c = new Color(0, 0, 2*avr);
        } else if (y <= (6 * h) / 7) {
            c = new Color((int)Math.floor(0.8 * avr), 0, 2 * avr);
        } else {
            c = new Color((int)Math.floor(1.6 * avr), 0, (int)Math.floor(1.6 * avr));
        }
        return c;
    }


}

