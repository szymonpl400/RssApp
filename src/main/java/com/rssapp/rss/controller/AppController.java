package com.rssapp.rss.controller;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.rssapp.rss.service.EmailService;


@Controller
public class AppController {

    @Autowired
    EmailService emailService;
    
	@ResponseBody
	@PostMapping(value={"/sendRss"}, consumes = "application/json", produces = "application/json")
	public String sendRss(@RequestBody String data, HttpServletRequest request) 
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject = new JSONObject(data);
		String url = (String) jsonObject.get("url");
		String email = (String) jsonObject.get("email");

		System.out.println("emial" + email + " " + "url" + url);
		String titleOfRss = "rssTitle";

        String messageFromParses = "";
        try {
            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle());
                System.out.println("***********************************");
                titleOfRss = feed.getTitle();
                for (SyndEntry entry : feed.getEntries()) {
                    System.out.println(entry.getDescription().getValue());
                    System.out.println(entry.getContents());
                    messageFromParses+=entry.getDescription().getValue();
                }
                System.out.println("Done");
            }

            emailService.sendMail("abc@gmail.com",email,titleOfRss,messageFromParses);

        }  catch (Exception e) {
            e.printStackTrace();
        }
		
		return messageFromParses;
	}		
}
