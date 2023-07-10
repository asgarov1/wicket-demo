package com.asgarov.wicket.demo;

import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteBehavior;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.StringAutoCompleteRenderer;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HomePage extends WebPage {

    private final SortedSet<String> rememberedNames = new TreeSet<>();

    @Override
    public void renderHead(IHeaderResponse response) {
        PackageResourceReference cssFile =
                new PackageResourceReference(this.getClass(), "style.css");
        CssHeaderItem cssItem = CssHeaderItem.forReference(cssFile);

        response.render(cssItem);
    }

    public HomePage() {
        setUpRememberedNames(List.of("Olaf", "Roland", "Carl-Eric"));
        final IModel<String> model = new Model<>("Welt");
        final Label nameLabel = new Label("name", model);
        add(nameLabel);

        var myForm = new Form<>("myForm"){
            @Override
            protected void onSubmit() {
                super.onSubmit();
                rememberedNames.add(model.getObject());
            }
        };
        add(myForm);

        TextField<String> nameField = new TextField<>("nameField", model);
        myForm.add(nameField);

        nameField.add(new AutoCompleteBehavior<String>(StringAutoCompleteRenderer.instance()){
            @Override
            protected Iterator<String> getChoices(String input) {
                return rememberedNames.stream()
                        .filter(name -> name.startsWith(input))
                        .collect(Collectors.toList())
                        .iterator();
            }
        });
    }

    private void setUpRememberedNames(List<String> names) {
        rememberedNames.addAll(names);
    }
}
