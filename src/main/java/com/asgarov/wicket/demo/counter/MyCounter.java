package com.asgarov.wicket.demo.counter;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class MyCounter extends WebPage {

    int counter = 0;

    public MyCounter() {
        add(new Link<Void>("counter-link") {
            @Override
            public void onClick() {
                counter++;
            }
        });
        add(new Label("counter-label", () -> counter));
    }
}
