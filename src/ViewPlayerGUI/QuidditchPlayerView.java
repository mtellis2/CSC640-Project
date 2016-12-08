package ViewPlayerGUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brown Biggers
 */
public class QuidditchPlayerView extends javax.swing.JFrame{
    private UserList ActiveUserList;
    private PlayerStatsList ActivePlayerStats;
    private TeamList ActiveTeamList;
    private eventList ActiveEventList;
    private supplyList ActiveSupplyList;
    private SupplyRequestList ActiveSupplyRequestList;
    private TeamRegistry ActiveTeamRegistry;
    private EventRegistry ActiveEventRegistry;
    private User ActiveUser;
    private int ActiveUserID;
    
//    creating event list with static data.
    private static class eventList{
        ArrayList<Integer> eventIDs;
        ArrayList<String> eventName;
        ArrayList<String> eventDate;
        ArrayList<String> eventTime;
        ArrayList<String> eventLocation;
        ArrayList<String> eventDesc;
        public eventList(){
            this.eventIDs = new ArrayList<>();
            this.eventName = new ArrayList<>(Arrays.asList("Game 1","Game 2","Game 3","Practice 1","Practice 2","Practice 3","Meeting 1","Meeting 2","Meeting 3","Tryouts 1"));
            this.eventDate = new ArrayList<>(Arrays.asList("10/7/2016","10/14/2016","10/21/2016","10/6/2016","10/13/2016","10/20/2016","10/8/2016","10/15/2016","10/22/2016","9/1/2016"));
            this.eventTime = new ArrayList<>(Arrays.asList("7:00 PM","7:00 PM","7:00 PM","5:00 PM","5:00 PM","5:00 PM","3:00 PM","3:00 PM","3:00 PM","12:00 PM"));
            this.eventLocation = new ArrayList<>(Arrays.asList("Away","Home - Lower Field","Home - Upper Field","Lower Field","Upper Field","Lower Field","EUC Cone A Ballroom","EUC Dale Room","Raquetball Court A","Lower Field"));
            this.eventDesc = new ArrayList<>(Arrays.asList("Versus the Atlanta Avada Kadabaras","Versus the Detroit Demogorgons","Versus the San Diego Simulacrums","Preparation for our game on October 7th","Preparation for our game on October 14th","Preparation for our game on October 21st","Reflect on game versus Atlanta. Planning for the new season.","Discuss game and player placement on teams.","Equipment inventory and coach meeting.","All players are welcome to attend. Previous team members are expected, but not required."));
            
            for (int i = 1; i <= 10; i++) {
                this.eventIDs.add(i);
            }
          
          
          }
        
        public int getIDFromEventName(String eventName){
             return this.eventName.indexOf(eventName);
        }
        public String getEventNameFromID(int eventID){
            int searchedID = this.eventIDs.indexOf(eventID);
            return this.eventName.get(searchedID);
        }
    
    }
    private static class supplyList{
        ArrayList<Integer> supplyIDs;
        ArrayList<String> supplyName;
        ArrayList<String> supplyDesc;
        public supplyList(){
            this.supplyIDs = new ArrayList<>();
            this.supplyName = new ArrayList<>(Arrays.asList("Bludger","Broom - S","Broom - M","Broom - L","Headband (Beater)","Headband (Keeper)","Headband (Seeker)","Headband (Chaser)","Hoop","Quaffle","Snitch","Snitch Harness"));
            this.supplyDesc = new ArrayList<>(Arrays.asList("Ball used by the Beaters","Player's broom - size small","Player's broom - size small","Player's broom - size small","Black headband for beaters","Green headband for keepers","Yellow headband for seekers","White headband for chasers","Three hoops per team for scoring","Ball used by Chasers for scoring","Ball mounted in harness for role of snitch","Harness/Sock used to hold snitch for snitch player"));
            
            for (int i = 1; i <= 12; i++) {
                this.supplyIDs.add(i);
            }
          
          
          }
        
        public int getIDFromEventName(String supplyName){
             return this.supplyName.indexOf(supplyName);
        }
        public String getEventNameFromID(int supplyID){
            int searchedID = this.supplyIDs.indexOf(supplyID);
            return this.supplyName.get(searchedID);
        }
    
    }
    
    public void resetEventTab(){
        DefaultListModel EventScrollList = new DefaultListModel();
        for (int i = 0; i < ActiveEventList.eventName.size(); i++) {
            EventScrollList.addElement(ActiveEventList.eventName.get(i));
        }
        plrEventScrollList.setModel(EventScrollList);
        plrEventDetailsNameField.setText("");
        plrEventDetailsDateField.setText("");
        plrEventDetailsTimeField.setText("");
        plrEventDetailsLocField.setText("");
        plrEventDetailsDescText.setText("");
        
    }
    
    public void groupButton(){
        ButtonGroup plrButtonGroup = new ButtonGroup();
        plrButtonGroup.add(plrEventAttendYes);
        plrButtonGroup.add(plrEventAttendNo);
    }
    public void resetTeamTab(){
//        initializing the values for the Team List.
        DefaultListModel TeamScrollList = new DefaultListModel();
        for (Map.Entry<Integer, Team> teamEntry : ActiveTeamList.getTeamMap().entrySet())
	{
		TeamScrollList.addElement(teamEntry.getValue().getTeamName());
	}

        plrTeamScrollList.setModel(TeamScrollList);
//        Set team fields blank
        plrTeamDetailsBtrAFld.setText("");
        plrTeamDetailsBtrBFld.setText("");
        plrTeamDetailsChsAFld.setText("");
        plrTeamDetailsChsBFld.setText("");
        plrTeamDetailsChsCFld.setText("");
        plrTeamDetailsKeepFld.setText("");
        plrTeamDetailsSeekFld.setText("");
        plrTeamDetailsCoachFld.setText("");
        
        }
    
    public void resetSupplyTab(){
        DefaultListModel SupplyScrollList = new DefaultListModel();
        for (int i = 0; i < ActiveSupplyList.supplyName.size(); i++) {
            SupplyScrollList.addElement(ActiveSupplyList.supplyName.get(i));
        }
        plrSuppliesScrollList.setModel(SupplyScrollList);
        plrSupplyItemFld.setText("");
        plrSupplyDescFld.setText("");
        plrSupplyQuantityFld.setValue(0);
        plrSupplyNotesText.setText("");
        
    }
    
    public void setPlayerEventList(){
        int [] eventIDs = this.ActiveEventRegistry.getEventsFromUserID(ActiveUserID);
        DefaultListModel PlayerEventListModel = new DefaultListModel();
        
        for (int i = 0; i < eventIDs.length; i++) {
            PlayerEventListModel.addElement(ActiveEventList.eventName.get(eventIDs[i]));
        }
        
        plrInfoEventsList.setModel(PlayerEventListModel);
        
        
    }
    
    public void setPlayerSupplyList(){
        int suppliesNum = this.ActiveSupplyRequestList.getUserSupplyRequests(ActiveUserID).length;
        int [] suppliesList = this.ActiveSupplyRequestList.getUserSupplyRequests(ActiveUserID);
        DefaultListModel PlayerSupplyListModel = new DefaultListModel();
        
        for (int i = 0; i < suppliesNum; i++) {
            PlayerSupplyListModel.addElement(ActiveSupplyList.supplyName.get(suppliesList[i]));
        }
        
        plrInfoSuppliesList.setModel(PlayerSupplyListModel);
        
        
    }
    
