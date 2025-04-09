package dk.easv.mohammadabd.ems.GUI.Model;

import dk.easv.mohammadabd.ems.BE.Ticket;
import dk.easv.mohammadabd.ems.BLL.TicketBL;

import java.sql.SQLException;


public class TicketML {

    public Ticket generateTicket() throws SQLException {
        TicketBL ticketBL = new TicketBL();
        Ticket ticket;
        ticket = ticketBL.generateRandomData();

        System.out.println("Generated Ticket: " + ticket.toString());
        return ticket;
    }
}
