# Randomized quicksort is a randomized 
# algorithm where the pivot is selected randomly.
from random import randint

def randQS(unorderedList):
	length = len(unorderedList)
	if length <= 1:
		return unorderedList
	i = randint(0, length - 1)
	pivot = unorderedList[i]
	listA = []
	listB = []
	listC = []
	for elem in unorderedList:
		if elem < pivot: 
			listA.append(elem)
		elif elem == pivot:
			listB.append(elem)
		else:
			listC.append(elem)
	return randQS(listA) + listB + randQS(listC)