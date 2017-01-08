package com.anh.android.criminalintent;

import java.util.UUID;

/**
 * Created by Anh Huynh on 1/3/2017.
 */

public class Crime {
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    private UUID mId;

    public void setTitle(String title) {
        mTitle = title;
    }

    private String mTitle;

    public Crime()
    {
        mId = UUID.randomUUID();
    }


}
