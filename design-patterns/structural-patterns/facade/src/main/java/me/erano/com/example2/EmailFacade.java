package me.erano.com.example2;

import me.erano.com.example2.Template.TemplateType;

//Facade
public class EmailFacade {

    public boolean sendOrderEmail(Order order) {
        Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
        Stationary stationary = StationaryFactory.createStationary();
        Email email = Email.getBuilder()
                .withTemplate(template)
                .withStationary(stationary)
                .forObject(order)
                .build();
        Mailer mailer = Mailer.getMailer();
        return mailer.send(email);
    }

}
