#! /usr/bin/env python
# -*- coding: utf-8 -*-

class Attributes(object):
	"""属性リスト：総理大臣の情報テーブルを入出力する際の属性情報を記憶。"""

	def __init__(self, kind_string):
		"""入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。"""
		self._keys = []
		self._names = []
		if kind_string == 'input':
			print "[Attributes]kind = input"
			self._keys = ['no','order','names','kana','period','school','party','birth','image','thumbnail']
			self._names = ['人目','代','氏名','ふりがな','在位期間','出身校','政党','出身地','画像','サムネイル']
		elif kind_string == 'output':
			print "[Attributes]kind = output"
			self._keys = ['no','order','names','kana','period','day','school','party','birth','image']
			self._names = ['人目','代','氏名','ふりがな','在位期間','在位日数','出身校','政党','出身地','画像']
		else:
			print "[Attributes]属性エラー"
		return

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
		names_str = ''
		for a_name in self._names :
			names_str = names_str + a_name + ' '

		return names_str

	def keys(self):
		"""キー群を応答する。"""
		return self._keys

	def names(self):
		"""名前群を応答する。"""
		return self._names

	def set_names(self, names):
		"""名前群を設定する。"""
		self._names.extend(names)

		return
