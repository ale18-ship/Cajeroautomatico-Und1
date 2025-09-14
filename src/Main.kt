fun main() {
    println("=== Cajero Automático ===")

    var saldo = 1000.0
    var opcion: Int

    do {
        println("\n1. Consultar saldo")
        println("2. Depositar")
        println("3. Retirar")
        println("4. Salir")
        print("Seleccione una opción: ")

        opcion = readln().toInt()

        when (opcion) {
            1 -> println("Su saldo actual es: $$saldo")
            2 -> {
                print("Ingrese monto a depositar: ")
                val deposito = readln().toDouble()
                saldo += deposito
                println("Depósito exitoso. Nuevo saldo: $$saldo")
            }
            3 -> {
                print("Ingrese monto a retirar: ")
                val retiro = readln().toDouble()
                if (retiro <= saldo) {
                    saldo -= retiro
                    println("Retiro exitoso. Nuevo saldo: $$saldo")
                } else {
                    println("Fondos insuficientes.")
                }
            }
            4 -> println("Gracias por usar el cajero automático.")
            else -> println("Opción inválida, intente de nuevo.")
        }
    } while (opcion != 4)
}