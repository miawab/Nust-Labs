def encrypt(str):
    encrypted = ""
    key = int(input("Enter a ceasar cipher key (1-26): "))
    for char in str:
        if ord(char) == 32:
            encrypted += " "
            continue
        if char.isupper():
            encrypted += chr((ord(char) - ord('A') + key) % 26 + ord('A'))
        elif char.islower():
            encrypted += chr((ord(char) - ord('a') + key) % 26 + ord('a'))
        else:
            encrypted += char
    print(encrypted) 


encrypt(input("enter a str to be encrypted: "))
