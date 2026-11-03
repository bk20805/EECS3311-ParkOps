# ParkOps — cumulative individual project starter

## Project route amendment - 18 September 2026

Choose ONE individual project route: the supplied ParkOps scenario, or an instructor-approved
client project with an equivalent written mapping of every required behaviour and acceptance case.
No client is required and a client route earns no extra marks. ParkOps work remains valid.
For ParkOps, use this fixture and the technical briefs directly. For the client route, the approved
mapping replaces domain-specific names, fixtures and business rules while preserving the common
Java 21, JUnit Jupiter 6.0.3, supervised-agent, testing, timing and approval requirements.

Read [PROJECT_AMENDMENT_2026-09-18.md](PROJECT_AMENDMENT_2026-09-18.md) before implementation.
It contains the full published route amendment, approval process and the D1 booking clarification.
Project deadlines are D1: 13 October 2026, 23:59 (10%); D2: 6 November 2026, 23:59 (10%);
D3: 30 November 2026, 23:59 (15%), all Toronto time. Total: 35%.

Release: 2026-09-15. Read the matching Student Brief before editing.
This is an exercise starter. A clean compile does not mean the exercise is solved.
The public checks are expected to fail initially. Preserve them and add your own tests.
All data is synthetic. No personal paid AI account or model service is needed for the labs.

## First run

Extract the whole ZIP. Open its starter folder, containing this README and src/Main.java.
Use JDK 21. Check java -version and javac -version.

macOS/Linux (or Git Bash on Windows):

    bash run.sh compile
    bash run.sh run
    bash run.sh check
    bash setup-junit.sh
    bash run.sh test

Windows PowerShell:

    ./run.ps1 compile
    ./run.ps1 run
    ./run.ps1 check
    ./setup-junit.ps1
    ./run.ps1 test

If local policy blocks PowerShell scripts, use Git Bash or the lab-supported setup;
do not weaken institution-managed security policies. COURSE_JAVA_HOME may point to
a supported JDK folder. JAVA_HOME is also respected. Scripts always target Java 21.

setup-junit downloads the pinned JUnit 6.0.3 console jar from Maven Central and checks its
SHA-256. The TA can cache it once and provide JUNIT_JAR as an absolute path instead.
Compilation and plain Java checks work offline without JUnit. A missing dependency
is an environment issue; report it separately from failed behavioural checks.

## Your work

Implement your domain model and application in D1, then extend the same repository for D2 and D3. The supplied adapter, JSON codec, raw fixture and build scripts are infrastructure. DomainRules and StudentApplication contain explicit TODOs. Their public methods are a small demonstration/testing boundary, not a required internal architecture; you may adapt this boundary with a documented mapping. The amended PDF briefs and PROJECT_AMENDMENT_2026-09-18.md define acceptance and marks for either route; use the approved written mapping for a client project. The initial check/test commands intentionally fail on unimplemented D1 requirements.

## D1 booking clarification

You may create or initialise bookings in StudentApplication or your own domain classes.
The instruction about never moving a booking refers specifically to propose(targetId).
That method creates a PENDING proposal; it must preserve the entire booking and occupancy
state, including location and version. For the baseline B12 proposal, B1 stays at A17/version 0.
Replacing B1 with a newly created booking at B12 would also be an impermissible committed move.
Actual movement belongs to D2's separate human approval/execution path with current-state checks.
Rejected proposals also leave the original state unchanged. Client projects apply the same rule
to their mapped entities and resource availability. Add tests that demonstrate these boundaries.

## Commands and evidence

- compile: compile source with Java 21 and compiler warnings enabled.
- run: small starter orientation or deliberately faulty demonstration, not a test suite.
- check: named plain Java checks, exit 1 when a required behaviour is missing.
- test: the same supplied cases through JUnit Jupiter plus your added test classes.
- lint: compile with -Xlint:all. Lab07 deliberately begins with raw/unchecked warnings.

Each check creates its own objects. Read the case name and assertion message; do not
delete failing cases or edit the captured output. Add focused Jupiter tests in
test/junit/StudentTests.java. An all-green public suite is not proof of every requirement.

For each project submission, use EECS3311_Dn_STUDENTNUMBER.zip and include src/, test/,
run.sh, README.md, DESIGN.pdf, AI_USE.md, TEST_PLAN.md, CHANGELOG.md and results/.
Keep the published documentation page limits and follow the named D1/D2/D3 eClass submission
instructions when the teaching team makes those activities available. The ZIP is the marking
snapshot; a GitHub link does not replace it. Exclude build/, lib/, secrets and IDE caches.
Follow the project brief's academic-integrity and AI-use requirements and disclose assistance.
The supplied infrastructure is acknowledged in STARTER_PROVENANCE.md.

## References

- Java 21: https://docs.oracle.com/en/java/javase/21/
- JUnit 6.0.3 console: https://docs.junit.org/6.0.3/running-tests/console-launcher.html
