# Test plan to complete

Map each case D1-A–F, D2-A–N and D3's acceptance cases from the briefs to your tests.
For rejection cases specify both the outcome and every protected field that stays unchanged.
Record preconditions, input, expected result, actual result and source/test method.
Add independent Jupiter tests; the supplied suite is deliberately not a complete marking suite.
D1-A: Valid Duration Boundaries
Preconditions: None.
Input: Construct bookings with durations of 1 and 24 hours.
Expected result: Both bookings are created successfully and retain the supplied duration.
Actual result: Covered by durationEndPointsCheck(). The reported JUnit run passed.
Source: Booking constructor and DomainRules.requireDuration(int hours).
Test method: StudentTests.durationEndPointsCheck().

D1-B: Invalid Durations
Preconditions: None.
Input: Construct bookings with durations of 0 and 25 hours.
Expected result: Both constructions throw IllegalArgumentException.
Actual result: Covered by durationEndPointsCheck(). The reported JUnit run passed.
Source: Booking constructor and DomainRules.requireDuration(int hours).
Test method: StudentTests.durationEndPointsCheck().

D1-C: Propose B12
Preconditions: Booking B1 is assigned to A17, has version 0 and requires accessibility. B12 is open and unoccupied.
Input: app.propose("B12").
Expected result: A pending proposal targets B12 and captures booking version 0 and policy version 1. Booking B1 remains assigned to A17 with version 0. Booking snapshot remains unchanged.
Actual result: Covered by eligibleB12ProposalPendingAndBookingUnchanged(). The reported JUnit run passed.
Source: StudentApplication.propose(String targetId) and StudentApplication.bookingSnapshot().
Test method: StudentTests.eligibleB12ProposalPendingAndBookingUnchanged().

D1-D: Reject Occupied D09
Preconditions: Booking B1 is assigned to A17 with version 0. D09 is occupied.
Input: app.propose("D09").
Expected result: IllegalArgumentException is thrown. Booking location, booking version and booking snapshot remain unchanged. No proposal should be added.
Actual result: Covered by occupiedD09Rejected(). The reported JUnit run passed.
Source: StudentApplication.propose(String targetId).
Test method: StudentTests.occupiedD09Rejected().

D1-E: Reject Unknown Target
Preconditions: Booking B1 is assigned to A17 with version 0.
Input: app.propose("Q90").
Expected result: IllegalArgumentException is thrown. Booking location, booking version and booking snapshot remain unchanged. No proposal should be added.
Actual result: Covered by unknownTargetRejected(). The reported JUnit run passed.
Source: StudentApplication.propose(String targetId).
Test method: StudentTests.unknownTargetRejected()

D1-F: Protected Booking Snapshot
Preconditions: Booking B1 exists.
Input: Obtain a snapshot using app.bookingSnapshot() and call snapshot.clear().
Expected result: UnsupportedOperationException is thrown. The underlying booking remains assigned to A17 with version 0.
Actual result: Covered by bookingSnapshotCannotBeModified(). The reported JUnit run passed.
Source: StudentApplication.bookingSnapshot() and Booking.snapshot().
Test method: StudentTests.bookingSnapshotCannotBeModified().

Invalid Identifier Checks
Preconditions: None.
Input: null, lowercase "b1" and an overlong identifier.
Expected result: Each identifier is rejected with IllegalArgumentException.
Actual result: Covered by nullAndInvalidIdentifierRejected(). The reported JUnit run passed.
Source: DomainRules.requireIdentifier(String id).
Test method: StudentTests.nullAndInvalidIdentifierRejected().

Execution Evidencebash 
run.sh check: 14 checks passed, 0 failed, as previously recorded.
bash run.sh test: 21 JUnit tests passed, 0 failed, as previously recorded.
bash run.sh compile: Compilation succeeded, as previously recorded.