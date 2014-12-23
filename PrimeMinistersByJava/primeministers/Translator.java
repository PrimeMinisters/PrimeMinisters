package primeministers;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 */
public class Translator extends Object
{

	/**
	 * CSVに由来するテーブルを記憶するフィールド
	 */
	private Table inputTable;

	/**
	 * HTMLに由来するテーブルを記憶するフィールド
	 */
	private Table outputTable;

	/**
	 * トランスレータのコンストラクタ。
	 */
	public Translator()
	{
		super();
		this.inputTable = new Table();
		this.outputTable = new Table();
		return;
	}

	/**
	 * 総理大臣のCSVファイルをHTMLページへ変換する。
	 */
	public void perform()
	{
		// ダウンロードを使ってCSVをダウンロードしてくる
		Downloader aDownloader = new Downloader();
		aDownloader.downloadCSV();

		this.inputTable = aDownloader.table();
		// System.out.println("inputTable: \n"+inputTable);

		aDownloader.downloadImages();
		aDownloader.downloadThumbnails();

		System.out.println("[Translator]Inputテーブル作成完了");
		// System.out.println("inputTable: \n" + this.inputTable);

		this.outputTable = table(this.inputTable);
		System.out.println("[Translator]Outputテーブル作成完了");
		System.out.println("outputTable: \n" + this.outputTable);

		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告",
		        JOptionPane.PLAIN_MESSAGE);
		return;
	}

	/**
	 * 在位日数を計算して、それを文字列にして応答する。
	 */
	public String computeNumberOfDays(String periodString)
	{
		System.out.println(periodString);
		if (!periodString.equals("在位期間"))
		{
			String[] aDate = periodString.split("\\D");
			String startDayStr = aDate[0] + "/" + aDate[1] + "/" + aDate[2];
			String endDayStr = "";
			long periodDays = 0;

			try
			{
				if (aDate.length == 7)
				{
					endDayStr = aDate[4] + "/" + aDate[5] + "/" + aDate[6];
				}

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date startDay = sdf.parse(startDayStr);
				Date endDay;
				if (aDate.length != 7)
					endDay = new Date();
				else
					endDay = sdf.parse(endDayStr);

				periodDays = (endDay.getTime() - startDay.getTime())
				        / (1000 * 60 * 60 * 24) + 1;

			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}

			String commaPeriodDays = String.valueOf(periodDays).replaceAll(
			        "(\\d)(?=(\\d{3})+(?!\\d))", "\\2,");
			return commaPeriodDays;
		}
		else
		{
			return "在位日数";
		}
	}

	/**
	 * サムネイルが画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。
	 */
	public String computeNumberOfImage(String periodString, Tuple aTuple)
	{
		ArrayList<String> values = aTuple.values();
		String[] alt = periodString.split("images/");
		if (values.get(aTuple.attributes().keys().indexOf("image"))
		        .equals("画像"))
			return "画像";

		String htmlImgStrings = "<a name=\"" + values.get(0) + "\" href=\""
		        + values.get(8) + "\">" + "<img class=\"borderless\" src=\""
		        + values.get(9) + "\"" + " width=\"25\" height=\"32\" alt=\""
		        + alt[1] + "\"></a>";
		return htmlImgStrings;
	}

	/**
	 * 総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。
	 */
	public Table table(Table aTable)
	{
		System.out.println("[Translator]tableの起動を確認");

		Table htmlTable = new Table();
		Attributes htmlAttributes = new Attributes("output");

		ArrayList<String> keys = aTable.attributes().keys();
		ArrayList<Tuple> tuples = aTable.tuples();
		ArrayList<String> values;

		for (Tuple aTuple : tuples)
		{
			values = aTuple.values();
			Tuple htmlTuple = new Tuple(htmlAttributes, new ArrayList<String>());

			htmlTuple.values().add(values.get(keys.indexOf("no")));
			htmlTuple.values().add(values.get(keys.indexOf("order")));
			htmlTuple.values().add(values.get(keys.indexOf("names")));
			htmlTuple.values().add(values.get(keys.indexOf("kana")));
			htmlTuple.values().add(values.get(keys.indexOf("period")));
			htmlTuple.values()
			        .add(this.computeNumberOfDays(values.get(keys
			                .indexOf("period"))));
			htmlTuple.values().add(values.get(keys.indexOf("school")));
			htmlTuple.values().add(values.get(keys.indexOf("party")));
			htmlTuple.values().add(values.get(keys.indexOf("birth")));
			htmlTuple.values().add(
			        this.computeNumberOfImage(
			                values.get(keys.indexOf("image")), aTuple));

			htmlTable.add(htmlTuple);
		}

		return htmlTable;
	}
}
