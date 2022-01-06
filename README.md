# BookMark
An android app developed in Kotlin language that keeps record of which books are issued to whom. User needs to enter his Name, Mobile Number and Selected Book and save these details.

## Summary
This app uses the following features:
1. MVVM architecture(Model View ViewModel)
2. Kotlin Language 
3. Room Database for storing data
4. Splash Screen

## Working Of Application

**Splash Screen:** User launches the app > Splash screen will be loaded

**Main Activity:** User is in Main Activity with one floating action button.
![Main Activity](https://user-images.githubusercontent.com/84138868/148373489-8c7ca7ef-4c70-4923-af15-4aa625455619.jpg)

**Add /Edit Activity:** User clicks on the Add icon and navigates to new activity 
User needs to enter his/her name, 10 digit mobile number and select Book from dropdown and submit button

**Recycler View Main Activity:** The saved item details will be loaded in the main activity in a card view format.

**Update Books:**  After adding a book user can click on the card view and edit his/her details and again update these details. Updated details will be displayed in Recycler View of Main Activity.

**Delete Record:** User can click on delete icon to delete any record he/she wants.


