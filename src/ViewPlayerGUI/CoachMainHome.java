package ViewPlayerGUI;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author moyockmike
 */
public class CoachMainHome extends javax.swing.JFrame {
    private UserList ActiveUserList;
    private TeamList ActiveTeamList;
    private TeamRegistry ActiveTeamRegistry;
    /**
     * Creates new form CoachMainHome
     */
    public CoachMainHome() {
        initComponents();
    }
    
    private void UpdateJList(){
        int teamID = 1;
        ArrayList<String> aList = new ArrayList<String>();
        ActiveTeamList.getTeamFromID(teamID).getTeamName();//System.out.println(newTeamList.getTeamFromID(teamID).getTeamName());
        for (int i = 0; i < ActiveTeamRegistry.getUsersFromTeamID(teamID).length; i++) {
            
           aList.add(ActiveUserList.getUserFromID(ActiveTeamRegistry.getUsersFromTeamID(teamID)[i]).getUserFullName()) ; 
            //System.out.println(ActiveUserList.getUserFromID(ActiveTeamRegistry.getUsersFromTeamID(teamID)[i]).getUserFullName());
        }
        DefaultListModel<String> model = new DefaultListModel<String>();
        //Iterable<String> aList = null;
        for(String s: aList){
            model.addElement(s);
        }
        JList<String> coachPendingRosterjList1 = new JList<String>(model);
                
        statsEditGameDrop.setModel(new DefaultComboBoxModel(ActivePlayerStats.getPlayerEvents(ActiveUserID).toArray()));

    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        coachScheduleEventDateBox = new javax.swing.JComboBox();
        coachScheduleEventTime = new javax.swing.JLabel();
        coachScheduleEventTimeBox = new javax.swing.JComboBox();
        coachScheduleDetailsPanel = new javax.swing.JPanel();
        coachScheduleWhere = new javax.swing.JLabel();
        coachScheduleDetailsWhereField = new javax.swing.JTextField();
        coachScheduleDetailsDescript = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CoachScheduleDetailsDescriptjTextArea1 = new javax.swing.JTextArea();
        coachScheduleBack = new javax.swing.JButton();
        coachScheduleSave = new javax.swing.JButton();
        coachRosterTabPane = new javax.swing.JTabbedPane();
        coachRosterPanel = new javax.swing.JPanel();
        coachRosterAdd = new javax.swing.JButton();
        coachRosterRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        coachPendingRosterjList1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        coachRosterjList1 = new javax.swing.JList();
        coachStartLineupPanel = new javax.swing.JPanel();
        coachStatLineupSeeker = new javax.swing.JLabel();
        coachStartLineupSeekerBox = new javax.swing.JComboBox();
        coachStartLineupKeeper = new javax.swing.JLabel();
        coachStartLineupKeeperBox = new javax.swing.JComboBox();
        coachStartLineupBeaters = new javax.swing.JLabel();
        coachStartLineupBeaterBox1 = new javax.swing.JComboBox();
        coachStartLineupBeaterBox2 = new javax.swing.JComboBox();
        coachStartLineupChasers = new javax.swing.JLabel();
        coachStartLineupChaserBox1 = new javax.swing.JComboBox();
        coachStartLineupChaserBox2 = new javax.swing.JComboBox();
        coachStartLineupChaserBox3 = new javax.swing.JComboBox();
        coachStartLineupSave = new javax.swing.JButton();
        coachLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(542, 520));

        coachLeftTabPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        coachLeftTabPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        coachEventsjList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Event 1", "Event 2", "Event 3", "Event 4", "Event 5", "Event 6", "Event 7", "Event 8", "Event 9", "Event 10", "Event 11", "Event 12" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        coachEventsScroll.setViewportView(coachEventsjList1);

        coachEventTabPane.addTab("Events", coachEventsScroll);

        coachScheduleTitleField.setText("Untitled Event");

        coachScheduleEventType.setText("Event Type:");

        coachScheduleEventTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Practice", "Meeting" }));

        coachScheduleEventDate.setText("Event Date:");

        coachScheduleEventDateBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "October 25, 2016", "October 26, 2016", "October 27, 2016", "October 28, 2016" }));

        coachScheduleEventTime.setText("Event Time:");

        coachScheduleEventTimeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM" }));
        coachScheduleEventTimeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachScheduleEventTimeBoxActionPerformed(evt);
            }
        });

        coachScheduleDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));

        coachScheduleWhere.setText("Where");

        coachScheduleDetailsWhereField.setText("Practice Field");

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
                    .addComponent(coachScheduleDetailsWhereField, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        coachScheduleDetailsPanelLayout.setVerticalGroup(
            coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachScheduleDetailsPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(coachScheduleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachScheduleWhere)
                    .addComponent(coachScheduleDetailsWhereField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout coachSchedulePanel2Layout = new javax.swing.GroupLayout(coachSchedulePanel2);
        coachSchedulePanel2.setLayout(coachSchedulePanel2Layout);
        coachSchedulePanel2Layout.setHorizontalGroup(
            coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coachScheduleDetailsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                        .addComponent(coachScheduleEventType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachScheduleEventTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                        .addComponent(coachScheduleEventDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachScheduleEventDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coachSchedulePanel2Layout.createSequentialGroup()
                        .addComponent(coachScheduleEventTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachScheduleEventTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(coachScheduleTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(coachScheduleEventDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(coachSchedulePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachScheduleEventTime)
                    .addComponent(coachScheduleEventTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        coachPendingRosterjList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Corey Kluber" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        coachPendingRosterjList1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                coachPendingRosterjList1ComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(coachPendingRosterjList1);

        coachRosterjList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Trevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Andrew Miller" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(coachRosterjList1);

        javax.swing.GroupLayout coachRosterPanelLayout = new javax.swing.GroupLayout(coachRosterPanel);
        coachRosterPanel.setLayout(coachRosterPanelLayout);
        coachRosterPanelLayout.setHorizontalGroup(
            coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coachRosterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coachRosterPanelLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(coachRosterAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachRosterRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        coachRosterPanelLayout.setVerticalGroup(
            coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachRosterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(coachRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachRosterRemove)
                    .addComponent(coachRosterAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        coachRosterTabPane.addTab("Roster", coachRosterPanel);

        coachStatLineupSeeker.setText("Seeker:");

        coachStartLineupSeekerBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Jeff Manship", "Zach McAllister", "Andrew Miller", "Dan Otero", "Bryan Shaw", "Cody Allen" }));

        coachStartLineupKeeper.setText("Keeper:");

        coachStartLineupKeeperBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Jeff Manship", "Zach McAllister", "Andrew Miller", "Dan Otero", "Bryan Shaw", "Cody Allen" }));
        coachStartLineupKeeperBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachStartLineupKeeperBoxActionPerformed(evt);
            }
        });

        coachStartLineupBeaters.setText("Beaters:");

        coachStartLineupBeaterBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Jeff Manship", "Zach McAllister", "Andrew Miller", "Dan Otero", "Bryan Shaw", "Cody Allen" }));

        coachStartLineupBeaterBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Jeff Manship", "Zach McAllister", "Andrew Miller", "Dan Otero", "Bryan Shaw", "Cody Allen" }));

        coachStartLineupChasers.setText("Chasers:");

        coachStartLineupChaserBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Jeff Manship", "Zach McAllister", "Andrew Miller", "Dan Otero", "Bryan Shaw", "Cody Allen" }));

        coachStartLineupChaserBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ITrevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Jeff Manship", "Zach McAllister", "Andrew Miller", "Dan Otero", "Bryan Shaw", "Cody Allen" }));
        coachStartLineupChaserBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachStartLineupChaserBox2ActionPerformed(evt);
            }
        });

        coachStartLineupChaserBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trevor Bauer", "Ryan Merritt", "Josh Tomlin", "Cody Anderson", "Mike Clevinger", "Jeff Manship", "Zach McAllister", "Andrew Miller", "Dan Otero", "Bryan Shaw", "Cody Allen" }));

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
            .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coachStartLineupBeaterBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                            .addComponent(coachStartLineupChasers)
                            .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(coachStartLineupChaserBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(coachStartLineupChaserBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(coachStartLineupChaserBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                                .addComponent(coachStatLineupSeeker)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coachStartLineupSeekerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                                .addComponent(coachStartLineupKeeper)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coachStartLineupKeeperBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                                .addComponent(coachStartLineupBeaters)
                                .addGap(18, 18, 18)
                                .addComponent(coachStartLineupBeaterBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(239, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coachStartLineupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coachStartLineupSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        coachStartLineupPanelLayout.setVerticalGroup(
            coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachStartLineupPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachStatLineupSeeker)
                    .addComponent(coachStartLineupSeekerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachStartLineupKeeper)
                    .addComponent(coachStartLineupKeeperBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachStartLineupBeaters)
                    .addComponent(coachStartLineupBeaterBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachStartLineupBeaterBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(coachStartLineupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachStartLineupChasers)
                    .addComponent(coachStartLineupChaserBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachStartLineupChaserBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachStartLineupChaserBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachLeftTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(coachLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coachLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachLeftTabPane)
                .addContainerGap())
        );

        coachLeftTabPane.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coachScheduleEventTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachScheduleEventTimeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachScheduleEventTimeBoxActionPerformed

    private void coachRosterRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRosterRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachRosterRemoveActionPerformed

    private void coachStartLineupKeeperBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachStartLineupKeeperBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachStartLineupKeeperBoxActionPerformed

    private void coachStartLineupChaserBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachStartLineupChaserBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachStartLineupChaserBox2ActionPerformed

    private void coachLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachLogoutActionPerformed

    private void coachScheduleBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachScheduleBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachScheduleBackActionPerformed

    private void coachScheduleSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachScheduleSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachScheduleSaveActionPerformed

    private void coachRosterAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRosterAddActionPerformed
       
    }//GEN-LAST:event_coachRosterAddActionPerformed

    private void coachStartLineupSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachStartLineupSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachStartLineupSaveActionPerformed

    private void coachPendingRosterjList1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_coachPendingRosterjList1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_coachPendingRosterjList1ComponentAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CoachMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoachMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoachMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoachMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoachMainHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CoachScheduleDetailsDescriptjTextArea1;
    private javax.swing.JTabbedPane coachEventTabPane;
    private javax.swing.JScrollPane coachEventsScroll;
    private javax.swing.JList coachEventsjList1;
    private javax.swing.JTabbedPane coachLeftTabPane;
    private javax.swing.JButton coachLogout;
    private javax.swing.JList coachPendingRosterjList1;
    private javax.swing.JButton coachRosterAdd;
    private javax.swing.JPanel coachRosterPanel;
    private javax.swing.JButton coachRosterRemove;
    private javax.swing.JTabbedPane coachRosterTabPane;
    private javax.swing.JList coachRosterjList1;
    private javax.swing.JButton coachScheduleBack;
    private javax.swing.JLabel coachScheduleDetailsDescript;
    private javax.swing.JPanel coachScheduleDetailsPanel;
    private javax.swing.JTextField coachScheduleDetailsWhereField;
    private javax.swing.JLabel coachScheduleEventDate;
    private javax.swing.JComboBox coachScheduleEventDateBox;
    private javax.swing.JLabel coachScheduleEventTime;
    private javax.swing.JComboBox coachScheduleEventTimeBox;
    private javax.swing.JLabel coachScheduleEventType;
    private javax.swing.JComboBox coachScheduleEventTypeBox;
    private javax.swing.JPanel coachSchedulePanel;
    private javax.swing.JPanel coachSchedulePanel2;
    private javax.swing.JButton coachScheduleSave;
    private javax.swing.JTextField coachScheduleTitleField;
    private javax.swing.JLabel coachScheduleWhere;
    private javax.swing.JComboBox coachStartLineupBeaterBox1;
    private javax.swing.JComboBox coachStartLineupBeaterBox2;
    private javax.swing.JLabel coachStartLineupBeaters;
    private javax.swing.JComboBox coachStartLineupChaserBox1;
    private javax.swing.JComboBox coachStartLineupChaserBox2;
    private javax.swing.JComboBox coachStartLineupChaserBox3;
    private javax.swing.JLabel coachStartLineupChasers;
    private javax.swing.JLabel coachStartLineupKeeper;
    private javax.swing.JComboBox coachStartLineupKeeperBox;
    private javax.swing.JPanel coachStartLineupPanel;
    private javax.swing.JButton coachStartLineupSave;
    private javax.swing.JComboBox coachStartLineupSeekerBox;
    private javax.swing.JLabel coachStatLineupSeeker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}