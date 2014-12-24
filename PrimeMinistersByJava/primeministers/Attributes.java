package primeministers;

import java.util.ArrayList;

/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 * 
 * @author isobe ueda
 */
public class Attributes extends Object
{

	/**
	 * 属性リストのキー群を記憶フィールド。
	 */
	private ArrayList<String> keys;

	/**
	 * 属性リストの名前群を記憶するフィールド。
	 */
	private ArrayList<String> names;

	/**
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	 * 
	 * @param aString
	 *            入力用または出力用を表す文字列。
	 */
	Attributes(String aString)
	{
		this.keys = new ArrayList<String>();
		this.names = new ArrayList<String>();
		if (aString == "input")
		{
			System.out.println("[Attributes]kind = input");
			this.keys.add("no");
			this.keys.add("order");
			this.keys.add("names");
			this.keys.add("kana");
			this.keys.add("period");
			this.keys.add("school");
			this.keys.add("party");
			this.keys.add("birth");
			this.keys.add("image");
			this.keys.add("thumbnail");

			this.names.add("人目");
			this.names.add("代");
			this.names.add("氏名");
			this.names.add("ふりがな");
			this.names.add("在位期間");
			this.names.add("出身校");
			this.names.add("政党");
			this.names.add("出身地");
			this.names.add("画像");
			this.names.add("サムネイル");

		}
		else if (aString == "output")
		{
			System.out.println("[Attributes]kind = output");
			this.keys.add("no");
			this.keys.add("order");
			this.keys.add("names");
			this.keys.add("kana");
			this.keys.add("period");
			this.keys.add("day");
			this.keys.add("school");
			this.keys.add("party");
			this.keys.add("birth");
			this.keys.add("image");

			this.names.add("人目");
			this.names.add("代");
			this.names.add("氏名");
			this.names.add("ふりがな");
			this.names.add("在位期間");
			this.names.add("在位日数");
			this.names.add("出身校");
			this.names.add("政党");
			this.names.add("出身地");
			this.names.add("画像");

		}
		else
		{
			System.out.println("[Attributes]属性エラー");
		}
		return;
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。名前がないときはキーを応答する。
	 * 
	 * @param index
	 *            インデックス番号。
	 * @return 指定されたインデックスに対応する名前又はキー。
	 */
	protected String at(int index)
	{
		if (this.names.get(index) != null)
		{
			return this.names.get(index);
		}
		else if (this.keys.get(index) != null)
		{
			return this.keys.get(index);
		}
		else
		{
			System.out.println("[Attributes]このindexに対応する名前及びキーが存在しません。");
			return null;
		}
	}

	/**
	 * 指定されたキー文字列のインデックスを応答する。
	 * 
	 * @param aString
	 *            指定するキー文字列。
	 * @return 指定されたキー文字列のインデックス。
	 */
	private int indexOf(String aString)
	{
		return this.keys.indexOf(aString);
	}

	/**
	 * 在位日数のインデックスを応答する。
	 * 
	 * @return 在位日数のインデックス。
	 */
	int indexOfDays()
	{
		return this.names.indexOf(nameAt(this.indexOf("day")));
	}

	/**
	 * 画像のインデックスを応答する。
	 * 
	 * @return 画像のインデックス。
	 */
	int indexOfImage()
	{
		return this.names.indexOf(nameAt(this.indexOf("image")));
	}

	/**
	 * ふりがなのインデックスを応答する。
	 * 
	 * @return ふりがなのインデックス。
	 */
	int indexOfkana()
	{
		return this.names.indexOf(nameAt(this.indexOf("kana")));
	}

	/**
	 * 氏名のインデックスを応答する。
	 * 
	 * @return 氏名のインデックス。
	 */
	int indexOfName()
	{
		return this.names.indexOf(nameAt(this.indexOf("names")));
	}

	/**
	 * 番号のインデックスを応答する。
	 * 
	 * @return 番号のインデックス。
	 */
	int indexOfNo()
	{
		return this.names.indexOf(nameAt(this.indexOf("no")));
	}

	/**
	 * 代のインデックスを応答する。
	 * 
	 * @return 代のインデックス。
	 */
	int indexOfOrder()
	{
		return this.names.indexOf(nameAt(this.indexOf("order")));
	}

	/**
	 * 政党のインデックスを応答する。
	 * 
	 * @return 政党のインデックス。
	 */
	int indexOfParty()
	{
		return this.names.indexOf(nameAt(this.indexOf("party")));
	}

	/**
	 * 在位期間のインデックスを応答する。
	 * 
	 * @return 在位期間のインデックス。
	 */
	int indexOfPeriod()
	{
		return this.names.indexOf(nameAt(this.indexOf("period")));
	}

	/**
	 * 出身地のインデックスを応答する。
	 * 
	 * @return 出身地のインデックス。
	 */
	int indexOfPlace()
	{
		return this.names.indexOf(nameAt(this.indexOf("birth")));
	}

	/**
	 * サムネイル画像のインデックスを応答する。
	 * 
	 * @return サムネイル画像のインデックス。
	 */
	int indexOfThumbnail()
	{
		return this.names.indexOf(nameAt(this.indexOf("thumbnail")));
	}

	/**
	 * 指定されたインデックスに対応するキーを応答する。
	 * 
	 * @param index
	 *            指定するインデックス。
	 * @return 指定されたインデックスに対応するキー。
	 */
	protected String keyAt(int index)
	{
		return this.keys.get(index);
	}

	/**
	 * キー群を応答する。
	 * 
	 * @return キー群を保持するフィールド。
	 */
	ArrayList<String> keys()
	{
		return this.keys;
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 * 
	 * @param index
	 *            指定するインデックス。
	 * @return 指定されたインデックスに対応する
	 */
	protected String nameAt(int index)
	{
		return this.names.get(index);
	}

	/**
	 * 名前群を応答する。
	 * 
	 * @return 名前群を保持するフィールド。
	 */
	ArrayList<String> names()
	{
		return this.names;
	}

	/**
	 * 名前郡を設定する。
	 * 
	 * @param aCollection
	 *            文字列群を保持するリスト。
	 */
	void names(ArrayList<String> aCollection)
	{
		this.names = aCollection;
		return;
	}

	/**
	 * 属性リストの長さを応答する。
	 * 
	 * @return 属性リストの長さ。
	 */
	int size()
	{
		return this.names.size();
	}

	/**
	 * 自身を文字列にして、それを応答する。
	 * 
	 * @return 名前群の文字列。
	 */
	@Override
	public String toString()
	{
		String nameString = "";
		for (String name : names)
		{
			nameString += name + " ";
		}

		return nameString;
	}
}
