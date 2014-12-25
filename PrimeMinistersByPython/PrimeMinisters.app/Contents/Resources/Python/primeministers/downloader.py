#! /usr/bin/env python
# -*- coding: utf-8 -*-

import os
import shutil
import urllib

import io
import reader

class Downloader(io.IO):
	"""ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。"""
	def __init__(self, base_directory):
		"""ダウンローダのコンストラクタ。"""
		print "[Downloader]コンストラクタ実行"
		self._directory = base_directory
		self._csv_directory = base_directory + 'csv/'
		self._images_directory = base_directory + 'images/'
		self._thumbnails_directory = base_directory + 'thumbnails/'

		self._base_url = 'http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/'
		self._csv_name = 'PrimeMinisters.csv'
		if(self._directory == None):
			print "[Downloader]エラー:No directory"
		print "[Downloader]directory="+self._directory
		return

	def download_all(self):
		"""すべて（総理大臣の情報を記したCSVファイル・画像ファイル群・縮小画像ファイル群）をダウンロードし、テーブルを応答する。"""
		#print "[Downloader]csv用のディレクトリを準備する"
		if os.path.isdir(self._csv_directory):
			shutil.rmtree(self._csv_directory)
		os.makedirs(self._csv_directory)
		#print "[Downloader]csv用のディレクトリ完了"

		#print "[Downloader]image用のディレクトリを準備する"
		if os.path.isdir(self._images_directory):
			shutil.rmtree(self._images_directory)
		os.makedirs(self._images_directory)
		#print "[Downloader]images用のディレクトリ完了"

		#print "[Downloader]image用のディレクトリを準備する"
		if os.path.isdir(self._thumbnails_directory):
			shutil.rmtree(self._thumbnails_directory)
		os.makedirs(self._thumbnails_directory)
		#print "[Downloader]images用のディレクトリ完了"


		self.download_csv()

		csv_reader = reader.Reader(self._csv_directory+self._csv_name)
		csv_table = csv_reader.table()

		print "[Downloader]imageのダウンロードを実行"
		images = csv_table.image_filenames()
		#print "test",images
		self.download_images(images)
		print "[Downloader]imageのダウンロードを完了?"

		thumbnail_images = csv_table.thumbnail_filenames()
		self.download_images(thumbnail_images)

		return csv_table

	def download_csv(self):
		"""総理大臣の情報を記したCSVファイルをダウンロードする。"""
		"""csv用のディレクトリにダウンロードしてきたcsvを保存"""			
		print "[Downloader]csvのダウンロードを実行	"
		
		filename = os.path.join(self._csv_directory, 'PrimeMinisters.csv')
		#print "[Downloader]filename=",
		#print filename

		#if os.path.exists(filename) and os.path.isfile(filename):
			#print "[Downloader]csvを確認"
			#pass
		#else:
		try:
			url =  self._base_url+self._csv_name
			urllib.urlopen(url)
			print "[Downloader]csvのURLの認証クリア"
		except URLError,an_exception:
			print an_exception.reason

		try:
			urllib.urlretrieve(url, filename)
			print "[Downloader]csvをURLからダウンロード"
		except IOError,an_exception:
			print an_exception.reason


		return None

	def download_images(self, image_filenames):
		"""画像ファイル群または縮小画像ファイル群をダウンロードする。"""
		for filename in image_filenames:
			try:
				a_url = urllib.urlopen(self._base_url + filename)
				print self._base_url + filename
			except URLError, an_exception:
				print an_exception.reason
			try:
				with open(self._directory + filename,'w') as a_file:
					shutil.copyfileobj(a_url, a_file)
			except IOError, an_exception:
				print an_exception.reason
			a_url.close()

		return
