class Solution:
    def countVowelPermutation(self, n: int) -> int:
      
        MOD = (10 ** 9 + 7)

        @functools.cache
        def vowel_count(len, vowel):
            total = 1
            if (len<=1): return len;
            if vowel == 'a':
                total = (vowel_count(len - 1, 'e') + vowel_count(len - 1, 'i') + vowel_count(len - 1, 'u')) % MOD
            elif vowel == 'e':
                total = (vowel_count(len - 1, 'a') + vowel_count(len - 1, 'i')) % MOD
            elif vowel == 'i':
                total = (vowel_count(len - 1, 'e') + vowel_count(len - 1, 'o')) % MOD
            elif vowel == 'o':
                total = (vowel_count(len - 1, 'i')) % MOD
            else:
                 total = (vowel_count(len - 1, 'i') + vowel_count(len - 1, 'o')) % MOD
            return total
        
        return sum(vowel_count(n, vowel) for vowel in 'aeiou') % MOD


