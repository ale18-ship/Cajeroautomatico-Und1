fun main() {
    println("=== Cajero Automático ===")

    // Lista de usuarios
    val usuarios = listOf(
        Usuario("Juan", 500.0),
        Usuario("María", 750.0),
        Usuario("Pedro", 300.0)
    )

    println("Bienvenido al cajero automático")
    println("Usuarios disponibles:")

    usuarios.forEachIndexed { index, usuario ->
        println("${index + 1}. ${usuario.nombre} - Saldo: ${usuario.saldo}")
    }

    // Selección de usuario
    print("Ingrese opción: ")
    val seleccion = readln().toInt() - 1
    val usuario = usuarios[seleccion]

    var opcion: Int
    do {
        println("\nBienvenido, ${usuario.nombre}")
        println("1. Consultar saldo")
        println("2. Depositar")
        println("3. Retirar")
        println("4. Salir")
        print("Seleccione una opción: ")

        opcion = readln().toInt()

        when (opcion) {
            1 -> println("Su saldo actual es: $${usuario.saldo}")
            2 -> {
                print("Ingrese monto a depositar: ")
                val deposito = readln().toDouble()
                usuario.saldo += deposito
                println("Depósito exitoso. Nuevo saldo: $${usuario.saldo}")
            }
            3 -> {
                print("Ingrese monto a retirar: ")
                val retiro = readln().toDouble()
                if (retiro <= usuario.saldo) {
                    usuario.saldo -= retiro
                    println("Retiro exitoso. Nuevo saldo: $${usuario.saldo}")
                } else {
                    println("Fondos insuficientes.")
                }
            }
            4 -> println("Gracias por usar el cajero automático.")
            else -> println("Opción inválida, intente de nuevo.")
        }
    } while (opcion != 4)
}
