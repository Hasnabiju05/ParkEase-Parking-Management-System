# ParkEase – Parking Management System

A Java-based console application designed to manage vehicle registration, parking-slot allocation, entry and exit tracking, overstay detection, and parking records for college or apartment parking areas.

---

## Problem Statement

College and apartment parking areas can become difficult to manage when vehicles are parked without a systematic allocation process. There may be no proper record of where a vehicle is parked, how long it has remained there, or whether it is registered.

**ParkEase** provides a structured solution for registering vehicles, assigning available parking slots, tracking entry and exit times, detecting overstayed vehicles, calculating applicable fines, and maintaining parking records.

---

## Features

* Register vehicles as **Two-Wheeler** or **Four-Wheeler**
* Automatically assign an available parking slot
* Track vehicle entry time
* Track vehicle exit time
* Calculate total parking duration
* Detect vehicles parked for more than 8 hours
* Calculate overstay fine at **Rs. 50 per additional hour**
* View real-time parking-slot availability
* View currently parked vehicles
* View the daily parking log
* Save and reload registered vehicle data using File I/O
* Handle invalid input using exception handling
* Prevent duplicate vehicle registrations

---

## Project Structure

```text
ParkEase/
│
├── src/
│   ├── Vehicle.java
│   ├── ParkingSlot.java
│   ├── ParkingRecord.java
│   ├── SlotManager.java
│   ├── EntryExitService.java
│   ├── AlertService.java
│   ├── FileHandler.java
│   └── Main.java
│
├── data/
│   └── vehicles.txt
│
└── README.md
```

### Class Responsibilities

| Class                   | Responsibility                                   |
| ----------------------- | ------------------------------------------------ |
| `Vehicle.java`          | Stores vehicle and owner details                 |
| `ParkingSlot.java`      | Represents an individual parking slot            |
| `ParkingRecord.java`    | Stores entry, exit, and duration information     |
| `SlotManager.java`      | Handles parking-slot assignment and availability |
| `EntryExitService.java` | Manages vehicle entry and exit                   |
| `AlertService.java`     | Detects overstays and calculates fines           |
| `FileHandler.java`      | Saves and loads vehicle information              |
| `Main.java`             | Provides the console menu and user interaction   |

---

## Technologies Used

* **Java 17**
* Object-Oriented Programming
* `HashMap`
* `ArrayList`
* `LocalDateTime`
* `Duration`
* File I/O
* `BufferedReader`
* `BufferedWriter`
* Exception Handling
* Switch expressions

---

## Prerequisites

Java JDK 17 or above is required.

Check your Java version using:

```bash
java -version
```

---

## How to Set Up and Run

### Step 1 – Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/ParkEase.git
```

### Step 2 – Navigate to the Source Folder

```bash
cd ParkEase/src
```

### Step 3 – Compile the Java Files

```bash
javac Vehicle.java ParkingSlot.java ParkingRecord.java SlotManager.java EntryExitService.java AlertService.java FileHandler.java Main.java
```

### Step 4 – Run the Application

```bash
java Main
```

---

## Main Menu

When ParkEase starts, the user is presented with a menu similar to:

```text
========== PARKEASE MAIN MENU ==========

1. Register Vehicle
2. Vehicle Entry
3. Vehicle Exit
4. View All Slots
5. View Active Parkings
6. Check Overstayed Vehicles
7. View Today's Log
8. Save and Exit

=========================================
```

---

## Menu Options

| Option | Operation                 | Description                                                    |
| ------ | ------------------------- | -------------------------------------------------------------- |
| 1      | Register Vehicle          | Adds a vehicle with owner name, number plate, and vehicle type |
| 2      | Vehicle Entry             | Records entry time and assigns an available slot               |
| 3      | Vehicle Exit              | Records exit time, calculates duration, and releases the slot  |
| 4      | View All Slots            | Displays FREE and OCCUPIED parking slots                       |
| 5      | View Active Parkings      | Displays vehicles currently parked                             |
| 6      | Check Overstayed Vehicles | Identifies vehicles parked beyond 8 hours                      |
| 7      | View Today's Log          | Displays the day's parking history                             |
| 8      | Save and Exit             | Saves registered vehicle data and closes the application       |

---

## Data Persistence

ParkEase uses **File I/O** to preserve registered vehicle information between application sessions.

Vehicle registrations are stored in:

```text
data/vehicles.txt
```

When the application starts, previously saved vehicle information is loaded automatically.

When the user selects **Save and Exit**, the current vehicle data is written back to the file.

---

## Parking Rules

* Two-wheeler slots use the prefix **T**
  Example: `T001`, `T002`
* Four-wheeler slots use the prefix **F**
  Example: `F001`, `F002`
* Default capacity:

  * 20 two-wheeler slots
  * 10 four-wheeler slots
* Maximum permitted parking duration: **8 hours**
* Overstay fine: **Rs. 50 per additional hour**
* Additional-hour calculation is rounded upward

---

## Java Concepts Demonstrated

### Object-Oriented Programming

The application represents real-world entities such as vehicles, parking slots, and parking records using Java classes and objects.

### Encapsulation

Model classes use private fields and controlled access through methods.

### Collections

`ArrayList` is used for dynamic collections, while `HashMap` provides efficient lookup of active parking records.

### Date and Time

`LocalDateTime` and `Duration` are used to record timestamps and calculate parking duration.

### File Handling

`BufferedReader` and `BufferedWriter` are used to load and save vehicle information.

### Exception Handling

Exception handling is used to prevent invalid user input or file-related problems from terminating the application unexpectedly.

---

## Example Workflow

```text
Register Vehicle
       ↓
Vehicle Entry
       ↓
Find Available Slot
       ↓
Assign Parking Slot
       ↓
Create Parking Record
       ↓
Vehicle Remains Parked
       ↓
Vehicle Exit
       ↓
Calculate Duration
       ↓
Release Parking Slot
       ↓
Check Overstay / Fine
```

---

## Future Improvements

Possible future enhancements include:

* Graphical User Interface
* Database integration
* Login and authentication
* Online payment support
* Admin dashboard
* Parking statistics and reports
* Search and filtering of parking records
* QR-code based vehicle identification
* Mobile application integration

---

## Author

**Hasna Biju**

**Registration Number:** 24BEC10085
**University:** VIT Bhopal University
**Course:** Programming in Java
**Project:** ParkEase – Parking Management System
**Year:** 2026
