import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

class TelephoneDirectory {
    private Person[] clientDetails; // array is accessable from every method
    private Scanner sc = new Scanner(System.in); // instance

    public void inputPersonDetails() {
        System.out.print("How many people do you want to input? ");
        int numberOfPeople = 0;

        boolean isValid = true;

        do {
            try {
                numberOfPeople = sc.nextInt(); 
                isValid = true;
            } catch(InputMismatchException ime) {
                isValid  = false;
                System.out.print("\nInvalid input!\nHow many people do you want to input? ");
                sc.next();
            }
        } while(isValid == false);

        if (numberOfPeople == 0) {
            System.out.println();
            return;
        }

        String id, name, surname, town, address, telephone;
        int start = 0;
        for (int i = 0; i < clientDetails.length; i++){
            if (clientDetails[i] == null) {
                start = i;
                break;
            }
        }

        for(int i = start; i < numberOfPeople + start; i++) {
            System.out.println("\nDetails for Person " + (i+1));
            boolean isDigit = true;
            boolean isLetter = true;
            do {
                System.out.print("Enter ID Card: ");
                id = sc.next();

                for(int j = 0; j < id.length()-1; j++){// checking if the first six characters are digits
                    if(!Character.isDigit(id.charAt(j))){
                        isDigit = false;
                        break;
                    }
                    else isDigit = true;
                }
            } while(id.equals("") || id.length() < 7 || !Character.isLetter(id.charAt(id.length() - 1)) || isDigit == false); 
            // Checking if the id is empty, less than 7 characters, if the last character is a letter and if the first 6 characters are digits.

            do {
                System.out.print("Enter name: ");
                name = sc.next();
                isLetter = isCharacter(name);
            } while(name.equals("") || isLetter == false);// checking if characters are letters

            do {
                System.out.print("Enter surname: ");
                surname = sc.next();
                isLetter = isCharacter(surname);
            } while(surname.equals("") || isLetter == false);

            do {
                sc.nextLine();
                System.out.print("Enter address: ");
                address = sc.nextLine();
            } while(address.equals(""));

            do {
                System.out.print("Enter town: ");
                town = sc.next();
                isLetter = isCharacter(town);
            } while(town.equals("") || isLetter == false);

            do {
                sc.nextLine();
                System.out.print("Enter telephone: ");
                telephone = sc.next();

                for(int j = 0; j < telephone.length(); j++){// checking if the first six characters are digits
                    if(!Character.isDigit(telephone.charAt(j)) || Character.isWhitespace(telephone.charAt(j))) {
                        isDigit = false;
                        break;
                    }
                    else isDigit = true;
                }
            } while(telephone.equals("") || telephone.length() != 8 || isDigit == false);// checking if the characters are digits and that it is 8 numbers long
            
            String lastLetter = id.substring(6,7).toUpperCase();
            String ftdId = id.substring(0, 6) + lastLetter;
            
            clientDetails[i] = new Person(ftdId, capitalize(name), capitalize(surname), capitalize(town), address, telephone);
            System.out.println();
        }
    }

    public String searchByName(String name){
        String personSearched = "";

        for(int i = 0; i < clientDetails.length; i++) {
            if (checkForNull(clientDetails[i])) break;
            if(clientDetails[i].getName().toLowerCase().equals(name.toLowerCase())){
                personSearched = clientDetails[i].getAddressAndTown();
            }
        }

        return personSearched;
    }

    public Person[] searchByTown(String town){
        List<Person> foundPeople = new ArrayList<Person>();//A list is created since the number of found people is not known

        for(int i = 0; i < clientDetails.length; i++){
            if (checkForNull(clientDetails[i])) break;
            if(clientDetails[i].getTown().toLowerCase().equals(town.toLowerCase())){
                foundPeople.add(clientDetails[i]);
            }
        }

        Person[] searchedPeople = foundPeople.toArray(new Person[0]);//converting the array list to an array
        return searchedPeople;
    }

    public void outputWholeDirectory(){
        for(int i = 0; i < clientDetails.length; i++){
            if (checkForNull(clientDetails[i])) break;
            System.out.println(clientDetails[i].personDetails() + "\n");
        }
    }

    public boolean isCharacter(String input){
        boolean isLetter = true;
        for(int j = 0; j < input.length(); j++){
            if(!Character.isLetter(input.charAt(j))){
                isLetter = false;
                break;
            }
            else isLetter = true;
        }

        return isLetter;
    }
    
    public String capitalize(String word){
        String firstLetter = word.substring(0,1).toUpperCase();
        String capitalizedWord = firstLetter + word.substring(1);
        return capitalizedWord;
    }

    public void populateWithPeople() {
        clientDetails = new Person[100];
        clientDetails[0] = new Person("267389M","Joe", "Borg", "Zurrieq", "97 Riverview Rd.", "79564382");
        clientDetails[1] = new Person("563794M", "Suzanne", "Cardona", "Birzebbugia", "204 Del Monte St.", "99846753");
        clientDetails[2] = new Person("432888M","Laila", "Vella", "Birkirkara", "8441 Princeton Drive", "79890654");
        clientDetails[3] = new Person("347803L", "Pabu", "Muscat", "Safi", "7466 Fifth Street" , "79014326");
        clientDetails[4] = new Person("258706L", "Daniela", "Farrugia", "Safi", "9 Wintergreen Street", "99875643");
    }

    private boolean checkForNull(Person person) {// checking if there is an input
        if (person == null) return true;
        else return false;
    }
}