package com.asgarov.wicket.demo.counter;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import java.util.Optional;

public class MyCounter extends WebPage {
    int counter = 0;

    public MyCounter() {
        Label label = new Label("counter-label", () -> counter);
        label.setOutputMarkupId(true);
        add(label);

        add(new AjaxFallbackLink<>("counter-link") {
            @Override
            public void onClick(Optional<AjaxRequestTarget> target) {
                counter++;
                target.ifPresent(t -> t.add(label));
            }
        });
    }
}