    public void setPlayerTeamsList(){
        DefaultListModel PlayerTeamsListModel = new DefaultListModel();
        for (int i = 0; i < ActiveTeamRegistry.getTeamsFromUserID(ActiveUserID).length; i++) {
            int teamID = ActiveTeamRegistry.getTeamsFromUserID(ActiveUserID)[i];
            PlayerTeamsListModel.addElement(ActiveTeamList.getTeamnameFromID(teamID));
        }
        plrInfoTeamsList.setModel(PlayerTeamsListModel);
    }
            
    
    public void setTeamPositionFields(String teamName){
        Team selectedTeam = ActiveTeamList.getTeamFromTeamname(teamName);
//        set coach
        if(selectedTeam.getCoach() > 0){
           int coachID = selectedTeam.getCoach();
           String coachName = ActiveUserList.getUserFromID(coachID).getUserFullName();
           plrTeamDetailsCoachFld.setText(coachName);
        }
        else{plrTeamDetailsCoachFld.setText("");}
//        set beater one
        if(selectedTeam.getBeaterOne() > 0){
           int beaterOneID = selectedTeam.getBeaterOne();
           String beaterOneName = ActiveUserList.getUserFromID(beaterOneID).getUserFullName();
           plrTeamDetailsBtrAFld.setText(beaterOneName);
        }
        else{plrTeamDetailsBtrAFld.setText("");}
//        set beater two
        if(selectedTeam.getBeaterTwo() > 0){
           int beaterTwoID = selectedTeam.getBeaterTwo();
           String beaterTwoName = ActiveUserList.getUserFromID(beaterTwoID).getUserFullName();
           plrTeamDetailsBtrBFld.setText(beaterTwoName);
        }
        else{plrTeamDetailsBtrBFld.setText("");}
//        set chaser one
        if(selectedTeam.getChaserOne() > 0){
           int chaserOneID = selectedTeam.getChaserOne();
           String chaserOneName = ActiveUserList.getUserFromID(chaserOneID).getUserFullName();
           plrTeamDetailsChsAFld.setText(chaserOneName);
        }
        else{plrTeamDetailsChsAFld.setText("");}
//        set chaser two
        if(selectedTeam.getChaserTwo() > 0){
           int chaserTwoID = selectedTeam.getChaserTwo();
           String chaserTwoName = ActiveUserList.getUserFromID(chaserTwoID).getUserFullName();
           plrTeamDetailsChsBFld.setText(chaserTwoName);
        }
        else{plrTeamDetailsChsBFld.setText("");}
//        set chaser three
        if(selectedTeam.getChaserThree() > 0){
           int chaserThreeID = selectedTeam.getChaserThree();
           String chaserThreeName = ActiveUserList.getUserFromID(chaserThreeID).getUserFullName();
           plrTeamDetailsChsCFld.setText(chaserThreeName);
        }
        else{plrTeamDetailsChsCFld.setText("");}
//        set keeper
        if(selectedTeam.getKeeper() > 0){
           int keeperID = selectedTeam.getKeeper();
           String keeperName = ActiveUserList.getUserFromID(keeperID).getUserFullName();
           plrTeamDetailsKeepFld.setText(keeperName);
        }
        else{plrTeamDetailsKeepFld.setText("");}
//        set seeker
        if(selectedTeam.getSeeker() > 0){
           int seekerID = selectedTeam.getSeeker();
           String seekerName = ActiveUserList.getUserFromID(seekerID).getUserFullName();
           plrTeamDetailsSeekFld.setText(seekerName);
        }
        else{plrTeamDetailsSeekFld.setText("");}
    
    }
    
    public void setEventInfoFields(String eventName){
        int index = this.ActiveEventList.getIDFromEventName(eventName);
        plrEventDetailsNameField.setText(this.ActiveEventList.eventName.get(index));
        plrEventDetailsDateField.setText(this.ActiveEventList.eventDate.get(index));
        plrEventDetailsTimeField.setText(this.ActiveEventList.eventTime.get(index));
        plrEventDetailsLocField.setText(this.ActiveEventList.eventLocation.get(index));
        plrEventDetailsDescText.setText(this.ActiveEventList.eventDesc.get(index));
    
    }
    
    public void setSupplyInfoFields(String supplyName){
        int index = this.ActiveSupplyList.getIDFromEventName(supplyName);
        plrSupplyItemFld.setText(this.ActiveSupplyList.supplyName.get(index));
        plrSupplyDescFld.setText(this.ActiveSupplyList.supplyDesc.get(index));
    }
    
    public QuidditchPlayerView(UserList ActiveUserList, PlayerStatsList ActivePlayerStats, TeamList ActiveTeamList, eventList ActiveEventList, supplyList ActiveSupplyList, SupplyRequestList ActiveSupReqList, TeamRegistry ActiveTeamRegistry, EventRegistry ActiveEventRegistry){
        this.ActiveUserList = ActiveUserList;
        this.ActivePlayerStats = ActivePlayerStats;
        this.ActiveTeamList = ActiveTeamList;
        this.ActiveEventList = ActiveEventList;
        this.ActiveSupplyList = ActiveSupplyList;
        this.ActiveSupplyRequestList = ActiveSupReqList;
        this.ActiveTeamRegistry = ActiveTeamRegistry;
        this.ActiveEventRegistry = ActiveEventRegistry;
        this.ActiveUser = null;
        this.ActiveUserID = -1;
        initComponents();
//        puts frame in center of screen:
        this.setLocationRelativeTo(null);
        
    }
    
    /**
     * Creates new form QuidditchMain
     * 
     */
//    public QuidditchPlayerView(){
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plrEventAttendGroup = new javax.swing.ButtonGroup();
        plrSubmitTeamRequest = new javax.swing.JDialog();
        plrSubmitTeamPrompt = new javax.swing.JLabel();
        plrSubmitTeamConfirm = new javax.swing.JButton();
        plrSubmitTeamCancel = new javax.swing.JButton();
        plrSubmitTeamNameField = new javax.swing.JTextField();
        plrViewEditStats = new javax.swing.JDialog();
        statsEditPlayerLbl = new javax.swing.JLabel();
        statsEditPlayerFld = new javax.swing.JTextField();
        statsEditGameLbl = new javax.swing.JLabel();
        statsEditGameDrop = new javax.swing.JComboBox();
        statsEditQuafflePtsLbl = new javax.swing.JLabel();
        statsEditQuafflePtsFld = new javax.swing.JFormattedTextField();
        statsEditSnitchPtsLbl = new javax.swing.JLabel();
        statsEditSnitchPtsFld = new javax.swing.JFormattedTextField();
        statsEditGameFoulsLbl = new javax.swing.JLabel();
        statsEditGameFoulsFld = new javax.swing.JFormattedTextField();
        statsEditConfirm = new javax.swing.JButton();
        statsEditCancel = new javax.swing.JButton();
        plrSupplyRequest = new javax.swing.JDialog();
        plrSupplyRequestPrompt = new javax.swing.JLabel();
        plrSupplyRequestItemsFld = new javax.swing.JTextField();
        plrSupplyConfirmPrompt = new javax.swing.JLabel();
        plrSupplyConfirmYes = new javax.swing.JButton();
        plrSupplyConfirmNo = new javax.swing.JButton();
        plrMainDialog = new javax.swing.JFrame();
        plrInfoLogout = new javax.swing.JButton();
        plrNameLabel = new javax.swing.JLabel();
        plrNameTextField = new javax.swing.JTextField();
        plrTabPane = new javax.swing.JTabbedPane();
        plrTabEvents = new javax.swing.JPanel();
        plrEventScroll = new javax.swing.JScrollPane();
        plrEventScrollList = new javax.swing.JList<String>();
        plrEventDetailsPanel = new javax.swing.JPanel();
        plrEventDetailsName = new javax.swing.JLabel();
        plrEventDetailsNameField = new javax.swing.JTextField();
        plrEventDetailsDate = new javax.swing.JLabel();
        plrEventDetailsDateField = new javax.swing.JTextField();
        plrEventDetailsTime = new javax.swing.JLabel();
        plrEventDetailsTimeField = new javax.swing.JTextField();
        plrEventDetailsLoc = new javax.swing.JLabel();
        plrEventDetailsLocField = new javax.swing.JTextField();
        plrEventDetailsDesc = new javax.swing.JLabel();
        plrEventDetailsDescScroll = new javax.swing.JScrollPane();
        plrEventDetailsDescText = new javax.swing.JTextArea();
        plrEventDetailsAttend = new javax.swing.JLabel();
        plrEventAttendYes = new javax.swing.JRadioButton();
        plrEventAttendNo = new javax.swing.JRadioButton();
        plrEventStatsEdit = new javax.swing.JButton();
        plrTabTeams = new javax.swing.JPanel();
        plrTeamScroll = new javax.swing.JScrollPane();
        plrTeamScrollList = new javax.swing.JList<String>();
        plrTeamDetailsPanel = new javax.swing.JPanel();
        plrTeamDetailsBtrALbl = new javax.swing.JLabel();
        plrTeamDetailsBtrBLbl = new javax.swing.JLabel();
        plrTeamDetailsChsALbl = new javax.swing.JLabel();
        plrTeamDetailsChsBLbl = new javax.swing.JLabel();
        plrTeamDetailsChsCLbl = new javax.swing.JLabel();
        plrTeamDetailsKeepLbl = new javax.swing.JLabel();
        plrTeamDetailsSeekLbl = new javax.swing.JLabel();
        plrTeamDetailsCoachLbl = new javax.swing.JLabel();
        plrTeamDetailsBtrAFld = new javax.swing.JTextField();
        plrTeamDetailsBtrBFld = new javax.swing.JTextField();
        plrTeamDetailsChsAFld = new javax.swing.JTextField();
        plrTeamDetailsChsBFld = new javax.swing.JTextField();
        plrTeamDetailsChsCFld = new javax.swing.JTextField();
        plrTeamDetailsKeepFld = new javax.swing.JTextField();
        plrTeamDetailsSeekFld = new javax.swing.JTextField();
        plrTeamDetailsCoachFld = new javax.swing.JTextField();
        plrTeamRegister = new javax.swing.JButton();
        plrTabSupplies = new javax.swing.JPanel();
        plrSuppliesScroll = new javax.swing.JScrollPane();
        plrSuppliesScrollList = new javax.swing.JList<String>();
        plrSuppliesDetailsPanel = new javax.swing.JPanel();
        plrSupplyItemLbl = new javax.swing.JLabel();
        plrSupplyItemFld = new javax.swing.JTextField();
        plrSupplyDescLbl = new javax.swing.JLabel();
        plrSupplyDescFld = new javax.swing.JTextField();
        plrSupplyQuantityLbl = new javax.swing.JLabel();
        plrSupplyQuantityFld = new javax.swing.JSpinner();
        plrSupplyNotesLbl = new javax.swing.JLabel();
        plrSupplyNotesScroll = new javax.swing.JScrollPane();
        plrSupplyNotesText = new javax.swing.JTextArea();
        plrSupplyRequestButton = new javax.swing.JButton();
        plrInfoPanel = new javax.swing.JPanel();
        plrInfoEventsScroll = new javax.swing.JScrollPane();
        plrInfoEventsList = new javax.swing.JList();
        plrInfoTeamsScroll = new javax.swing.JScrollPane();
        plrInfoTeamsList = new javax.swing.JList();
        plrInfoSuppliesScroll = new javax.swing.JScrollPane();
        plrInfoSuppliesList = new javax.swing.JList();
        plrUpdatePlayerInfo = new javax.swing.JButton();
        plrErrorDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        plrEditContactInfo = new javax.swing.JFrame();
        editLblHead = new javax.swing.JLabel();
        editLblUsername = new javax.swing.JLabel();
        editLblFName = new javax.swing.JLabel();
        editLblLName = new javax.swing.JLabel();
        editLblAdd1 = new javax.swing.JLabel();
        editLblAdd2 = new javax.swing.JLabel();
        editLblState = new javax.swing.JLabel();
        editLblZip = new javax.swing.JLabel();
        editLblEmail = new javax.swing.JLabel();
        editLblPhone = new javax.swing.JLabel();
        editLblGender = new javax.swing.JLabel();
        editContactUsername = new javax.swing.JTextField();
        editContactFirstName = new javax.swing.JTextField();
        editContactLastName = new javax.swing.JTextField();
        editContactAddressLine1 = new javax.swing.JTextField();
        editContactAddressLine2 = new javax.swing.JTextField();
        editContactCity = new javax.swing.JTextField();
        editContactState = new javax.swing.JTextField();
        editContactZip = new javax.swing.JTextField();
        editContactEmail = new javax.swing.JTextField();
        editContactPhoneNumber = new javax.swing.JTextField();
        editContactGender = new javax.swing.JTextField();
        editContactOk = new javax.swing.JButton();
        editContactCancel = new javax.swing.JButton();
        loginUserLabel = new javax.swing.JLabel();
        loginUserField = new javax.swing.JTextField();
        loginOkButton = new javax.swing.JButton();
        loginCancelButton = new javax.swing.JButton();

