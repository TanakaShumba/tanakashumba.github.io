import hashlib
import json
import os

DATA_FILE = "patients.json"

def hash_password(password):
    return hashlib.sha256(password.encode()).hexdigest()

def load_data():
    if not os.path.exists(DATA_FILE):
        return {}
    with open(DATA_FILE, "r") as f:
        return json.load(f)

def save_data(data):
    with open(DATA_FILE, "w") as f:
        json.dump(data, f, indent=4)

def create_patient(data):
    name = input("Patient Name: ")
    age = input("Patient Age: ")
    condition = input("Medical Condition: ")
    data[name] = {"age": age, "condition": condition}
    save_data(data)
    print(f"Patient {name} added successfully)

def view_patients(data):
    if not data:
        print("No patients found.")
        return
    for name, info in data.items():
        print(f"Name: {name}, Age: {info['age']}, Condition: {info['condition']}")
        
def main():
    print("=== Secure Hospital Management System ===")
    data = load_data()

    while True:
        print("
Options:
1. Add Patient
2. View Patients
3. Exit")
        choice = input("Select an option: ")
        if choice == "1":
            create_patient(data)
        elif choice == "2":
            view_patients(data)
        elif choice == "3":
            break
        else:
            print("Invalid choice.")

if __name__ == "__main__":
    main()
