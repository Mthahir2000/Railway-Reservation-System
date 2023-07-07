import java.util.*;

public class Main
{
public static void bookTicket(Passenger p)
{
    TicketBook tb = new TicketBook();

    if(TicketBook.aWL == 0)
    {
        System.out.println("No Tickets Available");
        return;
    }
    else if(p.age > 60 && TicketBook.aLB > 0)
    {
        System.out.println("You're a Senior Citizen, so we arrange a Lower Berth");
        tb.bookTicket(p,(TicketBook.lBP.get(0)),"L");
        TicketBook.lBP.remove(0);
        TicketBook.aLB--;
    }
    else if(p.cname !=("null") && TicketBook.aLB > 0)
    {
        System.out.println("You Have a child, so we arrange the Lower Berth");
        tb.bookTicket(p,(TicketBook.lBP.get(0)),"L");
        TicketBook.lBP.remove(0);
        TicketBook.aLB--;
    }
    else if(((p.bp.equals("L") || p.bp.equals("l"))&& TicketBook.aLB > 0) || ((p.bp.equals("M") || p.bp.equals("m"))&& TicketBook.aMB > 0) || ((p.bp.equals("U") || p.bp.equals("u"))&& TicketBook.aUB > 0))
    {
        if(p.bp.equals("L") || p.bp.equals("l"))
        {
            p.bp = "L";
            System.out.println("\nLower Berth Given");
            tb.bookTicket(p,(TicketBook.lBP.get(0)),"L");
            TicketBook.lBP.remove(0);
            TicketBook.aLB--;
        }
        else if(p.bp.equals("M") || p.bp.equals("m"))
        {
            p.bp = "M";
            System.out.println("\nMiddle Berth Given");
            tb.bookTicket(p,(TicketBook.mBP.get(0)),"M");
            TicketBook.mBP.remove(0);
            TicketBook.aMB--;
        }
        else if(p.bp.equals("U") || p.bp.equals("u"))
        {
            p.bp = "U";
            System.out.println("\nUpper Berth Given");
            tb.bookTicket(p,(TicketBook.uBP.get(0)),"U");
            TicketBook.uBP.remove(0);
            TicketBook.aUB--;
        }
    }
    else if(TicketBook.aLB > 0)
    {
        System.out.println("\nLower Berth Given");
        tb.bookTicket(p,(TicketBook.lBP.get(0)),"L");
        TicketBook.lBP.remove(0);
        TicketBook.aLB--;
    }
    else if(TicketBook.aMB > 0)
    {
        System.out.println("\nMiddle Berth Given");
        tb.bookTicket(p,(TicketBook.mBP.get(0)),"M");
        TicketBook.mBP.remove(0);
        TicketBook.aMB--;
    }
    else if(TicketBook.aUB > 0)
    {
        System.out.println("\nUpper Berth Given");
        tb.bookTicket(p,(TicketBook.uBP.get(0)),"U");
        TicketBook.uBP.remove(0);
        TicketBook.aUB--;
    }
    else if(TicketBook.aRAC > 0)
    {
        System.out.println("\nRAc Given");
        tb.racTicket(p,(TicketBook.racP.get(0)),"RAC");
        TicketBook.racP.remove(0);
        TicketBook.aRAC--;
    }
    else if(TicketBook.aWL > 0)
    {
        System.out.println("\nWaiting List Given");
        tb.wlTicket(p,(TicketBook.wlP.get(0)),"WL");
        TicketBook.wlP.remove(0);
        TicketBook.aWL--;
    }
}



public static void cancelTicket(int id)
{
    TicketBook tb=new TicketBook();
    if(!tb.passenger_stored_data.containsKey(id))    
    {
        System.out.println("Passenger ID is not found!");
    }
    else
    {
        tb.cancelTicket(id);
    }
}





public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Welcome to Railway Reservation System");
    System.out.println();
    boolean loop=true; 
    while(loop)
    {
        System.out.println("1. Book \n2. Cancel \n3. Available Tickets \n4. Booked Tickets \n5. Exit");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
            {
                System.out.println("\nEnter the Passenger Name:");
                String name=sc.next();
                System.out.println("Enter the Passenger Age:");
                int age=sc.nextInt();
                System.out.println("Enter the Passenger Gender: [M, F]");
                boolean GV = true;
                while(GV)
                {
                    String gender=sc.next();
                    if(gender.equals("F") || gender.equals("f"))
                    {
                        GV = false;
                        gender = "F";
                        System.out.println("1. If you have a child, Press 1 \n2. If you haven't a child, press 2");
                        int gchoice=sc.nextInt();
                        if(gchoice == 1)
                        {
                            System.out.println("Enter Your Child Name:");
                            String cname=sc.next();
                            System.out.println("Enter Your Child Age:");
                            int cage=sc.nextInt();
                            System.out.println("Enter the Passenger Berth Preference: [L, M, U]");
                            String bp=sc.next();
                            Passenger p = new Passenger(name, age, gender, cname, cage, bp);
                            bookTicket(p);
                        }
                        else if(gchoice == 2)
                        {
                            System.out.println("Enter the Passenger Berth Preference: [L, M, U]");
                            String bp=sc.next();
                            String cname="null";
                            int cage=0;
                            Passenger p = new Passenger(name, age, gender, cname, cage, bp);
                            bookTicket(p);
                        }
                    }
                    else if(gender.equals("M") || gender.equals("m"))
                    {
                        GV = false;
                        gender = "M";
                        System.out.println("Enter the Passenger Berth Preference: [L, M, U]");
                        String bp=sc.next();
                        String cname="null";
                        int cage=0;
                        Passenger p = new Passenger(name, age, gender, cname, cage, bp);
                        bookTicket(p);
                    }
                    else
                        System.out.println("Invalid Input");
                } 
                break;
            }
            case 2:
            {
                System.out.println("\nEnter the Passenger ID:");
                int id=sc.nextInt();
                cancelTicket(id);
                break;
            }
            case 3:
            {
                TicketBook tb = new TicketBook();
                tb.availableTickets();
                break;
            }
            case 4:
            {
                TicketBook tb=new TicketBook();
                tb.passengersDetail();
                break;
            }
            case 5:
            {
                loop=false;
                break;
            }
        }
    }
}
}