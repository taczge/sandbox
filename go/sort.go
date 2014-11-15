package main

import(
	"fmt"
)

func print(array []int) {
	fmt.Printf("%v\n", array)
}

func swap(array []int, i int, j int) {
	tmp := array[i]
	array[i] = array[j]
	array[j] = tmp
}

func bubble(array []int) {
	for i := 0; i < len(array) - 1; i++ {
		for j := 0; j < len(array) - i - 1; j++ {
			if array[j] > array[j + 1] {
				swap(array, j, j + 1)
			}
		}
	}
}

func selection(array []int) {
	for i := 0; i < len(array) - 1; i++ {
		min_index := i
		for j := i + 1; j < len(array); j++ {
			if array[j] < array[min_index] {
				min_index = j
			}
		}
		swap(array, i, min_index)
	}
}

func insertion(array []int) {
	for i := 0; i < len(array) - 1; i++ {
		for j := i + 1; j > 0; j-- {
			if array[j - 1] < array[j] {
				break;
			}
			swap(array, j, j - 1)
		}
	}
}

func main() {
	array := []int{3, 0, 1, 8, 7, 2, 5, 4, 6, 9}

	fmt.Println("--")
	print(array)
//	bubble(array)
//	selection(array)
	insertion(array)
	print(array)
}
