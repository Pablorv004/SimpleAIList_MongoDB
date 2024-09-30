package util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.mongodb.client.model.Filters;

import models.AI;

public class DataManagement {
	private static ArrayList<AI> aiList;

	public static List<AI> recoverAIList() {
		if (aiList != null)
			return aiList;
		aiList = new ArrayList<>();
		Iterator<AI> it = MongoConnect.getCollection().find().iterator();
		while (it.hasNext())
			aiList.add(it.next());
		return aiList;
	}

	public static void refreshAIList() {
		aiList = null;
		recoverAIList();
	}

	public static void insertAI(String name, String type, int year, String imgPath) {
		AI ai1 = new AI(getLastID(), name, type, year, imgPath);
		MongoConnect.getCollection().insertOne(ai1);
		refreshAIList();
	}
	
	public static void insertAI(AI ai) {
		MongoConnect.getCollection().insertOne(ai);
		refreshAIList();
	}
	
	public static void deleteAI(AI ai) {
		MongoConnect.getCollection().deleteOne(Filters.eq("_id", ai.getId()));
		refreshAIList();
	}

	public static int getLastID() {
		if (aiList.size() == 0)
			return 1;
		int id = 0;
		for(AI a : aiList)
			id = a.getId() > id ? a.getId() : id;
		return id + 1;
	}

	public static ImageIcon scaleImg(String imgPath) {
		return new ImageIcon(
				new ImageIcon(imgPath).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
	}
	
	public static BufferedImage scaleImg(BufferedImage imgPath) {
		return convertImageToBufferedImage(imgPath.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
	}
	
	public static BufferedImage convertImageToBufferedImage(Image img) {
        BufferedImage bufferedImage = new BufferedImage(
                img.getWidth(null),
                img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB); 
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return bufferedImage;
    }

	
	public static String encodeBufferedImageToBase64(BufferedImage image) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
			ImageIO.write(image, "png", outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
        byte[] imageBytes = outputStream.toByteArray();
        String base64String = Base64.getEncoder().encodeToString(imageBytes);
        return base64String;
    }
	 
	 public static BufferedImage decodeBase64ToBufferedImage(String base64String) {
	        byte[] imageBytes = Base64.getDecoder().decode(base64String);
	        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
	        try {
				return ImageIO.read(bis);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return null;
	    }
	 
	public static List<String> listImageSuffixes() {
		List<String> imageSuffixes = new ArrayList<>();
		imageSuffixes.add("png");
		imageSuffixes.add("jpg");
		imageSuffixes.add("JPG");
		imageSuffixes.add("webp");
		imageSuffixes.add("jpeg");
		return imageSuffixes;
	}
}
