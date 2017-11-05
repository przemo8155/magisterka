
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManager
{

	public Boolean somethingOpened = false;
	public Boolean somethingSaved = false;

	String key = "przemkeb123123zx";

	Image imageToken1 = new Image("tokens/token_1.png");
	Image imageToken2 = new Image("tokens/token_2.png");
	Image imageToken3 = new Image("tokens/token_3.png");
	Image imageToken4 = new Image("tokens/token_4.png");
	Image imageToken5 = new Image("tokens/token_5.png");
	Image imageToken6 = new Image("tokens/token_6.png");
	Image imageToken7 = new Image("tokens/token_7.png");
	Image imageToken8 = new Image("tokens/token_8.png");
	Image imageToken9 = new Image("tokens/token_9.png");


	public void SaveFile(Stage stage, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<HeadArrow> arrows, ObservableList<LeftDoubleArrow> leftDoubleArrows,
			ObservableList<RightDoubleArrow> rightDoubleArrows, ObservableList<ImageView> imageViews, ObservableList<Label> labelTokens)
	{
		try
		{
			setSomethingSaved(false);
			StringBuilder stringBuilder = new StringBuilder();
			final String _circles = "circles";
			stringBuilder.append(_circles);
			stringBuilder.append(System.getProperty("line.separator"));
			for (Circle c : circles)
			{
				Double _d1 = c.getCenterX();
				Double _d2 = c.getCenterY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _squares = "squares";
			stringBuilder.append(_squares);
			stringBuilder.append(System.getProperty("line.separator"));
			for (Rectangle r : squares)
			{
				Double _d1 = r.getX();
				Double _d2 = r.getY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _arrows = "arrows";
			stringBuilder.append(_arrows);
			stringBuilder.append(System.getProperty("line.separator"));
			for (HeadArrow l : arrows)
			{
				Double _d1 = l.getStartX();
				Double _d2 = l.getStartY();
				Double _d3 = l.getEndX();
				Double _d4 = l.getEndY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				Integer _i3 = _d3.intValue();
				Integer _i4 = _d4.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(" ");
				stringBuilder.append(_i3);
				stringBuilder.append(" ");
				stringBuilder.append(_i4);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _leftDoubleArrows = "leftDouble";
			stringBuilder.append(_leftDoubleArrows);
			stringBuilder.append(System.getProperty("line.separator"));
			for (LeftDoubleArrow lda : leftDoubleArrows)
			{
				Double _d1 = lda.getStartX();
				Double _d2 = lda.getStartY();
				Double _d3 = lda.getControlX();
				Double _d4 = lda.getControlY();
				Double _d5 = lda.getEndX();
				Double _d6 = lda.getEndY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				Integer _i3 = _d3.intValue();
				Integer _i4 = _d4.intValue();
				Integer _i5 = _d5.intValue();
				Integer _i6 = _d6.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(" ");
				stringBuilder.append(_i3);
				stringBuilder.append(" ");
				stringBuilder.append(_i4);
				stringBuilder.append(" ");
				stringBuilder.append(_i5);
				stringBuilder.append(" ");
				stringBuilder.append(_i6);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _rightDoubleArrows = "rightDouble";
			stringBuilder.append(_rightDoubleArrows);
			stringBuilder.append(System.getProperty("line.separator"));
			for (RightDoubleArrow lda : rightDoubleArrows)
			{
				Double _d1 = lda.getStartX();
				Double _d2 = lda.getStartY();
				Double _d3 = lda.getControlX();
				Double _d4 = lda.getControlY();
				Double _d5 = lda.getEndX();
				Double _d6 = lda.getEndY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				Integer _i3 = _d3.intValue();
				Integer _i4 = _d4.intValue();
				Integer _i5 = _d5.intValue();
				Integer _i6 = _d6.intValue();
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(" ");
				stringBuilder.append(_i3);
				stringBuilder.append(" ");
				stringBuilder.append(_i4);
				stringBuilder.append(" ");
				stringBuilder.append(_i5);
				stringBuilder.append(" ");
				stringBuilder.append(_i6);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _imageViewsString = "views";
			stringBuilder.append(_imageViewsString);
			stringBuilder.append(System.getProperty("line.separator"));
			for(ImageView iv : imageViews)
			{
				Double _d1 = iv.getLayoutX();
				Double _d2 = iv.getLayoutY();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				Integer imageToken = 0;
				Image image = iv.getImage();
				if(image.equals(MainWindowController.imageToken1))
				{
					imageToken = 1;
				}
				else if(image.equals(MainWindowController.imageToken2))
				{
					imageToken = 2;
				}
				else if(image.equals(MainWindowController.imageToken3))
				{
					imageToken = 3;
				}
				else if(image.equals(MainWindowController.imageToken4))
				{
					imageToken = 4;
				}
				else if(image.equals(MainWindowController.imageToken5))
				{
					imageToken = 5;
				}
				else if(image.equals(MainWindowController.imageToken6))
				{
					imageToken = 6;
				}
				else if(image.equals(MainWindowController.imageToken7))
				{
					imageToken = 7;
				}
				else if(image.equals(MainWindowController.imageToken8))
				{
					imageToken = 8;
				}
				else if(image.equals(MainWindowController.imageToken9))
				{
					imageToken = 9;
				}
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(" ");
				stringBuilder.append(imageToken);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String _labelTokens = "labelTokens";
			stringBuilder.append(_labelTokens);
			stringBuilder.append(System.getProperty("line.separator"));
			for (Label l : labelTokens)
			{
				Double _d1 = l.getLayoutX();
				Double _d2 = l.getLayoutY();
				String _d3 = l.getText();
				Integer _i1 = _d1.intValue();
				Integer _i2 = _d2.intValue();
				Integer _i3 = Integer.valueOf(_d3);
				stringBuilder.append(_i1);
				stringBuilder.append(" ");
				stringBuilder.append(_i2);
				stringBuilder.append(" ");
				stringBuilder.append(_i3);
				stringBuilder.append(System.getProperty("line.separator"));
			}

			final String stringToFile = stringBuilder.toString();
			FileChooser fileChooser = new FileChooser();
			File file;

			fileChooser.setTitle("Save File");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PB files (*.pb)", "*.pb");
			fileChooser.getExtensionFilters().add(extFilter);
			file = fileChooser.showSaveDialog(stage);

			if (file != null)
			{
				setSomethingSaved(true);
			}

			Saver(stringToFile, file);

			String absolutePath = file.getAbsolutePath();
			String directoryPath = file.getParent();
			File inputFile = new File(absolutePath);
			File encryptedFile = new File(directoryPath + "\\encrypt");
			try
			{
				CryptoUtils.encrypt(key, inputFile, encryptedFile);
			} catch (CryptoException ex)
			{
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
			file.delete();
			encryptedFile.renameTo(inputFile);

		} catch (NullPointerException ex)
		{
			ex.fillInStackTrace();
		}
	}

	private void Saver(String content, File file)
	{
		try
		{
			FileWriter fileWriter = null;

			fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (IOException ex)
		{
			ex.getLocalizedMessage();
		}

	}

	public void OpenFile(Stage stage, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<HeadArrow> arrows, ObservableList<LeftDoubleArrow> leftDoubleArrows,
			ObservableList<RightDoubleArrow> rightDoubleArrows, ObservableList<ImageView> imageViews, ObservableList<Label> labelTokens, Pane gc)
	{
		try
		{
			setSomethingOpened(false);
			FileChooser fileChooser = new FileChooser();
			File file;
			fileChooser.setTitle("Open File");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PB files (*.pb)", "*.pb");
			fileChooser.getExtensionFilters().add(extFilter);
			file = fileChooser.showOpenDialog(stage);
			if (file != null)
			{
				setSomethingOpened(true);
			}

			String directoryPath = file.getParent();

			File decryptedFile = new File(directoryPath + "\\decrypt.txt");

			decryptedFile.createNewFile();
			try
			{
				CryptoUtils.decrypt(key, file, decryptedFile);
			} catch (CryptoException ex)
			{
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}

			Reader(decryptedFile, circles, squares, arrows, leftDoubleArrows, rightDoubleArrows, imageViews, labelTokens, gc);
			decryptedFile.delete();

		} catch (NullPointerException | IOException ex)
		{
			ex.fillInStackTrace();
		}

	}

	private void Reader(File file, ObservableList<Circle> circles, ObservableList<Rectangle> squares,
			ObservableList<HeadArrow> arrows, ObservableList<LeftDoubleArrow> leftDoubleArrows,
			ObservableList<RightDoubleArrow> rightDoubleArrows,  ObservableList<ImageView> imageViews, ObservableList<Label> labelTokens, Pane gc)
	{
		Scanner scanner;

		Boolean fullCircle = false;
		Boolean fullSquare = false;
		Boolean fullView = false;

		int faze = 1;

		Double g1 = 0.0, g2 = 0.0;
		Double s1 = 0.0, s2 = 0.0;
		Double ls1 = 0.0, ls2 = 0.0, le1 = 0.0, le2 = 0.0;
		Double iv1 = 0.0, iv2 = 0.0;
		Integer imageType = 0;

		Double labelX = 0.0, labelY = 0.0;
		Integer labelInt = 0;
		String labelStr = "";

		Double as1 = 0.0, as2 = 0.0, ac1 = 0.0, ac2 = 0.0, ae1 = 0.0, ae2 = 0.0;
		try
		{
			scanner = new Scanner(file);
			while (scanner.hasNext())
			{
				String tmp = scanner.next();

				if (tmp.equals("circles"))
				{
					String t;
					while (!(t = scanner.next()).equals("squares"))
					{

						if (!fullCircle)
						{
							g1 = Double.parseDouble(t);
							fullCircle = true;
						} else
						{
							g2 = Double.parseDouble(t);
							fullCircle = false;
							Circle c = new Circle(g1, g2, 20.0f, Paint.valueOf("#923456"));
							c.setStroke(Paint.valueOf("#555555"));
							c.setStrokeWidth(5.0f);
							circles.add(c);
						}

					}
				}

			}
			scanner.close();
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		try
		{
			scanner = new Scanner(file);

			while (scanner.hasNext())
			{
				String tmp = scanner.next();

				if (tmp.equals("squares"))
				{
					String t;
					while (!(t = scanner.next()).equals("arrows"))
					{

						if (!fullSquare)
						{
							s1 = Double.parseDouble(t);
							fullSquare = true;
						} else
						{
							s2 = Double.parseDouble(t);
							fullSquare = false;
							Rectangle r = new Rectangle(s1, s2, 40.0f, 40.0f);
							r.setFill(Paint.valueOf("#ABCDEF"));
							r.setStroke(Paint.valueOf("#555555"));
							r.setStrokeWidth(5.0f);
							squares.add(r);

						}

					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		try
		{
			scanner = new Scanner(file);

			while (scanner.hasNext())
			{
				String tmp = scanner.next();

				if (tmp.equals("arrows"))
				{
					String t;
					while (scanner.hasNext())
					{
						t = scanner.next();
						if (t.equals("leftDouble"))
						{
							break;
						}

						switch (faze)
						{
							case 1:
								ls1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 2:
								ls2 = Double.parseDouble(t);
								faze += 1;
								break;
							case 3:
								le1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 4:
								le2 = Double.parseDouble(t);
								faze = 1;
								HeadArrow ha = new HeadArrow(ls1, ls2, le1, le2, gc);
								arrows.add(ha);
								break;

						}

					}
				}

			}

			scanner.close();
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		try
		{
			scanner = new Scanner(file);

			while (scanner.hasNext())
			{
				String tmp = scanner.next();

				if (tmp.equals("leftDouble"))
				{
					String t;
					while (scanner.hasNext())
					{
						t = scanner.next();
						if (t.equals("rightDouble"))
						{
							break;
						}

						switch (faze)
						{
							case 1:
								as1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 2:
								as2 = Double.parseDouble(t);
								faze += 1;
								break;
							case 3:
								ac1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 4:
								ac2 = Double.parseDouble(t);
								faze += 1;
								break;
							case 5:
								ae1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 6:
								ae2 = Double.parseDouble(t);
								faze = 1;
								LeftDoubleArrow lda = new LeftDoubleArrow(as1, as2, ac1, ac2, ae1, ae2);
								leftDoubleArrows.add(lda);
								break;

						}

					}
				}

			}

			scanner.close();
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		try
		{
			scanner = new Scanner(file);

			while (scanner.hasNext())
			{
				String tmp = scanner.next();

				if (tmp.equals("rightDouble"))
				{
					String t;
					while (scanner.hasNext())
					{
						t = scanner.next();

						if (t.equals("views"))
						{
							break;
						}

						switch (faze)
						{
							case 1:
								as1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 2:
								as2 = Double.parseDouble(t);
								faze += 1;
								break;
							case 3:
								ac1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 4:
								ac2 = Double.parseDouble(t);
								faze += 1;
								break;
							case 5:
								ae1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 6:
								ae2 = Double.parseDouble(t);
								faze = 1;
								RightDoubleArrow rda = new RightDoubleArrow(as1, as2, ac1, ac2, ae1, ae2);
								rightDoubleArrows.add(rda);
								break;

						}

					}
				}

			}

			scanner.close();
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		try
		{
			scanner = new Scanner(file);

			while (scanner.hasNext())
			{
				String tmp = scanner.next();

				if (tmp.equals("views"))
				{
					String t;
					while (scanner.hasNext())
					{
						t = scanner.next();

						if (t.equals("labelTokens"))
						{
							break;
						}

						switch(faze)
						{
							case 1:
								iv1 = Double.parseDouble(t);
								faze += 1;
								break;
							case 2:
								iv2 = Double.parseDouble(t);
								faze += 1;
								break;
							case 3:
								imageType = Integer.parseInt(t);
								ImageView imageView = new ImageView();
								imageView.setLayoutX(iv1);
								imageView.setLayoutY(iv2);
								imageView.setFitHeight(40.0f);
								imageView.setFitWidth(40.0f);
								if(imageType == 1)
								{
									imageView.setImage(MainWindowController.imageToken1);
								}
								else if(imageType == 2)
								{
									imageView.setImage(MainWindowController.imageToken2);
								}
								else if(imageType == 3)
								{
									imageView.setImage(MainWindowController.imageToken3);
								}
								else if(imageType == 4)
								{
									imageView.setImage(MainWindowController.imageToken4);
								}
								else if(imageType == 5)
								{
									imageView.setImage(MainWindowController.imageToken5);
								}
								else if(imageType == 6)
								{
									imageView.setImage(MainWindowController.imageToken6);
								}
								else if(imageType == 7)
								{
									imageView.setImage(MainWindowController.imageToken7);
								}
								else if(imageType == 8)
								{
									imageView.setImage(MainWindowController.imageToken8);
								}
								else if(imageType == 9)
								{
									imageView.setImage(MainWindowController.imageToken9);
								}
								imageViews.add(imageView);
								faze = 1;
								break;
						}

					}
				}

			}

			scanner.close();
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}


		try
		{
			scanner = new Scanner(file);

			while (scanner.hasNext())
			{
				String tmp = scanner.next();

				if (tmp.equals("labelTokens"))
				{
					String t;
					while (scanner.hasNext())
					{
						t = scanner.next();

						switch (faze)
						{
							case 1:
								labelX = Double.parseDouble(t);
								faze += 1;
								break;
							case 2:
								labelY = Double.parseDouble(t);
								faze += 1;
								break;
							case 3:
								labelInt = Integer.valueOf(t);
								Label l = new Label();
								l.setText(labelInt.toString());
								l.setFont(new Font("Arial", 24));
								l.setLayoutX(labelX);
								l.setLayoutY(labelY);
								labelTokens.add(l);
								faze = 1;
								break;

						}

					}
				}

			}

			scanner.close();
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}


	}

	public Boolean getSomethingOpened()
	{
		return somethingOpened;
	}

	public void setSomethingOpened(Boolean a)
	{
		somethingOpened = a;
	}

	public Boolean getSomethingSaved()
	{
		return somethingSaved;
	}

	public void setSomethingSaved(Boolean a)
	{
		somethingSaved = a;
	}

	public static final byte[] intToByteArray(int value)
	{
		return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value };
	}
}
