package com.clipboard.register;

import com.clipboard.misclib.FileHandler;
import com.clipboard.objects.InstanceRecording;
import com.clipboard.type.Click;
import com.clipboard.type.Elements;
import com.clipboard.type.Switch;
import com.clipboard.type.TextInput;
import io.cucumber.java.Before;

/**
 * @author jitendra.pisal
 */
public class FactoryInit {

    public FactoryInit() {
        InstanceRecording.recordInstance(TextInput.class, new TextInput());
        InstanceRecording.recordInstance(Click.class, new Click());
        InstanceRecording.recordInstance(Switch.class, new Switch());
        InstanceRecording.recordInstance(Elements.class, new Elements());
        InstanceRecording.recordInstance(FileHandler.class, new FileHandler());
    }

    @Before(
            order = 1
    )
    public void startActionsRegistration() {
    }
}
