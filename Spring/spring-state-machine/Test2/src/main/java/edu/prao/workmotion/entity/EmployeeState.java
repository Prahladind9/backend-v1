package edu.prao.workmotion.entity;

public enum EmployeeState {
    FORK, JOIN,

    ADDED,
    IN_CHECK,
    SECURITY_CHECK_STARTED,
    SECURITY_CHECK_FINISHED,
    WORK_PERMIT_CHECK_STARTED,
    WORK_PERMIT_CHECK_FINISHED,
    APPROVED,
    ACTIVE
}
