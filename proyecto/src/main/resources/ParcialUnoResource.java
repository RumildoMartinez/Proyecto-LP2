from flask import Flask, request, jsonify

app = Flask(__name__)

# Función para determinar si un número es primo
def es_primo(num):
    if num < 2:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True

# Función para obtener los primeros n números primos
def obtener_primos(n):
    primos = []
    contador = 2
    while len(primos) < n:
        if es_primo(contador):
            primos.append(contador)
        contador += 1
    return primos

# Endpoint que recibe un número n y devuelve los primeros n números primos
@app.route('/primos', methods=['GET'])
def obtener_n_primos():
    # Obtener el valor de n desde los parámetros de la URL
    n = request.args.get('n', default=10, type=int)  # Valor por defecto de 10 si no se especifica
    if n <= 0:
        return jsonify({"error": "El número debe ser mayor que 0"}), 400
    primos = obtener_primos(n)
    return jsonify({"primos": primos})

if __name__ == '__main__':
    app.run(debug=True)
