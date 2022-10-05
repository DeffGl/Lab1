package org.example.lab.models;


import javax.persistence.*;

@Entity
@Table(name="Link")
public class Link {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="name_link")
    String nameLink;
    @Column(name="link")
    String link;
    @Column(name="session_counter")
    int sessionCounter = 0;

    public Link() {

    }

    public Link(String nameLink, String link, int sessionCounter) {
        this.nameLink = nameLink;
        this.link = link;
        this.sessionCounter=sessionCounter;

    }

    public String getNameLink() {
        return nameLink;
    }

    public void setNameLink(String nameLink) {
        this.nameLink = nameLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionCounter() {
        return sessionCounter;
    }

    public void setSessionCounter(int sessionCounter) {
        this.sessionCounter = sessionCounter;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", nameLink='" + nameLink + '\'' +
                ", link='" + link + '\'' +
                ", sessionCounter=" + sessionCounter +
                '}';
    }
}
