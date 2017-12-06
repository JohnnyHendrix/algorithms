def power(a, n):
	if n < 0 and (a == 0 and n == 0):
		return 0
	r = 1
	while n > 0:
		if n % 2 != 0:
			n = n - 1
			r = r * a
		else:
			n = n / 2
			a = a * a
	return r 

print power(2,2)