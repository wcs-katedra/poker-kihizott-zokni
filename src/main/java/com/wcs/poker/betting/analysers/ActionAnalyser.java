package com.wcs.poker.betting.analysers;

import com.wcs.poker.betting.ActionAnalyserParameter;
import com.wcs.poker.model.ActionInTurn;

public class ActionAnalyser {

    private ActionAnalyserParameter actionAnalyserParameter;

    public ActionAnalyser(ActionAnalyserParameter actionAnalyserParameter) {
        this.actionAnalyserParameter = actionAnalyserParameter;
    }

    public ActionInTurn getNextAction() {
        return ActionInTurn.FOLD;
    }
}
