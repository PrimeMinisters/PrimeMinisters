#! /usr/bin/env python
# -*- coding: utf-8 -*-

import datetime
import os
import re

import table
import tuple

class Translator(object):
	"""トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。"""

	def __init__(self, input_table):
		"""トランスレータのコンストラクタ。"""
		self._input_table = input_table
		self._output_table = table.Table('output')

		return

	def compute_string_of_days(self, period):
		"""在位日数を計算して、それを文字列にして応答する。"""
		if period != "在位期間" :
			a_date = re.split(r'\D+', period)
			a_date.remove('')
			# print a_date
			start_day = datetime.date(int(a_date[0]),int(a_date[1]),int(a_date[2]))
			if(len(a_date) == 3):
				current_date = datetime.date.today()
				end_day = datetime.date(current_date.year, current_date.month, current_date.day)
			else:
				end_day = datetime.date(int(a_date[3]),int(a_date[4]),int(a_date[5]))
			period_days = end_day - start_day

			return re.sub(r'(\d)(?=(\d{3})+(?!\d))', '\\1,', str(period_days.days+1))
		else:
			return "在位日数"


	def compute_string_of_image(self, tuple):
		"""サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。"""

		values = tuple.values()
		alt = values[8].split("images/")
		if values[self._input_table.attributes().keys().index('image')] == '画像':
			return '画像'

		html_img_str = "<a name=\""+values[0]+"\" href=\""+values[8]+"\"><img class=\"borderless\" src=\""+values[9]+"\" width=\"25\" height=\"32\" alt=\""+alt[0]+"\"></a>"
		return html_img_str

	def table(self):
		"""総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。"""
		html_table = []
		attributes = self._input_table.attributes()
		keys = attributes.keys()
		tuples = self._input_table.tuples()
		values = []

		for index,a_tuple in enumerate(tuples):
			values = a_tuple.values()

			html_table.append([])
			html_table[index].append(values[keys.index("no")])
			html_table[index].append(values[keys.index("order")])
			html_table[index].append(values[keys.index("names")])
			html_table[index].append(values[keys.index("kana")])
			html_table[index].append(values[keys.index("period")])
			html_table[index].append(self.compute_string_of_days(values[keys.index("period")]))
			html_table[index].append(values[keys.index("school")])
			html_table[index].append(values[keys.index("party")])
			html_table[index].append(values[keys.index("birth")])
			html_table[index].append(self.compute_string_of_image(a_tuple))

		for row in html_table:
			self._output_table.add(tuple.Tuple(self._output_table.attributes(),row))

		return self._output_table
