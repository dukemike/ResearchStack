package org.researchstack.backbone.utils;

import android.content.Context;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.view.View;

import org.researchstack.backbone.DataResponse;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.ui.step.layout.StepLayout;
import org.researchstack.backbone.ui.views.AlertFrameLayout;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;

import rx.Observable;

/**
 * Created by TheMDP on 1/16/17.
 */

public class StepLayoutHelper {

    @NonNull
    @MainThread
    public static  StepLayout createLayoutFromStep(Step step, Context context)
    {
        try
        {
            Class cls = step.getStepLayoutClass();
            Constructor constructor = cls.getConstructor(Context.class);
            return (StepLayout) constructor.newInstance(context);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
