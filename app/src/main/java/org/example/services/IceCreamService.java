package org.example.services;

import org.example.models.IceCreamFlavor;
import org.example.repositories.IceCreamRepository;

public class IceCreamService {
    private final IceCreamRepository repository;


    public IceCreamService() {
        this.repository = IceCreamRepository.getInstance();
    }

    public void addFlavor(String flavorName, Integer quantity){
        IceCreamFlavor iceCreamFlavor = new IceCreamFlavor(flavorName, quantity);
        repository.addFlavor(iceCreamFlavor);
    }

    public Boolean sellFlavor(String flavorName, Integer quantity){
        return repository.sellFlavor(flavorName, quantity);
    }

    public void displayInventory(){
        repository.displayInventory();
    }
}
