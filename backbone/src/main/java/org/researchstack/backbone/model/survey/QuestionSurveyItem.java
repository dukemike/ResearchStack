package org.researchstack.backbone.model.survey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TheMDP on 12/31/16.
 */

public class QuestionSurveyItem<T extends Object> extends SurveyItem<T> {

    @SerializedName("questionStyle")
    public boolean questionStyle;
    @SerializedName("placeholderText")
    public String placeholderText;
    @SerializedName("optional")
    public boolean optional;
    @SerializedName("range")
    public RangeSurveyItem range;

    @SerializedName("expectedAnswer")
    public boolean expectedAnswer; // Does this need to be a generic type?

    public boolean isValidQuestionItem() {
        return identifier != null && type.isQuestionSubtype();
    }

    public boolean isBooleanToggle() {
        return type == SurveyItemType.QUESTION_TOGGLE;
    }

    public boolean isCompoundStep() {
        return isBooleanToggle() || type == SurveyItemType.QUESTION_COMPOUND;
    }

    /**
     * @return false by default, true if this question survey item
     *         can be used to create a QuestionStep that will implement
     *         the interface NavigationStep
     */
    public boolean usesNavigation() {
        if (skipIdentifier != null || rulePredicate != null) {
            return true;
        }
        return false;
    }
}
