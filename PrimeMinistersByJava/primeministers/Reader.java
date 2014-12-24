package primeministers;

import java.io.File;
import java.util.ArrayList;

/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 * 
 * @author isobe ueda
 */
public class Reader extends IO
{
	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド。
	 */
	private File filename;

	/**
	 * リーダのコンストラクタ。
	 */
	public Reader()
	{
		this.filename = new File(IO.directoryOfPages(), "PrimeMinisters.csv");

		return;
	}

	/**
	 * ダウンロードしたCSVファイルを応答。
	 * 
	 * @return 総理大臣の情報を記したCSVファイルを記憶するフィールド。
	 */
	public File filename()
	{
		return this.filename;
	}

	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 * 
	 * @return テーブルを保持するフィールド。
	 */
	@Override
	public Table table()
	{
		this.table = new Table();
		this.table.attributes(new Attributes("input"));

		ArrayList<String> reader = readTextFromFile(this.filename);

		for (String row : reader)
		{
			this.table.add(new Tuple(this.table.attributes(), splitString(row,
			        ",")));
		}

		return this.table;
	}
}
