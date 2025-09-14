fun main() {
    println("===========================")
    println("     CAJERO AUTOMÁTICO     ")
    println("===========================")

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

    print("Ingrese opción: ")
    val seleccion = readlnOrNull()?.toIntOrNull()

    if (seleccion == null || seleccion !in 1..usuarios.size) {
        println("Opción inválida. Saliendo del programa.")
        return
    }

    val usuario = usuarios[seleccion - 1]

    var opcion: Int
    do {
        println("\n===========================")
        println(" Bienvenido/a, ${usuario.nombre}")
        println("===========================\n")

        println("1. Consultar saldo")
        println("2. Depositar")
        println("3. Retirar")
        println("4. Salir")
        print("Seleccione una opción: ")

        opcion = readlnOrNull()?.toIntOrNull() ?: -1

        when (opcion) {
            1 -> println("Su saldo actual es: $${usuario.saldo}")
            2 -> {
                print("Ingrese monto a depositar: ")
                val deposito = readlnOrNull()?.toDoubleOrNull()
                if (deposito != null && deposito > 0) {
                    usuario.saldo += deposito
                    println("Depósito exitoso. Nuevo saldo: $${usuario.saldo}")
                } else {
                    println("Monto inválido. Intente de nuevo.")
                }
            }
            3 -> {
                print("Ingrese monto a retirar: ")
                val retiro = readlnOrNull()?.toDoubleOrNull()
                if (retiro != null && retiro > 0) {
                    if (retiro <= usuario.saldo) {
                        usuario.saldo -= retiro
                        println("Retiro exitoso. Nuevo saldo: $${usuario.saldo}")
                    } else {
                        println("Fondos insuficientes.")
                    }
                } else {
                    println("Monto inválido. Intente de nuevo.")
                }
            }
            4 -> println("\n===========================" +
                         "\n Gracias por usar el cajero" +
                         "\n===========================")
            else -> println("Opción inválida, intente de nuevo.")
        }
    } while (opcion != 4)
}
