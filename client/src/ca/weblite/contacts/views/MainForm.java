/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.weblite.contacts.views;

import ca.weblite.contacts.dto.BaseRequest;
import ca.weblite.contacts.dto.BaseResponse;
import ca.weblite.contacts.dto.Contact;
import ca.weblite.contacts.services.RESTClient;
import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.util.Callback;
import java.util.List;

/**
 *
 * @author shannah
 */
public class MainForm extends Form {
    
    
    private List<Contact> contacts;
    private Container contactsContainer;
    
    public MainForm() {
        super("My Application");
        contactsContainer = BoxLayout.encloseY(new Label("Loading..."));
        setLayout(new BorderLayout());
        addComponent(BorderLayout.CENTER, contactsContainer);
        Button refresh = new Button("Refresh Contacts");
        refresh.addActionListener(e->{
            refreshContacts();
        });
        
        Display.getInstance().callSerially(()->{refreshContacts();});
        
    }
   
    private void update() {
        contactsContainer.removeAll();
        if (contacts != null) {
            for (Contact c : contacts) {
                contactsContainer.add(new Label(c.getName()));
            }
            
        }
        revalidate();
    }
    
    
    private void refreshContacts() {
        RESTClient client = new RESTClient();
        
        client.sendRequest("/getContacts", new BaseRequest(), new Callback<BaseResponse>() {

            @Override
            public void onSucess(BaseResponse value) {
                contacts = (List<Contact>)value.getResponseData().get("contacts");
                System.out.println("Contacts "+contacts);
                update();
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                ToastBar.showErrorMessage(errorMessage);
                Log.e(err);
            }
            
        });
    }
}
