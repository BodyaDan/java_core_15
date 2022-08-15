package hometask;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ZooClub zooClub = new ZooClub();
        int n;

        while (true) {
            menu();
            n = scn.nextInt();
            switch (n) {
                case 1:
                    zooClub.addMember();
                    break;
                case 2:
                    zooClub.addPet();
                    break;
                case 3:
                    zooClub.removePet();
                    break;
                case 4:
                    zooClub.removeMember();
                    break;
                case 5:
                    zooClub.removeAllTypeOfPets();
                    break;
                case 6:
                    zooClub.showClub();
                    break;
                case 7:
                    System.exit(1);
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("1 - Додати учасника клубу");
        System.out.println("2 - Додати тваринку до учасника клубу");
        System.out.println("3 - Видалити тваринку з учасника клубу");
        System.out.println("4 - Видалити учасника з клубу");
        System.out.println("5 - Видалити конкретну тваринку зі всіх власників");
        System.out.println("6 - Вивести на екран зооклуб");
        System.out.println("7 - Вийти з програми");
        System.out.print("Enter: ");
    }
}
