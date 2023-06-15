package net.flectone.utils;

import net.flectone.system.SystemInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ImageUtils {

    public static BufferedImage createBufferedImage(String filePath) {
        BufferedImage image = null;
        try {
            //get image from "images/"

            File file = IOUtils.getWebFile(SystemInfo.siteUrl + "components/configs/images/" + filePath,
                    SystemInfo.getConfigPath() + filePath);

            image = ImageIO.read(file);
        } catch (IOException e) {
//            Dialog.showException(e);
        }
        return image;
    }

    public static ImageIcon getWebImage(String filePath) {

        try {
            URL url = new URL("https://flectone.net/xyeta.jpg");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedImage image = ImageIO.read(connection.getInputStream());

            return new ImageIcon(image);

        } catch (IOException e){
            Dialog.showException(e);
            return null;
        }

    }


    public static ImageIcon createImageIcon(String filePath) {
        try {
            return new ImageIcon(createBufferedImage(filePath));
        } catch (NullPointerException e){
            return null;
        }
    }

    public static ImageIcon createExtraIcon(String filePath){

        return new ImageIcon(IOUtils.getResourceBufferedImage(filePath));

    }

    private static final Map<String, BufferedImage> mapThemeIcons = new HashMap<>();

    public static ImageIcon createThemeImageIcon(String filePath){
        return new ImageIcon(createBufferedImageTheme(filePath));
    }

    public static BufferedImage createBufferedImageTheme(String filePath){
        BufferedImage image = mapThemeIcons.get(filePath);
        if(image == null) {
            image = IOUtils.getResourceBufferedImage(filePath);

            changeIconColor(image, SwingUtils.getColor(2));

            mapThemeIcons.put(filePath, image);
        }
        return image;
    }

    public static BufferedImage createBufferedImageTheme(String filePath, Color color){
        BufferedImage image = mapThemeIcons.get(filePath);
        if(image == null) {
            image = IOUtils.getResourceBufferedImage(filePath);

            changeIconColor(image, color);

            mapThemeIcons.put(filePath, image);
        }
        return image;
    }

    public static void changeIconsColor(Color color){
        for(BufferedImage icon : mapThemeIcons.values()){
            if(icon.getAccelerationPriority() == 1.0f){
                changeIconColor(icon, ColorUtils.makeBrighterOrDarker(SwingUtils.getColor(0), 20));
                continue;
            }
            changeIconColor(icon, color);
        }
    }

    public static void changeIconColor(BufferedImage image, Color color){

        WritableRaster raster = image.getRaster();
        int[] pixel = new int[4];

        for(int x = 0; x < raster.getWidth(); x++) {
            for(int y = 0; y < raster.getHeight(); y++) {

                raster.getPixel(x, y, pixel);

                if(pixel[3] == 0) continue;

                pixel[0] = color.getRed();
                pixel[1] = color.getGreen();
                pixel[2] = color.getBlue();

                raster.setPixel(x, y, pixel);
            }
        }
    }
}
