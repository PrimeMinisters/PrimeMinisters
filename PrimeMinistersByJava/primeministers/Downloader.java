package primeministers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Arrays;


/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 */
public class Downloader extends IO
{
	/**
	 * 総理大臣の情報を記したCSVファイルの在所(URL文字列)を記憶するフィールド
	 */
	private String url;

	/**
	 * ダウンローダーのコンストラクタ
	 */
	public Downloader()
	{
		this.url = this.urlString();
		//System.out.println("[Downloader]URL:"+this.url);

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

			 //入力用ストリーム
			 InputStream input = url.openStream();

			 //出力用ストリーム
			 //System.out.println("[Downloader]:ディレクトリチェック="+IO.directoryOfPages());
			 OutputStream output = new FileOutputStream(new File(IO.directoryOfPages(),"PrimeMinisters.csv"));

			 try {
		            byte[] bytes = new byte[1024];
		            int len = 0;
		            while ((len = input.read(bytes)) > 0)
		            {
		                output.write(bytes,0,len);
		                //System.out.println("test");
		            }
		            output.flush();
		        }
			 finally
			 {
		            output.close();
		            input.close();
		     }
	    }
		catch(MalformedURLException e)
		{
			//System.out.println("エラーチェック[1]");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			//System.out.println("エラーチェック[2]");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			//System.out.println("エラーチェック[3]");
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages()
	{
		File aFile = new File(IO.directoryOfPages(),"images");

		if(aFile.exists() == false)
		{
			aFile.mkdir();
			//System.out.println("[Downloader]:imageディレクトリを作成");
		}

		int index = this.table.attributes().indexOfImage();

		//System.out.println("[Downloader]:image=index:"+index);

		this.downloadPictures(index);


		return;
	}

	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 */
	private void downloadPictures(int indexOfPicture)
	{
		String[] top = {"画像","縮小画像"};
		for(Tuple aTuple : this.table().tuples())
		{
			String imageName = aTuple.values().get(indexOfPicture);
			System.out.println("[Downloader]"+imageName+"のダウンロード開始");
		
			URL aURL = null;
			BufferedImage anImage = null;
			
			//System.out.println("ImageName="+imageName);
			
			if(Arrays.asList(top).contains(imageName))
			{
				System.out.println("[Downloader]"+imageName+"は例外");
			}
			else
			{
				try
				{
					aURL = new URL(this.urlString()+imageName);
					
					
					//入力用ストリーム
					anImage = ImageIO.read(aURL);
					
					//出力用ストリーム
					ImageIO.write(anImage, "jpeg", new File(IO.directoryOfPages(),imageName));
				}
				catch(MalformedURLException e)
				{
					System.out.println("エラーチェック[1]");
					e.printStackTrace();
				}
				catch(IOException e)
				{
					System.out.println("エラーチェック[2]");
					e.printStackTrace();
				}
				catch(Exception e)
				{
					System.out.println("エラーチェック[3]");
					e.printStackTrace();
				}
				if(indexOfPicture == aTuple.attributes().indexOfImage())
				{
					this.table.images().add(anImage);
				}
				else
				{
					this.table.thumbnails().add(anImage);
				}
				System.out.println("[Downloader]"+imageName+"のダウンロード終了");
			}
			
		}
		return;

	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails()
	{
		File aFile = new File(IO.directoryOfPages(),"Thumbnails");

		if(aFile.exists() == false)
		{
			aFile.mkdir();
			//System.out.println("[Downloader]:Thumbnailsディレクトリを作成");
		}

		int index = this.table.attributes().indexOfThumbnail();

		//System.out.println("[Downloader]:Thumbnails=index:"+index);

		this.downloadPictures(index);


		return;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 */
	public Table table()
	{
		Reader aReader = new Reader();
		this.table = aReader.table();

		return this.table;
	}

	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメゾット。
	 */
	static String urlString()
	{
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/";
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメゾット。
	 */
	static String urlStringOfCSV()
	{
		return urlString()+"PrimeMinisters.csv";

	}

}
