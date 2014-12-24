package primeministers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 * 
 * @author isobe
 */
public class Downloader extends IO
{
	/**
	 * 総理大臣の情報を記したCSVファイルの在所(URL文字列)を記憶するフィールド。
	 */
	private String url;

	/**
	 * ダウンローダーのコンストラクタ。
	 */
	public Downloader()
	{
		this.url = this.urlString();
		return;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 */
	public void downloadCSV()
	{
		try
		{
			URL url = new URL(this.urlStringOfCSV());

			InputStream input = url.openStream();

			OutputStream output = new FileOutputStream(new File(
			        IO.directoryOfPages(), "PrimeMinisters.csv"));

			try
			{
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = input.read(bytes)) > 0)
				{
					output.write(bytes, 0, len);
				}
				output.flush();
			}
			finally
			{
				output.close();
				input.close();
			}
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages()
	{
		File aFile = new File(IO.directoryOfPages(), "images");

		if (aFile.exists() == false)
		{
			aFile.mkdir();
		}

		int index = this.table.attributes().indexOfImage();

		this.downloadPictures(index);

		return;
	}

	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 * 
	 * @param indexOfPicture
	 *            画像のインデックス
	 */
	private void downloadPictures(int indexOfPicture)
	{
		String[] top =
			{ "画像", "縮小画像" };
		for (Tuple aTuple : this.table().tuples())
		{
			String imageName = aTuple.values().get(indexOfPicture);
			System.out.println("[Downloader]" + imageName + "のダウンロード開始");

			URL aURL = null;
			BufferedImage anImage = null;

			if (Arrays.asList(top).contains(imageName))
			{
				System.out.println("[Downloader]" + imageName + "は例外");
			}
			else
			{
				try
				{
					aURL = new URL(this.urlString() + imageName);

					anImage = ImageIO.read(aURL);

					ImageIO.write(anImage, "jpeg",
					        new File(IO.directoryOfPages(), imageName));
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				if (indexOfPicture == aTuple.attributes().indexOfImage())
				{
					this.table.images().add(anImage);
				}
				else
				{
					this.table.thumbnails().add(anImage);
				}

			}

		}
		return;

	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails()
	{
		File aFile = new File(IO.directoryOfPages(), "Thumbnails");

		if (aFile.exists() == false)
		{
			aFile.mkdir();
		}

		int index = this.table.attributes().indexOfThumbnail();

		this.downloadPictures(index);

		return;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 * 
	 * @return テーブルを保持するフィールド
	 */
	@Override
	public Table table()
	{
		Reader aReader = new Reader();
		this.table = aReader.table();

		return this.table;
	}

	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 * 
	 * @return 総理大臣の情報の在処のURL文字列
	 */
	String urlString()
	{
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/";
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメゾット。
	 * 
	 * @return 総理大臣の情報を記したCSVファイルの在処のURL文字列
	 */
	String urlStringOfCSV()
	{
		return this.url + "PrimeMinisters.csv";
	}

}
