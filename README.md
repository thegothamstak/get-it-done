# Get It Done - Task Management App

Get It Done is a task management application designed to help users efficiently manage their tasks and to-do lists, similar to the Google Tasks app. The app allows users to create, edit, delete, and categorize tasks, providing a user-friendly interface and seamless experience.

## Technologies Used

- **Kotlin**: The primary programming language used for developing the Android application.
- **Room Database**: For local data persistence to store tasks.

## Project Structure

The project is organized into several key components:

- **Activities**: UI components that interact with users.
- **ViewModels**: Handle the data for UI components and manage UI-related data lifecycle.
- **Repositories**: Abstraction layer that handles data operations, providing a clean API for data access.
- **Room Database Entities**: Data models that define the structure of the database.

## Setup Instructions

To set up and run this application locally, follow these steps:

### Prerequisites

- **Android Studio**: Ensure you have Android Studio installed. You can download it from [developer.android.com/studio](https://developer.android.com/studio).
- **Java Development Kit (JDK)**: The project requires JDK 8 or higher.

### Steps to Run the Application

1. **Clone the repository:**

   Open your terminal and run:

   ```bash
   git clone https://github.com/thegothamstak/get-it-done.git

2. Open the project in Android Studio:

    Launch Android Studio.
    Select "Open an existing Android Studio project."
    Navigate to the cloned directory and open it.

3. Sync Gradle:

    Wait for Android Studio to sync the Gradle files. If any dependencies are missing, ensure your build.gradle files are correctly set up.

4. Run the application:

    Connect an Android device or start an emulator.
    Click the "Run" button (the green play icon) in Android Studio.
