package exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.exceptions.DomainException;

/**
 *
 * @author Rafu
 */
public class ProgramReservation {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
        System.out.print("Room number:");
        int number = sc.nextInt();
        System.out.print("CheckIn:");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("CheckOut:");
        Date checkOut = sdf.parse(sc.next());
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.print("CheckIn:");
            checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut:");
            checkOut = sdf.parse(sc.next());
            
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: "+reservation);
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch(DomainException e){
            System.out.println(e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
    }
}