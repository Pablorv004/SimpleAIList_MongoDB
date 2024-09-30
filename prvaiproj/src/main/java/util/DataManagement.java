package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
		return aiList.get(aiList.size() - 1).getId() + 1;
	}

	public static ImageIcon scaleImg(String imgPath) {
		return new ImageIcon(
				new ImageIcon(imgPath).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
	}

	public static void writeAIImg(ImageIcon savedImg, int aiNum) {
		BufferedImage tempImg = new BufferedImage(savedImg.getIconWidth(), savedImg.getIconHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = tempImg.createGraphics();
		savedImg.paintIcon(null, g2d, 0, 0);
		g2d.dispose();
		try {
			ImageIO.write(tempImg, "png", new File("src/main/resources/AI/ai_" + aiNum + ".png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
