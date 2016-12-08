/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPlayerGUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author moyockmike
 */
public class CoachLogin extends javax.swing.JFrame {
    private UserList ActiveUserList;
    private TeamList ActiveTeamList;
    private EventList ActiveEventList;
    //private static eventList ActiveEventList;

    private TeamRegistry ActiveTeamRegistry;
    private User ActiveUser;
    private int ActiveUserID;
    private Team ActiveTeam;
    
    private DefaultListModel<String> model2;
    
//    private static class eventList{
//        ArrayList<Integer> eventIDs;
//        ArrayList<String> eventName;
//        ArrayList<String> eventDate;
//        ArrayList<String> eventTime;
//        ArrayList<String> eventLocation;
//        ArrayList<String> eventDesc;
//        public eventList(){
//            this.eventIDs = new ArrayList<>();
//            this.eventName = new ArrayList<>(Arrays.asList("Game 1","Game 2","Game 3","Practice 1","Practice 2","Practice 3","Meeting 1","Meeting 2","Meeting 3","Tryouts 1"));
//            this.eventDate = new ArrayList<>(Arrays.asList("10/7/2016","10/14/2016","10/21/2016","10/6/2016","10/13/2016","10/20/2016","10/8/2016","10/15/2016","10/22/2016","9/1/2016"));
//            this.eventTime = new ArrayList<>(Arrays.asList("7:00 PM","7:00 PM","7:00 PM","5:00 PM","5:00 PM","5:00 PM","3:00 PM","3:00 PM","3:00 PM","12:00 PM"));
//            this.eventLocation = new ArrayList<>(Arrays.asList("Away","Home - Lower Field","Home - Upper Field","Lower Field","Upper Field","Lower Field","EUC Cone A Ballroom","EUC Dale Room","Raquetball Court A","Lower Field"));
//            this.eventDesc = new ArrayList<>(Arrays.asList("Versus the Atlanta Avada Kadabaras","Versus the Detroit Demogorgons","Versus the San Diego Simulacrums","Preparation for our game on October 7th","Preparation for our game on October 14th","Preparation for our game on October 21st","Reflect on game versus Atlanta. Planning for the new season.","Discuss game and player placement on teams.","Equipment inventory and coach meeting.","All players are welcome to attend. Previous team members are expected, but not required."));
//            
//            for (int i = 1; i <= 10; i++) {
//                this.eventIDs.add(i);
//            }
//          
//          
//          }
//    }
    
    public void resetPendingTeamTab(){
        String inputUserName = coachLoginNameText.getText().toLowerCase();
        this.ActiveUserID = this.ActiveUserList.getIDFromUsername(inputUserName);
        int teamID = ActiveTeamList.getIDFromCoach(this.ActiveUserID);
       
        DefaultListModel<String> model1 = new DefaultListModel<String>();

        ArrayList<String> aList = new ArrayList<String>();
        //ArrayList<String> aList2 = new ArrayList<String>();
        ActiveTeamList.getTeamFromID(teamID).getTeamName();//System.out.println(newTeamList.getTeamFromID(teamID).getTeamName());
        for (int i = 0; i < ActiveTeamRegistry.getUsersFromTeamID(teamID).length; i++) { 
            aList.add(ActiveUserList.getUserFromID(ActiveTeamRegistry.getUsersFromTeamID(teamID)[i]).getUserFullName().toString());   
        }
        for(String s: aList){
            model1.addElement(s);
        }
        coachPendingRosterjList1.setModel(model1);
        
    }
    
