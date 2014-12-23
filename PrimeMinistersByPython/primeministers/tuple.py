#! /usr/bin/env python
# -*- coding: utf-8 -*-

class Tuple(object):
	"""タプル：総理大臣の情報テーブルの中の各々のレコード。"""

	def __init__(self, attributes, values):
		"""属性リストと値リストからタプルを作るコンストラクタ。"""
		self._attributes = attributes
		self._values = values
		return

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
		values_str = ""
		for a_value in self._values :
			if a_value.startswith('<a name') :
				values_str = values_str + '<a name="'+self._values[0]+'"...</a>'
			else :
				values_str = values_str + a_value + ' '

		return values_str

	def attributes(self):
		"""属性リストを応答する。"""
		return self._attributes

	def values(self):
		"""値リストを応答する。"""
		return self._values

	def set_values(self, values):
		"""値リストを設定する。"""
		self._value.extend(values)
		return
