package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args){

        ArrayList<Contact> phoneBook = new ArrayList<>();
        ArrayList<Contact> bin = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println(" \n Please select an action with its corresponding number \n 1. Add \n 2. View All Contacts \n 3. Search \n 4. Delete \n 5. Update \n 6. Exit");
            int res = sc.nextInt();
                if(res == 1){
                    int listItem = phoneBook.size() + 1;
                    System.out.println("Please add first name");
                    String newFirstName = sc.next();
                    System.out.println("Please add last name");
                    String newLastName = sc.next();

                    Contact newContact = new Contact(listItem, newFirstName, newLastName);
                    phoneBook.add(newContact);
                }
                else if(res == 2){
                    System.out.println(phoneBook);
                }
                else if(res == 3){
                    System.out.println("Search:");
                    String searchString = sc.next();

                    for(Contact c : phoneBook){
                        if((c.getFirstName() != null && c.getFirstName().contains(searchString)) || (c.getLastName() != null && c.getLastName().contains(searchString))){
                            System.out.println(c);
                        }
                    }
                }
                else if(res == 4){
                    System.out.println("Input the id of the contact to delete");
                    int contactId = sc.nextInt();
                    for(Contact c: phoneBook){
                        if(c.getId() == contactId) {
                            System.out.println("Contact will be deleted: \n" + c );
                            bin.add(c);
                        }
                    } phoneBook.removeAll(bin);
                }
                else if(res == 5){
                    System.out.println("Input the id of the contact to update");
                    int contactId = sc.nextInt();
                    for(Contact c: phoneBook){
                        if(c.getId() == contactId){
                            System.out.println("Please add first name");
                            String newFirstName = sc.next();
                            System.out.println("Please add last name");
                            String newLastName = sc.next();
                            Contact updatedContact = new Contact(c.getId(), newFirstName, newLastName);
                            phoneBook.set(c.getId()-1, updatedContact);
                            System.out.println("User details updated to: ");
                            System.out.println(updatedContact);
                        }else if(c.getId() != contactId){
                            System.out.println("No contact found");
                        }
                    }
                }
                else if(res == 6){
                    System.out.println("Terminating...");
                    break;
                }
                else{
                    System.out.println("Invalid input");
                    break;
                }
        }
    }
}