/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.isiot.flinkjobs;

/**
 *
 */
public class AlertMessage {
    
    public String recipientEmail;

    public String message;
    
    @Override
    public String toString() {
        return "AlertMessage{" + "recipientEmail=" + recipientEmail + ", message=" + message + '}';
    }   
           
    
}
