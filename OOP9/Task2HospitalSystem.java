import java.util.ArrayList;

class Report {
    private String diagnosis;

    public Report(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}

class Patient {
    private String name;
    private String birthDate;
    private String gender;
    private String dateAcceptedToHospital;
    private Report report;
    private Doctor treatingDoctor;
    private int numberOfDaysStay;

    public Patient(String name, String birthDate, String gender, String dateAcceptedToHospital, Report report, Doctor treatingDoctor, int numberOfDaysStay) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.dateAcceptedToHospital = dateAcceptedToHospital;
        this.report = report;
        this.treatingDoctor = treatingDoctor;
        this.numberOfDaysStay = numberOfDaysStay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateAcceptedToHospital() {
        return dateAcceptedToHospital;
    }

    public void setDateAcceptedToHospital(String dateAcceptedToHospital) {
        this.dateAcceptedToHospital = dateAcceptedToHospital;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Doctor getTreatingDoctor() {
        return treatingDoctor;
    }

    public void setTreatingDoctor(Doctor treatingDoctor) {
        this.treatingDoctor = treatingDoctor;
    }

    public int getNumberOfDaysStay() {
        return numberOfDaysStay;
    }

    public void setNumberOfDaysStay(int numberOfDaysStay) {
        this.numberOfDaysStay = numberOfDaysStay;
    }
}

class TeamMember {
    private String name;
    private String id;
    private String gender;
    private String dateJoined;
    private int maxWorkingHours;

    public TeamMember(String name, String id, String gender, String dateJoined) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.dateJoined = dateJoined;
        this.maxWorkingHours = 12;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    public void setMaxWorkingHours(int maxWorkingHours) {
        if (maxWorkingHours > 12) {
            this.maxWorkingHours = 12;
        } else {
            this.maxWorkingHours = maxWorkingHours;
        }
    }
}

class Nurse extends TeamMember {
    public Nurse(String name, String id, String gender, String dateJoined) {
        super(name, id, gender, dateJoined);
    }
}

class Doctor extends TeamMember {
    private String specialty;

    public Doctor(String name, String id, String gender, String dateJoined, String specialty) {
        super(name, id, gender, dateJoined);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void treatPatient(Patient patient) {
        System.out.println(getName() + " is treating " + patient.getName());
    }

    public void checkPatientReport(Patient patient) {
        System.out.println(getName() + " checked report of " + patient.getName() + ": " + patient.getReport().getDiagnosis());
    }
}

class Intern extends Doctor {
    private SeniorDoctor supervisor;

    public Intern(String name, String id, String gender, String dateJoined, String specialty, SeniorDoctor supervisor) {
        super(name, id, gender, dateJoined, specialty);
        this.supervisor = supervisor;
    }

    public SeniorDoctor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SeniorDoctor supervisor) {
        this.supervisor = supervisor;
    }

    public void treatPatient(Patient patient) {
        System.out.println(getName() + " (intern) is doing basic treatment for " + patient.getName() + " under supervisor " + supervisor.getName());
        patient.getReport().setDiagnosis(patient.getReport().getDiagnosis() + " | basic treatment done by intern");
    }
}

class SeniorDoctor extends Doctor {
    private ArrayList<Patient> patients;

    public SeniorDoctor(String name, String id, String gender, String dateJoined, String specialty) {
        super(name, id, gender, dateJoined, specialty);
        patients = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void treatPatient(Patient patient) {
        System.out.println(getName() + " (senior doctor) is giving medicines to " + patient.getName());
        patient.getReport().setDiagnosis(patient.getReport().getDiagnosis() + " | medicine plan by senior doctor");
    }
}

class Surgeon extends Doctor {
    private ArrayList<Patient> patients;

    public Surgeon(String name, String id, String gender, String dateJoined, String specialty) {
        super(name, id, gender, dateJoined, specialty);
        patients = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void treatPatient(Patient patient) {
        System.out.println(getName() + " (surgeon) is performing surgery for " + patient.getName());
        patient.getReport().setDiagnosis(patient.getReport().getDiagnosis() + " | surgery completed");
    }
}

class Department {
    private String name;
    private ArrayList<TeamMember> staff;

    public Department(String name) {
        this.name = name;
        this.staff = new ArrayList<TeamMember>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TeamMember> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<TeamMember> staff) {
        this.staff = staff;
    }

    public void addTeamMember(TeamMember member) {
        staff.add(member);
        System.out.println(member.getName() + " added to " + name + " department");
    }

    public void removeTeamMember(TeamMember member) {
        if (staff.remove(member)) {
            System.out.println(member.getName() + " removed from " + name + " department");
        } else {
            System.out.println(member.getName() + " not found in " + name + " department");
        }
    }
}

class Hospital {
    private String name;
    private String address;
    private ArrayList<Patient> patients;
    private ArrayList<Department> departments;

    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
        this.patients = new ArrayList<Patient>();
        this.departments = new ArrayList<Department>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Department added: " + department.getName());
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.getName());
    }

    public void removePatient(Patient patient) {
        if (patients.remove(patient)) {
            System.out.println("Patient removed: " + patient.getName());
        } else {
            System.out.println("Patient not found: " + patient.getName());
        }
    }
}

public class Task2HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care Hospital", "Main Road, Islamabad");

        Department cardiology = new Department("Cardiology");
        Department pediatrics = new Department("Pediatrics");
        hospital.addDepartment(cardiology);
        hospital.addDepartment(pediatrics);

        Nurse nurse1 = new Nurse("Sara", "N101", "Female", "2024-01-10");
        SeniorDoctor senior1 = new SeniorDoctor("Dr. Hamza", "D201", "Male", "2020-03-14", "Cardiology");
        Intern intern1 = new Intern("Dr. Ali", "D301", "Male", "2025-02-01", "Cardiology", senior1);
        Surgeon surgeon1 = new Surgeon("Dr. Ayesha", "D401", "Female", "2018-09-20", "General Surgery");

        cardiology.addTeamMember(nurse1);
        cardiology.addTeamMember(senior1);
        cardiology.addTeamMember(intern1);
        pediatrics.addTeamMember(surgeon1);

        Patient p1 = new Patient("Ahmed", "2005-07-01", "Male", "2026-04-05", new Report("Heart pain"), senior1, 5);
        Patient p2 = new Patient("Fatima", "2010-11-21", "Female", "2026-04-06", new Report("Appendix issue"), surgeon1, 7);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        senior1.addPatient(p1);
        surgeon1.addPatient(p2);

        Doctor d1 = intern1;
        Doctor d2 = senior1;
        Doctor d3 = surgeon1;

        System.out.println("\nPolymorphism test for treatPatient:");
        d1.treatPatient(p1);
        d2.treatPatient(p1);
        d3.treatPatient(p2);

        System.out.println("\nCheck patient reports:");
        d1.checkPatientReport(p1);
        d2.checkPatientReport(p1);
        d3.checkPatientReport(p2);

        System.out.println("\nRemove team member and patient:");
        cardiology.removeTeamMember(intern1);
        hospital.removePatient(p2);

        System.out.println("\nFinal data:");
        System.out.println("Hospital: " + hospital.getName() + ", Address: " + hospital.getAddress());
        System.out.println("Total departments: " + hospital.getDepartments().size());
        System.out.println("Total patients in hospital: " + hospital.getPatients().size());
        System.out.println("Cardiology staff count: " + cardiology.getStaff().size());
        System.out.println("Pediatrics staff count: " + pediatrics.getStaff().size());
    }
}
