# Project routes and D1 booking clarification

Amended 18 September 2026. Route policy published 17 September 2026.

Published route addendum: https://drive.google.com/file/d/1pPBfwYcEREHTCTVh1Nxg8Nn-Sg8EmCGh/view

This file incorporates the published addendum into the starter. It supersedes ParkOps-only wording in this bundle. The original starter remains deliberately incomplete; this amendment changes documentation and code comments only.

## One project, two equally valid routes

There is ONE individual course project, worth 35%, delivered cumulatively through D1, D2 and D3. You may use the supplied ParkOps scenario, or work with a real client on an instructor-approved equivalent. You do not complete both. This clarification resolves the difference between the classroom discussion of client projects and the ParkOps-only wording in the original written materials.

## Route A - ParkOps

Use 00_Project_Overview.pdf, the D1-D3 briefs and ParkOps_Starter_2026-09-15.zip. A client is not required. ParkOps is a complete, fully valid route with the same opportunity to earn marks. Work already completed on ParkOps remains useful; there is no requirement to restart or switch.

## Route B - A client-defined problem

Engage with a person or organisation to understand their requirements, then agree with the instructor on a small software prototype that demonstrates the SAME course requirements and acceptance-test coverage. The client supplies the problem and domain needs; the instructor approves the assessed scope and its mapping to the published briefs. A client project is optional and earns no extra marks merely for having a client.

A suitable example is equipment-loan rescheduling: read an affected reservation, find eligible replacement equipment, propose a change, and require a human decision before applying it. An arbitrary website, mobile interface or simple CRUD application is not by itself equivalent to the required supervised-agent project.

## Assessment deadlines and marks

| Milestone | Deadline (Toronto time) | Course weight |
| --- | --- | --- |
| D1 - Design and executable path | 13 October 2026, 23:59 | 10% |
| D2 - Working supervised agent | 6 November 2026, 23:59 | 10% |
| D3 - Evolution and contracts | 30 November 2026, 23:59 | 15% |

Both routes remain individual work: one student, one repository, three cumulative deliverables. The published rubric categories, weights, documentation limits, submission contents and academic-integrity requirements apply to both routes. Client satisfaction, access to a client and production deployment are not additional grading criteria.

## How this addendum applies

Read this addendum with the syllabus, project overview and D1-D3 briefs. It supersedes wording that makes ParkOps the only permitted domain. For ParkOps, follow the original technical specifications directly. For an approved client project, the written mapping replaces domain-specific names, fixtures and business rules; it does not waive the common engineering requirements or reduce test coverage. Any unresolved interpretation should be raised privately with the teaching team.

## Common technical requirements for both routes

- Java 21 and JUnit Jupiter 6.0.3; encapsulated domain objects, validation and defensive state handling; reproducible build/run/test instructions.
- A supervised AI-agent workflow with a model/provider boundary, strict structured tool inputs, bounded execution and deterministic replay. The model proposes an action; a human approves or rejects it; Java validates current state before committing.
- Equivalent read, list alternatives, propose and finish operations, preserving the published ordering, error cases and 1-6 tool-call budget. Client-facing operation names may differ where the approved mapping explains them.
- Approval state transitions, stale entity/policy-version checks, eligibility checks and repeat-execution protection: one committed change and one simulated notification, not duplicates.
- Explicit controllable 60-second periodic ticks, boundary checks, backward-time rejection and duplicate-work suppression, with equivalent version-based retry behaviour.
- JUnit tests for successful, invalid, boundary, failure and state-transition cases; actual test results; deterministic fixtures and regression coverage.
- The published diagrams and design explanations; a meaningful D3 policy change, justified refactoring, static analysis, contracts/JML and invariant/loop reasoning with the published tool-access contingencies.

## Equivalent evidence at each milestone

| Milestone | Evidence required for either route |
| --- | --- |
| D1 | Validated domain model; class and sequence diagrams; executable replay path to a pending proposal with no committed mutation; positive and negative JUnit tests; design rationale. |
| D2 | Bounded model/tool loop; provider history and errors; human approval and current-state checks; safe repeated execution; periodic behaviour; updated diagrams, regression tests and model-connection evidence under the published access arrangements. |
| D3 | Versioned eligibility/policy change and rejection of stale proposals; baseline and changed-policy fixtures; regression tests; justified refactoring and static analysis; contracts, class invariant and loop reasoning; final design/reflection evidence. |

