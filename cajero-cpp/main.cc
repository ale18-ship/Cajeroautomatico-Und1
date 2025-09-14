#include <iostream>
#include <string>
using namespace std;

struct Usuario {
    string nombre;
    double saldo;
};

int main() {
    Usuario usuarios[3] = {
        {"Juan", 500.0},
        {"María", 750.0},
        {"Pedro", 300.0}
    };

    cout << "===========================" << endl;
    cout << "   CAJERO AUTOMÁTICO (C++) " << endl;
    cout << "===========================" << endl;

    cout << "Usuarios disponibles:" << endl;
    for (int i = 0; i < 3; i++) {
        cout << i + 1 << ". " << usuarios[i].nombre << endl;
    }

    int seleccion;
    cout << "Seleccione un usuario: ";
    cin >> seleccion;

    if (seleccion < 1 || seleccion > 3) {
        cout << "❌ Opción inválida." << endl;
        return 0;
    }

    Usuario &usuario = usuarios[seleccion - 1];
    int opcion;

    do {
        cout << "\n===========================" << endl;
        cout << " Bienvenido/a, " << usuario.nombre << endl;
        cout << "===========================" << endl;

        cout << "1. Consultar saldo" << endl;
        cout << "2. Depositar" << endl;
        cout << "3. Retirar" << endl;
        cout << "4. Salir" << endl;
        cout << "Seleccione una opción: ";
        cin >> opcion;

        switch (opcion) {
            case 1:
                cout << "💰 Su saldo actual es: $" << usuario.saldo << endl;
                break;
            case 2: {
                double deposito;
                cout << "Ingrese monto a depositar: ";
                cin >> deposito;
                if (deposito > 0) {
                    usuario.saldo += deposito;
                    cout << "✅ Depósito exitoso. Nuevo saldo: $" << usuario.saldo << endl;
                } else {
                    cout << "❌ Monto inválido." << endl;
                }
                break;
            }
            case 3: {
                double retiro;
                cout << "Ingrese monto a retirar: ";
                cin >> retiro;
                if (retiro > 0 && retiro <= usuario.saldo) {
                    usuario.saldo -= retiro;
                    cout << "✅ Retiro exitoso. Nuevo saldo: $" << usuario.saldo << endl;
                } else {
                    cout << "❌ Fondos insuficientes o monto inválido." << endl;
                }
                break;
            }
            case 4:
                cout << "👋 Gracias por usar el cajero." << endl;
                break;
            default:
                cout << "❌ Opción inválida." << endl;
        }
    } while (opcion != 4);

    return 0;
}

