package ru.netology.shop;

import ru.netology.repository.NotFoundException;
import ru.netology.repository.ShopRepository;

public class Main {
    public static void main(String[] args) {
        ShopRepository repo = new ShopRepository();

        try {
            repo.remove(1000);
            System.out.println("Hello");
        } catch (NotFoundException e) {
            System.out.println("error");
        }
    }
}