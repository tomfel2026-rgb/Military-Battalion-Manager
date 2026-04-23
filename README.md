# 🎖️ Battalion Manager - Fleet & Mission System

A robust **Java** application designed to streamline the management of military assets and operational logs. This project focuses on the management of specialized vehicle fleets and tactical missions using **Object-Oriented Programming (OOP)** best practices.

## 🚀 Features

The system provides a comprehensive suite of tools for battalion administration:

* **Fleet Classification:** Managed through inheritance, supporting:
    * 🚚 **Troop Transport:** Tracks soldier capacity.
    * 🛡️ **Armored Vehicles:** Manages specialized armor levels.
    * 🚑 **Support Vehicles:** Categorized by Logistics, Communications, or Medical functions.
* **Operational Tracking:** Monitor vehicle mileage, mission counts, and real-time status (Available, On Mission, Maintenance).
* **Mission Management:** Register tactical missions including location, date, and assigned personnel/units.
* **Advanced Reports:** Quickly identify high-performance units (vehicles with 50+ missions).
* **GUI Interaction:** User-friendly experience via `JOptionPane` dialogs.

## 🛠️ Technical Stack

* **Language:** Java 17+
* **GUI:** Swing (JOptionPane)
* **Testing:** JUnit 5
* **Design Patterns:** Heavy use of Inheritance, Polymorphism, and Encapsulation.

## 🧪 Quality Assurance

Reliability is a priority. This project includes a comprehensive suite of **Unit Tests** for every class and core function within the model package.
* **Validation:** Ensures unique IDs and correct data input.
* **Logic Verification:** Tests for state transitions and mission updates.
* **Edge Cases:** Handles incorrect status codes and empty data fields.

## 📋 Getting Started

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/Military-Battalion-Manager.git](https://github.com/your-username/Military-Battalion-Manager.git)