    public void resetRosterTab(){
        String inputUserName = coachLoginNameText.getText().toLowerCase();
        this.ActiveUserID = this.ActiveUserList.getIDFromUsername(inputUserName);
        int teamID = ActiveTeamList.getIDFromCoach(this.ActiveUserID);
      
        model2 = new DefaultListModel();
         
        String ActiveUserTeam = ActiveTeamList.getTeamFromID(teamID).getTeamName();
        Team ActiveTeam = ActiveTeamList.getTeamFromTeamname(ActiveUserTeam);
        
           
            int seekerID = ActiveTeam.getSeeker();
            if(!(seekerID == 0)){
            //int seekerID = ActiveTeam.getSeeker();
            String seekerName = ActiveUserList.getUserFromID(seekerID).getUserFullName();
            model2.addElement(seekerName.toString());
            coachStartLineupSeekFld.setText(seekerName);
            }
            
            int keeperID = ActiveTeam.getKeeper();
            if(!(keeperID == 0)){
            String keeperName = ActiveUserList.getUserFromID(keeperID).getUserFullName();
            model2.addElement(keeperName.toString());
            coachStartLineupKeeperFld.setText(keeperName);
            }
            
            int beaterOneID = ActiveTeam.getBeaterOne();
            if(!(beaterOneID == 0)){
            String beaterOneName = ActiveUserList.getUserFromID(beaterOneID).getUserFullName();
            model2.addElement(beaterOneName.toString());
            coachStartLineupBeaterOneFld.setText(beaterOneName);
            }
            
            int beaterTwoID = ActiveTeam.getBeaterTwo();
            if(!(beaterTwoID == 0)){
            String beaterTwoName = ActiveUserList.getUserFromID(beaterTwoID).getUserFullName();
            model2.addElement(beaterTwoName.toString());
            coachStartLineupBeaterTwoFld.setText(beaterTwoName);
            }
            
            
            int chaserOneID = ActiveTeam.getChaserOne();
            if(!(chaserOneID == 0)){
            String chaserOneName = ActiveUserList.getUserFromID(chaserOneID).getUserFullName();
            model2.addElement(chaserOneName.toString());
            coachStartLineupChaserOneFld.setText(chaserOneName);
            }
            
            int chaserTwoID = ActiveTeam.getChaserTwo();
            if(!(chaserTwoID == 0)){
            String chaserTwoName = ActiveUserList.getUserFromID(chaserTwoID).getUserFullName();
            model2.addElement(chaserTwoName.toString());
            coachStartLineupChaserTwoFld.setText(chaserTwoName);
            }
            
            int chaserThreeID = ActiveTeam.getChaserThree();
            if(!(chaserThreeID == 0)){
            String chaserThreeName = ActiveUserList.getUserFromID(chaserThreeID).getUserFullName();
            model2.addElement(chaserThreeName.toString());
            coachStartLineupChaserThreeFld.setText(chaserThreeName);
            }
            
            coachRosterjList1.setModel(model2);
            
            
    }
    
//    public void resetEventTab(){
//        DefaultListModel EventScrollList = new DefaultListModel();
//        
//        for (int i = 0; i < ActiveEventList.eventName.size(); i++) {
//            EventScrollList.addElement(ActiveEventList.eventName.get(i));
//        }
//        coachEventsjList1.setModel(EventScrollList);
////        plrEventDetailsNameField.setText("");
////        plrEventDetailsDateField.setText("");
////        plrEventDetailsTimeField.setText("");
////        plrEventDetailsLocField.setText("");
////        plrEventDetailsDescText.setText("");
//        
//    }
    
    public void resetEventsTab(){
        DefaultListModel eventModel = new DefaultListModel();
        
        for (Map.Entry<Integer, Event> eventEntry : ActiveEventList.getEventMap().entrySet()){
            System.out.println("eventEntry.getValue().getEventName() = " + eventEntry.getValue().getEventName());
            eventModel.addElement(eventEntry.getValue().getEventName());
                
 	}
 
         coachEventsjList1.setModel(eventModel);
         
    }
    
