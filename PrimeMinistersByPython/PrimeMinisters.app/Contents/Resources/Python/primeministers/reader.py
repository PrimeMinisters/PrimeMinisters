#! /usr/bin/env python
# -*- coding: utf-8 -*-

import io
import table
import tuple

class Reader(io.IO):
	"""リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。"""

	def __init__(self, csv_filename):
		"""リーダのコンストラクタ。"""
		self._csv_name = csv_filename
		print "[Reader]ファイルネーム確認",self._csv_name
		return

	def table(self):
		"""ダウンロードしたCSVファイルを読み込んでテーブルを応答する。"""
		print "[Reader]tableの起動を確認"
		csv_table = table.Table('input')
		print "[Reader]ファイルネーム確認",self._csv_name

		#継承の確認
		#test = super(Reader,self).test()
		#print test

		reader = super(Reader,self).read_csv(self._csv_name)
		#print reader
		for row in reader:
			csv_table.add(tuple.Tuple(csv_table.attributes(), row))
			#print row
		return csv_table
