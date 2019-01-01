package com.company.Collections;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
    private final String theatreName;
    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            // this may look like we are instantiating the Comparator interface, but this is what's happening is that it is an "anonymous" in a class that implements the Comparator
            // and is providing an implementation of a single compare method
            @Override
            public int compare(Seat seat1, Seat seat2) { // sort by price of tickets
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1; // returns the same values as the compareTo method
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    public List<Seat> seats = new ArrayList<>(); // making it of type "Collection" is just making it more "generic"
    // private Collection<Seat> seats = new LinkedHashSet<>(); // still returns in order
    // private Collection<Seat> seats = new HashSet<>(); // returns not in order
    // private Collection<Seat> seats = new TreeSet<>(); // will return an error, because TreeSet is below the SortedSet (in our hierarchy image)
    // so anything below there will return an error

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if (row < 'D' && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if (row > 'F' || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
//        int low = 0; // Java "source code" for binarySearch
//        int high = seats.size()-1;
//
//        while (low <= high) {
//            System.out.print("."); // prints out the number of iterations Java has to go through to find the seat
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            if (cmp < 0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid - 1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat " + seatNumber);
//        return false;
        Seat requestedSeat = new Seat(seatNumber, 0); //gives us the object for comparison
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null); // much more efficient than doing a loop
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat: " + seatNumber);
            return false;
        }
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> { // this is an inner class
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " already reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}



















