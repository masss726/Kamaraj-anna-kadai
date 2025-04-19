/*
 * package com.example.MasilaMainMethods; import com.twilio.Twilio; import
 * com.twilio.rest.api.v2010.account.Message; import
 * com.twilio.type.PhoneNumber;
 * 
 * public class WhatsAppSender {
 * 
 * // Replace with your Twilio SID and Auth Token public static final String
 * ACCOUNT_SID = "YOUR_TWILIO_ACCOUNT_SID"; public static final String
 * AUTH_TOKEN = "YOUR_TWILIO_AUTH_TOKEN";
 * 
 * public static void main(String[] args) { Twilio.init(ACCOUNT_SID,
 * AUTH_TOKEN);
 * 
 * Message message = Message.creator( new PhoneNumber("whatsapp:+91xxxxxxxxxx"),
 * // To new PhoneNumber("whatsapp:+14155238886"), // From (Twilio Sandbox
 * Number) "Hello from Thamilan Maligai Billing App!" ).create();
 * 
 * System.out.println("Message SID: " + message.getSid()); } }
 */