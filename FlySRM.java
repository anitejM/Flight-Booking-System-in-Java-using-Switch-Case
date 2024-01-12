import java.util.*;
class FlySRM
{
    String from, to, feedback;
    Scanner sc;
    int day, month, year, num, fclass, amt, booking, meal, luggage, ff, offer, date_fee; //global variables
    FlySRM() //constructor to initialize global variables
    {
        sc=new Scanner(System.in);
        from="";
        to=""; day=0; month=0; year=0; num=0; fclass=0; amt=0; booking=0; meal=0; luggage=0; ff=0; offer=0; date_fee=0;
        feedback="You have not given a feedback as of now!\n";
    }
    void book() //function to book flights
    {
        if(booking==1)
        {
            System.out.print("You already have a booking with flySRM!\n");
            return;
        }
        System.out.print("From: ");
        from=sc.nextLine();
        System.out.print("To: ");
        to=sc.nextLine();
        System.out.print("Date: ");
        day=sc.nextInt();
        month=sc.nextInt();
        year=sc.nextInt();
        if(day<0 || month<0 || year<0 || (month==2 && day>29) || ((month==4 || month==6 || month==9 || month==11) && day>30) || day>31)
        {	//checking if the entered date is valid or not
            System.out.print("Invalid date entered! Please try again from the main menu!\n");
            return;
        }
        System.out.print("Which class do you want to fly?");
        System.out.print("\n1) Executive\n2) Business\nOther) Economy\n\nEnter your choice by entering the code: ");
        fclass=sc.nextInt();
        System.out.print("Number of Passengers: "); 
        num=sc.nextInt();
        if(fclass==1)
        amt=num*10000; 
        else if(fclass==2) 
        amt=num*7500; 
        else 
        amt=num*5000;
        System.out.print("Do you want to book a meal? Press 1 to select YES, any other key for NO: ");
        meal=sc.nextInt();
        System.out.print("Do you want extra luggage weight? Press 1 to select YES, any other key for NO: "); 
        luggage=sc.nextInt();
        System.out.print("Are you a frequent flyer? Press 1 to select YES, any other key for NO: ");
        ff=sc.nextInt();
        System.out.print("We have some special offers for you! Select ONE that is applicable with the given codes, or press any other key to proceed");
        System.out.print("\n1) Student Offer\n2) Defence Personnel Offer\n3) First Time flySRM Customer Offer\n4) Elders Offer\nEnter your choice: ");
        offer=sc.nextInt();
        booking=1; //setting booking to TRUE
        if(offer==1) //offers
        {
            System.out.print("You have selected the STUDENT OFFER! You have received extra luggage priveliges and a discount of Rs.500 per pax!\n");
            amt=amt-num*500;
            luggage=1;
        }
        else if(offer==2)
        {
            System.out.print("You have selected the DEFENCE PERSONNEL OFFER! You have received a FREE MEAL and an upgrade to BUSINESS CLASS!\n");
            meal=1; 
            fclass=2;
        }
        else if(offer==3)
        {
            System.out.print("You are a FIRST TIME flySRM CUSTOMER! Please enjoy a FREE MEAL from our side and a discount of flat Rs.1000!\n");
            meal=1; 
            amt=amt-1000;
        }
        else if(offer==4)
        {
            System.out.print("You have selected the ELDERS OFFER! Please enjoy the comfort of BUSINESS CLASS and a discount of flat Rs.1500!\n");
            fclass=2; 
            amt=amt-1500;
        }
        else if(ff==1)
        {
            System.out.print("Thank you for trusting flySRM! You have received a free upgrade to BUSINESS CLASS on the house!\n");
            fclass=2;
        }
        System.out.print("Please pay Rs."+amt+" through any method like debit card, credit card or UPI in the next 5 minutes.");
        System.out.print("\n\nThank you for booking your flight with flySRM! Looking forward to seeing you in the skies with us!");
        System.out.print("\n\nDo you want to see a summary of your booking?");
        System.out.print("\nPress 1 to see booking summary or any other to proceed to the main menu...");
        int ch=sc.nextInt();
        if(ch==1) //viewing it once after booking
        view();
    }
    void view() //viewing booking details
    {
        if(booking==1)
        {
            System.out.print("Your booking\n\n");
            System.out.print("From: "+from);
            System.out.print("\nTo: "+to);
            System.out.print("\nDate of Departure: "+day+" / "+month+" / "+year);
            System.out.print("\nClass: ");
            if(fclass==1)
            System.out.print("Executive");
            else if(fclass==2)
            System.out.print("Business");
            else
            System.out.print("Economy");
            System.out.print("\nNumber of Passengers: "+num);
            System.out.print("\nMeal: ");
            if(meal==1)
            System.out.print("YES");
            else 
            System.out.print("NO");
            System.out.print("\nExtra Luggage: ");
            if(luggage==1)
            System.out.print("YES");
            else
            System.out.print("NO");
            System.out.print("\nAmount: Rs."+amt);
            System.out.print("\nYour Feedback: "+feedback);
            System.out.print("\n\nSeats are assigned on a first come-first serve basis for free.");
            System.out.print("\n\nExtra luggage and meal costs will be assigned at the check-in counter if applicable.");
        }
        else
        {
            System.out.print("\nYou don't have an active booking with us right now!");
            System.out.print("\nDo you want to book a flight? Press 1 for YES, any other key for NO: ");
            int ch=sc.nextInt();
            if(ch==1)
            book();
        }
    }
    void edit() //editing global variables if required
    {
        System.out.print("\nWhat do you want to edit?");
        System.out.print("\n1) Date\n2) Class\n3) Meal\n4) Luggage\n5) Offer\n\nUse the codes to select or press any other key to go back to the main menu: ");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
            System.out.print("\nEnter the new Date: ");
            day=sc.nextInt();
            month=sc.nextInt();
            year=sc.nextInt();
            if(day<0 || month<0 || year<0 || (month==2 && day>29) || ((month==4 || month==6 || month==9 || month==11) && day>30) || day>31)
            {
                System.out.print("Invalid date entered! Please try again from the main menu!\n"); 
                return;
            }
            System.out.print("Since you changed the date, an extra fee of Rs.750 has been applied per pax\n");
            amt=amt+num*750; 
            date_fee=750;
            break;
            case 2:
            System.out.print("\nWhich class do you want to fly?");
            System.out.print("\n1) Executive\n2) Business\nOther) Economy\n\nEnter your choice by entering the code: ");
            fclass=sc.nextInt();
            break;
            case 3:
            System.out.print("\nDo you want to book a meal? Press 1 to select YES, any other key for NO: ");
            meal=sc.nextInt();
            break;
            case 4:
            System.out.print("\nDo you want extra luggage weight? Press 1 to select YES, any other key for NO: ");
            luggage=sc.nextInt();
            break;
            case 5:
            if(fclass==1) 
            amt=num*10000; 
            else if(fclass==2) 
            amt=num*7500; 
            else 
            amt=num*5000;
            System.out.print("We have some special offers for you! Select ONE that is applicable with the given codes, or press any other key to proceed");
            System.out.print("\n1) Student Offer\n2) Defence Personnel Offer\n3) First Time flySRM Customer Offer\n4) Elders Offer\nEnter your choice: ");
            offer=sc.nextInt();
            if(offer==1)
            {
                System.out.print("You have selected the STUDENT OFFER! You have received extra luggage priveliges and a discount of Rs.500 per pax!");
                amt=amt-num*500;
                luggage=1;
            }
            else if(offer==2)
            {
                System.out.print("You have selected the DEFENCE PERSONNEL OFFER! You have received a FREE MEAL and an upgrade to BUSINESS CLASS!");
                meal=1;
                fclass=2;
            }
            else if(offer==3)
            {
                System.out.print("You are a FIRST TIME flySRM CUSTOMER! Please enjoy a FREE MEAL from our side and a discount of flat Rs.1000!");
                meal=1; 
                amt=amt-1000;
            }
            else if(offer==4)
            {
                System.out.print("You have selected the ELDERS OFFER! Please enjoy the comfort of BUSINESS CLASS and a discount of flat Rs.1500!");
                fclass=2; 
                amt=amt-1500;
            }
            else if(ff==1)
            {
                System.out.print("Thank you for trusting flySRM! You have received a free upgrade to BUSINESS CLASS on the house!");
                fclass=2;
            }
            amt+=date_fee; 
            break;
        }
        System.out.print("Please pay Rs."+amt+" through any method like debit card, credit card or UPI in the next 5 minutes.");
        System.out.print("\n\nThank you for booking your flight with flySRM! Looking forward to seeing you in the skies with us!");
        System.out.print("\n\nDo you want to see a summary of your updated booking?"); 
        System.out.print("\nPress 1 to see booking summary or any other to proceed to the main menu...");
        ch=sc.nextInt();
        if(ch==1) 
        view();
    }
    void cancel() //cancelling the booking
    {
        System.out.print("\nDo you want to cancel the booking made for "+num+" pax on "+day+" / "+month+" / "+year+" from "+from+" to "+to+"?");
        System.out.print("\nPress 1 to CANCEL THE BOOKING, or any other key to proceed to the main menu: ");
        int ch=sc.nextInt(); 
        if(ch==1)
        {
            System.out.print("You have cancelled the booking :-<\nSee you soon on flySRM!\n");
            booking=0;
        }
    }
    void customer_feedback()
    {
        System.out.print("Please enter your feedback here: "); 
        feedback=sc.nextLine();
        System.out.print("Thank you for giving us for valuable feedback!\n");
    }
    public static void main(String args[]) //main function to call other functions
    {
        Scanner in=new Scanner(System.in);
        int i=1, ch;
        FlySRM obj=new FlySRM(); //class object to call functions
        while(i!=0) //will run as long as you enter a non-menu value
        {
            System.out.print("WELCOME TO THE flySRM EASY TICKET BOOKING SYSTEM!");
            System.out.print("\n\nHow can we help you today?\n\nI want to"); 
            System.out.print("\n1) Book a Flight...");
            System.out.print("\n2) View my Booking...");
            System.out.print("\n3) Edit my Booking..."); 
            System.out.print("\n4) Cancel my Booking..."); 
            System.out.print("\n5) Give Feedback for flySRM...");
            System.out.print("\n\nPress the numbers to select an option, or press any other key to exit: "); 
            ch=in.nextInt();
            switch(ch) //simple switch case to pick the function to be called
            {
                case 1: 
                obj.book(); 
                break; 
                case 2: 
                obj.view(); 
                break; 
                case 3: 
                obj.edit(); 
                break; 
                case 4:
                obj.cancel(); 
                break;
                case 5:
                obj.customer_feedback(); 
                break;
                default: 
                i=0;
                break;
            }
        }
        System.out.print("\n\nThank you for considering flySRM! See you soon!");
        in.close();
    }
}