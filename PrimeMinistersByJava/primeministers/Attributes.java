package primeministers;

import java.util.ArrayList;

/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 */
public class Attributes extends Object
{

	/**
	 * 属性リストのキー群を記憶フィールド。
	 */
	private ArrayList<String> keys;

	/**
	 * 属性リストの名前群を記憶するフィールド
	 */
	private ArrayList<String> names;

	/**
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
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
	 */
	private int indexOf(String aString)
	{
		return this.keys.indexOf(aString);
	}

	/**
	 * 在位日数のインデックスを応答する
	 */
	int indexOfDays()
	{
        return this.names.indexOf(nameAt(this.indexOf("day")));
	}

	/**
	 * 画像のインデックスを応答する。
	 */
    int indexOfImage()
    {
        return this.names.indexOf(nameAt(this.indexOf("image")));
    }

    /**
     * ふりがなのインデックスを応答する。
     */
    int indexOfkana()
    {
        return this.names.indexOf(nameAt(this.indexOf("kana")));
    }

    /**
     * 氏名のインデックスを応答する。
     */
    int indexOfName()
    {
        return this.names.indexOf(nameAt(this.indexOf("names")));
    }

    /**
     * 番号のインデックスを応答する。
     */
    int indexOfNo()
    {
        return this.names.indexOf(nameAt(this.indexOf("no")));
    }

    /**
     * 代のインデックスを応答する。
     */
    int indexOfOrder()
    {
        return this.names.indexOf(nameAt(this.indexOf("order")));
    }

    /**
     * 政党のインデックスを応答する。
     */
    int indexOfParty()
    {
        return this.names.indexOf(nameAt(this.indexOf("party")));
    }

    /**
     * 在位期間のインデックスを応答する。
     */
    int indexOfPeriod()
    {
        return this.names.indexOf(nameAt(this.indexOf("period")));
    }

    /**
     * 出身地のインデックスを応答する。
     */
    int indexOfPlace()
    {
        return this.names.indexOf(nameAt(this.indexOf("birth")));
    }

    /**
     * サムネイル画像のインデックスを応答する。
     */
    int indexOfThumbnail()
    {
        return this.names.indexOf(nameAt(this.indexOf("thumbnail")));
    }

	/**
	 * 指定されたインデックスに対応するキーを応答する。
	 */
	protected String keyAt(int index)
	{
		return this.keys.get(index);
	}

	/**
	 * キー郡を応答する。
	 */
	ArrayList<String> keys()
	{
		return this.keys;
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 */
	protected String nameAt(int index)
	{
		return this.names.get(index);
	}

	/**
	 * 名前群を応答する。
	 */
	ArrayList<String> names()
	{
		return this.names;
	}

	/**
	 * 名前郡を設定する。
	 */
	void names(ArrayList<String> aCollection)
	{
		this.names = aCollection;
		return;
	}

	/**
	 * 属性リストの長さを応答する。
	 */
	int size()
	{
		return this.names.size();
	}

	/**
	 * 自身を文字列にして、それを応答する。
	 */
	public String toString()
	{
		String nameString = "";
		for (String name : names)
        {
	        nameString += name+" ";
        }
		
		return nameString;
	}
}
