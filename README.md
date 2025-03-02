# Hospital Management System
A Java-based Hospital Management System that demonstrates various design patterns to manage user registration, login, viewing records, and billing processes. The system allows for the management of different user roles (Admin, Doctor, and Patient) with specific functionalities, billing strategies, and user data management.

## Features
- **User Management**: Register and authenticate Admin, Doctor, and Patient users.
- **Role-based Access**: Each role has specific access:
  - **Admin**: View all user records.
  - **Doctor**: View patient records.
  - **Patient**: View their own records, choose billing options, and apply for VIP status.
- **Billing System**: Patients can enter their billing amount, choose between self or insurance billing, and opt for special discounts as VIP patients.
- **Design Patterns Used**:
  - **Factory**: For creating different user types based on roles.
  - **Proxy**: For handling user authentication securely.
  - **Singleton**: To manage a single instance of the file-based database.
  - **Decorator**: For applying additional discounts for VIP patients.
  - **Strategy**: For different billing strategies.

## Project Structure
- `Main.java`: The entry point for the program, providing a menu-driven interface for interacting with the system.
- `User`: Abstract class for defining the structure of user accounts.
- `Admin`, `Doctor`, `Patient`: Concrete user classes implementing specific roles and behaviors.
- `FileDatabase`: A singleton class that stores user data in a file-based storage system.
- `AuthenticationService` & `AuthenticationProxy`: For secure login and user authentication.
- `BillingStrategy`: Interface for defining different billing strategies (Self-Pay, Insurance, Discount).
- `VIPPatient`: A decorator class to add VIP discount functionality.

## Getting Started
### Prerequisites
- Java Development Kit (JDK 8 or higher)
- A code editor (e.g., IntelliJ, Eclipse) or a terminal with command-line access

### Running the Project
1. **Clone the Repository** (or download the files if using a ZIP):
   ```bash
   git clone https://github.com/your-username/hospital-management-system.git
   cd hospital-management-system
2. **Compile and Run the Program**:
   - Compile:
      ```bash
      javac *.java
      ```
   - Run:
      ```bash
      java Main
      ```
## Using the System:
Run the program and select options from the menu to register users, log in, view records, and handle billing.
### Usage Guide
The system provides a menu-driven interface to interact with different roles:
- **Register New User**:
Enter name, username, password, and role (Admin, Doctor, Patient).
- **Login**:
Enter username and password to access the system based on your role.
- **View Records**:
  Access records based on role permissions:
    - Admin can view all users.
    - Doctor can view patient records.
    - Patients can view their own records.
- **Billing**:
Patients can enter an amount, choose billing strategy (self-pay or insurance), and apply for VIP status for additional discounts.

## Design Patterns Explained
- **Factory Pattern**: Used to create user instances based on roles.
- **Proxy Pattern**: Provides controlled access to the system for secure login.
- **Singleton Pattern**: Ensures only one instance of the FileDatabase exists.
- **Decorator Pattern**: Adds optional VIP discount functionality to Patient billing.
- **Strategy Pattern**: Supports multiple billing strategies (self-pay or insurance).
  
## Example Workflow
- **Register as Admin**: The Admin can log in and view all user records.
- **Register as Doctor**: Doctors can log in and view records of patients.
- **Register as Patient**: Patients can log in, view their own records, enter billing amounts, and select billing options.
- **VIP Status**: Patients can opt for VIP billing to receive discounts.
