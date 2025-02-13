# Bank Management System

## Overview
This is a **Bank Management System** built using Java that implements Object-Oriented Programming (OOP) principles. The system allows users to **sign up, log in, deposit, withdraw, and view account details**, while an admin can **view all accounts but cannot modify them**.

## Features

### Admin Features:
- Can **log in** with a predefined username and password.
- Can **view all registered accounts** and their details.
- Cannot modify user accounts.

### User Features:
- Can **sign up** using a unique phone number and create a username and password.
- After signing up, they must **log in** using their credentials.
- Can **deposit money** into their account.
- Can **withdraw money** from their account.
- Can **view their account details**.
- Can **log out**.

### Database Management:
- A **Database class** stores all accounts and users.
- Uses **collections (HashMap)** to manage user data efficiently.

## Project Structure

```
BankManagementSystem/
│── src/
│   ├── Banking/
│   │   ├── BankSystem.java  # Main class, controls the flow
│   │   ├── Admin.java       # Admin class to manage and view accounts
│   │   ├── User.java        # User class to handle user-related actions
│   │   ├── Account.java     # Represents a bank account
│   │   ├── Database.java    # Stores all user accounts and handles retrieval
│   │   ├── Signup.java      # Handles new user registration
│   │   ├── Login.java       # Handles user and admin login
│── README.md                # Project documentation
```

## Installation and Setup

### Prerequisites
- **Java Development Kit (JDK) 8 or later**
- **IntelliJ IDEA (or any Java IDE)**

### Steps to Run
1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/BankManagementSystem.git
   ```
2. **Open the project in IntelliJ IDEA** (or another Java IDE).
3. **Compile and run** the `BankSystem.java` file.
4. Follow the prompts to **sign up, log in, and perform transactions**.

## Usage
- Run `BankSystem.java`.
- If you're a **new user**, sign up first.
- If you're an **existing user**, log in using your username and password.
- Choose an action (**Deposit, Withdraw, View Account, Logout**).
- If you're an **admin**, log in to **view all accounts**.

## Example Demo

```
Welcome to Bank System
1. Login as User
2. Login as Admin
3. Sign Up
4. Exit
Choose an option: 3
Enter Phone Number: 1234567890
Enter Account Number: 122245667899
Enter Account Holder Name: Adam
Enter Initial Deposit: 1000
Create Username: Adam
Create Password: *****
Account created successfully! You can now log in.

Welcome to Bank System
1. Login as User
2. Login as Admin
3. Sign Up
4. Exit
```

## Future Enhancements
- Implementing a **database system** (MySQL/PostgreSQL) instead of using HashMaps.
- Adding **interest calculations** for savings accounts.
- Implementing **multi-threading** for concurrent transactions.

## License
This project is licensed under the **MIT License**.

## Author
Developed by **Pardhiv Bhupathiraju**