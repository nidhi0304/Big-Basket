import java.util.Scanner;
class Payment
{
    Scanner sc = new Scanner(System.in);
    public void makePayment()
    {
        System.out.println("\n Payment options:\n");
        
        System.out.println("1 - Card");
        System.out.println("2 - Cash on Delivery");
        
        System.out.print("Your choice:");
        int ch = readNumber(1,2);
        
        if(ch==1){
            cardPayment();
        }
        else if(ch==2){
            cashOnDelivery();
        }
        
    }
    
    private void cardPayment()
    {
        
         readCardNumber();
         readCardHoderName();
         readExpiryDate();
         readCVV();
        
    }
    private void cashOnDelivery()
    {
        
        
    }
    
    String readCardHoderName()
    {
        System.out.print("Card Holder Name:");
        String cardHolderName = sc.nextLine();
        
        while(cardHolderName.length()<3)
        {
            System.out.print("Invalid name should be at least more than 2 letters!:");
            cardHolderName = sc.nextLine();
        }
        return cardHolderName;
    }
    
    String readCardNumber()
    {
        
        System.out.print("Card Number (xxxx-xxxx-xxxx-xxxx):");
        String cardNumber = sc.nextLine();
        while(!validateCard(cardNumber)){
            System.out.print("Invalid please renter format(xxxx-xxxx-xxxx-xxxx):");
            cardNumber = sc.nextLine();
        }
        return cardNumber;
    }
    
    String readExpiryDate()
    {
        System.out.print("Expiry Date (dd-mm):");
        String expDate = sc.nextLine();
        
        while(!expDateValidation(expDate)){
            System.out.print("Invalid please renter format (dd-mm):");
            expDate = sc.nextLine();
        }
        
        return expDate;
    }
    boolean expDateValidation(String s)
    {
        if(s.length()!=5)
            return false;
            
        char c  = s.charAt(2);
        
        if(c!='-')
            return false;
            
        String s1 = s.substring(0,2);
        String s2 = s.substring(3,5);
        
        if(!isNumber(s1))
            return false;
        
        if(!isNumber(s2))
            return false;
        
        return true;
        
    }
    
    String readCVV()
    {
        System.out.print("CVV (xxx):");
        String cvv = sc.nextLine();
        
        while(cvv.length()!=3 || !isNumber(cvv))
        {
            System.out.print("Invalid , please re-enter (3 digits number printed in the back of your card:");
            cvv = sc.nextLine();
        }
        return cvv;
        
    }
    
    boolean validateCard(String cardNumber)
    {
        if(cardNumber.length()!=19)
            return false;
            
            char c1 = cardNumber.charAt(4);
            char c2 = cardNumber.charAt(9);
            char c3 = cardNumber.charAt(14);
            
            if(c1!='-'&&c2!='-'&&c3!='-'){
                return false;
            }
            String fi4=cardNumber.substring(0,4);
            String se4=cardNumber.substring(5,9);
            String th4=cardNumber.substring(10,14);
            String fo4=cardNumber.substring(15,19);
            
            if(!isNumber(fi4))
                return false;
            if(!isNumber(se4))
                return false;
            if(!isNumber(th4))
                return false;
            if(!isNumber(fo4))
                return false;
             
            return true;
    }
    
     // Numeric Validation...    
    boolean isNumber(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if(!(s.charAt(i)>='0' && s.charAt(i)<='9'))
                return false;
        }
        return true;
    }
    
    // To read a number input if wrongly enter ask to re-enter
    int readNumber(int min,int max)
    {
        int ch;
        boolean correct=false;
        
        do{
            
            while(!sc.hasNextInt()) // to make sure user enters only number..
            {
                System.out.print("Invalid input, please re-enter:");
                sc.nextLine();
            }
            ch = sc.nextInt();
            if(ch>=min && ch<=max)
            {
                correct=true;
            }else{
                System.out.print("Invalid input, please re-enter:");
            }
        }while(!correct);
        
        sc.nextLine();
        return ch;
        
    }
    
    
}