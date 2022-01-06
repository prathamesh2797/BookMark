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

![Screenshot_2022-01-06-16-36-13-01_4b6430ffafc1871dffdc461b63c2c32c](https://user-images.githubusercontent.com/84138868/148373765-2948b42f-81dd-4c87-b68d-da24cd4fcef8.jpg)

**Main Activity:** User is in Main Activity with one floating action button.

![Main Activity](https://user-images.githubusercontent.com/84138868/148373489-8c7ca7ef-4c70-4923-af15-4aa625455619.jpg)

**Add /Edit Activity:** User clicks on the Add icon and navigates to new activity 

![Add Book](https://user-images.githubusercontent.com/84138868/148373845-81d4e2bd-ae7c-43bf-ac7a-6376e7af004e.jpg)

User needs to enter his/her name, 10 digit mobile number and select Book from dropdown and submit button

![Book Dropdown](https://user-images.githubusercontent.com/84138868/148374177-96767565-2dd0-4505-a665-d3f9848af3ad.jpg)


**Recycler View Main Activity:** The saved item details will be loaded in the main activity in a card view format.

![main activity recycler view](https://user-images.githubusercontent.com/84138868/148373914-99c0e0b0-0adc-4fa6-8a49-a30fa6505a7e.jpg)

**Update Books:**  After adding a book user can click on the card view and edit his/her details and again update these details. Updated details will be displayed in Recycler View of Main Activity.

![update book](https://user-images.githubusercontent.com/84138868/148373967-791b1a27-a592-4980-9af6-4d170021fdca.jpg)

**Delete Record:** User can click on delete icon to delete any record he/she wants.




