public class Person{
    private String idCard;
    private String name;
    private String surname;
    private String town;
    private String address;
    private String telephone;
    
    public String getIdCard(){
        return idCard;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getTelephone(){
        return telephone;
    }
    
    public String getAddressAndTown(){  
        return "Address: " + address + "\nTown: " + town;
    }
    
    public String getTown(){
        return town;
    }
    
    public Person(String idCard, String name, String surname, String town, String address, String telephone){
        // creating a constructor for Person
        // initialising fields
        this.idCard = idCard;
        this.name = name;
        this.surname = surname;
        this.town = town;
        this.address = address;
        this.telephone = telephone;
    }
    
    public String personDetails(){
        return 
            "ID Card: " + idCard + "\n" +
            "Full Name: " + name + " " + surname + "\n" +
            "Address: " + address + "\n" +
            "Town: " + town + "\n" +
            "Telephone: " + telephone;
    }
}