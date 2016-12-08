/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPlayerGUI;

/**
 *
 * @author fbbigger
 */
public class UserRequest {
    
    private int userID;
    private String requestType;
    private String requestDisc;
    private boolean statusPending;

    public UserRequest(int userID, String requestType, String requestDisc) {
        this.userID = userID;
        this.requestType = requestType;
        this.requestDisc = requestDisc;
        this.statusPending = true;
    }
}