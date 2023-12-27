package org.example;

class Attraction {
    private String name;
    private String description;
    private int id;


    private boolean open;

    private int ticket_count;


    private int price=0;

    Attraction(String name, String description, Integer id) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.open=true;
        this.ticket_count=0;

    }
    public int getTicket_count() {
        return ticket_count;
    }

    public void setTicket_count(int ticket_count) {
        this.ticket_count = ticket_count;
    }

    //  @Override
    //public String toString() {
//        return "Attraction{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
    public String getName() {
        return name;
    }
    public boolean isOpen() {
        return open;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketCount() {
        return ticket_count;
    }

    public void setTicketCount(int ticketCount) {
        this.ticket_count = ticketCount;
    }

}