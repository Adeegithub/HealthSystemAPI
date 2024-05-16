**This is a REST API dveloped for health system using JAX-RS** <br>

**Scenario**
 <p> The task presents students with the challenge of designing and implementing a
Health System API that addresses the complex requirements of modern healthcare
management. The API will serve as the foundation upon which various healthcare
applications and systems can be built, providing essential functionalities for patient
management, appointment scheduling, medical record keeping, prescription management,
and billing. </p> <br>
</p> This task is designed to align with specific student learning goals, focusing on
REST API design and implementation using JAX-RS. The objectives aim to equip students
with practical skills and knowledge that directly contribute to their understanding of
modern software development practices and the role of RESTful APIs in the context of
healthcare systems. </p>

**System Entities**
1. Person:
• Represents a generic individual with attributes such as name, contact
information, and address. <br>
2. Patient:
• Extends the Person entity to include specific details relevant to patients, such as
medical history and current health status. <br>
3. Doctor:
• Also extends the Person entity to include information about healthcare
professionals, including their specialization and contact details. <br>
4. Appointment:
• Represents scheduled appointments between patients and doctors, including
details like date, time, and associated participants. <br>
5. Medical Record:
• Holds comprehensive medical information about patients, covering diagnoses,
treatments, and other relevant data. <br>
6. Prescription:
• Records information about prescribed medications, including dosage,
instructions, and duration. <br>
7. Billing:
• Manages financial transactions related to healthcare services, including
invoices, payments, and outstanding balances. <br>
**Model Classes** <br>
<br>
**1. Model Classes:** <br>
• All model classes (Person, Patient, Doctor, Appointment, MedicalRecord,
Prescription, Billing) are well-implemented with correct attributes, getters,
setters, and constructors. Proper use of inheritance with clear hierarchies and
relationships among classes. All classes have well-defined constructors with
appropriate parameters and initialization of attributes. <br>
**2. DAO Implementation : <br>**
• Create well-implemented DAO classes (PersonDAO, PatientDAO, DoctorDAO,
AppointmentDAO, MedicalRecordDAO, PrescriptionDAO, BillingDAO) with all
CRUD methods for corresponding entities. Implement comprehensive
exception handling and validation using HTTP response codes. <br>
**3. Logging and Exception Handling:** <br>
• Implement comprehensive logging throughout the codebase, providing detailed
information for debugging and auditing. Ensure exception handling covers a
wide range of scenarios with informative error messages using appropriate
HTTP response codes. <br>
**4. Restful resource implementation:** <br>
• All resource classes (PersonResource, PatientResource, DoctorResource,
AppointmentResource, MedicalRecordResource, PrescriptionResource,
BillingResource) follow RESTful principles correctly. Resource methods for
retrieving patient details by ID, searching for available appointments,
scheduling appointments, managing related entities, accessing medical records,
issuing prescriptions, handling billing follow RESTful principles and are
accurately implemented. Resources are clearly identified and named according
to RESTful conventions. URIs are intuitive, hierarchical, and self-explanatory.
Appropriate HTTP methods (GET, POST, PUT, DELETE, etc.) are used for each
operation on resources. Methods align with CRUD operations. <br>
**5. Code Organization:** <br>
• Organize code following best practices for separation of concerns, modularity,
and maintainability. Providing clear explanations for codes. <br>
