package com.example.anew;

import android.text.TextUtils;
import android.util.Patterns;

public class Utility {
    public static boolean isValidEmail(CharSequence target){

        return (!TextUtils.isEmpty(target))&& Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }

}