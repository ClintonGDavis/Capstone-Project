# CSCI 2906 Capstone Project

## Synopsis
This program is a continuation of the one I created for my CSCI 1175 Final Project.

My CSCI 1175 project was a rudimentary mental health logbook (which I built using JavaFX) meant for people who are utilizing a new mental health program called "Balanced Living".

This capstone project is basically that program but I've repurposed it into a rudimentary Android app. 

## Motivation
I built this project at the behest of the creator of the Balanced Living program (this person is a professional psychologist & personal friend of mine).

## How to Run
Load the project into Android Studio and utilize an Android emulator in order to review the app.

## Code Example
I am proud of the following line of code because learning about "sharedPreferences" objects is what enabled me to save and utilize any user input
my app might acquire.
```
            public void saveStringToSharedPreferences(String key, String value) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(key, value);
                editor.apply();
            }
            
            // Method to retrieve a string value from the app's SharedPreferences
            public String getStringFromSharedPreferences(String key, String defaultValue) {
                return sharedPreferences.getString(key, defaultValue);
            }
        }
```
