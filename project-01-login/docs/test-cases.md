https://practicetestautomation.com/practice-test-login/

### TC_ID : TC_01
Title : Verify login with valid credentials

Priority: P0
Precondition: User is on the Login Page

Steps:
1. Enter valid username student in the username field
2. Enter valid password Password123 in the password field
3. Click on Login button

Expected Result:
User should be successfully logged in and redirected to the Secure Area page.

Execution Status: Pass
Comments: User redirected to secure area successfully

Execution Status: Pass
Comments: User redirected to secure area successfully

### TC_ID : TC_02
Title : Verify successful login redirects to the Secure Area page

Priority: P0
Precondition: User is on the Login Page

Steps:

1. Enter valid username student
2. Enter valid password Password123
3. Click on Login button

Expected Result:
1. User should be navigated to the Secure Area page with success message
2. “You logged into a secure area!”

Execution Status: Pass
Comments: User redirected to secure area successfully and being redirected to secure area page

### TC_ID : TC_03
Title : Verify user is able to log out after successful login

Priority: P0
Precondition: User is logged in on the Secure Area page

Steps:
1. Click on the Logout button

Expected Result:
1. User should be logged out
2. User should be redirected back to the Login Page

Execution Status: Pass
Comments: User able to log out back to login pagge

### TC_ID : TC_04
Title : Verify system rejects invalid username + valid password

Priority: P0
Precondition: User is on the Login Page

Steps:

1. Enter invalid username
2. Enter valid password Password123
3. Click on Login button

Expected Result:

1. User should NOT be logged in
2. Error message should appear: “Your username is invalid!”

Execution Status: Failed
Comments: User redirected to secure area successfully

### TC_ID : TC_05
Title : Verify system rejects valid username + invalid password

Priority: P0
Precondition: User is on the Login Page

Steps:

1. Enter valid username student
2. Enter invalid password
3. Click on Login button

Expected Result:

1. User should NOT be logged in
2. Error message should appear: “Your password is invalid!”

Execution Status: Passed
Comments: User not get logged in

### TC_ID : TC_06
Title : Verify system rejects invalid username + invalid password

Priority: P0
Precondition: User is on the Login Page

Steps:

1. Enter invalid username
2. Enter invalid password
3. Click on Login button

Expected Result:

1. User should NOT be logged in
2. Error message should appear: “Your username is invalid!”

(Note: The website always prioritizes username invalid message when both fields are wrong.)

Execution Status: Passed
Comments: User not get logged in

### TC_ID : TC_07
Title : Verify error message when username field is empty

Priority: P0
Precondition: User is on the Login Page

Steps:

1. Leave username field empty
2. Enter valid or invalid password
3. Click on Login button

Expected Result:

1. User should NOT be logged in
2. Error message: “Your username is invalid!”

Execution Status: Passed
Comments: As Expected

### TC_ID : TC_08
Title : Verify error message when password field is empty

Priority: P0
Precondition: User is on the Login Page

Steps:

1. Enter valid or invalid username
2. Leave password field empty
3. Click Login

Expected Result:

1. User should NOT be logged in
2. Error message: “Your password is invalid!”

Execution Status: Passed
Comments: As Expected

### TC_ID : TC_09
Title : Verify both fields empty

Priority: P0
Precondition: User is on the Login Page

Steps:

1. Do not enter username
2. Do not enter password
3. Click Login

Expected Result:

1. User should NOT be logged in
2. Error message: “Your username is invalid!”
(The app shows username error first.)

Execution Status: Passed
Comments: As Expected
   

### TC_ID : TC_10
Title : Verify login attempt with special characters in username

Priority: P1
Precondition: User is on the Login Page

Steps:

1. Enter special characters in username field (e.g., @@@, #$%)
2. Enter any password
3. Click Login

Expected Result:

1. User should NOT be logged in
2. Error message: “Your username is invalid!”

Execution Status: Passed
Comments: As Expected

### TC_ID : TC_11
Title : Verify login attempt with special characters in password

Priority: P1
Precondition: User is on the Login Page

Steps:

1. Enter valid username student
2. Enter password with special characters (e.g., @#$%^&)
3. Click Login

Expected Result:

1. If password does NOT match stored one → “Your password is invalid!”
2. User should NOT be logged in

Execution Status: Passed
Comments: As Expected

### TC_ID : TC_12
Title : Verify user cannot navigate back to secure page after logout (Back Button)

Priority: P0
Precondition: User is logged in and on Secure Page

Steps:

1. Click Logout button
2. Click browser Back button

Expected Result:

1. User should NOT be able to access the Secure Page
2. User should be redirected to Login Page

Execution Status: Failed
Comments: User still able to navigate back to secure page after logout using back button

### TC_ID : TC_13
Title : Verify user stays logged in when using Back button without logging out

Priority: P1
Precondition: User is logged in on Secure Page

Steps:

1. Click Browser Back button

Expected Result:

1. User should remain logged in
2. Clicking Back should keep the user in Secure Area (browser cached page)

### TC_ID : TC_14
Title : Verify login error message disappears after refresh

Priority: P2
Precondition: User has attempted invalid login once

Steps:

1. Enter invalid username or password
2. Click Login
3. Refresh the page

Expected Result:

1. Error message should disappear
2. Login page should be clean/reset

Execution Status: Passed
Comments: As Expected

### TC_ID : TC_15
Title : Verify Secure Area page elements after successful login

Priority: P1
Precondition: User is logged into Secure Area

Steps:

1. Verify “Secure Area” header
2. Verify success message “You logged into a secure area!”
3. Verify Logout button is visible

Expected Result:
1. All Secure Area components should be displayed correctly.

Execution Status: Passed
Comments: As Expected
