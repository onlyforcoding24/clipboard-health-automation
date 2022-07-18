package com.clipboard.register;


import com.clipboard.controller.Factory;
import com.clipboard.objects.InstanceRecording;

/**
 * @author jitendra.pisal
 */
public class I {
    public I(){

    }

    public static Factory amPerforming(){
        return (Factory) InstanceRecording.getInstance(Factory.class);
    }
}

