#! /usr/bin/env python
# -*- coding: utf-8 -*-

import os
import shutil

import downloader
import translator
import writer

class Example(object):
	"""例題プログラム：総理大臣のCSVファイルをHTMLページへと変換する。"""

	def main(self):
		"""総理大臣のCSVファイルをHTMLページへと変換するメインプログラム。"""

		# ホームディレクトリの直下のデスクトップのディレクトリに、
		# SouriDaijinというディレクトリを作成する。
		# すでに存在すれば、当該ディレクトリを消して、新たに作り、
		# 存在しなければ、当該ディレクトリを作成する。

		#ここからデバックのためのコメントアウト多数につき注意

		#print "[example]ホームディレクトリを指定:",
		home_directory = os.environ['HOME']
		#print home_directory

		print "[example]ベースディレクトリを指定:",
		base_directory = home_directory + '/Desktop/SouriDaijin/'
		print base_directory

		if os.path.isdir(base_directory):
			print "[example]ベースディレクトリからディレクトリを削除"
			shutil.rmtree(base_directory)

		print "[example]ベースディレクトリからディレクトリを作成"
		os.makedirs(base_directory)

		# ダウンローダに必要なファイル群をすべてダウンロードしてもらい、
		# 入力となるテーブルを獲得する。
		a_downloader = downloader.Downloader(base_directory)
		a_table = a_downloader.download_all()
		print a_table

		# トランスレータに入力となるテーブルを渡して変換してもらい、
		# 出力となるテーブルを獲得する。
		a_translator = translator.Translator(a_table)
		a_table = a_translator.table()
		print a_table

		# ライタに出力となるテーブルを渡して、
		# Webページを作成してもらう。
		a_writer = writer.Writer(base_directory, a_table)
		a_writer.write()

		return 0
