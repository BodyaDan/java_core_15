package hometask;

import java.util.*;
import java.util.Map.Entry;

public class ZooClub {
    Scanner scn = new Scanner(System.in);
    HashMap<Person, List<Animal>> map = new HashMap<>();

    public void addMember() {
        System.out.print("Введіть ім'я нового учасника: ");
        String n = scn.next();
        System.out.print("Введіть вік учасника: ");
        int a = scn.nextInt();
        map.put(new Person(n, a), new ArrayList<>());
        System.out.println("Учасник був успішно доданий!\n");
    }

    public void addPet() {
        boolean flag = false;
        System.out.print("Що це за тваринка? - ");
        String t = scn.next();
        System.out.print("Введіть ім'я нової тваринки: ");
        String name = scn.next();

        while (true) {
            System.out.print("Введіть ім'я учасника якому належить ця тваринка: ");
            String n = scn.next();
            Iterator<Entry<Person, List<Animal>>> mainIterator = map.entrySet().iterator();
            while (mainIterator.hasNext()) {
                Entry<Person, List<Animal>> next = mainIterator.next();
                if (next.getKey().getName().equals(n)) {
                    Animal animal = new Animal(t, name);
                    next.getValue().add(animal);
                    System.out.println("Тваринка \"" + name + "\" була успішно додана до власника - " + n + "\n");
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            else
                System.out.println("Щось пішло не так! Спробуйте ще раз\n");
        }
    }

    public void removePet() {
        boolean flag = false;
        while (true) {
            System.out.print("Введіть ім'я учасника, тваринку якого потрібно видалити: ");
            String n = scn.next();
            Iterator<Entry<Person, List<Animal>>> mainIterator = map.entrySet().iterator();
            while (mainIterator.hasNext()) {
                Entry<Person, List<Animal>> next = mainIterator.next();
                if (next.getKey().getName().equalsIgnoreCase(n)) {
                    System.out.print("Введіть ім'я тваринки, яку потрібно видалити: ");
                    String np = scn.next();
                    Iterator<Animal> iterator = next.getValue().iterator();
                    while (iterator.hasNext()) {
                        Animal animal = iterator.next();
                        if (animal.getName().equalsIgnoreCase(np)) {
                            iterator.remove();
                            System.out.println("Тваринка \"" + np + "\" успішно видалена\n");
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (flag)
                break;
            System.out.println("Щось пішло не так! Спробуйте ще раз\n");
        }
    }

    public void removeMember() {
        boolean flag = false;
        while (true) {
            System.out.print("Введіть ім'я учасника, якого потрібно видалити: ");
            String n = scn.next();
            Iterator<Entry<Person, List<Animal>>> mainIterator = map.entrySet().iterator();
            while (mainIterator.hasNext()) {
                Entry<Person, List<Animal>> next = mainIterator.next();
                if (next.getKey().getName().equalsIgnoreCase(n)) {
                    System.out.println("Учасник \"" + next.getKey().getName() + "\" був успішно видалений\n");
                    mainIterator.remove();
                    flag = true;
                }
            }
            if (flag)
                break;
            else
                System.out.println("Щось пішло не так! Спробуйте ще раз\n");
        }
    }

    public void removeAllTypeOfPets() {
        int count = 0;
        System.out.print("Введіть тип тваринки який потрібно у всіх видалити: ");
        String n = scn.next();
        Iterator<Entry<Person, List<Animal>>> mainIterator = map.entrySet().iterator();
        while (mainIterator.hasNext()) {
            Entry<Person, List<Animal>> next = mainIterator.next();
            Iterator<Animal> iterator = next.getValue().iterator();
            while (iterator.hasNext()) {
                Animal animal = iterator.next();
                if (animal.getType().equalsIgnoreCase(n)) {
                    iterator.remove();
                    count++;
                }
            }
        }
        System.out.println("Тваринки типу \"" + n + "\" були видалені успішно! К-сть: " + count + "\n");
    }

    public void showClub() {
        Iterator<Entry<Person, List<Animal>>> mainIterator = map.entrySet().iterator();
        while (mainIterator.hasNext()) {
            Entry<Person, List<Animal>> next = mainIterator.next();
            System.out.println(next.getKey().getName() + " має такі тваринки: ");
            Iterator<Animal> iterator = next.getValue().iterator();
            while (iterator.hasNext()) {
                Animal animal = iterator.next();
                System.out.println(animal.getType() + " - \"" + animal.getName() + "\"");
            }
            System.out.println("\n");
        }
    }
}
