package com.example.portfolio;

import android.os.Build;
import android.os.Bundle;

public interface FragmentSummaryCallback {

    public void onCommand(String command, String data);

    public void onFragmentSelected(int position, Bundle bundle);

}
