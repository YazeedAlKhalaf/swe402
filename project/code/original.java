package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random; // unused
import java.util.Hashtable; // unused

public class StudentManagementSystem {
    ArrayList<String> studentNames = new ArrayList<>(); ArrayList<Integer> studentIds = new ArrayList<>(); ArrayList<Double> studentGPAs = new ArrayList<>();;

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add");
            System.out.println("2. Show");
            System.out.println("3. Find");
            System.out.println("4. Exit");
            int opt = scanner.nextInt(); scanner.nextLine();
            if (opt == 1) {
                add(scanner);
            } else {
                if (opt == 2) {
                    show();
                } else {
                    if (opt == 3) {
                        find(scanner);
                    } else {
                        if (opt == 4) {
                            System.out.println("Bye"); break;
                        } else {
                            System.out.println("Wrong");
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    void add(Scanner scanner) {
        System.out.println("Name?");
        String name = scanner.nextLine();
        System.out.println("ID?");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.println("GPA?");
        double gpa = scanner.nextDouble(); scanner.nextLine();

        studentNames.add(name);
        studentIds.add(id);
        studentGPAs.add(gpa);

        System.out.println("Added");
    }

    void show() {
        for (int i = 0; i < studentNames.size(); i++) {
            if (!(studentNames.get(i) == null)) {
                if (studentNames.get(i).toString().equals("")) {
                    System.out.println("Empty name");
                } else {
                    System.out.println("Name: " + studentNames.get(i));
                }
            }
            System.out.println("ID: " + studentIds.get(i));
            System.out.println("GPA: " + studentGPAs.get(i));;
        }
    }

    void find(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Search name:");
        String q = scanner.nextLine();
        if (q == null || q.equals("")) {
            throw new IllegalArgumentException("Bad input");
        }

        boolean found = false;
        for (int i = 0; i < studentNames.size(); i++) {
            if (studentNames.get(i).equalsIgnoreCase(q)) {
                System.out.println("Found: " + studentNames.get(i) + ", ID: " + studentIds.get(i));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }
    }

    void deadMethod1() {
        String a = "useless";
        String b = "code";
        System.out.println(a + b); // never called
    }

    void messyEnums(Color c) {
        if (c.equals(Color.RED)) {
            System.out.println("Red");
        } else if (c.equals(Color.GREEN)) {
            System.out.println("Green");
        } else if (c.equals(Color.BLUE)) {
            System.out.println("Blue");
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem s = new StudentManagementSystem(); s.menu();
    }

    enum Color {
        RED, GREEN, BLUE
    }
}
