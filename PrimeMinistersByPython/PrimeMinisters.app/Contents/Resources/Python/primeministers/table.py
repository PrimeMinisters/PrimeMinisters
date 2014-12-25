#! /usr/bin/env python
# -*- coding: utf-8 -*-

import attributes

class Table(object):
	"""表：総理大臣の情報テーブル。"""

	def __init__(self, kind_string):
		"""テーブルのコンストラクタ。"""
		print "[table]テーブルのコンストラクタの起動"
		self._kind = kind_string
		self._attributes = attributes.Attributes(self._kind)
		self._images = []
		self._smallImages = []
		self._tuples = []
		return

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
		tuples_str = ''
		for index,a_tuple in enumerate(self._tuples) :
			if index == 0:
				pass
			else :
				tuples_str = tuples_str + str(a_tuple) + '\n'

		return self._kind+'table :\n'+str(self._attributes)+'\n'+tuples_str

	def add(self, tuple):
		"""タプルを追加する。"""
		value = tuple.values()
		keys = tuple.attributes().keys()
		if value[keys.index('image')] != '画像':
			self._images.append(value[keys.index('image')])
			if self._kind == 'input':
				self._smallImages.append(value[keys.index('thumbnail')])
		self._tuples.append(tuple)
		return

	def attributes(self):
		"""属性リストを応答する。"""
		return self._attributes

	def image_filenames(self):
		"""画像ファイル群をリストにして応答する。"""
		return self._images

	def thumbnail_filenames(self):
		"""縮小画像ファイル群をリストにして応答する。"""
		return self._smallImages

	def tuples(self):
		"""タプル群を応答する。"""
		return self._tuples