    public CoachLogin(UserList ActiveUserList, TeamList ActiveTeamList, EventList ActiveEventList, TeamRegistry ActiveTeamRegistry){
        this.ActiveUserList = ActiveUserList;
        this.ActiveTeamList = ActiveTeamList;
        this.ActiveEventList = ActiveEventList;
        this.ActiveTeamRegistry = ActiveTeamRegistry;
        this.ActiveUser = null;
        this.ActiveUserID = -1;
        
        
        
        initComponents();
//        puts frame in center of screen:
        this.setLocationRelativeTo(null);
    }
    /**
     * Creates new form Login
     */
//    public CoachLogin() {
//        initComponents();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CoachMain = new javax.swing.JFrame();
        coachLeftTabPane = new javax.swing.JTabbedPane();
        coachEventTabPane = new javax.swing.JTabbedPane();
        coachEventsScroll = new javax.swing.JScrollPane();
        coachEventsjList1 = new javax.swing.JList();
        coachSchedulePanel = new javax.swing.JPanel();
        coachSchedulePanel2 = new javax.swing.JPanel();
        coachScheduleTitleField = new javax.swing.JTextField();
        coachScheduleEventType = new javax.swing.JLabel();
        coachScheduleEventTypeBox = new javax.swing.JComboBox();
        coachScheduleEventDate = new javax.swing.JLabel();
        coachScheduleDetailsPanel = new javax.swing.JPanel();
        coachScheduleWhere = new javax.swing.JLabel();
        coachScheduleDetailsWhere = new javax.swing.JTextField();
        coachScheduleDetailsDescript = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CoachScheduleDetailsDescriptjTextArea1 = new javax.swing.JTextArea();
        coachScheduleEventDatejTextField1 = new javax.swing.JTextField();
        coachScheduleBack = new javax.swing.JButton();
        coachScheduleSave = new javax.swing.JButton();
        coachRosterTabPane = new javax.swing.JTabbedPane();
        coachRosterPanel = new javax.swing.JPanel();
        coachRosterAdd = new javax.swing.JButton();
        coachRosterRemove = new javax.swing.JButton();
        coachPendingRosterjScrollPane2 = new javax.swing.JScrollPane();
        coachPendingRosterjList1 = new javax.swing.JList();
        coachRosterjScrollPane3 = new javax.swing.JScrollPane();
        coachRosterjList1 = new javax.swing.JList();
        coachStartLineupPanel = new javax.swing.JPanel();
        coachStatLineupSeeker = new javax.swing.JLabel();
        coachStartLineupKeeper = new javax.swing.JLabel();
        coachStartLineupBeaters = new javax.swing.JLabel();
        coachStartLineupChasers = new javax.swing.JLabel();
        coachStartLineupSave = new javax.swing.JButton();
        coachStartLineupSeekFld = new javax.swing.JTextField();
        coachStartLineupKeeperFld = new javax.swing.JTextField();
        coachStartLineupBeaterOneFld = new javax.swing.JTextField();
        coachStartLineupBeaterTwoFld = new javax.swing.JTextField();
        coachStartLineupChaserOneFld = new javax.swing.JTextField();
        coachStartLineupChaserTwoFld = new javax.swing.JTextField();
        coachStartLineupChaserThreeFld = new javax.swing.JTextField();
        coachLogout = new javax.swing.JButton();
        coachLoginPanel = new javax.swing.JPanel();
        coachLoginName = new javax.swing.JLabel();
        coachLoginNameText = new javax.swing.JTextField();
        coachLoginOK = new javax.swing.JButton();
        coachLoginCancel = new javax.swing.JButton();

        CoachMain.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        CoachMain.setSize(new java.awt.Dimension(850, 660));

        coachLeftTabPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        coachLeftTabPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        coachEventsScroll.setViewportView(coachEventsjList1);

        coachEventTabPane.addTab("Events", coachEventsScroll);

