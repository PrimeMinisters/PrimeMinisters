#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv

class IO(object):
	"""入出力：リーダ・ダウンローダ・ライタを抽象する。"""

	def read_csv(self, filename):
		"""指定されたファイルをCSVとして読み込む。"""
		print "[io]readの起動を確認"
		rows = []
		with open(filename,'rU') as file:
		    reader = csv.reader(file)
		    #header = next(reader)
		    for row in reader:
		    	rows.append(row)
		    #print rows
		return rows

	def write_csv(self, filename, rows):
		"""指定されたファイルにCSVとして行たち(rows)を書き出す。"""
		return

	#def test(self):
	#	return 'test'
