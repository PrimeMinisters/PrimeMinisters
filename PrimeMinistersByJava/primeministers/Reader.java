package primeministers;

import java.io.File;
import java.util.ArrayList;

/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 */
public class Reader extends IO
{
	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド
	 */
	private File filename;

	/**
	 * リーダのコンストラクタ
	 */
	public Reader()
	{
		this.filename = new File(IO.directoryOfPages(),"PrimeMinisters.csv");
		//System.out.println("[Reader]ファイルネーム確認 \"" + filename + "\"");

		return;
	}

	/**
	 * ダウンロードしたCSVファイルを応答
	 */
	public File filename()
	{
		return this.filename;
	}

	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメゾット
	 */
	public/* static */File filenameOfCSV()
	{
		return this.filename;
	}

	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 */
	public Table table()
	{
		//System.out.println("[Reader]tableの起動を確認");
		Table csvTable = new Table();
		csvTable.attributes(new Attributes("input"));

		ArrayList<String> reader = readTextFromFile(this.filename);
		//System.out.println("[Reader]該当ファイルを行文字列リストに変換完了");

		for (String row : reader)
		{
			csvTable.add(new Tuple(csvTable.attributes(), splitString(row, ",")));
		}

		return csvTable;
	}
}
