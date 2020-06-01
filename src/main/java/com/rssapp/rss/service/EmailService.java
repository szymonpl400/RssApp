package com.rssapp.rss.service;


public interface EmailService {
    public void sendSimpleMessage(String to, String subject, String text);
    public void sendMail(String from, String to, String subject, String msg);
}
