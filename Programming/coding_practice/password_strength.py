def password_strength(password):
    vowels = "aeiou"
    consonents = "qwrtypsdfghjklzxcvbnm"
    strength = 0
    set_index = False
    index_consonent = False
    index_vowel = False
    subsets = []
    index = 0
    counter = 0

    for character in password:
        if (character not in vowels) and (character not in consonents):
            print(character)
            return strength
        else:
            if not set_index:
                if  character in vowels:
                    index_vowel = True
                else:
                    index_consonent = True
                set_index = True
                index = counter
            else:
                if index_consonent and (character in vowels):
                    subsets.append(password[index:counter+1])
                    index_consonent = False
                    set_index = False
                elif index_vowel and (character in consonents):
                    subsets.append(password[index:counter+1])
                    index_vowel = False
                    set_index = False
                pass
        counter += 1

    strength = len(subsets)
    print(subsets)
    return strength


test = ["thisisbeautiful", "rhythm", "aeiou", "a", "t", "ababab", "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz", "xyz", "abcde", "", "beautifulcoding", "aaaabbbbcccc", "abc@123", "a" * 10**5]
for password in test:
    print(password_strength(password))
    print("--------------------------\n")
pass
# password_strength(test[0])