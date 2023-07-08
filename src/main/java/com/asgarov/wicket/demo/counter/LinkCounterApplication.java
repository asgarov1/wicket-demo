package com.asgarov.wicket.demo.counter;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.RequestCycleSettings;

public class LinkCounterApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return MyCounter.class;
    }
}