        plrSubmitTeamRequest.setTitle("Select a team:");
        plrSubmitTeamRequest.setLocation(new java.awt.Point(200, 200));
        plrSubmitTeamRequest.setResizable(false);
        plrSubmitTeamRequest.setSize(new java.awt.Dimension(550, 100));

        plrSubmitTeamPrompt.setText("Please choose a team to submit request:");

        plrSubmitTeamConfirm.setText("Confirm");
        plrSubmitTeamConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrSubmitTeamConfirmActionPerformed(evt);
            }
        });

        plrSubmitTeamCancel.setText("Cancel");
        plrSubmitTeamCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrSubmitTeamCancelActionPerformed(evt);
            }
        });

        plrSubmitTeamNameField.setText("blank.");
        plrSubmitTeamNameField.setEnabled(false);

        javax.swing.GroupLayout plrSubmitTeamRequestLayout = new javax.swing.GroupLayout(plrSubmitTeamRequest.getContentPane());
        plrSubmitTeamRequest.getContentPane().setLayout(plrSubmitTeamRequestLayout);
        plrSubmitTeamRequestLayout.setHorizontalGroup(
            plrSubmitTeamRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrSubmitTeamRequestLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(plrSubmitTeamPrompt)
                .addGap(18, 18, 18)
                .addGroup(plrSubmitTeamRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(plrSubmitTeamRequestLayout.createSequentialGroup()
                        .addComponent(plrSubmitTeamConfirm)
                        .addGap(52, 52, 52)
                        .addComponent(plrSubmitTeamCancel))
                    .addComponent(plrSubmitTeamNameField))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        plrSubmitTeamRequestLayout.setVerticalGroup(
            plrSubmitTeamRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrSubmitTeamRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrSubmitTeamRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrSubmitTeamPrompt)
                    .addComponent(plrSubmitTeamNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(plrSubmitTeamRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrSubmitTeamConfirm)
                    .addComponent(plrSubmitTeamCancel))
                .addGap(19, 19, 19))
        );

        plrViewEditStats.setTitle("Edit/View Player Statistics");
        plrViewEditStats.setLocation(new java.awt.Point(200, 200));
        plrViewEditStats.setResizable(false);
        plrViewEditStats.setSize(new java.awt.Dimension(475, 225));

        statsEditPlayerLbl.setText("Player:");

        statsEditPlayerFld.setEditable(false);
        statsEditPlayerFld.setText("Matt Smith");

        statsEditGameLbl.setText("Game:");

        statsEditGameDrop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Game 1", "Game 2", "Game 3", "Game 4" }));
        statsEditGameDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsEditGameDropActionPerformed(evt);
            }
        });

        statsEditQuafflePtsLbl.setText("Quaffles:");

        statsEditQuafflePtsFld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        statsEditQuafflePtsFld.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        statsEditQuafflePtsFld.setText("0");

        statsEditSnitchPtsLbl.setText("Snitch:");

        statsEditSnitchPtsFld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        statsEditSnitchPtsFld.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        statsEditSnitchPtsFld.setText("0");

        statsEditGameFoulsLbl.setText("Fouls:");

        statsEditGameFoulsFld.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        statsEditGameFoulsFld.setText("0");

        statsEditConfirm.setText("Confirm");
        statsEditConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsEditConfirmActionPerformed(evt);
            }
        });

        statsEditCancel.setText("Cancel");
        statsEditCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsEditCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plrViewEditStatsLayout = new javax.swing.GroupLayout(plrViewEditStats.getContentPane());
        plrViewEditStats.getContentPane().setLayout(plrViewEditStatsLayout);
        plrViewEditStatsLayout.setHorizontalGroup(
            plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrViewEditStatsLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statsEditQuafflePtsLbl)
                    .addComponent(statsEditGameLbl)
                    .addComponent(statsEditPlayerLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrViewEditStatsLayout.createSequentialGroup()
                        .addComponent(statsEditQuafflePtsFld, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(statsEditSnitchPtsLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statsEditSnitchPtsFld, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plrViewEditStatsLayout.createSequentialGroup()
                                .addComponent(statsEditConfirm)
                                .addGap(18, 18, 18)
                                .addComponent(statsEditCancel))
                            .addGroup(plrViewEditStatsLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(statsEditGameFoulsLbl)
                                .addGap(18, 18, 18)
                                .addComponent(statsEditGameFoulsFld, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(statsEditGameDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statsEditPlayerFld, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plrViewEditStatsLayout.setVerticalGroup(
            plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrViewEditStatsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statsEditPlayerLbl)
                    .addComponent(statsEditPlayerFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statsEditGameLbl)
                    .addComponent(statsEditGameDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statsEditQuafflePtsLbl)
                    .addComponent(statsEditQuafflePtsFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statsEditSnitchPtsLbl)
                    .addComponent(statsEditSnitchPtsFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statsEditGameFoulsLbl)
                    .addComponent(statsEditGameFoulsFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plrViewEditStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statsEditConfirm)
                    .addComponent(statsEditCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        plrSupplyRequest.setTitle("Requesting Supplies");
        plrSupplyRequest.setLocation(new java.awt.Point(200, 200));
        plrSupplyRequest.setResizable(false);
        plrSupplyRequest.setSize(new java.awt.Dimension(475, 225));

        plrSupplyRequestPrompt.setText("You have requested the following supplies:");

        plrSupplyRequestItemsFld.setEditable(false);
        plrSupplyRequestItemsFld.setText("Snitch Harness");

        plrSupplyConfirmPrompt.setText("Is this correct?");

        plrSupplyConfirmYes.setText("Yes");
        plrSupplyConfirmYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrSupplyConfirmYesActionPerformed(evt);
            }
        });

        plrSupplyConfirmNo.setText("No");
        plrSupplyConfirmNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrSupplyConfirmNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plrSupplyRequestLayout = new javax.swing.GroupLayout(plrSupplyRequest.getContentPane());
        plrSupplyRequest.getContentPane().setLayout(plrSupplyRequestLayout);
        plrSupplyRequestLayout.setHorizontalGroup(
            plrSupplyRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrSupplyRequestLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(plrSupplyRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrSupplyRequestLayout.createSequentialGroup()
                        .addGroup(plrSupplyRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(plrSupplyRequestItemsFld)
                            .addGroup(plrSupplyRequestLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(plrSupplyConfirmYes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(plrSupplyConfirmNo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(plrSupplyRequestLayout.createSequentialGroup()
                        .addGroup(plrSupplyRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plrSupplyConfirmPrompt)
                            .addComponent(plrSupplyRequestPrompt))
                        .addContainerGap(162, Short.MAX_VALUE))))
        );
        plrSupplyRequestLayout.setVerticalGroup(
            plrSupplyRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrSupplyRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plrSupplyRequestPrompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plrSupplyRequestItemsFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plrSupplyConfirmPrompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(plrSupplyRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrSupplyConfirmYes)
                    .addComponent(plrSupplyConfirmNo))
                .addContainerGap())
        );

        plrMainDialog.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        plrMainDialog.setLocationByPlatform(true);
        plrMainDialog.setPreferredSize(new java.awt.Dimension(850, 750));
        plrMainDialog.setResizable(false);
        plrMainDialog.setSize(new java.awt.Dimension(818, 660));

        plrInfoLogout.setText("Logout");
        plrInfoLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrInfoLogoutActionPerformed(evt);
            }
        });

        plrNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plrNameLabel.setText("Player Name:");
        plrNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        plrNameLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        plrNameTextField.setEditable(false);
        plrNameTextField.setText("Matt Smith");
        plrNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrNameTextFieldActionPerformed(evt);
            }
        });

        plrEventScrollList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Game 1", "Game 2", "Game 3", "Game 4", "Game 5", "Game 6", "Game 7", "Game 8", "Game 9", "Game 10", "Game 11", "Game 12", "Game 13", "Game 14", "Game 15", "Game 16", "Game 17", "Game 18", "Game 19", "Game 20", "Game 21", "Game 22", "Game 23", "Game 24", "Game 25", "Game 26", "Game 27", "Game 28", "Game 29", "Game 30", "Game 31", "Game 32", "Game 33" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        plrEventScrollList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plrEventScrollListMouseClicked(evt);
            }
        });
        plrEventScroll.setViewportView(plrEventScrollList);

        plrEventDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Event Details"));
        plrEventDetailsPanel.setFocusable(false);

        plrEventDetailsName.setText("Event:");

        plrEventDetailsNameField.setEditable(false);
        plrEventDetailsNameField.setText("Game 2: Minneapolis Accio Snowball");

        plrEventDetailsDate.setText("Date:");

        plrEventDetailsDateField.setEditable(false);
        plrEventDetailsDateField.setText("November 27, 2016");

        plrEventDetailsTime.setText("Time:");

        plrEventDetailsTimeField.setEditable(false);
        plrEventDetailsTimeField.setText("7:00 PM");

        plrEventDetailsLoc.setText("Location:");

        plrEventDetailsLocField.setEditable(false);
        plrEventDetailsLocField.setText("UNCG Quidditch Pitch");

        plrEventDetailsDesc.setText("Description:");

        plrEventDetailsDescText.setEditable(false);
        plrEventDetailsDescText.setColumns(20);
        plrEventDetailsDescText.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        plrEventDetailsDescText.setLineWrap(true);
        plrEventDetailsDescText.setRows(5);
        plrEventDetailsDescText.setText("This is our last preseason game against an out-of-state opponent. After this, the regular season starts, and our schedule is set until May. Game starts at 8:00 PM, and we will meet at the UNCG Quidditch Pitch at 7:00 PM for a pregame meeting.");
        plrEventDetailsDescText.setWrapStyleWord(true);
        plrEventDetailsDescScroll.setViewportView(plrEventDetailsDescText);

        plrEventDetailsAttend.setText("Attending:");

        plrEventAttendYes.setText("Yes");
        plrEventAttendYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrEventAttendYesActionPerformed(evt);
            }
        });

        plrEventAttendNo.setText("No");
        plrEventAttendNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrEventAttendNoActionPerformed(evt);
            }
        });

        plrEventStatsEdit.setText("Edit Statistics...");
        plrEventStatsEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrEventStatsEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plrEventDetailsPanelLayout = new javax.swing.GroupLayout(plrEventDetailsPanel);
        plrEventDetailsPanel.setLayout(plrEventDetailsPanelLayout);
        plrEventDetailsPanelLayout.setHorizontalGroup(
            plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                        .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(plrEventDetailsName)
                                    .addComponent(plrEventDetailsDate)
                                    .addComponent(plrEventDetailsTime)
                                    .addComponent(plrEventDetailsLoc))
                                .addGap(13, 13, 13))
                            .addComponent(plrEventDetailsDesc, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(plrEventAttendYes)
                                .addGap(18, 18, 18)
                                .addComponent(plrEventAttendNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(plrEventStatsEdit))
                            .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(plrEventDetailsDescScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(plrEventDetailsDateField)
                                    .addComponent(plrEventDetailsNameField)
                                    .addComponent(plrEventDetailsTimeField)
                                    .addComponent(plrEventDetailsLocField)))))
                    .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                        .addComponent(plrEventDetailsAttend)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        plrEventDetailsPanelLayout.setVerticalGroup(
            plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrEventDetailsName)
                    .addComponent(plrEventDetailsNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrEventDetailsDate)
                    .addComponent(plrEventDetailsDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrEventDetailsTime)
                    .addComponent(plrEventDetailsTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrEventDetailsLoc)
                    .addComponent(plrEventDetailsLocField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrEventDetailsPanelLayout.createSequentialGroup()
                        .addComponent(plrEventDetailsDesc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(plrEventDetailsDescScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrEventDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrEventDetailsAttend)
                    .addComponent(plrEventAttendYes)
                    .addComponent(plrEventAttendNo)
                    .addComponent(plrEventStatsEdit))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout plrTabEventsLayout = new javax.swing.GroupLayout(plrTabEvents);
        plrTabEvents.setLayout(plrTabEventsLayout);
        plrTabEventsLayout.setHorizontalGroup(
            plrTabEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTabEventsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrTabEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrTabEventsLayout.createSequentialGroup()
                        .addComponent(plrEventScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(plrEventDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        plrTabEventsLayout.setVerticalGroup(
            plrTabEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTabEventsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plrEventScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plrEventDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        plrTabPane.addTab("Events", plrTabEvents);

        plrTabTeams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                plrTabTeamsMouseReleased(evt);
            }
        });

        plrTeamScrollList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        plrTeamScrollList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plrTeamScrollListMouseClicked(evt);
            }
        });
        plrTeamScroll.setViewportView(plrTeamScrollList);

        plrTeamDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Team Details"));
        plrTeamDetailsPanel.setFocusable(false);

        plrTeamDetailsBtrALbl.setText("Beater:");

        plrTeamDetailsBtrBLbl.setText("Beater:");

        plrTeamDetailsChsALbl.setText("Chaser:");

        plrTeamDetailsChsBLbl.setText("Chaser:");

        plrTeamDetailsChsCLbl.setText("Chaser:");

        plrTeamDetailsKeepLbl.setText("Keeper:");

        plrTeamDetailsSeekLbl.setText("Seeker:");

        plrTeamDetailsCoachLbl.setText("Coach:");

        plrTeamDetailsBtrAFld.setEditable(false);
        plrTeamDetailsBtrAFld.setText("William Hartnell");

        plrTeamDetailsBtrBFld.setEditable(false);
        plrTeamDetailsBtrBFld.setText("Patrick Troughton");

        plrTeamDetailsChsAFld.setEditable(false);
        plrTeamDetailsChsAFld.setText("Jon Pertwee");

        plrTeamDetailsChsBFld.setEditable(false);
        plrTeamDetailsChsBFld.setText("Tom Baker");

        plrTeamDetailsChsCFld.setEditable(false);
        plrTeamDetailsChsCFld.setText("Peter Davison");

        plrTeamDetailsKeepFld.setEditable(false);
        plrTeamDetailsKeepFld.setText("Colin Baker");

        plrTeamDetailsSeekFld.setEditable(false);
        plrTeamDetailsSeekFld.setText("Sylvester McCoy");

        plrTeamDetailsCoachFld.setEditable(false);
        plrTeamDetailsCoachFld.setText("Paul McGann");

        plrTeamRegister.setText("Register for team...");
        plrTeamRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrTeamRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plrTeamDetailsPanelLayout = new javax.swing.GroupLayout(plrTeamDetailsPanel);
        plrTeamDetailsPanel.setLayout(plrTeamDetailsPanelLayout);
        plrTeamDetailsPanelLayout.setHorizontalGroup(
            plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTeamDetailsPanelLayout.createSequentialGroup()
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrTeamDetailsPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plrTeamDetailsBtrALbl)
                            .addComponent(plrTeamDetailsBtrBLbl)
                            .addComponent(plrTeamDetailsChsALbl)
                            .addComponent(plrTeamDetailsChsBLbl)
                            .addComponent(plrTeamDetailsChsCLbl)
                            .addComponent(plrTeamDetailsKeepLbl)
                            .addComponent(plrTeamDetailsSeekLbl)
                            .addComponent(plrTeamDetailsCoachLbl))
                        .addGap(29, 29, 29)
                        .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plrTeamDetailsBtrAFld)
                            .addComponent(plrTeamDetailsBtrBFld, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                            .addComponent(plrTeamDetailsChsAFld)
                            .addComponent(plrTeamDetailsChsBFld)
                            .addComponent(plrTeamDetailsChsCFld)
                            .addComponent(plrTeamDetailsKeepFld)
                            .addComponent(plrTeamDetailsSeekFld)
                            .addComponent(plrTeamDetailsCoachFld)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plrTeamDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plrTeamRegister)))
                .addContainerGap())
        );
        plrTeamDetailsPanelLayout.setVerticalGroup(
            plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTeamDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsBtrALbl)
                    .addComponent(plrTeamDetailsBtrAFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsBtrBFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plrTeamDetailsBtrBLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsChsAFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plrTeamDetailsChsALbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsChsBFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plrTeamDetailsChsBLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsChsCLbl)
                    .addComponent(plrTeamDetailsChsCFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsKeepLbl)
                    .addComponent(plrTeamDetailsKeepFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsSeekLbl)
                    .addComponent(plrTeamDetailsSeekFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrTeamDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrTeamDetailsCoachLbl)
                    .addComponent(plrTeamDetailsCoachFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(plrTeamRegister)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout plrTabTeamsLayout = new javax.swing.GroupLayout(plrTabTeams);
        plrTabTeams.setLayout(plrTabTeamsLayout);
        plrTabTeamsLayout.setHorizontalGroup(
            plrTabTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTabTeamsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrTabTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plrTeamScroll)
                    .addComponent(plrTeamDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        plrTabTeamsLayout.setVerticalGroup(
            plrTabTeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTabTeamsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plrTeamScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plrTeamDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        plrTabPane.addTab("Teams", plrTabTeams);

        plrSuppliesScrollList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Bludger", "Broom - SM", "Broom - MD", "Broom - LG", "Headband (Snitch)", "Headband (Beater)", "Headband (Keeper)", "Headband (Seeker)", "Headband (Chaser)", "Hoop", "Quaffle", "Snitch", "Snitch Harness" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        plrSuppliesScrollList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plrSuppliesScrollListMouseClicked(evt);
            }
        });
        plrSuppliesScroll.setViewportView(plrSuppliesScrollList);

        plrSuppliesDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplies/Equipment"));
        plrSuppliesDetailsPanel.setFocusable(false);

        plrSupplyItemLbl.setText("Item:");

        plrSupplyItemFld.setEditable(false);
        plrSupplyItemFld.setText("Snitch Harness");

        plrSupplyDescLbl.setText("Desc:");

        plrSupplyDescFld.setEditable(false);
        plrSupplyDescFld.setText("Harness for player as the snitch. Official equipment for tournament play.");

        plrSupplyQuantityLbl.setText("Quantity:");

        plrSupplyQuantityFld.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        plrSupplyNotesLbl.setText("Notes");

        plrSupplyNotesText.setColumns(20);
        plrSupplyNotesText.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        plrSupplyNotesText.setLineWrap(true);
        plrSupplyNotesText.setRows(5);
        plrSupplyNotesText.setText("I think our snitch is broken. Part of the fabric is missing, and it may change game play. We need a new one before Game 2, as we're hosting the event.");
        plrSupplyNotesText.setWrapStyleWord(true);
        plrSupplyNotesScroll.setViewportView(plrSupplyNotesText);

        plrSupplyRequestButton.setText("Request Supplies...");
        plrSupplyRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrSupplyRequestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plrSuppliesDetailsPanelLayout = new javax.swing.GroupLayout(plrSuppliesDetailsPanel);
        plrSuppliesDetailsPanel.setLayout(plrSuppliesDetailsPanelLayout);
        plrSuppliesDetailsPanelLayout.setHorizontalGroup(
            plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrSuppliesDetailsPanelLayout.createSequentialGroup()
                .addGroup(plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrSuppliesDetailsPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plrSupplyItemLbl)
                            .addComponent(plrSupplyDescLbl)
                            .addComponent(plrSupplyQuantityLbl)
                            .addComponent(plrSupplyNotesLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(plrSupplyDescFld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(plrSupplyItemFld, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(plrSupplyNotesScroll)
                            .addComponent(plrSupplyQuantityFld, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plrSuppliesDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plrSupplyRequestButton)))
                .addContainerGap())
        );
        plrSuppliesDetailsPanelLayout.setVerticalGroup(
            plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrSuppliesDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrSupplyItemLbl)
                    .addComponent(plrSupplyItemFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrSupplyDescFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plrSupplyDescLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plrSupplyQuantityLbl)
                    .addComponent(plrSupplyQuantityFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrSuppliesDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plrSupplyNotesLbl)
                    .addComponent(plrSupplyNotesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plrSupplyRequestButton)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout plrTabSuppliesLayout = new javax.swing.GroupLayout(plrTabSupplies);
        plrTabSupplies.setLayout(plrTabSuppliesLayout);
        plrTabSuppliesLayout.setHorizontalGroup(
            plrTabSuppliesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTabSuppliesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrTabSuppliesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrTabSuppliesLayout.createSequentialGroup()
                        .addComponent(plrSuppliesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(plrSuppliesDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        plrTabSuppliesLayout.setVerticalGroup(
            plrTabSuppliesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrTabSuppliesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plrSuppliesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plrSuppliesDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        plrTabPane.addTab("Supplies", plrTabSupplies);

        plrInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Information"));

        plrInfoEventsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Event Registrations"));
        plrInfoEventsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        plrInfoEventsScroll.setViewportView(plrInfoEventsList);

        plrInfoTeamsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Team Registrations"));
        plrInfoTeamsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        plrInfoTeamsScroll.setViewportView(plrInfoTeamsList);

        plrInfoSuppliesList.setBorder(javax.swing.BorderFactory.createTitledBorder("Supply Requests"));
        plrInfoSuppliesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        plrInfoSuppliesScroll.setViewportView(plrInfoSuppliesList);

        javax.swing.GroupLayout plrInfoPanelLayout = new javax.swing.GroupLayout(plrInfoPanel);
        plrInfoPanel.setLayout(plrInfoPanelLayout);
        plrInfoPanelLayout.setHorizontalGroup(
            plrInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plrInfoEventsScroll)
                    .addComponent(plrInfoTeamsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(plrInfoSuppliesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap())
        );
        plrInfoPanelLayout.setVerticalGroup(
            plrInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrInfoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(plrInfoEventsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(plrInfoTeamsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(plrInfoSuppliesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        plrUpdatePlayerInfo.setText("Edit Contact Info...");
        plrUpdatePlayerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrUpdatePlayerInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plrMainDialogLayout = new javax.swing.GroupLayout(plrMainDialog.getContentPane());
        plrMainDialog.getContentPane().setLayout(plrMainDialogLayout);
        plrMainDialogLayout.setHorizontalGroup(
            plrMainDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrMainDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrMainDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plrMainDialogLayout.createSequentialGroup()
                        .addComponent(plrNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plrNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(plrMainDialogLayout.createSequentialGroup()
                        .addGroup(plrMainDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plrMainDialogLayout.createSequentialGroup()
                                .addComponent(plrUpdatePlayerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(plrInfoLogout))
                            .addComponent(plrInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plrTabPane)
                .addContainerGap())
        );
        plrMainDialogLayout.setVerticalGroup(
            plrMainDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plrMainDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plrMainDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plrTabPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(plrMainDialogLayout.createSequentialGroup()
                        .addGroup(plrMainDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(plrNameTextField)
                            .addComponent(plrNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(plrMainDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plrUpdatePlayerInfo)
                            .addComponent(plrInfoLogout))
                        .addGap(18, 18, 18)
                        .addComponent(plrInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout plrErrorDialogLayout = new javax.swing.GroupLayout(plrErrorDialog.getContentPane());
        plrErrorDialog.getContentPane().setLayout(plrErrorDialogLayout);
        plrErrorDialogLayout.setHorizontalGroup(
            plrErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrErrorDialogLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        plrErrorDialogLayout.setVerticalGroup(
            plrErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrErrorDialogLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        plrEditContactInfo.setResizable(false);
        plrEditContactInfo.setSize(new java.awt.Dimension(350, 450));

        editLblHead.setText("Edit Player Contact Info:");

        editLblUsername.setText("Username:");

        editLblFName.setText("First Name:");

        editLblLName.setText("Last Name:");

        editLblAdd1.setText("Address:");

        editLblAdd2.setText("City:");

        editLblState.setText("State:");

        editLblZip.setText("Zip:");

        editLblEmail.setText("Email:");

        editLblPhone.setText("Phone:");

        editLblGender.setText("Gender:");

        editContactUsername.setEditable(false);
        editContactUsername.setText("jTextField1");

        editContactFirstName.setText("jTextField2");

        editContactLastName.setText("jTextField3");

        editContactAddressLine1.setText("jTextField4");

        editContactAddressLine2.setText("jTextField5");

        editContactCity.setText("jTextField6");

        editContactState.setText("jTextField7");

        editContactZip.setText("jTextField8");

        editContactEmail.setText("jTextField9");

        editContactPhoneNumber.setText("jTextField10");

        editContactGender.setText("jTextField1");

        editContactOk.setText("Ok");
        editContactOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContactOkActionPerformed(evt);
            }
        });

        editContactCancel.setText("Cancel");
        editContactCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContactCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plrEditContactInfoLayout = new javax.swing.GroupLayout(plrEditContactInfo.getContentPane());
        plrEditContactInfo.getContentPane().setLayout(plrEditContactInfoLayout);
        plrEditContactInfoLayout.setHorizontalGroup(
            plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plrEditContactInfoLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(editContactOk, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editContactCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(plrEditContactInfoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editLblHead)
                    .addGroup(plrEditContactInfoLayout.createSequentialGroup()
                        .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editLblFName)
                            .addComponent(editLblUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editContactUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(editContactFirstName)))
                    .addGroup(plrEditContactInfoLayout.createSequentialGroup()
                        .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editLblLName)
                            .addComponent(editLblAdd1)
                            .addComponent(editLblAdd2)
                            .addComponent(editLblState)
                            .addComponent(editLblZip)
                            .addComponent(editLblEmail)
                            .addComponent(editLblPhone)
                            .addComponent(editLblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editContactGender)
                            .addComponent(editContactLastName)
                            .addComponent(editContactAddressLine1)
                            .addComponent(editContactAddressLine2)
                            .addComponent(editContactCity)
                            .addComponent(editContactState)
                            .addComponent(editContactZip)
                            .addComponent(editContactEmail)
                            .addComponent(editContactPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plrEditContactInfoLayout.setVerticalGroup(
            plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrEditContactInfoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(editLblHead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblUsername)
                    .addComponent(editContactUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblFName)
                    .addComponent(editContactFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblLName)
                    .addComponent(editContactLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblAdd1)
                    .addComponent(editContactAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editContactAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblAdd2)
                    .addComponent(editContactCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblState)
                    .addComponent(editContactState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblZip)
                    .addComponent(editContactZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblEmail)
                    .addComponent(editContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblPhone)
                    .addComponent(editContactPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLblGender)
                    .addComponent(editContactGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(plrEditContactInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editContactOk)
                    .addComponent(editContactCancel))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("loginScreen"); // NOI18N
        setResizable(false);

        loginUserLabel.setText("user name:");

        loginUserField.setText("enter your username...");
        loginUserField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginUserFieldMouseClicked(evt);
            }
        });

        loginOkButton.setText("ok");
        loginOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginOkButtonActionPerformed(evt);
            }
        });

        loginCancelButton.setText("cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginUserLabel)
                    .addComponent(loginUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginOkButton)
                    .addComponent(loginCancelButton))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginOkButtonActionPerformed
//        This code checks to see if the username entered is valid or not.
        
        String inputUserName = loginUserField.getText().toLowerCase();
        if (this.ActiveUserList.getIDFromUsername(inputUserName) > -1) {
            this.ActiveUserID = this.ActiveUserList.getIDFromUsername(inputUserName);
            this.ActiveUser = this.ActiveUserList.getUserFromID(ActiveUserID);
            plrMainDialog.setVisible(true);
            plrMainDialog.setLocationRelativeTo(null);
            plrNameTextField.setText(this.ActiveUser.getUserFullName());
            this.dispose();
            plrMainDialog.pack();
        }
        else{
//            display error dialog...
            JOptionPane.showMessageDialog(this, "Please enter a valid username.");
        }

        this.resetTeamTab();
        this.resetEventTab();
        this.resetSupplyTab();
        this.setPlayerSupplyList();
        this.setPlayerTeamsList();
        this.setPlayerEventList();
        this.groupButton();
        
    }//GEN-LAST:event_loginOkButtonActionPerformed

    private void loginUserFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserFieldMouseClicked
        loginUserField.setText("");
    }//GEN-LAST:event_loginUserFieldMouseClicked

    private void plrSubmitTeamConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrSubmitTeamConfirmActionPerformed
        //add user to currently selected team via teamRegistry.
        String teamName = plrTeamScrollList.getSelectedValue();
        int teamID = ActiveTeamList.getIDFromTeamname(teamName);
        ActiveTeamRegistry.addToTeamRegistry(ActiveUserID, teamID);
        try {
            ActiveTeamRegistry.writeListToCSV();
        } catch (IOException ex) {
            Logger.getLogger(QuidditchPlayerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setPlayerTeamsList();
        plrSubmitTeamRequest.setVisible(false);
    }//GEN-LAST:event_plrSubmitTeamConfirmActionPerformed

    private void plrInfoLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrInfoLogoutActionPerformed
        // This is the button that will probably become a logout action
        plrMainDialog.dispose();
        this.setVisible(true);
        
        
    }//GEN-LAST:event_plrInfoLogoutActionPerformed

    private void plrNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrNameTextFieldActionPerformed
        // Since this is a text field, it may be editable. Otherwise, might be just locked from edits outside of account creation.
    }//GEN-LAST:event_plrNameTextFieldActionPerformed

    private void plrTeamRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrTeamRegisterActionPerformed
        if (plrTeamScrollList.getSelectedIndex() == -1) {
           JOptionPane.showMessageDialog(this, "Please select a team from the list provided.");
             
        }
        else{
            plrSubmitTeamNameField.setText(plrTeamScrollList.getSelectedValue());
            plrSubmitTeamRequest.setVisible(true);
        }
        
    }//GEN-LAST:event_plrTeamRegisterActionPerformed

    private void plrSupplyRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrSupplyRequestButtonActionPerformed
        if (plrSuppliesScrollList.getSelectedIndex() == -1) {
           JOptionPane.showMessageDialog(this, "Please select an item from the supplies list.");
             
        }
        else if ((int)plrSupplyQuantityFld.getValue() == 0){
           JOptionPane.showMessageDialog(this, "Please enter a quantity greater than 1.");
        }
        else if (plrSupplyNotesText.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Please enter a justification for this purchase.");
        }
        else{
            plrSupplyRequestItemsFld.setText(plrSuppliesScrollList.getSelectedValue());
            plrSupplyRequest.setVisible(true);
        }
        
        
    }//GEN-LAST:event_plrSupplyRequestButtonActionPerformed

    private void plrUpdatePlayerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrUpdatePlayerInfoActionPerformed
        plrEditContactInfo.setVisible(true);
        plrEditContactInfo.setLocationRelativeTo(null);
        editContactUsername.setText(ActiveUser.getUserName());
        editContactFirstName.setText(ActiveUser.getUserFirstName());
        editContactLastName.setText(ActiveUser.getUserLastName());
        editContactAddressLine1.setText(ActiveUser.getUserAddressLine1());
        editContactAddressLine2.setText(ActiveUser.getUserAddressLine2());
        editContactCity.setText(ActiveUser.getUserCity());
        editContactState.setText(ActiveUser.getUserState());
        editContactZip.setText(ActiveUser.getUserZip());
        editContactEmail.setText(ActiveUser.getUserEmail());
        editContactPhoneNumber.setText(ActiveUser.getUserPhoneNumber());
        editContactGender.setText(ActiveUser.getUserGender());
    }//GEN-LAST:event_plrUpdatePlayerInfoActionPerformed

    private void plrEventStatsEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrEventStatsEditActionPerformed
        plrViewEditStats.setVisible(true);
        plrViewEditStats.setLocationRelativeTo(null);
        statsEditPlayerFld.setText(ActiveUser.getUserFullName());
        statsEditGameDrop.setModel(new DefaultComboBoxModel(ActivePlayerStats.getPlayerEvents(ActiveUserID).toArray()));
        Object selectedEvent = statsEditGameDrop.getSelectedItem();
        
        if(selectedEvent != null){
            int selectedEventInt = Integer.parseInt(selectedEvent.toString());
            int[] playerEventStats = ActivePlayerStats.getPlayerEventStats(ActiveUserID,selectedEventInt);
            statsEditQuafflePtsFld.setText(String.valueOf(playerEventStats[2]));
            statsEditSnitchPtsFld.setText(String.valueOf(playerEventStats[3]));
            statsEditGameFoulsFld.setText(String.valueOf(playerEventStats[4]));
        }
        
    }//GEN-LAST:event_plrEventStatsEditActionPerformed

    private void editContactCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContactCancelActionPerformed
         plrEditContactInfo.setVisible(false);
    }//GEN-LAST:event_editContactCancelActionPerformed

    private void editContactOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContactOkActionPerformed
        
        ActiveUser.setUserName(editContactUsername.getText());
        ActiveUser.setUserFirstName(editContactFirstName.getText());
        ActiveUser.setUserLastName(editContactLastName.getText());
        ActiveUser.setUserAddressLine1(editContactAddressLine1.getText());
        ActiveUser.setUserAddressLine2(editContactAddressLine2.getText());
        ActiveUser.setUserCity(editContactCity.getText());
        ActiveUser.setUserState(editContactState.getText());
        ActiveUser.setUserZip(editContactZip.getText());
        ActiveUser.setUserEmail(editContactEmail.getText());
        ActiveUser.setUserPhoneNumber(editContactPhoneNumber.getText());
        ActiveUser.setUserGender(editContactGender.getText());
        try {
            ActiveUserList.writeListToCSV();
        } catch (IOException ex) {
            Logger.getLogger(QuidditchPlayerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        plrEditContactInfo.setVisible(false);
    }//GEN-LAST:event_editContactOkActionPerformed

    private void statsEditGameDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsEditGameDropActionPerformed
        Object selectedEvent = statsEditGameDrop.getSelectedItem();
        
        if(selectedEvent != null){
            int selectedEventInt = Integer.parseInt(selectedEvent.toString());
            int[] playerEventStats = ActivePlayerStats.getPlayerEventStats(ActiveUserID,selectedEventInt);
            statsEditQuafflePtsFld.setText(String.valueOf(playerEventStats[2]));
            statsEditSnitchPtsFld.setText(String.valueOf(playerEventStats[3]));
            statsEditGameFoulsFld.setText(String.valueOf(playerEventStats[4]));
        }
    }//GEN-LAST:event_statsEditGameDropActionPerformed

    private void statsEditCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsEditCancelActionPerformed
        plrViewEditStats.dispose();
    }//GEN-LAST:event_statsEditCancelActionPerformed

    private void statsEditConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsEditConfirmActionPerformed
        Object selectedEvent = statsEditGameDrop.getSelectedItem();
        
        if(selectedEvent != null){
            int playerID = ActiveUserID;
            int eventID = Integer.parseInt(selectedEvent.toString());
            int ptsQuaffle = Integer.parseInt(statsEditQuafflePtsFld.getText());
            int ptsSnitch = Integer.parseInt(statsEditSnitchPtsFld.getText());
            int gameFouls = Integer.parseInt(statsEditGameFoulsFld.getText());
            ActivePlayerStats.setPlayerEventStats(playerID, eventID, ptsQuaffle, ptsSnitch, gameFouls);
            try {
                ActivePlayerStats.writePlayerStatsListToCSV();
            } catch (IOException ex) {
                Logger.getLogger(QuidditchPlayerView.class.getName()).log(Level.SEVERE, null, ex);
            }
            plrViewEditStats.dispose();
        }
        
        
    }//GEN-LAST:event_statsEditConfirmActionPerformed

    private void plrTabTeamsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plrTabTeamsMouseReleased
        
    }//GEN-LAST:event_plrTabTeamsMouseReleased

    private void plrTeamScrollListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plrTeamScrollListMouseClicked
        String teamName = plrTeamScrollList.getSelectedValue();
        this.setTeamPositionFields(teamName);
		
		
        
    }//GEN-LAST:event_plrTeamScrollListMouseClicked

    private void plrEventScrollListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plrEventScrollListMouseClicked
        String eventName = plrEventScrollList.getSelectedValue();
        int eventID = ActiveEventList.getIDFromEventName(eventName);
        this.setEventInfoFields(eventName);
        if (ActiveEventRegistry.getRegistryIndex(ActiveUserID, eventID) == -1) {
            plrEventAttendNo.setSelected(true);
        }
        else{plrEventAttendYes.setSelected(true);}
    }//GEN-LAST:event_plrEventScrollListMouseClicked

    private void plrSuppliesScrollListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plrSuppliesScrollListMouseClicked
        String supplyName = plrSuppliesScrollList.getSelectedValue();
        this.setSupplyInfoFields(supplyName);
        plrSupplyQuantityFld.setValue(0);
        plrSupplyNotesText.setText("");
    }//GEN-LAST:event_plrSuppliesScrollListMouseClicked

    private void plrSupplyConfirmYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrSupplyConfirmYesActionPerformed
        String supplyReqName = plrSuppliesScrollList.getSelectedValue();
        int supplyReqQty = (int) plrSupplyQuantityFld.getValue();
        String supplyReqNotes = plrSupplyNotesText.getText();
        int supplyIDForReq = ActiveSupplyList.supplyName.indexOf(supplyReqName);
        this.ActiveSupplyRequestList.addNewRequest(ActiveUserID, supplyIDForReq, supplyReqQty, supplyReqNotes);
        try {
            this.ActiveSupplyRequestList.writeListToCSV();
        } catch (IOException ex) {
            Logger.getLogger(QuidditchPlayerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        plrSupplyRequest.setVisible(false);
        this.setPlayerSupplyList();
    }//GEN-LAST:event_plrSupplyConfirmYesActionPerformed

    private void plrSupplyConfirmNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrSupplyConfirmNoActionPerformed
        plrSupplyRequest.setVisible(false);
    }//GEN-LAST:event_plrSupplyConfirmNoActionPerformed

    private void plrSubmitTeamCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrSubmitTeamCancelActionPerformed
        plrSubmitTeamRequest.setVisible(false);
    }//GEN-LAST:event_plrSubmitTeamCancelActionPerformed

    private void plrEventAttendNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrEventAttendNoActionPerformed
        if (plrEventScrollList.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an event from the list above.");
        }
        else{
            String eventName = plrEventScrollList.getSelectedValue();
            int eventID = ActiveEventList.getIDFromEventName(eventName);
            ActiveEventRegistry.removeFromEventRegistry(ActiveUserID, eventID);
            this.setPlayerEventList();
            try {
                ActiveEventRegistry.writeListToCSV();
            } catch (IOException ex) {
                Logger.getLogger(QuidditchPlayerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_plrEventAttendNoActionPerformed

    private void plrEventAttendYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrEventAttendYesActionPerformed
        if (plrEventScrollList.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an event from the list above.");
        }
        else{
            String eventName = plrEventScrollList.getSelectedValue();
            int eventID = ActiveEventList.getIDFromEventName(eventName);
            ActiveEventRegistry.addToEventRegistry(ActiveUserID, eventID);
            this.setPlayerEventList();
            try {
                ActiveEventRegistry.writeListToCSV();
            } catch (IOException ex) {
                Logger.getLogger(QuidditchPlayerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_plrEventAttendYesActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        UserList initUserList = new UserList();
        PlayerStatsList initPlayerStats = new PlayerStatsList();
        TeamList initTeamList = new TeamList();
        eventList initEventList = new eventList();
        supplyList initSupplyList = new supplyList();
        SupplyRequestList initSupReqList = new SupplyRequestList();
        TeamRegistry initTeamRegistry = new TeamRegistry();
        EventRegistry initEventRegistry = new EventRegistry();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            QuidditchPlayerView QPV = new QuidditchPlayerView(initUserList, initPlayerStats, initTeamList, initEventList, initSupplyList, initSupReqList, initTeamRegistry, initEventRegistry);
            
            QPV.setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField editContactAddressLine1;
    private javax.swing.JTextField editContactAddressLine2;
    private javax.swing.JButton editContactCancel;
    private javax.swing.JTextField editContactCity;
    private javax.swing.JTextField editContactEmail;
    private javax.swing.JTextField editContactFirstName;
    private javax.swing.JTextField editContactGender;
    private javax.swing.JTextField editContactLastName;
    private javax.swing.JButton editContactOk;
    private javax.swing.JTextField editContactPhoneNumber;
    private javax.swing.JTextField editContactState;
    private javax.swing.JTextField editContactUsername;
    private javax.swing.JTextField editContactZip;
    private javax.swing.JLabel editLblAdd1;
    private javax.swing.JLabel editLblAdd2;
    private javax.swing.JLabel editLblEmail;
    private javax.swing.JLabel editLblFName;
    private javax.swing.JLabel editLblGender;
    private javax.swing.JLabel editLblHead;
    private javax.swing.JLabel editLblLName;
    private javax.swing.JLabel editLblPhone;
    private javax.swing.JLabel editLblState;
    private javax.swing.JLabel editLblUsername;
    private javax.swing.JLabel editLblZip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginCancelButton;
    private javax.swing.JButton loginOkButton;
    private javax.swing.JTextField loginUserField;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JFrame plrEditContactInfo;
    private javax.swing.JDialog plrErrorDialog;
    private javax.swing.ButtonGroup plrEventAttendGroup;
    private javax.swing.JRadioButton plrEventAttendNo;
    private javax.swing.JRadioButton plrEventAttendYes;
    private javax.swing.JLabel plrEventDetailsAttend;
    private javax.swing.JLabel plrEventDetailsDate;
    private javax.swing.JTextField plrEventDetailsDateField;
    private javax.swing.JLabel plrEventDetailsDesc;
    private javax.swing.JScrollPane plrEventDetailsDescScroll;
    private javax.swing.JTextArea plrEventDetailsDescText;
    private javax.swing.JLabel plrEventDetailsLoc;
    private javax.swing.JTextField plrEventDetailsLocField;
    private javax.swing.JLabel plrEventDetailsName;
    private javax.swing.JTextField plrEventDetailsNameField;
    private javax.swing.JPanel plrEventDetailsPanel;
    private javax.swing.JLabel plrEventDetailsTime;
    private javax.swing.JTextField plrEventDetailsTimeField;
    private javax.swing.JScrollPane plrEventScroll;
    private javax.swing.JList<String> plrEventScrollList;
    private javax.swing.JButton plrEventStatsEdit;
    private javax.swing.JList plrInfoEventsList;
    private javax.swing.JScrollPane plrInfoEventsScroll;
    private javax.swing.JButton plrInfoLogout;
    private javax.swing.JPanel plrInfoPanel;
    private javax.swing.JList plrInfoSuppliesList;
    private javax.swing.JScrollPane plrInfoSuppliesScroll;
    private javax.swing.JList plrInfoTeamsList;
    private javax.swing.JScrollPane plrInfoTeamsScroll;
    private javax.swing.JFrame plrMainDialog;
    private javax.swing.JLabel plrNameLabel;
    private javax.swing.JTextField plrNameTextField;
    private javax.swing.JButton plrSubmitTeamCancel;
    private javax.swing.JButton plrSubmitTeamConfirm;
    private javax.swing.JTextField plrSubmitTeamNameField;
    private javax.swing.JLabel plrSubmitTeamPrompt;
    private javax.swing.JDialog plrSubmitTeamRequest;
    private javax.swing.JPanel plrSuppliesDetailsPanel;
    private javax.swing.JScrollPane plrSuppliesScroll;
    private javax.swing.JList<String> plrSuppliesScrollList;
    private javax.swing.JButton plrSupplyConfirmNo;
    private javax.swing.JLabel plrSupplyConfirmPrompt;
    private javax.swing.JButton plrSupplyConfirmYes;
    private javax.swing.JTextField plrSupplyDescFld;
    private javax.swing.JLabel plrSupplyDescLbl;
    private javax.swing.JTextField plrSupplyItemFld;
    private javax.swing.JLabel plrSupplyItemLbl;
    private javax.swing.JLabel plrSupplyNotesLbl;
    private javax.swing.JScrollPane plrSupplyNotesScroll;
    private javax.swing.JTextArea plrSupplyNotesText;
    private javax.swing.JSpinner plrSupplyQuantityFld;
    private javax.swing.JLabel plrSupplyQuantityLbl;
    private javax.swing.JDialog plrSupplyRequest;
    private javax.swing.JButton plrSupplyRequestButton;
    private javax.swing.JTextField plrSupplyRequestItemsFld;
    private javax.swing.JLabel plrSupplyRequestPrompt;
    private javax.swing.JPanel plrTabEvents;
    private javax.swing.JTabbedPane plrTabPane;
    private javax.swing.JPanel plrTabSupplies;
    private javax.swing.JPanel plrTabTeams;
    private javax.swing.JTextField plrTeamDetailsBtrAFld;
    private javax.swing.JLabel plrTeamDetailsBtrALbl;
    private javax.swing.JTextField plrTeamDetailsBtrBFld;
    private javax.swing.JLabel plrTeamDetailsBtrBLbl;
    private javax.swing.JTextField plrTeamDetailsChsAFld;
    private javax.swing.JLabel plrTeamDetailsChsALbl;
    private javax.swing.JTextField plrTeamDetailsChsBFld;
    private javax.swing.JLabel plrTeamDetailsChsBLbl;
    private javax.swing.JTextField plrTeamDetailsChsCFld;
    private javax.swing.JLabel plrTeamDetailsChsCLbl;
    private javax.swing.JTextField plrTeamDetailsCoachFld;
    private javax.swing.JLabel plrTeamDetailsCoachLbl;
    private javax.swing.JTextField plrTeamDetailsKeepFld;
    private javax.swing.JLabel plrTeamDetailsKeepLbl;
    private javax.swing.JPanel plrTeamDetailsPanel;
    private javax.swing.JTextField plrTeamDetailsSeekFld;
    private javax.swing.JLabel plrTeamDetailsSeekLbl;
    private javax.swing.JButton plrTeamRegister;
    private javax.swing.JScrollPane plrTeamScroll;
    private javax.swing.JList<String> plrTeamScrollList;
    private javax.swing.JButton plrUpdatePlayerInfo;
    private javax.swing.JDialog plrViewEditStats;
    private javax.swing.JButton statsEditCancel;
    private javax.swing.JButton statsEditConfirm;
    private javax.swing.JComboBox statsEditGameDrop;
    private javax.swing.JFormattedTextField statsEditGameFoulsFld;
    private javax.swing.JLabel statsEditGameFoulsLbl;
    private javax.swing.JLabel statsEditGameLbl;
    private javax.swing.JTextField statsEditPlayerFld;
    private javax.swing.JLabel statsEditPlayerLbl;
    private javax.swing.JFormattedTextField statsEditQuafflePtsFld;
    private javax.swing.JLabel statsEditQuafflePtsLbl;
    private javax.swing.JFormattedTextField statsEditSnitchPtsFld;
    private javax.swing.JLabel statsEditSnitchPtsLbl;
    // End of variables declaration//GEN-END:variables
}
