package com.car.asistant.demo.kit;

public class VerivicationMessage {


    public String createMessage(String verivicationToken) {
        String mesage;
        mesage = "<h2>Dziękujemy za założenie konta<h2>" +
                "<br>" +
                "W celu aktywacji kliknij w link: "+
                "<a href="+"http://localhost:8080/users/verification/email/" + verivicationToken + ">link aktywacyjny</a>";

        return mesage;
    }


}
