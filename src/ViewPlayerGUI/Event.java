package ViewPlayerGUI;

public class Event {
    /*
    eventList attributes:
    0. eventID int
    1. event_name String
    2. event_type String
    3. date date
    4. venue String
    5. member1 String
    6. member2 String
    7. member3 String
    8. member4 String
    9. member5 String
    10. member6 String
    */
   
    public Event(String newEventName){
        this.setEventName(newEventName);
        this.setEventType("");
        this.setDateOfEvent("");
        this.setVenue("");
        this.setMember1("");
        this.setMember2("");
        this.setMember3("");
        this.setMember4("");
        this.setMember5("");
        this.setMember6("");        
    }
    
   
    
    private int EventID;
    private String EventName;
    private String EventType;
    private String DateOfEvent;
    private String Venue;
    private String Member1;
    private String Member2;
    private String Member3;
    private String Member4;
    private String Member5;
    private String Member6;
    
    public int getEventID() {
        return EventID;
    }
    public void SetEventID(int EventID) {
        this.EventID = EventID;
    }
     
    public String getEventName() {
        return EventName;
    }
     public void setEventName(String EventName) {
        this.EventName = EventName;
    }
      public String getEventType() {
        return EventType;
    }
     public void setEventType(String EventType) {
        this.EventType = EventType;
    }
      public String getDateOfEvent() {
        return DateOfEvent;
    }
     public void setDateOfEvent(String DateOfEvent) {
        this.DateOfEvent = DateOfEvent;
    }
     public String getVenue() {
        return Venue;
    }
     public void setVenue(String Venue) {
        this.Venue = Venue;
    }
      public String getMember1() {
        return Member1;
    }
     public void setMember1(String Member1) {
        this.Member1 = Member1;
    }
      public String getMember2() {
        return Member2;
    }
     public void setMember2(String Member2) {
        this.Member2 = Member2;
    }
      public String getMember3() {
        return Member3;
    }
     public void setMember3(String Member3) {
        this.Member3 = Member3;
    }
      public String getMember4() {
        return Member4;
    }
     public void setMember4(String Member4) {
        this.Member4 = Member4;
    }
      public String getMember5() {
        return Member5;
    }
     public void setMember5(String Member5) {
        this.Member5 = Member5;
    }
      public String getMember6() {
        return Member6;
    }
     public void setMember6(String Member6) {
        this.Member6 = Member6;
    }
     public String [] toStringArray(){
//        this array converts the User/Player class back into a string array for export to CSV.
        int EventAttributes = 11;
        String [] EventInfoArray = new String[EventAttributes];
      
        EventInfoArray[0]=Integer.toString(this.getEventID());
        EventInfoArray[1]=this.getEventName();
        EventInfoArray[2]=this.getEventType();
        EventInfoArray[3]=this.getDateOfEvent();
        EventInfoArray[4]=this.getVenue();
        EventInfoArray[5]=this.getMember1();
        EventInfoArray[6]=this.getMember2();
        EventInfoArray[7]=this.getMember3();
        EventInfoArray[8]=this.getMember4();
        EventInfoArray[9]=this.getMember5();
        EventInfoArray[10]=this.getMember6();
        
        return EventInfoArray;
        
     }
     
}