        coachScheduleTitleField.setText("Untitled Event");
        coachScheduleTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachScheduleTitleFieldActionPerformed(evt);
            }
        });

        coachScheduleEventType.setText("Event Type:");

        coachScheduleEventTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Practice", "Meeting" }));
        coachScheduleEventTypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachScheduleEventTypeBoxActionPerformed(evt);
            }
        });

        coachScheduleEventDate.setText("Event Date:");

        coachScheduleDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));

        coachScheduleWhere.setText("Where");

        coachScheduleDetailsWhere.setText("Practice Field");

        coachScheduleDetailsDescript.setText("Description");

        CoachScheduleDetailsDescriptjTextArea1.setColumns(20);
        CoachScheduleDetailsDescriptjTextArea1.setRows(5);
        CoachScheduleDetailsDescriptjTextArea1.setText("This is a Team practice.");
        jScrollPane1.setViewportView(CoachScheduleDetailsDescriptjTextArea1);

        javax.swing.GroupLayout coachScheduleDetailsPanelLayout = new javax.swing.GroupLayout(coachScheduleDetailsPanel);
        coachScheduleDetailsPanel.setLayout(coachScheduleDetailsPanelLayout);
        coachScheduleDetailsPanelLayout.setHorizontalGroup(
            coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachScheduleDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(coachScheduleDetailsDescript, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coachScheduleWhere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(coachScheduleDetailsWhere, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        coachScheduleDetailsPanelLayout.setVerticalGroup(
            coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachScheduleDetailsPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachScheduleWhere)
                    .addComponent(coachScheduleDetailsWhere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coachScheduleDetailsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachScheduleDetailsDescript)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coachScheduleDetailsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        coachScheduleEventDatejTextField1.setText("10/25/16");

        javax.swing.GroupLayout coachSchedulePanel2Layout = new javax.swing.GroupLayout(coachSchedulePanel2);
        coachSchedulePanel2.setLayout(coachSchedulePanel2Layout);
        coachSchedulePanel2Layout.setHorizontalGroup(
            coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coachScheduleDetailsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                        .addComponent(coachScheduleEventDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachScheduleEventDatejTextField1))
                    .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                        .addGroup(coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                                .addComponent(coachScheduleEventType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(coachScheduleEventTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(coachScheduleTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        coachSchedulePanel2Layout.setVerticalGroup(
            coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(coachScheduleTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachScheduleEventType)
                    .addComponent(coachScheduleEventTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachScheduleEventDate)
                    .addComponent(coachScheduleEventDatejTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(coachScheduleDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        coachScheduleBack.setText("Back");
        coachScheduleBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachScheduleBackActionPerformed(evt);
            }
        });

        coachScheduleSave.setText("Save");
        coachScheduleSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachScheduleSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coachSchedulePanelLayout = new javax.swing.GroupLayout(coachSchedulePanel);
        coachSchedulePanel.setLayout(coachSchedulePanelLayout);
        coachSchedulePanelLayout.setHorizontalGroup(
            coachSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachSchedulePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coachSchedulePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(285, 285, 285))
            .addGroup(coachSchedulePanelLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(coachScheduleBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachScheduleSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        coachSchedulePanelLayout.setVerticalGroup(
            coachSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachSchedulePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(coachSchedulePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coachSchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachScheduleBack)
                    .addComponent(coachScheduleSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        coachEventTabPane.addTab("Schedule", coachSchedulePanel);

        coachLeftTabPane.addTab("Event", coachEventTabPane);

        coachRosterAdd.setText("Add");
        coachRosterAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachRosterAddActionPerformed(evt);
            }
        });

        coachRosterRemove.setText("Remove");
        coachRosterRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachRosterRemoveActionPerformed(evt);
            }
        });

        coachPendingRosterjList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coachPendingRosterjList1MouseClicked(evt);
            }
        });
        coachPendingRosterjList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                coachPendingRosterjList1ValueChanged(evt);
            }
        });
        coachPendingRosterjScrollPane2.setViewportView(coachPendingRosterjList1);

        coachRosterjList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coachRosterjList1MouseClicked(evt);
            }
        });
        coachRosterjScrollPane3.setViewportView(coachRosterjList1);

        javax.swing.GroupLayout coachRosterPanelLayout = new javax.swing.GroupLayout(coachRosterPanel);
        coachRosterPanel.setLayout(coachRosterPanelLayout);
        coachRosterPanelLayout.setHorizontalGroup(
            coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coachRosterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coachRosterjScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coachRosterPanelLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(coachRosterAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachRosterRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addComponent(coachPendingRosterjScrollPane2))
                .addContainerGap())
        );
        coachRosterPanelLayout.setVerticalGroup(
            coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachRosterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coachPendingRosterjScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachRosterRemove)
                    .addComponent(coachRosterAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachRosterjScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        coachRosterTabPane.addTab("Roster", coachRosterPanel);

        coachStatLineupSeeker.setText("Seeker:");

        coachStartLineupKeeper.setText("Keeper:");

        coachStartLineupBeaters.setText("Beaters:");

        coachStartLineupChasers.setText("Chasers:");

        coachStartLineupSave.setText("Save");
        coachStartLineupSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachStartLineupSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coachStartLineupPanelLayout = new javax.swing.GroupLayout(coachStartLineupPanel);
        coachStartLineupPanel.setLayout(coachStartLineupPanelLayout);
        coachStartLineupPanelLayout.setHorizontalGroup(
            coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coachStartLineupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coachStartLineupSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                            .addComponent(coachStatLineupSeeker)
                            .addGap(18, 18, 18)
                            .addComponent(coachStartLineupSeekFld, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                            .addComponent(coachStartLineupKeeper)
                            .addGap(18, 18, 18)
                            .addComponent(coachStartLineupKeeperFld))
                        .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                            .addComponent(coachStartLineupChasers)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(coachStartLineupChaserOneFld)
                                .addComponent(coachStartLineupChaserTwoFld)
                                .addComponent(coachStartLineupChaserThreeFld))))
                    .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                        .addComponent(coachStartLineupBeaters)
                        .addGap(18, 18, 18)
                        .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(coachStartLineupBeaterTwoFld, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(coachStartLineupBeaterOneFld))
                        .addGap(2, 2, 2)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        coachStartLineupPanelLayout.setVerticalGroup(
            coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachStatLineupSeeker)
                    .addComponent(coachStartLineupSeekFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coachStartLineupKeeper)
                    .addComponent(coachStartLineupKeeperFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachStartLineupBeaters)
                    .addComponent(coachStartLineupBeaterOneFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(coachStartLineupBeaterTwoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachStartLineupChasers)
                    .addComponent(coachStartLineupChaserOneFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(coachStartLineupChaserTwoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(coachStartLineupChaserThreeFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coachStartLineupSave)
                .addGap(39, 39, 39))
        );

        coachRosterTabPane.addTab("Starting Lineup", coachStartLineupPanel);

        coachLeftTabPane.addTab("Roster", coachRosterTabPane);

        coachLogout.setText("Logout");
        coachLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CoachMainLayout = new javax.swing.GroupLayout(CoachMain.getContentPane());
        CoachMain.getContentPane().setLayout(CoachMainLayout);
        CoachMainLayout.setHorizontalGroup(
            CoachMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoachMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CoachMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachLeftTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(coachLogout)))
                .addContainerGap())
        );
        CoachMainLayout.setVerticalGroup(
            CoachMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coachLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachLeftTabPane))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        coachLoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        coachLoginName.setText("Enter name: ");

        coachLoginNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachLoginNameTextActionPerformed(evt);
            }
        });

        coachLoginOK.setText("OK");
        coachLoginOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachLoginOKActionPerformed(evt);
            }
        });

        coachLoginCancel.setText("Cancel");
        coachLoginCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachLoginCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coachLoginPanelLayout = new javax.swing.GroupLayout(coachLoginPanel);
        coachLoginPanel.setLayout(coachLoginPanelLayout);
        coachLoginPanelLayout.setHorizontalGroup(
            coachLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachLoginPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(coachLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(coachLoginPanelLayout.createSequentialGroup()
                        .addComponent(coachLoginName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coachLoginNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coachLoginPanelLayout.createSequentialGroup()
                        .addComponent(coachLoginOK, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(coachLoginCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        coachLoginPanelLayout.setVerticalGroup(
            coachLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachLoginPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(coachLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachLoginName)
                    .addComponent(coachLoginNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(coachLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachLoginCancel)
                    .addComponent(coachLoginOK))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coachLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coachLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coachLoginOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLoginOKActionPerformed
//        CoachMainHome coachNewScreen = new CoachMainHome();
//        coachNewScreen.setVisible(true);
//        this.setVisible(false);
        
        String inputUserName = coachLoginNameText.getText().toLowerCase();
        if (this.ActiveUserList.getIDFromUsername(inputUserName) > -1) {
            this.ActiveUserID = this.ActiveUserList.getIDFromUsername(inputUserName);
            this.ActiveUser = this.ActiveUserList.getUserFromID(ActiveUserID);
            if (this.ActiveUser.getIsCoach() == true) {
                
            
                CoachMain.setVisible(true);
                CoachMain.setLocationRelativeTo(null);
                //plrNameTextField.setText(this.ActiveUser.getUserFullName());
                this.dispose();
                //CoachMain.pack();
            }
            else{
//              display error dialog...
                JOptionPane.showMessageDialog(this, "Invalid username. Not a Coach");
            }
        }
        else{
//            display error dialog...
            JOptionPane.showMessageDialog(this, "Please enter a valid username.");
        }
        this.resetPendingTeamTab();
        this.resetRosterTab();
        //this.resetEventTab();
        this.resetEventsTab();
        
    }//GEN-LAST:event_coachLoginOKActionPerformed

    private void coachLoginNameTextMouseClicked(java.awt.event.MouseEvent evt) {                                            
        coachLoginNameText.setText("");
    } 
    private void coachLoginCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLoginCancelActionPerformed
        // TODO add your handling code here:
        //CoachLogin.dispose();
    }//GEN-LAST:event_coachLoginCancelActionPerformed

    private void coachLoginNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLoginNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachLoginNameTextActionPerformed

    private void coachScheduleBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachScheduleBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachScheduleBackActionPerformed

    private void coachScheduleSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachScheduleSaveActionPerformed
        
        
        String eventName = coachScheduleTitleField.getText();
        Object selectedEventType = coachScheduleEventTypeBox.getSelectedItem();
        String dateOfEvent = coachScheduleEventDatejTextField1.getText().toUpperCase();
        String venue = coachScheduleDetailsWhere.getText().toUpperCase();
        
        Event newEvent = new Event(eventName);
        newEvent.setEventType(selectedEventType.toString());
        newEvent.setDateOfEvent(dateOfEvent.toString());
        newEvent.setVenue(venue.toString());
        newEvent.setMember1("");
        newEvent.setMember2("");
        newEvent.setMember3("");
        newEvent.setMember4("");
        newEvent.setMember5("");
        newEvent.setMember6("");
        
        
        int newEventID = ActiveEventList.getNewMaxID();
        newEvent.SetEventID(newEventID);

        ActiveEventList.getEventMap().put(newEventID, newEvent);

        
        //ActiveEventList.addNewEvent(eventName);
        try {
                ActiveEventList.writeListToCSV();
            } catch (IOException ex) {
                Logger.getLogger(CoachLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_coachScheduleSaveActionPerformed

    private void coachRosterAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRosterAddActionPerformed
        model2 = (DefaultListModel<String>) coachRosterjList1.getModel();
        int size = coachRosterjList1.getModel().getSize();

        if (!(size == 7)){
            String selection =(String) coachPendingRosterjList1.getSelectedValue();
//            model2.addElement(selection);
            
            model2.addElement(selection);
            
           
        }
             
    }//GEN-LAST:event_coachRosterAddActionPerformed

    private void coachRosterRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRosterRemoveActionPerformed
        DefaultListModel<String> model2 = new DefaultListModel<String>();
        //if (!(coachRosterjList1.getModel().getSize() == 7)){
        
        
//        String selection =(String) coachRosterjList1.getSelectedValue();
//        
//        //model2.addElement(selection);
//        coachRosterjList1.clearSelection();
//        model2.removeElement(selection);
//        
//        coachRosterjList1.setModel(model2);
        
        
//        List<String> selectedItems = coachRosterjList1.getSelectedValuesList();
//
//    for (String s: selectedItems){
//        model2.removeElement(s);
//    }
    //coachRosterjList1.setModel(model2);
    
        final int index = coachRosterjList1.getSelectedIndex();

        if (index >= 0) {

            ((DefaultListModel) coachRosterjList1.getModel()).removeElementAt(index);

        }
    
    }//GEN-LAST:event_coachRosterRemoveActionPerformed

    private void coachStartLineupSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachStartLineupSaveActionPerformed
        String inputUserName = coachLoginNameText.getText().toLowerCase();
        this.ActiveUserID = this.ActiveUserList.getIDFromUsername(inputUserName);
        int teamID = ActiveTeamList.getIDFromCoach(this.ActiveUserID);
        ActiveTeam = ActiveTeamList.getTeamFromID(teamID);
        
        
        int seekID = ActiveUserList.getIDFromFullName(coachStartLineupSeekFld.getText().toUpperCase());
        int keepID = ActiveUserList.getIDFromFullName(coachStartLineupKeeperFld.getText().toUpperCase());
        int beatOneID = ActiveUserList.getIDFromFullName(coachStartLineupBeaterOneFld.getText().toUpperCase());
        int beatTwoID = ActiveUserList.getIDFromFullName(coachStartLineupBeaterTwoFld.getText().toUpperCase());
        int chaseOneID = ActiveUserList.getIDFromFullName(coachStartLineupChaserOneFld.getText().toUpperCase());
        int chaseTwoID = ActiveUserList.getIDFromFullName( coachStartLineupChaserTwoFld.getText().toUpperCase());
        int chaseThreeID = ActiveUserList.getIDFromFullName(coachStartLineupChaserThreeFld.getText().toUpperCase());
        
        
        //System.out.println("seekID =  " + seekID); 
        ActiveTeam.setCoach(ActiveUser.getID());
        ActiveTeam.setBeaterOne(beatOneID);
        ActiveTeam.setBeaterTwo(beatTwoID); 
        ActiveTeam.setChaserOne(chaseOneID); 
        ActiveTeam.setChaserTwo(chaseTwoID); 
        ActiveTeam.setChaserThree(chaseThreeID); 
        ActiveTeam.setSeeker(seekID);
        ActiveTeam.setKeeper(keepID);
        try {
            ActiveTeamList.writeListToCSV();
        } catch (IOException ex) {
            Logger.getLogger(CoachLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
                                                       
    }//GEN-LAST:event_coachStartLineupSaveActionPerformed

    private void coachLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLogoutActionPerformed
        // TODO add your handling code here:
        CoachMain.dispose();
    }//GEN-LAST:event_coachLogoutActionPerformed

    private void coachScheduleTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachScheduleTitleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachScheduleTitleFieldActionPerformed

    private void coachScheduleEventTypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachScheduleEventTypeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachScheduleEventTypeBoxActionPerformed

    private void coachPendingRosterjList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_coachPendingRosterjList1ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_coachPendingRosterjList1ValueChanged

    private void coachPendingRosterjList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachPendingRosterjList1MouseClicked
//        
    }//GEN-LAST:event_coachPendingRosterjList1MouseClicked

    private void coachRosterjList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachRosterjList1MouseClicked
        
    }//GEN-LAST:event_coachRosterjList1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UserList initUserList = new UserList();
        TeamList initTeam = new TeamList();
        EventList initEvent = new EventList();
        //eventList initEvents = new eventList();
        TeamRegistry initTeamReg = new TeamRegistry();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CoachLogin(initUserList, initTeam, initEvent, initTeamReg).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame CoachMain;
    private javax.swing.JTextArea CoachScheduleDetailsDescriptjTextArea1;
    private javax.swing.JTabbedPane coachEventTabPane;
    private javax.swing.JScrollPane coachEventsScroll;
    private javax.swing.JList coachEventsjList1;
    private javax.swing.JTabbedPane coachLeftTabPane;
    private javax.swing.JButton coachLoginCancel;
    private javax.swing.JLabel coachLoginName;
    private javax.swing.JTextField coachLoginNameText;
    private javax.swing.JButton coachLoginOK;
    private javax.swing.JPanel coachLoginPanel;
    private javax.swing.JButton coachLogout;
    private javax.swing.JList coachPendingRosterjList1;
    private javax.swing.JScrollPane coachPendingRosterjScrollPane2;
    private javax.swing.JButton coachRosterAdd;
    private javax.swing.JPanel coachRosterPanel;
    private javax.swing.JButton coachRosterRemove;
    private javax.swing.JTabbedPane coachRosterTabPane;
    private javax.swing.JList coachRosterjList1;
    private javax.swing.JScrollPane coachRosterjScrollPane3;
    private javax.swing.JButton coachScheduleBack;
    private javax.swing.JLabel coachScheduleDetailsDescript;
    private javax.swing.JPanel coachScheduleDetailsPanel;
    private javax.swing.JTextField coachScheduleDetailsWhere;
    private javax.swing.JLabel coachScheduleEventDate;
    private javax.swing.JTextField coachScheduleEventDatejTextField1;
    private javax.swing.JLabel coachScheduleEventType;
    private javax.swing.JComboBox coachScheduleEventTypeBox;
    private javax.swing.JPanel coachSchedulePanel;
    private javax.swing.JPanel coachSchedulePanel2;
    private javax.swing.JButton coachScheduleSave;
    private javax.swing.JTextField coachScheduleTitleField;
    private javax.swing.JLabel coachScheduleWhere;
    private javax.swing.JTextField coachStartLineupBeaterOneFld;
    private javax.swing.JTextField coachStartLineupBeaterTwoFld;
    private javax.swing.JLabel coachStartLineupBeaters;
    private javax.swing.JTextField coachStartLineupChaserOneFld;
    private javax.swing.JTextField coachStartLineupChaserThreeFld;
    private javax.swing.JTextField coachStartLineupChaserTwoFld;
    private javax.swing.JLabel coachStartLineupChasers;
    private javax.swing.JLabel coachStartLineupKeeper;
    private javax.swing.JTextField coachStartLineupKeeperFld;
    private javax.swing.JPanel coachStartLineupPanel;
    private javax.swing.JButton coachStartLineupSave;
    private javax.swing.JTextField coachStartLineupSeekFld;
    private javax.swing.JLabel coachStatLineupSeeker;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
