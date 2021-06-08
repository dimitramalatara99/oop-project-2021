import java.util.Scanner;
import java.util.Iterator;

public class Menu {
    private Organization my_org;
        
    public Menu(Organization my_org){
        this.my_org = my_org;
    }
    
    public void PrintMainMenu(){
        System.out.println("Donator/Beneficiary Management Tool"); 
        System.out.println("Organization: " + my_org.getName());
        System.out.println("Main Menu: ");
        System.out.println("-----------------------------");             
        System.out.println("Please type your phone number (type 0 to exit): "); 
        System.out.println("-----------------------------");             
    }
    
    public void HandleMainMenu(){
        String phone_number="";
        Beneficiary ben;
        Donator don;
        Scanner scan = new Scanner(System.in);
        PrintMainMenu();
        phone_number = scan.nextLine();

        while (phone_number.compareTo("0")!=0) {

            if (phone_number.compareTo(my_org.getAdmin().getPhone())==0) {  //Check if this User is the Admin of Organization
                if (my_org.getAdmin().getIsAdmin()) {
                    System.out.println(my_org.getAdmin().getName() + " logged in. Welcome Admin!!!");
                    System.out.println("Name: " + my_org.getAdmin().getName() + " Phone: " + my_org.getAdmin().getPhone());
                    //Show Admin Menu
                    my_org.current_user_phone=phone_number;
                    HandleAdminMenu();
                }
                else {
                    System.out.println("phone matches but isadmin field is false!!!");                    
                }
            }
            else if ((ben=my_org.PhoneCheckBeneficiaries(phone_number))!=null)  { 
                    System.out.println(ben.getName() + " logged in. Welcome Beneficiary!");
                    System.out.println("Name: " + ben.getName() + " Phone: " + ben.getPhone());
                    //Show Beneficiaries Menu
                    my_org.current_user_phone=phone_number;                    
                    HandleBeneficiaryMenu();                    
            }
            else if ((don=my_org.PhoneCheckDonators(phone_number))!=null)  { 
                    System.out.println(don.getName() + " logged in. Welcome Donator!");                    
                    System.out.println("Name: " + don.getName() + " Phone: " + don.getPhone());
                    //Show Donators Menu
                    my_org.current_user_phone=phone_number;                    
                    HandleDonatorMenu();
            }

            //TODO register new user
        
            // show menu according to user
            PrintMainMenu();
            phone_number = scan.nextLine();    
        }
        System.out.println("Thank you !");
        return;
    }
    
    public void PrintDonatorMenu() {
        System.out.println("Donator/Beneficiary Management Tool");
        System.out.println("Organization: " + my_org.getName());
        System.out.println("Donator Menu: ");        
        System.out.println("-----------------------------");     
        System.out.println(" Please Select: \n"
            + "1) Add Offer\n"
            + "2) Show Offers\n"
            + "3) Commit\n"
            + "4) Back\n"
            + "5) Logout\n"
            + "6) Exit");
        System.out.println("-----------------------------");                 
    }
    
    public void HandleDonatorMenu() {
        Donator don;
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        int choice1 = -1;
        PrintDonatorMenu();
        choice = scan.nextInt();
        Entity offered_entity;
        
        while (choice !=6) {
            switch (choice) {
            case 1:
                my_org.listEntities();
                System.out.println(" Please Select Entity (type entity id): \n");
                choice1 = scan.nextInt();
                
                while ((offered_entity=my_org.getEntityDetails(choice1))==null) {
                    System.out.println(" Entity not found ! \n");                    
                    System.out.println(" Please Select Entity (type entity id): \n");
                    choice1 = scan.nextInt();                    
                };
                
                System.out.println(" Do you want to add an offer of the selected entity ? \n"
                    + "1) Yes \n"
                    + "2) No");                
                
                choice1 = scan.nextInt();                    
                if (choice1 == 1) {
                    System.out.println(" Please enter the offered quantity/hours ? \n");
                    choice1 = scan.nextInt();                    

                    // New Offer from Donator
                    RequestDonation Drd = new RequestDonation(offered_entity, choice1);           
                    don=my_org.PhoneCheckDonators(my_org.current_user_phone);
                    don.offerList.add(Drd);
                    System.out.println(" new offer added \n");
                }                        
                break;
            case 2:
                don=my_org.PhoneCheckDonators(my_org.current_user_phone);
                don.offerList.monitor();
                break;
            case 3:
                //TODO commit
                break;
            case 4:
                return;
            case 5:
                return;
            case 6:
                break;     
            default:
                System.out.println("Invalid Input!");
            }             
            
            PrintDonatorMenu();
            choice = scan.nextInt();            
        }
        System.out.println("Thank you !");   
        System.exit(0);
    }
    
