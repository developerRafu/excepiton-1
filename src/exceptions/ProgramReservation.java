package exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rafu
 */
public class ProgramReservation {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number:");
        int number = sc.nextInt();
        System.out.print("CheckIn:");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("CheckOut:");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();


            System.out.print("CheckIn:");
            checkIn = sdf.parse(sc.next());
            System.out.print("CheckOut:");
            checkOut = sdf.parse(sc.next());
           Date now = new Date();
           if(checkOut.before(now) || checkIn.before(now)){
               System.out.println("Error in reservation: Reservation dates for update must be future dates");
           }else if(!checkOut.before(checkIn)){
               System.out.println("Error in reservation: Check-out date must be after check-in date");
           }else{
               reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: "+reservation);
           }
        }
    }
}
