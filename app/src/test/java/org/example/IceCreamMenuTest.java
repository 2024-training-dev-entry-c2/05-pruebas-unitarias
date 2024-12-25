package org.example;

import org.example.controllers.IceCreamController;
import org.example.utils.IHandler;
import org.example.utils.IceCreamMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class IceCreamMenuTest {

    private IHandler mockHandler;
    private IceCreamController mockController;
    private IceCreamMenu menu;

    @BeforeEach
    void setup(){
        mockHandler = mock( IHandler.class);
        mockController = mock(IceCreamController.class);
        menu = new IceCreamMenu(mockController, mockHandler);
    }

    @Test
    @DisplayName("Caso 1 del menu")
    void testAddFlavor(){

        //simulamos las entradas del usuario
        when(mockHandler.readLine()).thenReturn("1","Vainilla","20", "4");

        menu.displayMenu();

        //verificamos las interacciones de nuestro mock
        verify(mockHandler).writeLine("Bienvenido al sistema de inventarios de la paleteria");
        verify(mockHandler).writeLine("Ingrese el nombre del sabor:");
        verify(mockHandler).writeLine("Ingrese la cantidad:");

        verify(mockController).addFlavor("Vainilla", 20);
    }

    @Test
    @DisplayName("Caso 2 del menu")
    void testSellFlavor(){

        when(mockHandler.readLine()).thenReturn("2", "Chocolate", "5","4");

        menu.displayMenu();

        verify(mockHandler).writeLine("Ingrese el nombre del sabor a vender:");
        verify(mockHandler).writeLine("Ingrese la cantidad de paletas que desea:");

        verify(mockController).sellFlavor("Chocolate", 5);
    }

    @Test
    @DisplayName("Caso 3 del menu")
    void testDisplayInventory(){

        when(mockHandler.readLine()).thenReturn("3","4");

        menu.displayMenu();

        verify(mockController).displayinventory();

    }
    @Test
    @DisplayName("Caso 4 del menu")
    void testExitMenu(){

        when(mockHandler.readLine()).thenReturn("4");

        menu.displayMenu();

        verify(mockHandler).writeLine("Saliendo del sistema. Gracias por preferirnos!");
    }

    @Test
    @DisplayName("Default del menu")
    void errorInputMenu(){

        when(mockHandler.readLine()).thenReturn("7","4" );

        menu.displayMenu();

        verify(mockHandler).writeLine("Opcion no valida. Intente con un numero valido");
    }

}