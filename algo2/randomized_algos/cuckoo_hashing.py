class CuckooHash(object):

	def __init__(self, size, hashTable):
		self.size = size
		self.hashTable = hashTable

	def lookup(self, x):
		return self.hashTable[hashFunction1(x)] == x or self.hashTable[hashFunction2(x)] == x

	def insert(self, x):
		if lookup(x): return
		for i in range(len(self.hashTable)):
			if hashFunction1(x) not in self.hashTable:
				self.hashTable[hashFunction1(x)] = x
				return
			swap(x, self.hashTable[hashFunction1(x)])
			if hashFunction2(x) not in self.hashTable:
				self.hashTable[hashFunction2(x)] = x
				return
			swap(x, self.hashTable[hashfunction2(x)])
		rehash()
		insert(x)

	def remove(self, x):
		if self.hashTable[hashFunction1(x)] == x:
			del self.hashTable[hashFunction1(x)]
			return
		if self.hashTable[hashFunction2(x)] == x:
			del self.hashTable[hashFunction2(x)]
			return
