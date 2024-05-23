package exercises.inheritance;

import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        //smartphone
        Smartphone iphone = new Smartphone(22, "Iphone 16 Pro Max", "", 1489, "352177644145336", 128);
        //tv
        Television tv = new Television(22, "Sony", "", 899.99, true, 55);
        //cuffie
        Headphones cuffie = new Headphones(22, "Cuffie Logitech", "", 50.50, "black", true);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Quanti prodotti vuoi inserire?");
        int quantity = Integer.parseInt(scanner.nextLine());

        //inizializzo l'array
        Product[] cart = new Product[quantity];
        double total = 0;
        System.out.println("Hai una carta fedeltà? (y/n)");
        char replyFidelity = scanner.nextLine().charAt(0);
        boolean fidelityCard;
        if (replyFidelity == 'y') {
            fidelityCard = true;
        } else {
            fidelityCard = false;
        }

        for (int i = 0; i < cart.length; i++) {
            System.out.println("Cosa vuoi inserire? Smartphone(s), Televisore(t) o Cuffie(c)?");
            char option = scanner.nextLine().charAt(0);
            System.out.println("Inserisci l'iva del prodotto");
            int vat = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci il nome del prodotto");
            String name = scanner.nextLine();
            System.out.println("Inserisci la descrizione del prodotto");
            String description = scanner.nextLine();
            System.out.println("Inserisci il prezzo del prodotto");
            double price = Double.parseDouble(scanner.nextLine());


            switch (option) {
                case 's':
                    System.out.println("Inserisci il codice imei del prodotto");
                    String imeiCode = scanner.nextLine();
                    System.out.println("Inserisci la quantità di memoria del prodotto");
                    int ram = Integer.parseInt(scanner.nextLine());
                    cart[i] = new Smartphone(vat, name, description, price, imeiCode, ram);
                    break;
                case 't':
                    System.out.println("E' una smart tv? (y/n)");
                    char replySmart = scanner.nextLine().charAt(0);
                    boolean isItSmart;
                    isItSmart = replySmart == 'y';
                    System.out.println("Inserisci le dimensioni della tv");
                    int dimensions = Integer.parseInt(scanner.nextLine());
                    cart[i] = new Television(vat, name, description, price, isItSmart, dimensions);
                    break;
                case 'c':
                    System.out.println("Inserisci il colore delle cuffie");
                    String color = scanner.nextLine();
                    System.out.println("Sono cuffie wireless? (y/n)");
                    char replyWireless = scanner.nextLine().charAt(0);
                    boolean isItWireless;
                    isItWireless = replyWireless == 'y';
                    cart[i] = new Headphones(vat, name, description, price, color, isItWireless);
                    break;
                default:
                    cart[i] = new Product(vat, name, description, price);
                    break;
            }

            System.out.println("Hai inserito: " + cart[i].toString());
            System.out.println(String.format("Il prezzo con iva è: %.2f €", cart[i].getVatPrice()));
            if (fidelityCard) {
                System.out.println(String.format("Il prezzo scontato per la cartà fedeltà è: %.2f €", cart[i].getDiscountedPrice(fidelityCard)));
            }

        }

        System.out.println("Il tuo carrello: ");
        for (Product product : cart) {
            System.out.println(product.toString());
            total += product.getDiscountedPrice(fidelityCard);
        }

        System.out.println(String.format("Il totale del carrello è: %.2f €", total));


        scanner.close();


    }
}
