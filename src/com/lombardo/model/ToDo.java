package com.lombardo.model;

public class ToDo {
    private String mDescription;
    private Boolean mIsComplete;

    public ToDo(String description, Boolean isComplete) {
        mDescription = description;
        mIsComplete = isComplete;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "mDescription='" + mDescription + '\'' +
                '}';
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Boolean isComplete() {
        return mIsComplete;
    }

    public void markComplete() {
        mIsComplete = true;
    }
}
