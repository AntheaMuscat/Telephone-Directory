import java.util.Scanner;
import java.util.InputMismatchException;
class MainMethod{
    public static void main(String[] args) {
        TelephoneDirectory td = new TelephoneDirectory();
        td.populateWithPeople();

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean isLetter = true;

        do{
            choice = 0;
            System.out.print(
                "Telephone Directory\n\n" +
                "1. Input a new person\n" +
                "2. Search by name\n" +
                "3. Search by town\n" +
                "4. Output the whole directory\n" +
                "5. Exit\n\n" +
                "Choose one of the above: ");

            do {
                try {
                    choice = sc.nextInt();
                } catch(InputMismatchException ime) {
                    System.out.print("\nInvalid input!\nPlease try again: ");
                    sc.next();
                }
            } while(choice == 0);

            System.out.println();
            switch(choice){
                case 1: td.inputPersonDetails(); break;
                case 2: 
                    String name = "";
                    do{
                        System.out.print("Enter name: ");
                        name = sc.next();
                        isLetter = td.isCharacter(name);
                    }while(isLetter == false);

                    String result = td.searchByName(name);
                    if(result.isEmpty()){
                        System.out.println("No details found for " + td.capitalize(name) + "\n");
                        break;
                    }
                    
                    System.out.println(result + "\n");
                    break;

                case 3:
                    String town = "";
                    do{
                        System.out.print("Enter town: ");
                        town = sc.next();
                        isLetter = td.isCharacter(town);
                    }while(isLetter == false);
                    
                    Person[] townPeople = td.searchByTown(town);
                    String capitalizedTown = td.capitalize(town);
                    if(townPeople.length == 0){
                        System.out.println("No people found living in " + capitalizedTown + "\n");
                        break;
                    }
    
                    System.out.println("\nPeople living in " + capitalizedTown);
                    for(int i = 0 ; i < townPeople.length; i++){
                        System.out.println( 
                            "ID Card: " + townPeople[i].getIdCard() + "\n" +
                            "Full Name: " + townPeople[i].getName() + " " + townPeople[i].getSurname() + "\n" +
                            "Address: " + townPeople[i].getAddress() + "\n" +
                            "Telephone: " + townPeople[i].getTelephone() + "\n");
                    }
                    break;

                case 4: td.outputWholeDirectory(); break;
                case 5: break;
                default: System.out.println("Number chosen must be between 1 and 5");
            }
        }while(choice != 5);

    }

   
}