Use the original D1-D3 acceptance cases as the checklist. A client mapping must cover every applicable behaviour with comparable positive, negative and boundary examples; do not silently drop ParkOps requirements because the domain has changed. Keep numeric bounds and timing rules unless an equivalent is explicitly agreed in writing.

D1 does not require a real-model connection. D2 retains the separate real-model route and the published institution-supported access contingency; no personal paid AI/API account is required. Replay evidence must be labelled honestly and must not be described as a live model run.

## Starting the client route

Send a short outline through eClass > Connect Privately with the Teaching Team before committing to a client-specific implementation. This is a scope check, not an additional graded deliverable. There is no new separate assessment deadline. You may put the approved mapping into the existing README/DESIGN materials within their published limits.

- Describe the client context, problem and user roles, plus 3-5 concrete requirements that came from the client. A role or organisation description is sufficient; do not post private contact details or confidential documents.
- Identify the small workflow that can be read, evaluated, proposed, approved/rejected and executed. Map its entities, alternatives, eligibility rules, state/version checks and simulated notification to the ParkOps reference behaviours.
- Outline the D1, D2 and D3 evidence and corresponding acceptance tests, including malformed inputs, provider failure, stale approval, duplicate execution and periodic-tick boundaries.
- Propose a small policy change for D3 and explain how it changes eligibility and invalidates an earlier proposal. Agree the change in advance; the assessed D3 change becomes active on 9 November, as in the published schedule.
- State the bounded prototype scope and how you will use synthetic data, deterministic fixtures and simulated external effects. Request written instructor approval of the mapping.

## Scope, access and fairness

Until the client mapping is approved, ParkOps remains the safe reference path. You can continue the shared design and testing work. If client access falls through, contact the teaching team promptly to agree how to continue with the approved scope or map the work back to ParkOps. Having no client is not a disadvantage.

Build a small local prototype; a command-line interface is sufficient. No model training, large front end, real payments, unrestricted browser/shell access or autonomous production actions are required. Use synthetic/anonymised fixtures and simulated notifications. Keep confidential client data, credentials and personal information out of submissions and model prompts.

Later client requests do not automatically enlarge the assessed workload or change deadlines. Agree any scope adjustment with the instructor. No new D3 requirements will be introduced in the 30 November lecture. Grade decisions use the course rubric and the approved mapping.

## Submission and assessment

Follow the existing ZIP specification for each named D1/D2/D3 eClass submission activity: EECS3311_Dn_STUDENTNUMBER.zip, containing src/, test/, run.sh, README.md, DESIGN.pdf, AI_USE.md, TEST_PLAN.md, CHANGELOG.md and results/. Keep the same documentation page limits. Exclude compiled output, caches, secrets and bundled libraries as instructed in the briefs.

GitHub may support development and version history, but the submitted ZIP is the marking snapshot. A repository link does not replace the required eClass submission. The teaching team will identify the submission activities when they are available. Be ready to explain your own code and tests and disclose AI assistance as required.

Questions or client proposals: use Connect Privately with the Teaching Team on eClass. You only need to choose one route; ParkOps is available to everyone.

## D1: creating a booking versus moving a booking (18 September clarification)

You may create or initialise a Booking object in StudentApplication or in your chosen domain design. The supplied fixture already initialises B1 at A17 with booking version 0. You may add your own classes or wrap/replace the raw fixture storage with protected domain objects; no fixed class count or internal architecture is imposed.

In propose(targetId), creating a pending proposal is different from applying the proposed move. Validate the target, record the proposed destination and capture the booking/policy versions. Preserve the complete current booking and occupancy state: for the baseline B12 proposal, B1 remains at A17 with booking version 0. Do not change its location or version, free its current space, occupy the proposed space, or replace it with a new booking at the proposed destination. Replacing the object does not avoid this rule. A rejected proposal must also preserve the original state.

Actual execution belongs to the later D2 human approval and execution workflow, which must recheck current eligibility and booking/policy versions and prevent duplicate commits and simulated notifications. D1 ends at a pending proposal, with no committed move. Add tests that compare the full booking state before and after proposing or rejecting a target; test occupancy as well when represented by your domain model.

For an instructor-approved client route, apply the same boundary to the equivalent domain entity and resource occupancy/availability identified in your written mapping. Initialising an entity is allowed; proposing a change must not apply that change.
