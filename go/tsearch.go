package main

import (
	"fmt"
)

func print(text string, pattern string, position int) {
	fmt.Printf("%s\n", text)

	padding := repeat(" ", position)
	fmt.Printf("%s%s\n", padding, pattern)
}

func debug(txt string, pat string, padding int, txt_pos int, pat_pos int) {
	if false {
		fmt.Printf("%s*\n", repeat(" ", txt_pos))
		fmt.Printf("%s\n", txt)
		fmt.Printf("%s%s\n", repeat(" ", padding), pat)
		fmt.Printf("%s*\n", repeat(" ", pat_pos + padding))
		fmt.Printf("-----\n")
	}
}

func brute_force_search(txt string, pat string) int {
	for i := 0; i <= len(txt) - len(pat); i++ {
		txt_pos := i
		pat_pos := 0

		for ; pat_pos < len(pat); {
			debug(txt, pat, i, txt_pos, pat_pos)
			if txt[txt_pos] != pat[pat_pos] {
				break;
			}

			txt_pos++
			pat_pos++
		}

		if pat_pos == len(pat) {
			return txt_pos - pat_pos
		}
	}

	return -1
}

func repeat(text string, count int) string {
	str := ""
	for i := 0; i < count; i++ {
		str += text
	}

	return str
}

func search(txt string, pat string) {
	index := brute_force_search(txt, pat)

	fmt.Printf("index = %d: %s <-> %s\n", index, txt, pat)
	if index != -1 {
		print(txt, pat, index)
	}
}

func main() {
	search("abacb", "ac")
	search("abacb", "aa")
}