    public void PrintBeneficiaryMenu() {
        System.out.println("Donator/Beneficiary Management Tool");
        System.out.println("Organization: " + my_org.getName());
        System.out.println("Beneficiary Menu: ");        
        System.out.println("-----------------------------");     
        System.out.println(" Please Select: \n"
            + "1) Add Request\n"
            + "2) Show Requests\n"
            + "3) Commit\n"
            + "4) Back\n"
            + "5) Logout\n"
            + "6) Exit");
        System.out.println("-----------------------------");                 
    }
    
    public void HandleBeneficiaryMenu() {
        Beneficiary ben;
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        PrintBeneficiaryMenu();
        choice = scan.nextInt();
        Entity requested_entity;
        int choice1 = -1;
               
        while (choice !=6) {
            switch (choice) {
            case 1:
                my_org.listEntities();
                System.out.println(" Please Select Entity (type entity id): \n");
                choice1 = scan.nextInt();
                
                while ((requested_entity=my_org.getEntityDetails(choice1))==null) {
                    System.out.println(" Entity not found ! \n");                    
                    System.out.println(" Please Select Entity (type entity id): \n");
                    choice1 = scan.nextInt();                    
                };
                
                System.out.println(" Do you want to add a request of the selected entity ? \n"
                    + "1) Yes \n"
                    + "2) No");                
                
                choice1 = scan.nextInt();                    
                if (choice1 == 1) {
                    System.out.println(" Please enter the requested quantity/hours ? \n");
                    choice1 = scan.nextInt();                    

                    // New Offer from Donator
                    RequestDonation Drd = new RequestDonation(requested_entity, choice1);           
                    ben=my_org.PhoneCheckBeneficiaries(my_org.current_user_phone);
                    ben.requestsList.add(Drd);
                    System.out.println(" new request added \n");
                }                        
            case 2:
                ben=my_org.PhoneCheckBeneficiaries(my_org.current_user_phone);
                ben.requestsList.monitor();
                break;
            case 3:
                //TODO commit
                break;
            case 4:
                return;
            case 5:
                return;
            case 6:
                break;     
            default:
                System.out.println("Invalid Input!");
            }             
            
            PrintBeneficiaryMenu();
            choice = scan.nextInt();            
        }
        System.out.println("Thank you !");   
        System.exit(0);
    }
    
    public void PrintAdminMenu() {
        System.out.println("Donator/Beneficiary Management Tool");
        System.out.println("Organization: " + my_org.getName());
        System.out.println("Admin Menu: ");        
        System.out.println("-----------------------------");     
        System.out.println(" Please Select: \n"
            + "1) View\n"
            + "2) Monitor Organization\n"
            + "3) Back\n"
            + "4) Logout\n"
            + "5) Exit\n");
        System.out.println("-----------------------------");                 
    } 

    public void HandleAdminMenu() {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        int choice1 = -1;
        PrintAdminMenu();
        choice = scan.nextInt();
        
        while (choice !=5) {
            switch (choice) {
            case 1:
                my_org.listEntities();
                break;
            case 2:
                System.out.println(" Please select ? \n"
                    + "1) List Beneficiaries \n"
                    + "2) List Donators\n"
                    + "3) Reset Beneficiaries Lists\n");                
                
                choice1 = scan.nextInt(); 
                while ((choice1<1) ||  (choice1>3)) {
                    System.out.println("Invalid Input!");  
                    choice1 = scan.nextInt();
                }
                
                if (choice1 == 1) {
                    my_org.listBeneficiaries();
                }                        
                else if (choice1 == 2) {                
                    my_org.listDonators();                    
                }
                else if (choice1 == 3) {                                
                    my_org.resetBeneficiariesList();
                }
                
                break;
            case 3:
                return;
            case 4:
                return;
            case 5:
                return;    
            default:
                System.out.println("Invalid Input!");
            }             
            
            PrintAdminMenu();
            choice = scan.nextInt();            
        }
        System.out.println("Thank you !");   
        System.exit(0);
    }
    
}
    