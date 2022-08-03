import java.io.*;       

public class BigBasket
{
    // Arrays... to collect shopping information....
    
    // This is to collect items
    String shoppedItem[] = new String[1000];
    
    // This is to collect quantity of the items
    int shoppedQuantity[] = new int[1000];
    // This is to collect cost
    float itemCost[] = new float[1000];
    int itemDiscount[] = new int[1000];
   
    // Index movement in the arrays...
    int index;
    
    void ShopEntrance()throws IOException
    {
       
        
        // Shop categories...
        String mainCategory[]={"Vegitables And Fruits","Grocery & Staples","Bread Dairy & Eggs","Beverages","Snacks","Exit"};

        String shop1[]={"Onion - Medium (1kg)","Potato (1kg)","Tomato - Hybrid (500gms)","Apple - Fuji (4 pcs)","Ladis Finger (200gms)",
            "Carrot Local (250gms)","Bannana - Yelakki (500gms)","Lemon - 3 to 4 (100gm)","Pomegranate - 2pcs ",
        "Cuccumber - 500gms","Tomoto - Local 500gms","Beetroot - 250gms","Broccoli - 100gms"};
        float cost1[]={16,27,8,157,7,9,36,14,76,5,12,4,19};
        // Discount in percent...
        int discount1[]={0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        String shop2[]={"Atta - Whole Wheat (Aashirvaad) - 10kg","Sona Masoori Raw Rice (10kg)",
            "Nandini Pure Ghee - 1 Ltr.","Toor Dal - 1kg","Tata Salt - Iodized, 1 kg Pouch",
            "Sugar - 1kg","Moong Dal - 1kg","Fortune Sunflower Refined Oil - Sun Lite, 910 gm Pouch"};
        float cost2[]={400,575,415,175,18,46,160,90};
        // Discount in percent...
        int discount2[]={5,4,2,5,0,0,10,0};
                
        
        String shop3[]={"Nandini GoodLife Toned Milk, 500 ml Pouch","Eggs Table try - 30pcs",
            "Milky Mist Curd - 500gm","Bread - whole wheet","Amul Malai Paneer, 200 gm Pouch",
        "Amul Butter - Pasteurized, 100 gm Carton","Nestle Milkmaid, 400 gm Tin","Suguna Speciality Eggs - Shakti, 6 pcs Carton"};
        float cost3[]={22,180,32,35,64,42,110,49};
        // Discount in percent...
        int discount3[]={0,10,0,0,0,0,0,0};
        
       
        String shop4[]={"Bournvita Pro-Health Chocolate Drink, 500 gm Pouch","Diet Coke - 300ml",
            "Bisleri Mineral Water, 5 ltr Can","Nescafe Coffee & Milk Beverage - Chilled Latte, 180 ml",
            "Nestle Everyday - Masala Fusion, 100 gm","Tropicana Delight Fruit Juice - Pomegranate, 1000 ml Tetra",
        "Horlicks Health & Nutrition Drink - Classic Malt (Limited edition Pack), 500 gm",
        "MTR Mix - Badam Drink, Cardamom, 180 ml","Yoga Pulp Refreshing Drink-Mango with Aloevera Pulp, 1ltr"};
        float cost4[]={200,35,65,30,70,110,225,45,99};
        // Discount in percent...
        int discount4[]={0,0,0,0,0,0,0,0,0};
        
        String shop5[]={"Britannia Biscuits - Little Hearts", "Britannia 50-50 Maska Chaska Biscuits, 50 gm Pouch",
            "Kelloggs Corn - Flakes, 875 gm Pouch","Britannia Toast - Bake Suji, 300 gm Pouch",
            "Britannia Good Day Cookies - Rich Cashew, 120 gm Pouch","Britannia Bourbon-The Original Biscuits, 120gm Pouch",
        "Britannia Biscuits - Marie Gold, 120 gm Pouch","Kelloggs Chocos, 1.2 kg",
        "Oreo Vanilla Creme Biscuits, 150 gm","Double horse Chips - Banana, 60 Gm"};
        float cost5[]={10,10,280,40,25,20,15,430,35,40};
        // Discount in percent...
        int discount5[]={0,0,2,0,0,0,0,10,0,0};
        
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(inp);
        
         A a1 = new A();
        a1.disp();
        
        System.out.println("\u000C"); // to clear the screen...
        
        System.out.println("------------------ WELCOME TO BIG BASKET  ---------------------");
        for(int i=0;i<mainCategory.length;i++)
        {
            System.out.println("\t"+(i+1)+" - "+mainCategory[i]);
        }
        
        System.out.print("Enter your choice : ");
        String ch=b.readLine();
     
        while( !checkNumber(ch) || Integer.parseInt(ch)<=0 || Integer.parseInt(ch)>mainCategory.length)
        {
            System.out.print("Invalid entry... Try Again:");
            ch=b.readLine();
        }
        
        if(ch.equals("1"))
        {
            displayShopItems(mainCategory[0],shop1,cost1,discount1);    
        }
        else if(ch.equals("2"))
        {
            displayShopItems(mainCategory[1],shop2,cost2,discount2);    
        }
        else if(ch.equals("3"))
        {
            displayShopItems(mainCategory[2],shop3,cost3,discount3);    
        }
        else if(ch.equals("4"))
        {
            displayShopItems(mainCategory[3],shop4,cost4,discount4);    
        }
        else if(ch.equals("5"))
        {
            displayShopItems(mainCategory[4],shop5,cost5,discount5);    
        }
        else
            billing(); // Exit... so calcuate the bill...
    }

    // Display the menus in that shop...
    void displayShopItems(String shopName, String menu[], float cost[],int dis[])throws IOException
       {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(inp);

        System.out.println("\u000C"); // to clear the screen...
        System.out.println("------------------WELCOME TO "+ shopName +"---------------------");
        int z;
        for( z=0;z<menu.length;z++)
        {
            System.out.println("\t"+(z+1)+" - "+menu[z] + "("+ cost[z]+" Rs)");
        }
        System.out.println("\t"+(z+1)+" - go back to main menu");
        
        // To check whether any discount available or not
        boolean specialOffer=false;
        for(int i=0;i<menu.length;i++)
        {
            if(dis[i]!=0)
                specialOffer=true;
        }
        
        // to display the discounts...
        if(specialOffer)
        {
            System.out.println("\nWe have special discounts on the following items now...");
        
            for(int i=0;i<menu.length;i++)
            {
                if(dis[i]!=0)
                    System.out.println("\t"+(i+1)+" - "+menu[i] + " - Discount: "+dis[i] +"%");
            }
        }

        System.out.print("\nEnter your choice : ");
        String ch=b.readLine();
        
        if(Integer.toString(menu.length+1).equals(ch)){
            System.out.println("inside if");
            ShopEntrance(); // call the main menu...
            return;
        }
            
        // Validation...
        while( !checkNumber(ch) || Integer.parseInt(ch)<=0 || Integer.parseInt(ch)>menu.length)
        {
            System.out.print("Invalid entry... Try Again:");
            ch=b.readLine();
        }

        System.out.print("Quantity? : ");
        String qty=b.readLine();
        
        // Numeric Validation...
        while(!checkNumber(qty))
        {
            System.out.print("Invalid entry :");
            qty=b.readLine();
        }

        int c = Integer.parseInt(ch);
        int q = Integer.parseInt(qty);

        shoppedItem[index]=menu[c-1];
        shoppedQuantity[index]=q;
        
        itemCost[index]=cost[c-1];
        itemDiscount[index]=dis[c-1];
        
        index++;
        
        System.out.println("Do you want to continue shopping in "+shopName +" Enter y for yes");
        String co=b.readLine();
        if(co.equalsIgnoreCase("Y"))
            displayShopItems(shopName,menu,cost,dis); // call the same shop...
        else
            ShopEntrance(); // call the main menu...
    }
    
    
    // Billing....
    void billing() throws IOException
    {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        
        if(index>0)
        {
        double total=0.0;
        
        System.out.println("\u000C"); // to clear the screen...   
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tYOUR BILL");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("ITEM \t\t\t\t\t\t\t PRICE \t DISCOUNT \t QUANTITY \t AMOUNT");
        
        for(int i=0;i<index;i++)
        {
            double amount=0.0;
            if(itemDiscount[i]==0)
            {
                amount = itemCost[i]*shoppedQuantity[i];
                System.out.print(shoppedItem[i]);
                space(57-shoppedItem[i].length()); // Adjust the space to get the billing format properly
                System.out.print(itemCost[i]);
                space(24-(itemCost[i]+"").length());  // Adjust the space to get the billing format properly
                System.out.print(shoppedQuantity[i]);
                space(16-(shoppedQuantity[i]+"").length());  // Adjust the space to get the billing format properly
                System.out.println(amount);
                
            }
            else
            {
                double afterdiscount= itemCost[i]-(itemCost[i]*itemDiscount[i]/100);
                amount = afterdiscount * shoppedQuantity[i];
                
                System.out.print(shoppedItem[i]);
                space(57-shoppedItem[i].length());  // Adjust the space to get the billing format properly
                System.out.print(itemCost[i]);
                space(5-(itemDiscount[i]+"").length());  // Adjust the space to get the billing format properly
                System.out.print(itemDiscount[i]);
                space(19-(itemCost[i]+"").length());  // Adjust the space to get the billing format properly
                System.out.print(shoppedQuantity[i]);
                space(16-(shoppedQuantity[i]+"").length());  // Adjust the space to get the billing format properly
                System.out.println(amount);
            }
            total=total+amount;
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("\n\t\t\t\t\t\t Total Amount to pay is : "+total +"Rs");
        
        System.out.print("Enter your delivery address:");
        String address = br.readLine();
        
        Payment p1 = new Payment();
        p1.makePayment();
        
        System.out.println("\n\n Your order confirmed , will be delivered with in 12 hours.");
    }
        System.out.println("\n\n\t\t\t\t\t\t\tThanks Visit Again...");        
    }
    
    // Numeric Validation...    
    boolean checkNumber(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if(!(s.charAt(i)>='0' && s.charAt(i)<='9'))
                return false;
        }
        return true;
    }
    
    // To print n number of spaces...
    void space(int n)
    {
        for(int i=1;i<=n;i++)
            System.out.print(" ");
    }

    public static void main(String s[]) throws IOException
    {
        
        BigBasket bb = new BigBasket();
        bb.ShopEntrance();
        
    }
    
}
