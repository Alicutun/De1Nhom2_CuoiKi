package com.android.s19110209.Fragments;

import java.io.File;
public interface OnFileSelectedListener {
    void onFileClicked (File file);
    void onFileLongClicked(File file, int position);
}
