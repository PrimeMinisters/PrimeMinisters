package primeministers;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
/**
 * 表：総理大臣の情報テーブル。
 */
public class Table extends Object
{
	/**
	 * 属性リストを記憶するフィールド
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
	 * テーブルのコンストラクタ
	 */
	Table()
	{
		System.out.println("[Table]:コンストラクタ起動");
		this.images = new ArrayList<BufferedImage>();
		this.thumbnails = new ArrayList<BufferedImage>();
		this.tuples = new ArrayList<Tuple>();
		return;
	}

	/**
	 * タプルを追加する。
	 */
	void add(Tuple aTuple)
	{
		ArrayList<String> values = aTuple.values();
		ArrayList<String> keys = aTuple.attributes().keys();
		// if (values.get(this.attributes.indexOfImage()) != "画像")
		// {
		// values.add(values.get(this.attributes.indexOfImage()));
		// if(keys.get(this.attributes.indexOfThumbnail()))
		// {
		//
		// }
		// }
		this.tuples.add(aTuple);
		return;
	}

	/**
	 * 属性リストを応答する。
	 */
	Attributes attributes()
	{
		return this.attributes;
	}

	/**
	 * 属性リストを設定する。
	 */
	void attributes(Attributes instanceOfAttributes)
	{
		this.attributes = instanceOfAttributes;
		return;
	}

	/**
	 * 画像群を応答する。
	 */
	ArrayList<BufferedImage> images()
	{
		return this.images;
	}

	/**
	 * 画像またはサムネイル画像の文字列を受け取って当該画像を応答する。
	 */
	private BufferedImage picture(String aString)
	{
		return null;
	}

	/**
	 * サムネイル画像群を応答する。
	 */
	ArrayList<BufferedImage> thumbnails()
	{
		return this.thumbnails;
	}

	/**
	 * 自分自身を文字列にして。それを反応する。
	 */
	public String toString()
	{
		String tuplesString = "";
		for (Tuple tuple : tuples)
        {
	        tuplesString += tuple.toString()+"\n";
        }
		return tuplesString;
	}

	/**
	 * ダプル群を応答する。
	 */
	ArrayList<Tuple> tuples()
	{
		return this.tuples;
	}
}
