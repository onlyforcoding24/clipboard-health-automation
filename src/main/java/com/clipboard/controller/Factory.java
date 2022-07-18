package com.clipboard.controller;

import com.clipboard.api.Wait;
import com.clipboard.logging.OwnLogger;
import com.clipboard.misclib.FileHandler;
import com.clipboard.misclib.PropertyFileReader;
import com.clipboard.objects.InstanceRecording;
import com.clipboard.type.Click;
import com.clipboard.type.Elements;
import com.clipboard.type.Switch;
import com.clipboard.type.TextInput;
import org.assertj.core.api.SoftAssertions;

/**
 * @author jitendra.pisal
 */
public final class Factory {
    private Click click;
    private PropertyFileReader propertyFileReader;
    private Wait wait;
    private TextInput textInput;
    private Switch switchTo;
    private Elements elements;
    private OwnLogger ownLogger;
    private SoftAssertions softAssertions;
    private FileHandler fileHandler;

    public Factory() {
    }

    public Wait waitFor() {
        if (this.wait == null) {
            this.wait = new Wait();
        }
        return this.wait;
    }

    public FileHandler fileHandler() {
        if(this.fileHandler == null){
            this.fileHandler = InstanceRecording.getInstance(FileHandler.class);
        }
        return this.fileHandler;
    }

    public OwnLogger getLogger() {
        if (this.ownLogger == null) {
            this.ownLogger = new OwnLogger();
        }
        return ownLogger;
    }

    public Switch switchTo() {
        if (this.switchTo == null) {
            this.switchTo = InstanceRecording.getInstance(Switch.class);
        }
        return this.switchTo;
    }

    public TextInput textInput() {
        if (this.textInput == null) {
            this.textInput = InstanceRecording.getInstance(TextInput.class);
        }
        return this.textInput;
    }

    public Click click() {
        if (this.click == null) {
            this.click = InstanceRecording.getInstance(Click.class);
        }
        return this.click;
    }

    public PropertyFileReader propertiesFileOperationsTo() {
        if (this.propertyFileReader == null) {
            this.propertyFileReader = new PropertyFileReader();
        }
        return this.propertyFileReader;
    }

    public Elements elements() {
        if (this.elements == null) {
            this.elements = InstanceRecording.getInstance(Elements.class);
        }
        return this.elements;
    }

    public SoftAssertions assertionsTo() {
        if (this.softAssertions == null) {
            this.softAssertions = new SoftAssertions();
        }
        return this.softAssertions;
    }
}
