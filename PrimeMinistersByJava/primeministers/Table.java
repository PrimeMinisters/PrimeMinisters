package primeministers;

import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * 表：総理大臣の情報テーブル。
 * 
 * @author isobe ueda
 */
public class Table extends Object
{
	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;

	/**
	 * 画像群を記憶するフィールド。
	 */
	private ArrayList<BufferedImage> images;

	/**
	 * サムネイル画像群を記憶するフィールド。
	 */
	private ArrayList<BufferedImage> thumbnails;

	/**
	 * タプル群を記憶するフィールド。
	 */
	private ArrayList<Tuple> tuples;

	/**
	 * テーブルのコンストラクタ。
	 */
	Table()
	{
		this.images = new ArrayList<BufferedImage>();
		this.thumbnails = new ArrayList<BufferedImage>();
		this.tuples = new ArrayList<Tuple>();
		return;
	}

	/**
	 * タプルを追加する。
	 * 
	 * @param aTuple
	 *            タプルを保持するフィールド。
	 */
	void add(Tuple aTuple)
	{
		this.tuples.add(aTuple);
		return;
	}

	/**
	 * 属性リストを応答する。
	 * 
	 * @return 属性リストを保持するフィールド。
	 */
	Attributes attributes()
	{
		return this.attributes;
	}

	/**
	 * 属性リストを設定する。
	 * 
	 * @param instanceOfAttributes
	 *            属性リストの値群。
	 */
	void attributes(Attributes instanceOfAttributes)
	{
		this.attributes = instanceOfAttributes;
		return;
	}

	/**
	 * 画像群を応答する。
	 * 
	 * @return 画像群を記憶するフィールド。
	 */
	ArrayList<BufferedImage> images()
	{
		return this.images;
	}

	/**
	 * サムネイル画像群を応答する。
	 * 
	 * @return サムネイル画像群を記憶するフィールド。
	 */
	ArrayList<BufferedImage> thumbnails()
	{
		return this.thumbnails;
	}

	/**
	 * 自分自身を文字列にして。それを反応する。
	 * 
	 * @return このテーブルが保持している属性リストとタプル群の文字列
	 */
	@Override
	public String toString()
	{
		String tuplesString = "";
		int index = 0;
		for (Tuple tuple : tuples)
		{
			if (index != 0)
				tuplesString += tuple.toString() + "\n";
			index++;
		}
		return attributes + "\n" + tuplesString;
	}

	/**
	 * ダプル群を応答する。
	 * 
	 * @return タプル群を記憶するフィールド。
	 */
	ArrayList<Tuple> tuples()
	{
		return this.tuples;
	}
}
