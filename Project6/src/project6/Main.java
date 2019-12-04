
package project6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        int selection;
        System.out.println("Hello!");
        System.out.println("Welcome to the Lockwood Call Center.");
        System.out.println("Please select from the menu below. ");
        System.out.println("Pre-made call stack: 0 || Insert a caller: 1 || Hang up a caller: 2");
        System.out.println("Search for a caller: 3 || View call stack: 4 || Log off: 5");
        System.out.println("Clear specific stack: -1");
        System.out.print("Selection: ");
        selection = userInput.nextInt();
        Menu(selection);
    }
    public static void Menu(int selection){
        Hashtable h = new Hashtable();
        int clearStack = 0;
        String name;
        int count = 0;
        while(selection != 5){
        if(selection == -1){
            Scanner clear = new Scanner(System.in);
            Scanner insert1 = new Scanner(System.in);
            String add;
            System.out.println("Select the stack you would like to clear below.");
            System.out.println("Frehser: 1 || Technical Lead: 2 || Manager: 3 || On hold: 4");
            System.out.print("Selection: ");
            clearStack = clear.nextInt();
            h.clearStack(clearStack);
            System.out.print("Clear another? ");
            add = insert1.nextLine();
                while(add.matches("y")){
                System.out.print("Enter stack: ");
                clearStack = clear.nextInt();
                h.clearStack(clearStack);
                System.out.print("Enter another? ");
                add = insert1.nextLine();
            }
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select from the menu below. ");
        System.out.println("Insert a caller: 1 || Hang up a caller: 2 || Search for a caller: 3 || View call stack: 4. || Log off: 5.");
        System.out.print("Selection: ");
        selection = userInput.nextInt();
        }
        if (selection  == 0){
        h.insert(1, "John");h.insert(1, "Kyle");h.insert(1, "Mike");h.insert(2, "Ben");
        h.insert(2, "Shannon");h.insert(2, "Robert");h.insert(3, "Frank");h.insert(3, "Zack");
        h.insert(3, "Edward");h.insert(4, "Thomas");h.insert(4, "Quinn");h.insert(4, "William");
        System.out.println("*************************************************************");
        h.printTable();
        System.out.println("*************************************************************");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select from the menu below. ");
        System.out.println("Insert a caller: 1 || Hang up a caller: 2 || Search for a caller: 3 || View call stack: 4. || Log off: 5.");
        System.out.print("Selection: ");
        selection = userInput.nextInt();
        }    
        if (selection == 1){
            Scanner insert = new Scanner(System.in);
            String add;
            System.out.print("Enter name: ");
            name = insert.nextLine();
            if(h.length() < 3 || h.count1() <3){
                count = 1;
            }
            else if(h.length() > 3 && h.length() <6 || h.count2() <3){
                count = 2;
            }
            else if(h.length() > 6 && h.length() <9 || h.count3() <3){
                count = 3;
            }
            else{
                count = 4;
            }
            h.insert(count, name);
            System.out.print("Enter another? ");
            add = insert.nextLine();
                while(add.matches("y")){
                System.out.print("Enter name: ");
                name = insert.nextLine();
            if(h.length() < 3 || h.count1() <3){
                count = 1;
            }
            else if(h.length() > 3 && h.length() <6 || h.count2() <3){
                count = 2;
            }
            else if(h.length() > 6 && h.length() <9 || h.count3() <3){
                count = 3;
            }
            else{
                count = 4;
            }
            h.insert(count, name);
                System.out.print("Enter another? ");
                add = insert.nextLine();
            }
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select from the menu below. ");
        System.out.println("Insert a caller: 1 || Hang up a caller: 2 || Search for a caller: 3 || View call stack: 4. || Log off: 5.");
        System.out.print("Selection: ");
        selection = userInput.nextInt();
        }
        if (selection == 2){
           Scanner delete = new Scanner(System.in);
            String add;
            System.out.print("Enter name: ");
            name = delete.nextLine();
            if(!h.contains(name)){
                System.out.println("The caller you've entered is not in the call stack.");
            }
            h.delete(name);
            System.out.print("Delete another? ");
            add = delete.nextLine();
                while(add.matches("y")){
                System.out.print("Enter name: ");
                name = delete.nextLine();
                if(!h.contains(name)){
                    System.out.println("The caller you've entered is not in the call stack.");
                }
                h.delete(name);
                System.out.print("Delete another? ");
                add = delete.nextLine();
                }
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select from the menu below. ");
        System.out.println("Insert a caller: 1 || Hang up a caller: 2 || Search for a caller: 3 || View call stack: 4. || Log off: 5.");
        System.out.print("Selection: ");
        selection = userInput.nextInt();
        }
        if (selection == 3){
            Scanner search = new Scanner(System.in);
            System.out.print("Enter name: ");
            name = search.nextLine();
            if(h.contains(name)){
                if(h.waitNumber(name) == 0 && !h.getRep(name).matches("Calls pending")){
                    System.out.println(name + " is currently on a call with " + h.getRep(name) +".");
                }
                if(h.waitNumber(name) > 0 && !h.getRep(name).matches("Calls pending")){
                System.out.println(name + " has " + (h.waitNumber(name)) + " caller(s) in front of them.");
                System.out.println("Their representive will be " + h.getRep(name) + ".");
                }
                else{
                    System.out.println(name + " is currently in the calls pending stack.");
                    System.out.println("They will be placed in a representives stack once a slot is open.");
                }
            }
            else{
                System.out.println("The caller you are trying to search is not in the call stack.");
            }
            String add;
             System.out.print("Search another? ");
                add = search.nextLine();
                while(add.matches("y")){
                System.out.print("Enter name: ");
                name = search.nextLine();
               if(h.contains(name)){
                if(h.waitNumber(name) == 0){
                    System.out.println(name + " is currently on a call with " + h.getRep(name) +".");
                }
                if(h.waitNumber(name) > 0){
                System.out.println(name + " has " + (h.waitNumber(name)) + " caller(s) in front of them.");
                System.out.println("Their representive will be " + h.getRep(name) + ".");
                }
            }
            else{
                System.out.println("The caller you are trying to saerch is not in the call stack.");
            }
                System.out.print("Search another? ");
                add = search.nextLine();
                }
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select from the menu below. ");
        System.out.println("Insert a caller: 1 || Hang up a caller: 2 || Search for a caller: 3 || View call stack: 4. || Log off: 5.");
        System.out.print("Selection: ");
        selection = userInput.nextInt();
        }
        if (selection == 4){
            Scanner get = new Scanner(System.in);
            if(h.isEmpty()){
                System.out.println("*************************************************************");
                System.out.println("Your call stack is empty.");
                System.out.println("*************************************************************");
            }
            else{
            System.out.println("*************************************************************");
            h.printTable();
            System.out.println("*************************************************************");
            System.out.println("# of callers with Fresher: " + h.count1);
            System.out.println("# of callers with Technical Lead: " + h.count2);
            System.out.println("# of callers with the Manager: " + h.count3);
            System.out.println("# of callers on hold: " + h.count4);
            System.out.println("Total callers: " + h.length());
            }
            String add;
            System.out.print("Would you like to log out? ");
            add = get.nextLine();
            
                if(add.matches("y")){
                break;
                }
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select from the menu below. ");
        System.out.println("Insert a caller: 1 || Hang up a caller: 2 || Search for a caller: 3 || View call stack: 4. || Log off: 5.");
        System.out.print("Selection: ");
        selection = userInput.nextInt();
        }
        if (selection == 5){
            break;
            }
        }
    }
}
