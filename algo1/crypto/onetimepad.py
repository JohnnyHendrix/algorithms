class OneTimePad:
	def __init__(self, key):
		self.key = key

	def encrypt(self, message):
		return hex(message ^ self.key)

	def decrypt(self, cipher):
		return hex(cipher ^ self.key)

oneTime = OneTimePad(0x72f9)
ciph = oneTime.encrypt(0xbeef)
print ciph
m = oneTime.decrypt(0xcc16)
print m
