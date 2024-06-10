# Practicum-EXAM-
Name: Karabelo  
Surname: Mohale
Student Number: ST10456672

Introduction 

The Weather application is designed to assist users in tracking and managing their daily weather condition. This application aims to provide a simple yet effective way for individuals to monitor their daily temperature. By leveraging this tool, users can gain insights into their daily habits. 

 Features and Functionality 

The Weather application comprises three main screens: the splash screen, the main screen, and the detailed view screen. Each of these screens plays a vital role in delivering a comprehensive user experience. 

 Splash Screen 

The splash screen is the initial interface that greets the user upon launching the application. It includes the following elements: 

 

App Name and Logo: Displays the name of the app, "Weather Manager," alongside a representative logo. 

Developer Information: Shows the developer's name and student number. 

Navigation Options: Provides buttons to navigate to the main screen or exit the application. 

 Main Screen 

The main screen is where users can input their daily condition. Key components of the main screen include: 

 

Input Fields: Text fields for users to enter temperature and condition.

Submit Button: Saves the entered data into parallel arrays for future reference. 

Clear Data Functionality: Allows users to clear all input data, enabling them to start fresh. 

Error Checking: Ensures that users enter valid, positive integer values before data submission. 

Detailed View Navigation: Provides a button to navigate to the detailed view screen for further analysis. 

 Detailed View Screen 

The detailed view screen offers a weekly weather details
 

Summary Information: Weekly temperature and condition. 

Back Navigation: Allows users to return to the main screen. 

 

Pseudocode : 

Splash Screen  

Start 

    // Display splash screen elements 

    DISPLAY "ScreenTime Manager" 

    DISPLAY "Developer: Your Name" 

    DISPLAY "Student Number: Your Student Number" 

     

    // Navigation options 

    DISPLAY Button "Main Screen" 

    DISPLAY Button "Quit" 

 

    // Button actions 

    IF Button "Main Screen" CLICKED THEN 

        CALL MainScreen() 

    ENDIF 

     

    IF Button "Quit" CLICKED THEN 

        EXIT Application 

    ENDIF 

END  

Main Screen
Start
   // Declare temperatures array and conditions array
    temperatures = int array of size 7
    conditions = string array of size 7

    // onCreate method
    method onCreate(savedInstanceState: Bundle):
        // Call superclass method
        call superclass method onCreate(savedInstanceState)
        
        // Set content view to activity_main layout
        set content view to activity_main layout

        // Call updateWeatherText method
        call updateWeatherText()

        // Set click listeners for buttons
        set click listener for refreshButton:
            call refreshWeather() method
        set click listener for clearButton:
            call clearData() method
        set click listener for detailsButton:
            start DetailedViewActivity
        set click listener for exitButton:
            finish()

    // refreshWeather method
    method refreshWeather():
        // Get temperature and condition input
        tempInput = get text from tempEditText
        conditionInput = get text from conditionEditText

        // Check if inputs are not empty
        if tempInput is not empty and conditionInput is not empty:
            // Convert temperature input to integer
            temp = convert tempInput to integer
            
            // Check if conversion was successful
            if temp is not null:
                // Update temperatures and conditions arrays
                temperatures[0] = temp
                conditions[0] = conditionInput

                // Call updateWeatherText method
                call updateWeatherText()
            else:
                // Show error message for invalid temperature input
                show toast message: "Invalid temperature input"
        else:
            // Show error message for empty fields
            show toast message: "Please fill in both fields"

    // clearData method
    method clearData():
        // Set weatherTextView text to "Data Cleared"
        set weatherTextView text to "Data Cleared"

        // Clear text in tempEditText and conditionEditText
        clear text in tempEditText
        clear text in conditionEditText

    // updateWeatherText method
    method updateWeatherText():
        // Calculate average temperature
        avgTemp = calculate average of temperatures array
        
        // Set weatherTextView text with current and average temperature
        set weatherTextView text to "Current Weather: " + temperatures[0] + "°C, " + conditions[0] + "\nAverage Temp: " + avgTemp + "°C"
End

Detailed Screen
Start
    // Declare maxTemperatures array, minTemperatures array, and conditions array
    maxTemperatures = int array of size 7
    minTemperatures = int array of size 7
    conditions = string array of size 7

    // onCreate method
    method onCreate(savedInstanceState: Bundle):
        // Call superclass method
        call superclass method onCreate(savedInstanceState)
        
        // Set content view to activity_detailed_view layout
        set content view to activity_detailed_view layout

        // Create StringBuilder to store details
        details = StringBuilder("Weekly Weather Details:\n")
        
        // Loop through maxTemperatures array indices
        for i from 0 to length of maxTemperatures - 1:
            // Append details for each day
            details.append("Day " + (i + 1) + ": Max Temp: " + maxTemperatures[i] + "°C, Min Temp: " + minTemperatures[i] + "°C, Condition: " + conditions[i] + "\n")
        
        // Set detailsTextView text to details string
        set detailsTextView text to details.toString()

        // Set click listener for backButton
        set click listener for backButton:
            finish()
End
