package com.rob.vacancyapp;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class VacancyRoute  extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:8083/myapp/myservice?enableCORS=true&optionsEnabled=true")

            .wireTap("direct:foo")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    exchange.getOut().setHeader("Access-Control-Allow-Origin", "*");
                    exchange.getOut().setHeader("Access-Control-Allow-Methods", "POST, PUT, DELETE,GET, OPTIONS");
                    exchange.getOut().setHeader("Access-Control-Allow-Headers", "Content-Type");

                    exchange.getOut().setBody("<html><body>Book 123 is Camel in Action</body></html>");
                }
            });


        from("direct:foo")
            .process(new Processor() {
                 @Override
                 public void process(Exchange exchange) throws Exception {
                     System.out.println(exchange.getIn().getBody());
                 }
             })
            .to("activemq:queue:vacancyapplication");

    }
}
