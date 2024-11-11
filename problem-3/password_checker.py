def checkear_contrasena(contrasena):
    if len(contrasena) < 8:
        return False

    if contrasena.isalpha():
        return False

    if contrasena.isdigit():
        return False

    char_especial = ["!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "="]

    cuenta = sum(1 for char in contrasena if char in char_especial)

    if cuenta < 2:
        return False

    return True

if __name__ == "__main__":
    contrasena = input("Ingrese una contrasena: ")
    if checkear_contrasena(contrasena):
        print("Contrasena segura")
    else:
        print("Contrasena insegura")
