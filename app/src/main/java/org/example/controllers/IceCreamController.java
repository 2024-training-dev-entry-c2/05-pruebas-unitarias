package org.example.controllers;

import org.example.services.IceCreamService;

public class IceCreamController {
    private final IceCreamService service;

    public IceCreamController() {
        this.service = new IceCreamService();
    }

    public void addFlavor(String flavorName, Integer quantity){
        service.addFlavor(flavorName, quantity);
        System.out.println("El sabor se ha agregado exitosamente.");
    }

    public void sellFlavor(String flavorName, Integer quantity){
        if (service.sellFlavor(flavorName, quantity)){
            System.out.println("Se ha vendido el helado sabor:"+flavorName
                    +" cantidad:"+quantity+" paletas.");
        }else{
            System.out.println("No se pudo realizar la venta. Verifique el inventario.");
        }
    }

    public void displayinventory(){
        service.displayInventory();
    }

}
