package org.example.repositories;

import org.example.models.IceCreamFlavor;

import java.util.HashMap;
import java.util.Map;

public class IceCreamRepository {
    //clase singleton

    private static IceCreamRepository instance;
    private Map<String, IceCreamFlavor> inventory;

    private IceCreamRepository() {
        this.inventory = new HashMap<>();
    }

    public static synchronized IceCreamRepository getInstance(){
        if (instance==null){
            instance = new IceCreamRepository();
        }
        return instance;
    }

    public void addFlavor(IceCreamFlavor flavor){
        inventory.merge(flavor.getName(), flavor, (existing, newFlavor) -> {
            existing.setQuantity(existing.getQuantity() + newFlavor.getQuantity());
            return existing;
        });
    }

    public Boolean sellFlavor(String flavorName, Integer quantity){
        IceCreamFlavor flavor = inventory.get(flavorName);
        if (flavor != null && flavor.getQuantity()>=quantity){
            flavor.setQuantity(flavor.getQuantity() - quantity);
            return true;
        }
/*        Para borrar por completo del inventario
        if(flavor != null && flavor.getQuantity()==0){
            inventory.remove(flavorName);
        }

 */
        return false;

    }

    public void displayInventory(){
        System.out.println("\nInventario de la heladeria:");
        inventory.forEach((name, flavor) ->
                        System.out.println(name +": "+flavor.getQuantity() + " unidades." )
                );
    }



}
