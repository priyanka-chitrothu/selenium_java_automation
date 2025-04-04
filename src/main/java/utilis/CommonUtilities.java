package utilis;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class CommonUtilities {
    public static String generateBrandNewEmail() {
        Date date = new Date();
        String dateFormate = date.toString();
        return dateFormate.replaceAll("\\s", "").replaceAll("\\:", "").toString() + "@gmail.com";
    }

    public static boolean compareTwoScreenShots(String actualImagePath, String expectedImagePath) throws IOException {
        BufferedImage actualBImg = ImageIO.read(new File(actualImagePath));
        BufferedImage expectedBImg = ImageIO.read(new File(expectedImagePath));
        ImageDiffer imgDiffer = new ImageDiffer();
        ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, actualBImg);
        return imgDifference.hasDiff();
    }

    public static Properties loadProperties() {

        Properties prop = new Properties();
        try {
            FileReader fr = new FileReader(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\projectdata.properties");
            prop.load(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }
}
