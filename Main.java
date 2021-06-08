import java.util.Scanner;

public class Main
{   
    public static void main(String args[])
    {
        //Αρχικά δεδομένα
    
        //Organization
        Organization MMorg = new Organization("Médecins du Monde"); 
    
        //Entities
            //Materials
            Material mater1 = new Material(10,20,30);
            mater1.setName("milk");
            mater1.setDescription("Alpro, almond no sugars");
            mater1.setId(101);
            MMorg.addEntity(mater1);
            
            Material mater2 = new Material(20,40,60);
            mater2.setName("sugar");
            mater2.setDescription("Omega, organic white");
            mater2.setId(102);
            MMorg.addEntity(mater2);
            
            Material mater3 = new Material(30,60,90);
            mater3.setName("rice");
            mater3.setDescription("Unce Bens, wholegrain");
            mater3.setId(103);    
            MMorg.addEntity(mater3);            
            
            //Services
            Service serv1 = new Service();
            serv1.setName("MedicalSupport");
            serv1.setDescription("Hospital Visit");
            serv1.setId(201);  
            MMorg.addEntity(serv1);
            
            Service serv2 = new Service();
            serv2.setName("NurserySupport");
            serv2.setDescription("Nursery Visit");
            serv2.setId(202);  
            MMorg.addEntity(serv2);
            
            Service serv3 = new Service();
            serv3.setName("BabySitting");
            serv3.setDescription("BabySitting Service by the hour");
            serv3.setId(203);  
            MMorg.addEntity(serv3);

        //Users
            //Admin
            Admin adm_user = new Admin(true);
            adm_user.setName("Malatara and Gkilas");
            adm_user.setPhone("6666666666");
            MMorg.setAdmin(adm_user); 
            
            //Beneficiaries
            Beneficiary benef_user1 = new Beneficiary("Beneficiary user1","1111111111",2);
            MMorg.insertBeneficiary(benef_user1); 
            Beneficiary benef_user2 = new Beneficiary("Beneficiary user2","2222222222",3);
            MMorg.insertBeneficiary(benef_user2); 
            
            //Donators
            Donator don_user1 = new Donator("Donator user1", "3333333333");
            MMorg.insertDonator(don_user1);
            
            Donator don_user2 = new Donator("Donator user2", "4444444444");
            MMorg.insertDonator(don_user2);            
            
        // Request for Beneficiary #1
            RequestDonation rd1 = new RequestDonation(mater1, 5);
            RequestDonation rd2 = new RequestDonation(mater2, 10);            
            RequestDonation rd3 = new RequestDonation(serv2, 15);  
            
            benef_user1.requestsList.add(rd1);
            benef_user1.requestsList.add(rd2);
            benef_user1.requestsList.add(rd3);
            
        // Offer from Donator #1
            RequestDonation Drd1 = new RequestDonation(mater1, 500);
            RequestDonation Drd2 = new RequestDonation(mater2, 100);            
            RequestDonation Drd3 = new RequestDonation(serv2, 150); 
            
            don_user1.offerList.add(Drd1);
            don_user1.offerList.add(Drd2);
            don_user1.offerList.add(Drd3);
            
        // Offer from Donator #2                     
            RequestDonation Drd4 = new RequestDonation(mater1, 200);
            RequestDonation Drd5 = new RequestDonation(mater2, 300);            
            RequestDonation Drd6 = new RequestDonation(serv2, 450); 
            
            don_user2.offerList.add(Drd4);
            don_user2.offerList.add(Drd5);
            don_user2.offerList.add(Drd6);    
        
        //Call Menu Handler
        Menu myMenu = new Menu(MMorg); 
        myMenu.HandleMainMenu();
    }
}