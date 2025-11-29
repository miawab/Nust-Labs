def decrypt(str):
    key = 1
    while key < 27:
        decrypted = ""
        for char in str:
            if ord(char) == 32:
                decrypted += " "
                continue
            if char.isupper():
                decrypted += chr((ord(char) - ord('A') - key) % 26 + ord('A'))
            elif char.islower():
                decrypted += chr((ord(char) - ord('a') - key) % 26 + ord('a'))
            else:
                decrypted += char
        print(key,": ",decrypted)
        key += 1


decrypt(input("enter a str to be decrypted: "))