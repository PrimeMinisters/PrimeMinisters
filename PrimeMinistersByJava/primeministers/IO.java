package primeministers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;

/**
 * 入出力：リーダ・ダウンローダ・ライタを抽象する。
 * 
 * @author isobe ueda
 */
public abstract class IO extends Object
{
	/**
	 * テーブル(表:スプレッドシート)を記憶するフィールド
	 */
	protected Table table;

	/**
	 * 入出力のコンストラクタ
	 */
	public IO()
	{
		return;
	}

	/**
	 * ファイルやディレクトリを削除するクラスメソッド。
	 * 
	 * @param aFile
	 *            ファイルを保持するフィールド。
	 */
	public static void deleteFileOrDirectory(File aFile)
	{
		if (aFile.exists())
		{
			System.out.println("[IO]ファイルの存在を確認");
			aFile.delete();
		}
		else
		{
			System.out.println("[IO]ファイルの存在が確認できません。");
		}

		return;
	}

	/**
	 * 総理大臣ページのためのディレクトリ(存在しなければ作成して)を応答するクラスメソッド。
	 * 
	 * @return ディレクトリファイルを保持するフィールド。
	 */
	public static File directoryOfPages()
	{
		String homeDirectory = System.getProperty("user.home");
		File aDirectory = new File(homeDirectory + "/Desktop/SouriDaijin/");
		if (!aDirectory.exists())
		{

			if (aDirectory.mkdir())
			{
				System.out.println("[IO]ディレクトリ作成");
			}
			else
			{
				System.out.println("[IO]ディレクトリ作成に失敗");
			}

		}
		return aDirectory;
	}

	/**
	 * 入出力する際の文字コードを応答するクラスメソッド。
	 * 
	 * @return 入出力する際の文字コードの文字列。
	 */
	public static String encodingSymbol()
	{
		return "UTF-8";
	}

	/**
	 * 指定されたファイルからテキストを読みこんで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param aFile
	 *            ファイルを保持するフィールド。
	 * @return 行リストを保持するフィールド。
	 */
	public static ArrayList<String> readTextFromFile(File aFile)
	{
		ArrayList<String> rowList = new ArrayList<String>();
		try
		{
			FileReader fileReader = new FileReader(aFile);
			BufferedReader br = new BufferedReader(fileReader);

			String row;
			while ((row = br.readLine()) != null)
			{
				rowList.add(row);
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return rowList;
	}

	/**
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param fileString
	 *            指定するファイル文字列。
	 * @return 行リストを保持するフィールド。
	 */
	public static ArrayList<String> readTextFromFile(String fileString)
	{
		ArrayList<String> rowList = splitString(fileString,
		        System.getProperty("line.separator"));
		return rowList;
	}

	/**
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param aURL
	 *            指定するURL。
	 * @return 行リストを保持するフィールド。
	 */
	public static ArrayList<String> readTextFromURL(URL aURL)
	{
		return null;
	}

	/**
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param urlString
	 *            指定するURL文字列。
	 * @return 行リストを保持するフィールド。
	 */
	public static ArrayList<String> readTextFromURL(String urlString)
	{
		return null;
	}

	/**
	 * 文字列をセパレータで分割したトークン列を応答するクラスメソッド。
	 * 
	 * @param string
	 *            分割する文字列
	 * @param separators
	 *            文字列を分割するセパレータ
	 * @return トークン列を保持するフィールド。
	 */
	public static ArrayList<String> splitString(String string, String separators)
	{
		ArrayList<String> tokenList = new ArrayList<String>();
		String[] tokens = string.split(separators);
		for (String aToken : tokens)
		{
			tokenList.add(aToken);
		}

		return tokenList;
	}

	/**
	 * テーブルを応答する。
	 * 
	 * @return 変換したテーブル。
	 */
	public Table table()
	{
		return this.table;
	}

	/**
	 * テーブルを応答する。
	 * 
	 * @param aTable
	 *            テーブルを保持するフィールド。
	 * @return 変換したテーブル。
	 */
	public Table table(Table aTable)
	{
		return this.table;
	}

	/**
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド。
	 * 
	 * @param aCollection
	 *            指定する行リスト。
	 * @param aFile
	 *            指定するファイル。
	 */
	public static void writeText(ArrayList<String> aCollection, File aFile)
	{
		return;
	}

	/**
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド。
	 * 
	 * @param aCollection
	 *            指定する行リスト。
	 * @param fileString
	 *            指定するファイル名。
	 */
	public static void writeText(ArrayList<String> aCollection,
	        String fileString)
	{
		return;
	}

}
