# Main class for testing randomized quicksort algorithm
from random_quicksort import randQS

def main():
	unorderedList = [4,2,6,1,5,6,7,7,3,9, 23, 12]
	orderedList = randQS(unorderedList)
	for elem in orderedList:
		print elem
