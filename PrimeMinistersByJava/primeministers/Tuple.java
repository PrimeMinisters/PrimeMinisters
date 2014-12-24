package primeministers;

import java.util.ArrayList;

/**
 * タプル：総理大臣の情報テーブルの中の各々のレコード。
 * 
 * @author isobe ueda
 */
public class Tuple extends Object
{
	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;

	/**
	 * 値リストを記憶するフィールド。
	 */
	private ArrayList<String> values;

	/**
	 * 属性リストと値リストからタプルを作るコンストラクタ
	 * 
	 * @param instanceOfAttributes
	 *            属性リストを保持するフィールド。
	 * @param valueCollection
	 *            値リストを保持するフィールド。
	 */
	Tuple(Attributes instanceOfAttributes, ArrayList<String> valueCollection)
	{
		this.attributes = instanceOfAttributes;
		this.values = valueCollection;
		return;
	}

	/**
	 * 属性リストを応答する。
	 * 
	 * @return 属性リスト。
	 */
	public Attributes attributes()
	{
		return this.attributes;
	}

	/**
	 * 自分自身を文字列にして、それを応答する。
	 * 
	 * @return 値リストの文字列。
	 */
	@Override
	public String toString()
	{
		String valueString = "";
		for (String aValue : values)
		{
			if (aValue.startsWith("<a name"))
				valueString += "<a name=\"" + this.values.get(0) + "\"...</a>";
			else
				valueString += aValue + " ";
		}

		return valueString;
	}

	/**
	 * 値リストを応答する。
	 * 
	 * @return 値リスト。
	 */
	public ArrayList<String> values()
	{
		return this.values;
	}
}