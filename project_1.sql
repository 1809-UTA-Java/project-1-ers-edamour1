CREATE TABLE ERS_USERS (
    U_ID NUMBER NOT NULL,
    U_USERNAME varchar2(255) NOT NULL,
    U_PASSWORD varchar2(255) NOT NULL,
    U_FIRSTNAME varchar2(255),
    U_LASTNAME varchar2(255),
    U_EMAIL varchar2(255),
    UR_ID NUMBER NOT NULL,
    PRIMARY KEY (U_ID)
);

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE ERS_USERS
ADD UNIQUE (U_EMAIL);

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE ERS_REIMBURSEMENTS (
    R_ID NUMBER NOT NULL,
    R_AMOUNT NUMBER NOT NULL,
    R_DESCRIPTION varchar2(255),
    R_RECEIPT BLOB,
    R_SUBMITTED TIMESTAMP NOT NULL,
    R_RESOLVED TIMESTAMP,
    U_ID_AUTHOR NUMBER NOT NULL,
    U_ID_RESOLVER NUMBER,
    RT_TYPE NUMBER NOT NULL,
    RT_STATUS NUMBER NOT NULL,
    PRIMARY KEY (R_ID)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE ERS_REIMBURSEMENT_STATUS (
    RS_ID NUMBER NOT NULL,
    RS_STATUS varchar2(255) NOT NULL,
    PRIMARY KEY (RS_ID)
);
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE ERS_REIMBURSEMENT_TYPE (
    RT_ID NUMBER NOT NULL,
    RT_TYPE varchar2(255) NOT NULL,
    PRIMARY KEY (RT_ID)
);
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE ERS_REIMBURSEMENTS
ADD FOREIGN KEY (U_ID_AUTHOR) REFERENCES ERS_USERS(U_ID);
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE ERS_REIMBURSEMENTS
ADD FOREIGN KEY (U_ID_RESOLVER) REFERENCES ERS_USER_ROLES(UR_ID);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE ERS_REIMBURSEMENTS
ADD FOREIGN KEY (RT_TYPE) REFERENCES ERS_REIMBURSEMENT_TYPE(RT_ID);

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE ERS_REIMBURSEMENTS
ADD FOREIGN KEY (RT_STATUS) REFERENCES ERS_REIMBURSEMENT_STATUS(RS_ID);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------