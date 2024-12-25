package org.example.utils;

import org.example.controllers.IceCreamController;

public class IceCreamMenu {
    private final IceCreamController controller;
    private final IHandler handler;

    //constructor que utilizaremos para las pruebas unitarias
    public IceCreamMenu(IceCreamController controller, IHandler handler) {
        this.controller = controller;
        this.handler = handler;
    }


    public IceCreamMenu(IHandler handler) {
        this( new IceCreamController(), handler);
    }
    //El constructor IceCreamMenu(IHandler handler) toma un parámetro handler y,
    // al ser llamado, invoca a otro constructor de la misma clase, pasando el handler y
    // una nueva instancia de IceCreamController como argumentos.

    public void displayMenu(){
        handler.writeLine("Bienvenido al sistema de inventarios de la paleteria");

        while(true){
            handler.writeLine("\nSeleccione una opcion:");
            handler.writeLine("1. Agregar sabor");
            handler.writeLine("2. Vender sabor");
            handler.writeLine("3. Mostrar inventario");
            handler.writeLine("4. Salir del sistema");

            int option = Integer.parseInt(handler.readLine());

            switch (option){
                case 1 -> {
                    handler.writeLine("Ingrese el nombre del sabor:");
                    String flavor = handler.readLine();
                    handler.writeLine("Ingrese la cantidad:");
                    int quantity = Integer.parseInt(handler.readLine());
                    controller.addFlavor(flavor, quantity);
                }
                case 2 -> {
                    handler.writeLine("Ingrese el nombre del sabor a vender:");
                    String flavor = handler.readLine();
                    handler.writeLine("Ingrese la cantidad de paletas que desea:");
                    int quantity = Integer.parseInt(handler.readLine());
                    controller.sellFlavor(flavor, quantity);
                }
                case 3 -> controller.displayinventory();
                case 4 -> {
                    handler.writeLine("Saliendo del sistema. Gracias por preferirnos!");
                    return;
                }
                default -> handler.writeLine("Opcion no valida. Intente con un numero valido");
            }
        }



    }




}
